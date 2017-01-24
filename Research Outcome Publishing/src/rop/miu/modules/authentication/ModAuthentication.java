package rop.miu.modules.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rop.miu.beans.BaoUser;
import rop.miu.dao.ROPUserDao;
import rop.miu.modules.ServletModel;
import rop.miu.util.ROPConstants;

public class ModAuthentication extends ServletModel {
	private static final long serialVersionUID = 1L;
       
    public ModAuthentication() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String option = null;
		try{
			String parOpt = request.getParameter("o");
			if(parOpt != null)
				option = encryptor.decrypt(parOpt);
		}catch(Exception e){
			forward500(request, response);
		}
		
		if(option == null || option.equals("login")){
			includeManager.setTitle(languageManager.getLanguageValue("login_title", langTag));
			if(isConnected())
				includeManager.setTitle(languageManager.getLanguageValue("logout_title", langTag));
			includeManager.addJSP("/modules/authentication/login.jsp");
			returnRequest(request, response);
			return;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		String option = null;
		try{
			String parOpt = request.getParameter("o");
			if(parOpt != null)
				option = encryptor.decrypt(parOpt);
		}catch(Exception e){
			forward500(request, response);
			return;
		}
		
		if(option == null || option.equals("login")){
			String login = request.getParameter("login");
			if(login == null){
				includeManager.setTitle(languageManager.getLanguageValue("login_title", langTag));
				if(isConnected())
					includeManager.setTitle(languageManager.getLanguageValue("logout_title", langTag));
				includeManager.addJSP("/modules/authentication/login.jsp");
				returnRequest(request, response);
				return;
			}
			String pass = request.getParameter("pass");
			try{
				if(pass != null)
					pass = encryptor.encrypt(encryptor.encrypt(pass));
			}catch(Exception e){
				
			}
			String stayLogged = request.getParameter("stayLogged");
			String redirect = request.getParameter("auth_redirect");
			BaoUser user = null;
			if(login.contains("@"))
				user = ROPUserDao.getUserByEmailAndPassword(login, pass);
			else
				user = ROPUserDao.getUserByLoginAndPassword(login, pass);
			if(user != null){
				request.getSession().setAttribute("baoUser", user);
				if(stayLogged != null){
					try{
						Cookie cookie = new Cookie(ROPConstants.COOKIE_SESSION_ID_LABEL, encryptor.encrypt(user.getUserId()+""));
						cookie.setPath("/");
						cookie.setMaxAge(2 * 7 * 24 * 60 * 60);
						response.addCookie(cookie);
					}catch(Exception e){
						
					}
				}
				if(redirect != null){
					try{
						if(redirect != null)
							redirect = encryptor.decrypt(redirect);
						forwardToModule(request, response, redirect);
						return;
					}catch(Exception e){
						includeManager.setTitle(languageManager.getLanguageValue("logout_title", langTag));
						includeManager.addJSP("/modules/authentication/login.jsp");
						returnRequest(request, response);
						return;
					}
				}
				includeManager.setTitle(languageManager.getLanguageValue("logout_title", langTag));
				includeManager.addJSP("/modules/authentication/login.jsp");
				returnRequest(request, response);
				return;
			}
			request.setAttribute("loginError", languageManager.getLanguageValue("login_error", langTag));
			request.setAttribute("systemError", languageManager.getLanguageValue("login_error", langTag));
			includeManager.setTitle(languageManager.getLanguageValue("login_title", langTag));
			includeManager.addJSP("/modules/authentication/login.jsp");
			returnRequest(request, response);
			return;
		}
	}
}
