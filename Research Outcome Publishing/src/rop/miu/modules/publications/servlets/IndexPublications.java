package rop.miu.modules.publications.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rop.miu.beans.BaoJournalOrConf;
import rop.miu.modules.ServletModel;
import rop.miu.modules.publications.dao.ROPPublicationsDao;


public class IndexPublications extends ServletModel {
	private static final long serialVersionUID = 1L;
       

    public IndexPublications() {
        super();
     }


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
			
		ROPPublicationsDao dao = new ROPPublicationsDao();
		List<BaoJournalOrConf> journalList = dao.getAllJournalOrConf();
				
		request.setAttribute("Attr_journalList", journalList);
		request.setAttribute("action", "indexPubli");
		includeManager.setTitle(languageManager.getLanguageValue("publication_title", langTag));
		includeManager.addJSP("/modules/publications/index.jsp");
		includeManager.addCSS("/modules/publications/css/publications.css");
		includeManager.addJS("/modules/publications/js/accordeon.js");
		returnRequest(request, response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		includeManager.setTitle(languageManager.getLanguageValue("publication_title", langTag));
		includeManager.addJSP("/modules/publications/index.jsp");
		includeManager.addCSS("/modules/publications/css/publications.css");
		includeManager.addJS("/modules/publications/js/jquery-ui-1.8.13.custom.min.js");
		includeManager.addJS("/modules/publications/js/jquery-1.2.3.min.js");
		includeManager.addJS("/modules/publications/js/accordeon.js");
		returnRequest(request, response);
	}

}
