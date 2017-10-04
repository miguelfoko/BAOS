package rop.miu.modules.publications.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rop.miu.beans.BaoJournalOrConf;
import rop.miu.beans.BaoPaper;
import rop.miu.modules.ServletModel;
import rop.miu.modules.publications.dao.ROPPublicationsDao;


public class GetAllArticlesOfAJournal extends ServletModel {
	private static final long serialVersionUID = 1L;
       

    public GetAllArticlesOfAJournal() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		/*HttpSession journalInSession = request.getSession();
		
		int journalID=-1;
		
		try{
			journalID = Integer.parseInt(request.getParameter("id_journal"));
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		ROPPublicationsDao dao = new ROPPublicationsDao();
		List<BaoPaper> paperList = dao.getAllArticlesByJournal(journalID);
		BaoJournalOrConf journal = dao.getAJournalByID(journalID);
		
		journalInSession.setAttribute("journalID", journalID);
		
		request.setAttribute("action", "articlesOfAJournal");
		request.setAttribute("ATTR_paperList", paperList);
		request.setAttribute("journalID", journalID);
		request.setAttribute("journal", journal);
		includeManager.setTitle(request, languageManager.getLanguageValue("publication_title", langTag));
		includeManager.addJSP(request, "/modules/publications/index.jsp");
		includeManager.addCSS(request, "/modules/publications/css/publications.css");
		
		includeManager.addJS(request, "/modules/publications/js/jquery-ui-1.8.13.custom.min.js");
		includeManager.addJS(request, "/modules/publications/js/jquery-1.2.3.min.js");
		includeManager.addJS(request, "/modules/publications/js/onglet.js");
		returnRequest(request, response);*/
		
		includeManager.addJSP(request, "/modules/publications/underConstruction.jsp");
		returnRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		
		/*request.setAttribute("action", "articlesOfAJournal");
		includeManager.setTitle(request, languageManager.getLanguageValue("publication_title", langTag));
		includeManager.addJSP(request, "/modules/publications/index.jsp");
		includeManager.addCSS(request, "/modules/publications/css/publications.css");
		includeManager.addJS(request, "/modules/publications/js/jquery-ui-1.8.13.custom.min.js");
		includeManager.addJS(request, "/modules/publications/js/jquery-1.2.3.min.js");
		includeManager.addJS(request, "/modules/publications/js/onglets.js");
		returnRequest(request, response);*/
		
		includeManager.addJSP(request, "/modules/publications/underConstruction.jsp");
		returnRequest(request, response);
	}

}
