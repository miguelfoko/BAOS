package rop.miu;
/**
*
* @author Ndadji Maxime
*/
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rop.miu.beans.BaoUser;
import rop.miu.dao.ROPUserDao;
import rop.miu.util.GuiStatus;
import rop.miu.util.IncludeManager;
import rop.miu.util.ROPConstants;
import rop.miu.util.ROPEncryptor;
import rop.miu.util.ROPLanguageManager;
import rop.miu.util.exceptions.ROPApplException;
import rop.miu.util.exceptions.ROPCryptographyException;


public class FiltrePrincipal implements Filter {

	private ConfigManager configManager;
	public final String REDIRECT404 = "/ressources/jsp/redirect404.jsp";
	protected ROPLanguageManager languageManager;
	protected ROPEncryptor encryptor;
	
    public FiltrePrincipal() {
    	
    }

	@Override
	public void destroy() {
		
	}
	
	protected IncludeManager getIncludeManager(HttpServletRequest request) throws ServletException, IOException{
		return (IncludeManager)request.getAttribute("includeManager");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		this.init(request, response);
		
		IncludeManager includeManager = getIncludeManager(request);
		
		String langTag = (String)request.getSession().getAttribute("tag");
		if(langTag == null){
			langTag = configManager.getLangTags().get(0);
			request.getSession().setAttribute("tag", langTag);
		}
		String action = request.getParameter("l");
		if(action != null){
			try {
				action = encryptor.decrypt(action);
			} catch (ROPCryptographyException e2) {
				action = null;
			}
		}
		if(action != null && action.equals("s")){
			String value = request.getParameter("v");
			if(value != null){
				try {
					value = encryptor.decrypt(value);
				} catch (ROPCryptographyException e2) {
					value = null;
				}
			}
			if(configManager.getLangTags().contains(value) && !langTag.equals(value)){
				langTag = value;
				request.getSession().setAttribute("tag", langTag);
			}
		}
		try{
			ArrayList<String> tags = configManager.getLangTags();
			ArrayList<String> names = configManager.getLangNames();
			ArrayList<String> link = new ArrayList<String>();
			for(int i = 0; i < tags.size(); i++){
				link.add("<a href=\"index.jsp?l="+encryptor.encrypt("s")+"&v="+encryptor.encrypt(tags.get(i))+"\">"+names.get(i)+"</a>");
			}
			request.setAttribute("langItems", link);
			
			String success = request.getParameter("s");
			if(success != null)
				includeManager.createSuccessStatus(request, languageManager.getLanguageValue(encryptor.decrypt(success), langTag));
			
			String error = request.getParameter("e");
			if(error != null)
				includeManager.createErrorStatus(request, languageManager.getLanguageValue(encryptor.decrypt(error), langTag));
		}catch(Exception e){
			
		}
		if(request.getParameter("c") != null){
			validateCookie(request, response);
			request.getServletContext().getRequestDispatcher("/ressources/jsp/cookie.jsp").forward(request, response);
			return;
		}
		informAboutCookie(langTag, request, response);
		
		String contextPath = request.getContextPath();
		String chemin = request.getRequestURI().substring(contextPath.length() );
		if ((chemin.startsWith( "/ressources" )) || (chemin.startsWith( "/admin" )) || (chemin.startsWith( "/modules" )) || (chemin.startsWith( "/templates" ))) {
			chain.doFilter( request, response );
			return;
		}
		
		String moduleName = request.getParameter("m");
		if(moduleName != null){
			try {
				moduleName = encryptor.decrypt(moduleName);
			} catch (ROPCryptographyException e2) {
				moduleName = null;
			}
		}
		
		/*request.setAttribute("modules", configManager.getModules());
		int mid = includeManager.createSideMenu(request,"Modules");
		for(String mod : configManager.getModules()){
			try {
				includeManager.addMenuItem(request, mid, mod, "/?m="+encryptor.encrypt(mod));
			} catch (ROPCryptographyException e) {
				
			}
		}
		request.setAttribute("adminModules", configManager.getAdminModules());
		mid = includeManager.createSideMenu(request,"Admin Modules");
		for(String mod : configManager.getAdminModules()){
			try {
				includeManager.addMenuItem(request,mid, mod, "/admin?m="+encryptor.encrypt(mod));
			} catch (ROPCryptographyException e) {
				
			}
		}*/
		
		if((chemin.endsWith("/index.jsp") || chemin.length() <= 1) && (moduleName == null)){
			request.getServletContext().getRequestDispatcher("/Mod"+ConfigManager.setFirstUppercase(configManager.getDefaultModule())).forward(request, response);
			return;
		}
		if(configManager.moduleExist(moduleName))
			request.getServletContext().getRequestDispatcher("/Mod"+ConfigManager.setFirstUppercase(moduleName)).forward(request, response);
		else{
			includeManager.addJSP(request, REDIRECT404);
			includeManager.setTitle(request, languageManager.getLanguageValue("404_title", langTag));
			request.getServletContext().getRequestDispatcher("/templates/"+configManager.getDefaultTemplate()+"/index.jsp").forward(request, response);
		}
	}

