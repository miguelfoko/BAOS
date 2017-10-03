package rop.miu.modules.publications.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rop.miu.beans.BaoPaper;
import rop.miu.beans.BaoReviewOrEditionContract;
import rop.miu.beans.BaoUser;
import rop.miu.beans.BaoVolumeOrIssue;
import rop.miu.modules.ServletModel;
import rop.miu.modules.publications.dao.ROPPublicationsDao;


public class UserDashBoard extends ServletModel {
	private static final long serialVersionUID = 1L;
       

    public UserDashBoard() {
        super();
       
    }

<<<<<<< HEAD
	@Override
=======
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		HttpSession journalInSession = request.getSession();
		
		int journalID=-1;
		
		try{
			journalID = Integer.parseInt(request.getParameter("id_journal"));
		}
		catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		ROPPublicationsDao dao = new ROPPublicationsDao();
		List<BaoPaper> unreadPapers = dao.getAllUnreadPapersByJournal();
		List<BaoVolumeOrIssue> volumesOfThisJournal = dao.getAllVolumesOfAJournal(journalID);
		
		List<BaoReviewOrEditionContract> reviewcontract = dao.getAllReviewersForAJournal(journalID);
		ArrayList<BaoUser> reviewers = new ArrayList<BaoUser>();
		for (BaoReviewOrEditionContract r: reviewcontract) {
			reviewers.add(r.getUserIdContractCreator());
		}
		
		journalInSession.setAttribute("journalID", journalID);
		
		request.setAttribute("action", "userDashboard");
		request.setAttribute("journalID", journalID);
		request.setAttribute("ATTR_unreadPapers", unreadPapers);
		request.setAttribute("ATTR_volumeOfJournal", volumesOfThisJournal);
		request.setAttribute("ATTR_reviewersList", reviewers);
<<<<<<< HEAD
		includeManager.setTitle(languageManager.getLanguageValue("publication_title", langTag));
		includeManager.addJSP("/modules/publications/index.jsp");
		includeManager.addCSS("/modules/publications/css/publications.css");
		includeManager.addJS("/modules/publications/js/jquery-ui-1.8.13.custom.min.js");
		includeManager.addJS("/modules/publications/js/jquery-1.2.3.min.js");
		includeManager.addJS("/modules/publications/js/onglet.js");
=======
		includeManager.setTitle(request, languageManager.getLanguageValue("publication_title", langTag));
		includeManager.addJSP(request, "/modules/publications/index.jsp");
		includeManager.addCSS(request, "/modules/publications/css/publications.css");
		includeManager.addJS(request, "/modules/publications/js/jquery-ui-1.8.13.custom.min.js");
		includeManager.addJS(request, "/modules/publications/js/jquery-1.2.3.min.js");
		includeManager.addJS(request, "/modules/publications/js/onglet.js");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		returnRequest(request, response);
	}

	
<<<<<<< HEAD
	@Override
=======
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}

}
