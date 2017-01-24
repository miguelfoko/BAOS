package rop.miu;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rop.miu.util.IncludeManager;
import rop.miu.util.ROPEncryptor;
import rop.miu.util.ROPLanguageManager;
import rop.miu.util.exceptions.ROPCryptographyException;



public class FiltreAdmin implements Filter {

	private TesteurFiltrePrincipal testeur;
	public final String REDIRECT404 = "/ressources/jsp/redirect404.jsp";
	protected ROPLanguageManager languageManager;
	protected ROPEncryptor encryptor;
	
    public FiltreAdmin() {
        
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
		
		String moduleName = request.getParameter("module"),
			   contextPath = request.getContextPath();
		if(moduleName != null){
			try {
				moduleName = encryptor.decrypt(moduleName);
			} catch (ROPCryptographyException e2) {
				moduleName = null;
			}
		}
		String chemin = request.getRequestURI().substring(contextPath.length() + 6);
		
		if((chemin.startsWith("/modules")) || (chemin.startsWith("/templates"))) {
			chain.doFilter( request, response );
			return;
		}
		
		/*UserBanque baoUser = (UserBanque)request.getSession().getAttribute("baoUser");
		try {
			if(baoUser == null || !AccesRightDao.isAccessGranted(ROPConstants.DROIT_ACCEDER_ADMIN, baoUser)){
				String redirect = "";
				String name;
				Enumeration<String> enumeration = request.getParameterNames();
				while(enumeration.hasMoreElements()){
					name = enumeration.nextElement();
					redirect += "&"+name+"="+encryptor.encrypt(request.getParameter(name));
				}
				if(redirect.length() > 0)
					redirect.substring(1);
				redirect = "admin/"+redirect;
				request.setAttribute("redirect", redirect);
				request.setAttribute("message", languageManager.getLanguageValue("access_not_granted", tag));
				request.getServletContext().getRequestDispatcher("/ModAuth").forward(request, response);
				return;
			}
		} catch (Exception e) {
			request.getServletContext().getRequestDispatcher("/ModAuth").forward(request, response);
			return;
		}*/
		
		if((chemin.endsWith("/index.jsp") || chemin.length() <= 1) && (moduleName == null)){
			request.getServletContext().getRequestDispatcher("/ModAdmin"+TesteurFiltrePrincipal.setFirstUppercase(testeur.getDefaultAdminModule())).forward(request, response);
			return;
		}
		if(testeur.adminModuleExist(moduleName))
			request.getServletContext().getRequestDispatcher("/ModAdmin"+TesteurFiltrePrincipal.setFirstUppercase(moduleName)).forward(request, response);
		else{
			IncludeManager includeManager = new IncludeManager(request);
			includeManager.addJSP(REDIRECT404);
			includeManager.setTitle(languageManager.getLanguageValue("404_title", tag));
			request.getServletContext().getRequestDispatcher("/admin/templates/"+testeur.getDefaultAdminTemplate()+"/index.jsp").forward(request, response);
		}
	}

	
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		languageManager = (ROPLanguageManager)fConfig.getServletContext().getAttribute("languageManager");
		encryptor = (ROPEncryptor)fConfig.getServletContext().getAttribute("encryptor");
	}
}
