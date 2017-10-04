package rop.miu.modules.contactUs;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rop.miu.modules.ServletModel;
import rop.miu.modules.pages.util.CreateMenu;
import rop.miu.util.ROPEncryptor;
import rop.miu.util.exceptions.ROPCryptographyException;


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
    		if (action.equalsIgnoreCase("ourContacts")) {
    			HashMap<String,String> menuList = new HashMap<String,String>();
    			File fileMenu=new File((getClass().getResource("/../.." + "/modules/contactUs/menus/aboutUs-menu.txt").getFile()).replace("%20", " "));
				menuList = CreateMenu.generateMenu(fileMenu);
				int id = getIncludeManager(request).createSideMenu(request, languageManager.getLanguageValue("auth_about", langTag));
				for (int i=0; i<menuList.size(); i++){
					try {
						includeManager.addMenuItem(request, id,menuList.keySet().toArray()[i].toString(),"#"+menuList.get(menuList.keySet().toArray()[i].toString()));
					} catch(Exception e) {
					
					}
				}
    			
    			includeManager.setTitle(request, languageManager.getLanguageValue("cu_contacts", langTag));
				includeManager.addJSP(request, "/modules/contactUs/aboutUs.jsp");
				returnRequest(request, response);
    		}
    		if (action.equalsIgnoreCase("developpers")) { 
    			includeManager.setTitle(request, languageManager.getLanguageValue("cu_developpers", langTag));
				includeManager.addJSP(request, "/modules/contactUs/developpers.jsp");
				returnRequest(request, response);
    		}
    		if (action.equalsIgnoreCase("aboutUs")) {
    			HashMap<String,String> menuList = new HashMap<String,String>();
    			File fileMenu=new File((getClass().getResource("/../.." + "/modules/contactUs/menus/aboutUs-menu.txt").getFile()).replace("%20", " "));
				menuList = CreateMenu.generateMenu(fileMenu);
				int id = getIncludeManager(request).createSideMenu(request, languageManager.getLanguageValue("auth_about", langTag));
				for (int i=0; i<menuList.size(); i++){
					try {
						includeManager.addMenuItem(request, id,menuList.keySet().toArray()[i].toString(),"#"+menuList.get(menuList.keySet().toArray()[i].toString()));
					} catch(Exception e) {
					
					}
				}
    			includeManager.setTitle(request, languageManager.getLanguageValue("auth_about", langTag));
				includeManager.addJSP(request, "/modules/contactUs/aboutUs.jsp");
				returnRequest(request, response);
    		}
    		if (action.equalsIgnoreCase("terms")){
    			HashMap<String,String> menuList = new HashMap<String,String>();
    			File fileMenu=new File((getClass().getResource("/../.." + "/modules/contactUs/menus/terms-menu.txt").getFile()).replace("%20", " "));
				menuList = CreateMenu.generateMenu(fileMenu);
				int id = getIncludeManager(request).createSideMenu(request, languageManager.getLanguageValue("cu_terms", langTag));
				for (int i=0; i<menuList.size(); i++){
					try {
						includeManager.addMenuItem(request, id,menuList.keySet().toArray()[i].toString(),"#"+menuList.get(menuList.keySet().toArray()[i].toString()));
					} catch(Exception e) {
					
					}
				}
    			
    			includeManager.setTitle(request, languageManager.getLanguageValue("cu_terms", langTag));
				includeManager.addJSP(request, "/modules/contactUs/terms.jsp");
				returnRequest(request, response);
    		}
    		if (action.equalsIgnoreCase("privacy")){
    			HashMap<String,String> menuList = new HashMap<String,String>();
    			File fileMenu=new File((getClass().getResource("/../.." + "/modules/contactUs/menus/privacy-menu.txt").getFile()).replace("%20", " "));
				menuList = CreateMenu.generateMenu(fileMenu);
				int id = getIncludeManager(request).createSideMenu(request, languageManager.getLanguageValue("cu_privacy", langTag));
				for (int i=0; i<menuList.size(); i++){
					try {
						includeManager.addMenuItem(request, id,menuList.keySet().toArray()[i].toString(),"#"+menuList.get(menuList.keySet().toArray()[i].toString()));
					} catch(Exception e) {
					
					}
				}
    			
    			includeManager.setTitle(request, languageManager.getLanguageValue("cu_privacy", langTag));
				includeManager.addJSP(request, "/modules/contactUs/privacy.jsp");
				returnRequest(request, response);
    		}
    		if (action.equalsIgnoreCase("siteMap")){
    			includeManager.setTitle(request, languageManager.getLanguageValue("cu_site_map", langTag));
				includeManager.addJSP(request, "/modules/contactUs/siteMap.jsp");
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
