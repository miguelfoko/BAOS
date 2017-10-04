package rop.miu.modules.pages;

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

public class ModPages extends ServletModel {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModPages() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		ROPEncryptor encryptor = new ROPEncryptor();
    	String action="";
    	HashMap<String,String> menuList = new HashMap<String,String>();
    	if(request.getParameter("a") != null){
    		try {
	    		action = encryptor.decrypt(request.getParameter("a"));
	    	} catch (ROPCryptographyException e) {
				
			}
    		if (action.equalsIgnoreCase("guideForAutors")) {
				if (langTag.equalsIgnoreCase("fr_FR")){
					File fileMenu=new File((getClass().getResource("/../.." + "/modules/pages/fr_FR/menus/guideForAuthors-menu.txt").getFile()).replace("%20", " "));
					menuList = CreateMenu.generateMenu(fileMenu);
					int id = getIncludeManager(request).createSideMenu(request, languageManager.getLanguageValue("pages_guide_for_authors", langTag));
					for (int i=0; i<menuList.size(); i++){
						try {
							includeManager.addMenuItem(request, id,menuList.keySet().toArray()[i].toString(),"#"+menuList.get(menuList.keySet().toArray()[i].toString()));
						} catch(Exception e) {
						
						}
					}
									
					includeManager.setTitle(request, languageManager.getLanguageValue("pages_guide_for_authors", langTag));
					includeManager.addJSP(request, "/modules/pages/fr_FR/guideForAuthors.jsp");
					returnRequest(request, response);
				}
				if (langTag.equalsIgnoreCase("en_GB")){
					File fileMenu=new File((getClass().getResource("/../.." + "/modules/pages/en_GB/menus/guideForAuthors-menu.txt").getFile()).replace("%20", " "));
					menuList = CreateMenu.generateMenu(fileMenu);
					int id = getIncludeManager(request).createSideMenu(request, languageManager.getLanguageValue("pages_guide_for_authors", langTag));
					for (int i=0; i<menuList.size(); i++){
						try {
							includeManager.addMenuItem(request, id,menuList.keySet().toArray()[i].toString(),"#"+menuList.get(menuList.keySet().toArray()[i].toString()));
						} catch(Exception e) {
						
						}
					}
					
					includeManager.setTitle(request, languageManager.getLanguageValue("pages_guide_for_authors", langTag));
					includeManager.addJSP(request, "/modules/pages/en_GB/guideForAuthors.jsp");
					returnRequest(request, response);
				}
	    	}
    		if (action.equalsIgnoreCase("guideForTeachers")) {
    			if (langTag.equalsIgnoreCase("fr_FR")){
    				File fileMenu=new File((getClass().getResource("/../.." + "/modules/pages/fr_FR/menus/guideForTeachers-menu.txt").getFile()).replace("%20", " "));
					menuList = CreateMenu.generateMenu(fileMenu);
    				int id = getIncludeManager(request).createSideMenu(request, languageManager.getLanguageValue("pages_guide_for_teachers", langTag));
    				for (int i=0; i<menuList.size(); i++){
						try {
							includeManager.addMenuItem(request, id,menuList.keySet().toArray()[i].toString(),"#"+menuList.get(menuList.keySet().toArray()[i].toString()));
						} catch(Exception e) {
						
						}
					}
    				
    				includeManager.setTitle(request, languageManager.getLanguageValue("pages_guide_for_teachers", langTag));
					includeManager.addJSP(request, "/modules/pages/fr_FR/guideForTeachers.jsp");
					returnRequest(request, response);
				}
				if (langTag.equalsIgnoreCase("en_GB")){
					File fileMenu=new File((getClass().getResource("/../.." + "/modules/pages/en_GB/menus/guideForTeachers-menu.txt").getFile()).replace("%20", " "));
					menuList = CreateMenu.generateMenu(fileMenu);
					int id = getIncludeManager(request).createSideMenu(request, languageManager.getLanguageValue("pages_guide_for_teachers", langTag));
					for (int i=0; i<menuList.size(); i++){
						try {
							includeManager.addMenuItem(request, id,menuList.keySet().toArray()[i].toString(),"#"+menuList.get(menuList.keySet().toArray()[i].toString()));
						} catch(Exception e) {
						
						}
					}
					
					includeManager.setTitle(request, languageManager.getLanguageValue("pages_guide_for_teachers", langTag));
					includeManager.addJSP(request, "/modules/pages/en_GB/guideForTeachers.jsp");
					returnRequest(request, response);
				}
	    	}
    		if (action.equalsIgnoreCase("guideForStudents")) {
    			if (langTag.equalsIgnoreCase("fr_FR")){
    				File fileMenu=new File((getClass().getResource("/../.." + "/modules/pages/fr_FR/menus/guideForStudents-menu.txt").getFile()).replace("%20", " "));
					menuList = CreateMenu.generateMenu(fileMenu);    				
    				int id = getIncludeManager(request).createSideMenu(request, languageManager.getLanguageValue("pages_guide_for_students", langTag));
    				for (int i=0; i<menuList.size(); i++){
						try {
							includeManager.addMenuItem(request, id,menuList.keySet().toArray()[i].toString(),"#"+menuList.get(menuList.keySet().toArray()[i].toString()));
						} catch(Exception e) {
						
						}
					}
    				
    				includeManager.setTitle(request, languageManager.getLanguageValue("pages_guide_for_students", langTag));
					includeManager.addJSP(request, "/modules/pages/fr_FR/guideForStudents.jsp");
					returnRequest(request, response);
				}
				if (langTag.equalsIgnoreCase("en_GB")){
					File fileMenu=new File((getClass().getResource("/../.." + "/modules/pages/en_GB/menus/guideForStudents-menu.txt").getFile()).replace("%20", " "));
					menuList = CreateMenu.generateMenu(fileMenu);
					int id = getIncludeManager(request).createSideMenu(request, languageManager.getLanguageValue("pages_guide_for_students", langTag));
					for (int i=0; i<menuList.size(); i++){
						try {
							includeManager.addMenuItem(request, id,menuList.keySet().toArray()[i].toString(),"#"+menuList.get(menuList.keySet().toArray()[i].toString()));
						} catch(Exception e) {
						
						}
					}
					
					includeManager.setTitle(request, languageManager.getLanguageValue("pages_guide_for_students", langTag));
					includeManager.addJSP(request, "/modules/pages/en_GB/guideForStudents.jsp");
					returnRequest(request, response);
				}
	    	}
    		if (action.equalsIgnoreCase("guideForMonitors")) {
    			if (langTag.equalsIgnoreCase("fr_FR")){
    				File fileMenu=new File((getClass().getResource("/../.." + "/modules/pages/fr_FR/menus/guideForMonitors-menu.txt").getFile()).replace("%20", " "));
					menuList = CreateMenu.generateMenu(fileMenu);    				
    				int id = getIncludeManager(request).createSideMenu(request, languageManager.getLanguageValue("pages_guide_for_monitors", langTag));
    				for (int i=0; i<menuList.size(); i++){
						try {
							includeManager.addMenuItem(request, id,menuList.keySet().toArray()[i].toString(),"#"+menuList.get(menuList.keySet().toArray()[i].toString()));
						} catch(Exception e) {
						
						}
					}
    				
    				includeManager.setTitle(request, languageManager.getLanguageValue("pages_guide_for_monitors", langTag));
					includeManager.addJSP(request, "/modules/pages/fr_FR/guideForMonitors.jsp");
					returnRequest(request, response);
				}
				if (langTag.equalsIgnoreCase("en_GB")){
					File fileMenu=new File((getClass().getResource("/../.." + "/modules/pages/en_GB/menus/guideForMonitors-menu.txt").getFile()).replace("%20", " "));
					menuList = CreateMenu.generateMenu(fileMenu);
					int id = getIncludeManager(request).createSideMenu(request, languageManager.getLanguageValue("pages_guide_for_monitors", langTag));
					for (int i=0; i<menuList.size(); i++){
						try {
							includeManager.addMenuItem(request, id,menuList.keySet().toArray()[i].toString(),"#"+menuList.get(menuList.keySet().toArray()[i].toString()));
						} catch(Exception e) {
						
						}
					}
					
					includeManager.setTitle(request, languageManager.getLanguageValue("pages_guide_for_monitors", langTag));
					includeManager.addJSP(request, "/modules/pages/en_GB/guideForMonitors.jsp");
					returnRequest(request, response);
				}
	    	}
    		if (action.equalsIgnoreCase("aboutELearning")) {
    			if (langTag.equalsIgnoreCase("fr_FR")){
    				File fileMenu=new File((getClass().getResource("/../.." + "/modules/pages/fr_FR/menus/aboutELearning-menu.txt").getFile()).replace("%20", " "));
					menuList = CreateMenu.generateMenu(fileMenu);    				
    				int id = getIncludeManager(request).createSideMenu(request, languageManager.getLanguageValue("pages_about_elearning", langTag));
    				for (int i=0; i<menuList.size(); i++){
						try {
							includeManager.addMenuItem(request, id,menuList.keySet().toArray()[i].toString(),"#"+menuList.get(menuList.keySet().toArray()[i].toString()));
						} catch(Exception e) {
						
						}
					}
    				
    				includeManager.setTitle(request, languageManager.getLanguageValue("pages_about_elearning", langTag));
					includeManager.addJSP(request, "/modules/pages/fr_FR/aboutELearning.jsp");
					returnRequest(request, response);
				}
				if (langTag.equalsIgnoreCase("en_GB")){
					File fileMenu=new File((getClass().getResource("/../.." + "/modules/pages/en_GB/menus/aboutELearning-menu.txt").getFile()).replace("%20", " "));
					menuList = CreateMenu.generateMenu(fileMenu);
					int id = getIncludeManager(request).createSideMenu(request, languageManager.getLanguageValue("pages_about_elearning", langTag));
					for (int i=0; i<menuList.size(); i++){
						try {
							includeManager.addMenuItem(request, id,menuList.keySet().toArray()[i].toString(),"#"+menuList.get(menuList.keySet().toArray()[i].toString()));
						} catch(Exception e) {
						
						}
					}
					
					includeManager.setTitle(request, languageManager.getLanguageValue("pages_about_elearning", langTag));
					includeManager.addJSP(request, "/modules/pages/en_GB/aboutELearning.jsp");
					returnRequest(request, response);
				}
	    	}
    		if (action.equalsIgnoreCase("helpAndSupport")) {
    			if (langTag.equalsIgnoreCase("fr_FR")){
    				File fileMenu=new File((getClass().getResource("/../.." + "/modules/pages/fr_FR/menus/helpAndSupport-menu.txt").getFile()).replace("%20", " "));
					menuList = CreateMenu.generateMenu(fileMenu);    				
    				int id = getIncludeManager(request).createSideMenu(request, languageManager.getLanguageValue("pages_help_and_support", langTag));
    				for (int i=0; i<menuList.size(); i++){
						try {
							includeManager.addMenuItem(request, id,menuList.keySet().toArray()[i].toString(),"#"+menuList.get(menuList.keySet().toArray()[i].toString()));
						} catch(Exception e) {
						
						}
					}
    				
    				includeManager.setTitle(request, languageManager.getLanguageValue("pages_help_and_support", langTag));
					includeManager.addJSP(request, "/modules/pages/fr_FR/helpAndSupport.jsp");
					returnRequest(request, response);
				}
				if (langTag.equalsIgnoreCase("en_GB")){
					File fileMenu=new File((getClass().getResource("/../.." + "/modules/pages/en_GB/menus/helpAndSupport-menu.txt").getFile()).replace("%20", " "));
					menuList = CreateMenu.generateMenu(fileMenu);
					int id = getIncludeManager(request).createSideMenu(request, languageManager.getLanguageValue("pages_help_and_support", langTag));
					for (int i=0; i<menuList.size(); i++){
						try {
							includeManager.addMenuItem(request, id,menuList.keySet().toArray()[i].toString(),"#"+menuList.get(menuList.keySet().toArray()[i].toString()));
						} catch(Exception e) {
						
						}
					}
					
					includeManager.setTitle(request, languageManager.getLanguageValue("pages_help_and_support", langTag));
					includeManager.addJSP(request, "/modules/pages/en_GB/helpAndSupport.jsp");
					returnRequest(request, response);
				}
	    	}
    		
    		if (action.equalsIgnoreCase("findBooks")) {
    			includeManager.setTitle(request, languageManager.getLanguageValue("pages_guide_for_students", langTag));
				includeManager.addJSP(request, "/modules/pages/findBooks.jsp");
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