	private void init(HttpServletRequest request, HttpServletResponse response) {
		if(request.getCookies() != null){
			for(Cookie cookie : request.getCookies()){
				if(cookie.getName().equalsIgnoreCase(ROPConstants.COOKIE_SESSION_ID_LABEL)){
					try{						
						this.constructSessionWithCookie(cookie.getValue(), request, response);
					} catch(ROPApplException e){
						
					}
					break;
				}
			}
		}
		IncludeManager includeManager = new IncludeManager(request);
		request.setAttribute("includeManager", includeManager);
	}

	private void constructSessionWithCookie(String value, HttpServletRequest request, HttpServletResponse response) throws ROPApplException{
		try {
			String baossrid = encryptor.decrypt(value);
			int id = Integer.parseInt(baossrid);
			BaoUser user = ROPUserDao.getUserById(id);
			if(user != null && user.getUserAccountState() != ROPConstants.STATE_DESACTIVATED && user.getUserAccountState() != ROPConstants.STATE_DELETED){
				request.getSession().setAttribute("baoUser", user);
				Cookie cook = new Cookie(ROPConstants.COOKIE_SESSION_ID_LABEL, encryptor.encrypt(user.getUserId()+""));
				cook.setPath("/");
				cook.setMaxAge(2 * 7 * 24 * 60 * 60);
				response.addCookie(cook);
			}
		}catch(Exception e){
			throw new ROPApplException(e);
		}
	}
	
	private void informAboutCookie(String tag, HttpServletRequest request, HttpServletResponse response){
		try {
			if(request.getCookies() != null){
				for(Cookie cookie : request.getCookies()){
					if(cookie.getName().equalsIgnoreCase(ROPConstants.COOKIE_AGREE_LABEL))
						return;
				}
			}
			int sid = getIncludeManager(request).createInfoStatus(languageManager.getLanguageValue("auth_cookie", tag), request);
			getIncludeManager(request).addStatusInfoAction(request, sid, GuiStatus.JAVASCRIPT_FUNCTION, "iAgreeCookie()", languageManager.getLanguageValue("auth_cookie_ok", tag));
		}catch(Exception e){
			
		}
	}
	
	private void validateCookie(HttpServletRequest request, HttpServletResponse response){
		try {
			Cookie cook = new Cookie(ROPConstants.COOKIE_AGREE_LABEL, encryptor.encrypt("true"));
			cook.setPath("/");
			cook.setMaxAge(2 * 7 * 24 * 60 * 60);
			response.addCookie(cook);
		}catch(Exception e){
			
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		languageManager = (ROPLanguageManager)fConfig.getServletContext().getAttribute("languageManager");
		encryptor = (ROPEncryptor)fConfig.getServletContext().getAttribute("encryptor");
		configManager = (ConfigManager)fConfig.getServletContext().getAttribute("configManager");
	}
}
