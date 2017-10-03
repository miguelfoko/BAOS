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


<<<<<<< HEAD
	@Override
=======
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
			
		ROPPublicationsDao dao = new ROPPublicationsDao();
		List<BaoJournalOrConf> journalList = dao.getAllJournalOrConf();
				
		request.setAttribute("Attr_journalList", journalList);
		request.setAttribute("action", "indexPubli");
<<<<<<< HEAD
		includeManager.setTitle(languageManager.getLanguageValue("publication_title", langTag));
		includeManager.addJSP("/modules/publications/index.jsp");
		includeManager.addCSS("/modules/publications/css/publications.css");
		includeManager.addJS("/modules/publications/js/accordeon.js");
=======
		includeManager.setTitle(request, languageManager.getLanguageValue("publication_title", langTag));
		includeManager.addJSP(request, "/modules/publications/index.jsp");
		includeManager.addCSS(request, "/modules/publications/css/publications.css");
		includeManager.addJS(request, "/modules/publications/js/accordeon.js");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		returnRequest(request, response);
	}


<<<<<<< HEAD
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		includeManager.setTitle(languageManager.getLanguageValue("publication_title", langTag));
		includeManager.addJSP("/modules/publications/index.jsp");
		includeManager.addCSS("/modules/publications/css/publications.css");
		includeManager.addJS("/modules/publications/js/jquery-ui-1.8.13.custom.min.js");
		includeManager.addJS("/modules/publications/js/jquery-1.2.3.min.js");
		includeManager.addJS("/modules/publications/js/accordeon.js");
=======
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		includeManager.setTitle(request, languageManager.getLanguageValue("publication_title", langTag));
		includeManager.addJSP(request, "/modules/publications/index.jsp");
		includeManager.addCSS(request, "/modules/publications/css/publications.css");
		includeManager.addJS(request, "/modules/publications/js/jquery-ui-1.8.13.custom.min.js");
		includeManager.addJS(request, "/modules/publications/js/jquery-1.2.3.min.js");
		includeManager.addJS(request, "/modules/publications/js/accordeon.js");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		returnRequest(request, response);
	}

}
