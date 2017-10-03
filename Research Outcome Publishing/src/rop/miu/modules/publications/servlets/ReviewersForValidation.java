package rop.miu.modules.publications.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rop.miu.beans.BaoReviewOrEditionContract;
import rop.miu.beans.BaoUser;
import rop.miu.modules.ServletModel;
import rop.miu.modules.publications.dao.ROPPublicationsDao;
<<<<<<< HEAD
=======
import rop.miu.util.exceptions.ROPCryptographyException;
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc


public class ReviewersForValidation extends ServletModel {
	private static final long serialVersionUID = 1L;

    public ReviewersForValidation() {
        super();
        
    }


<<<<<<< HEAD
	@Override
=======
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		HttpSession sessionContext = request.getSession();
		    	
		ROPPublicationsDao dao = new ROPPublicationsDao();
		
<<<<<<< HEAD
=======
		
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		int journalID=-1;
		try{
			journalID = (Integer)sessionContext.getAttribute("journalID");
		}
		catch (NumberFormatException e){
			e.printStackTrace();
		}
		
		List<BaoReviewOrEditionContract> reviewcontract = dao.getAllReviewersForAJournal(journalID);
<<<<<<< HEAD
=======
		try {
			System.out.println(encryptor.encrypt(encryptor.encrypt(("mdemaya"))));
		} catch (ROPCryptographyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		ArrayList<BaoUser> reviewers = new ArrayList<BaoUser>();
		for (BaoReviewOrEditionContract r: reviewcontract) {
			reviewers.add(r.getUserIdContractCreator());
		}
		
		sessionContext.setAttribute("context", null);
		request.setAttribute("ATTR_reviewersList", reviewers);
		request.setAttribute("journalID", sessionContext.getAttribute("journalID"));
    	    	
		request.setAttribute("action", "printreviewersforvalidation");
		request.setAttribute("id_papier", request.getParameter("id_papier"));
<<<<<<< HEAD
		includeManager.setTitle(languageManager.getLanguageValue("publication_title", langTag));
		includeManager.addJSP("/modules/publications/index.jsp");
		includeManager.addCSS("/modules/publications/css/publications.css");
		returnRequest(request, response);
	}

	@Override
=======
		includeManager.setTitle(request, languageManager.getLanguageValue("publication_title", langTag));
		includeManager.addJSP(request, "/modules/publications/index.jsp");
		includeManager.addCSS(request, "/modules/publications/css/publications.css");
		returnRequest(request, response);
	}

>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}

}
