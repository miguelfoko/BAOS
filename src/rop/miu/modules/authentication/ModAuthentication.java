package rop.miu.modules.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rop.miu.modules.ServletModel;

public class ModAuthentication extends ServletModel {
	private static final long serialVersionUID = 1L;
       
    public ModAuthentication() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		request.setAttribute("hello_hello", "Bonjour");
		includeManager.setTitle(languageManager.getLanguageValue("hello_title", langTag));
		includeManager.addJSP("/modules/authentication/login.jsp");
		
		returnRequest(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
