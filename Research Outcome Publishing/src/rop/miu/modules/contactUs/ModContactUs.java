package rop.miu.modules.contactUs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rop.miu.modules.ServletModel;
import rop.miu.util.ROPEncryptor;
import rop.miu.util.exceptions.ROPCryptographyException;


//@WebServlet("/ModContactUs")
public class ModContactUs extends ServletModel {
	private static final long serialVersionUID = 1L;
       
    
    public ModContactUs() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		ROPEncryptor encryptor = new ROPEncryptor();
    	String action="";
    	if(request.getParameter("a") != null){
    		try {
	    		action = encryptor.decrypt(request.getParameter("a"));
	    	} catch (ROPCryptographyException e) {
				
			}
    		if (action.equalsIgnoreCase("email")) {
    			includeManager.setTitle(request, languageManager.getLanguageValue("cu_email", langTag));
				includeManager.addJSP(request, "/modules/contactUs/email.jsp");
				returnRequest(request, response);
    		}
    		if (action.equalsIgnoreCase("telephone")) {
    			includeManager.setTitle(request, languageManager.getLanguageValue("cu_telephone", langTag));
				includeManager.addJSP(request, "/modules/contactUs/telephone.jsp");
				returnRequest(request, response);
    		}
    		if (action.equalsIgnoreCase("developpers")) {
    			includeManager.setTitle(request, languageManager.getLanguageValue("cu_developpers", langTag));
				includeManager.addJSP(request, "/modules/contactUs/developpers.jsp");
				returnRequest(request, response);
    		}
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}

}
