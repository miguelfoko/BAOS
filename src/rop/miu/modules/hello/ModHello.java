package rop.miu.modules.hello;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rop.miu.modules.ServletModel;

public class ModHello extends ServletModel {
	private static final long serialVersionUID = 1L;
       
    public ModHello() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		request.setAttribute("hello_hello", "Bonjour");
		includeManager.setTitle(languageManager.getLanguageValue("hello_title", langTag));
		includeManager.addJSP("/modules/hello/toto.jsp");
		
		returnRequest(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
