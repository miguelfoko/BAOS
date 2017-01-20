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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rop.miu.util.IncludeManager;
import rop.miu.util.ROPCryptographyException;
import rop.miu.util.ROPEncryptor;
import rop.miu.util.ROPLanguageManager;


public class FiltrePrincipal implements Filter {

	private TesteurFiltrePrincipal testeur;
	public final String REDIRECT404 = "/ressources/jsp/redirect404.jsp";
	protected ROPLanguageManager languageManager;
	protected ROPEncryptor encryptor;
	
    public FiltrePrincipal() {
    	
    }

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		testeur = new TesteurFiltrePrincipal();
		String tag = (String)request.getSession().getAttribute("tag");
		if(tag == null){
			tag = testeur.getLangTags().get(0);
			request.getSession().setAttribute("tag", tag);
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
			if(testeur.getLangTags().contains(value) && !tag.equals(value)){
				tag = value;
				request.getSession().setAttribute("tag", tag);
			}
		}
		try{
			ArrayList<String> tags = testeur.getLangTags();
			ArrayList<String> names = testeur.getLangNames();
			ArrayList<String> link = new ArrayList<String>();
			for(int i = 0; i < tags.size(); i++){
				link.add("<a href=\"index.jsp?l="+encryptor.encrypt("s")+"&v="+encryptor.encrypt(tags.get(i))+"\">"+names.get(i)+"</a>");
			}
			request.setAttribute("langItems", link);
			
			String success = request.getParameter("success");
			if(success != null)
				request.setAttribute("success", languageManager.getLanguageValue(encryptor.decrypt(success), tag));
			
			String error = request.getParameter("error");
			if(error != null)
				request.setAttribute("error", languageManager.getLanguageValue(encryptor.decrypt(error), tag));
		}catch(Exception e){
			
		}
		
		request.setAttribute("modules", testeur.getModules());
		
		String moduleName = request.getParameter("m"),
			   contextPath = request.getContextPath();
		if(moduleName != null){
			try {
				moduleName = encryptor.decrypt(moduleName);
			} catch (ROPCryptographyException e2) {
				moduleName = null;
			}
		}
		String chemin = request.getRequestURI().substring(contextPath.length() );
		if ((chemin.startsWith( "/ressources" )) || (chemin.startsWith( "/admin" )) || (chemin.startsWith( "/modules" )) || (chemin.startsWith( "/templates" ))) {
			chain.doFilter( request, response );
			return;
		}
		
		//Récupérer un user
		
		/*if(user == null){
			request.getServletContext().getRequestDispatcher("/ModAuth").forward(request, response);
			return;
		}*/
		
		if((chemin.endsWith("/index.jsp") || chemin.length() <= 1) && (moduleName == null)){
			request.getServletContext().getRequestDispatcher("/Mod"+TesteurFiltrePrincipal.setFirstUppercase(testeur.getDefaultModule())).forward(request, response);
			return;
		}
		if(testeur.moduleExist(moduleName))
			request.getServletContext().getRequestDispatcher("/Mod"+TesteurFiltrePrincipal.setFirstUppercase(moduleName)).forward(request, response);
		else{
			IncludeManager includeManager = new IncludeManager(request);
			includeManager.addJSP(REDIRECT404);
			includeManager.setTitle(languageManager.getLanguageValue("404_title", tag));
			request.getServletContext().getRequestDispatcher("/templates/"+testeur.getDefaultTemplate()+"/index.jsp").forward(request, response);
		}
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		languageManager = (ROPLanguageManager)fConfig.getServletContext().getAttribute("languageManager");
		encryptor = (ROPEncryptor)fConfig.getServletContext().getAttribute("encryptor");
	}
}
