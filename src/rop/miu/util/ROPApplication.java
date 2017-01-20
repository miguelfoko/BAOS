package rop.miu.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import rop.miu.TesteurFiltrePrincipal;


public class ROPApplication implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext servletContext = event.getServletContext();
		ROPLanguageManager lang = null;
		ROPEncryptor encryptor = null;
		try {
			lang = new ROPLanguageManager((new TesteurFiltrePrincipal()).getLangTags());
			encryptor = new ROPEncryptor();
		} catch (Exception e) {
			
		}
		servletContext.setAttribute("languageManager", lang);
		servletContext.setAttribute("encryptor", encryptor);
	}

}
