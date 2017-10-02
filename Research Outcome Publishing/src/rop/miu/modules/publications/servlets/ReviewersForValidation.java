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
import rop.miu.util.exceptions.ROPCryptographyException;


public class ReviewersForValidation extends ServletModel {
	private static final long serialVersionUID = 1L;

    public ReviewersForValidation() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		HttpSession sessionContext = request.getSession();
		    	
		ROPPublicationsDao dao = new ROPPublicationsDao();
		
		
		int journalID=-1;
		try{
			journalID = (Integer)sessionContext.getAttribute("journalID");
		}
		catch (NumberFormatException e){
			e.printStackTrace();
		}
		
		List<BaoReviewOrEditionContract> reviewcontract = dao.getAllReviewersForAJournal(journalID);
		try {
			System.out.println(encryptor.encrypt(encryptor.encrypt(("mdemaya"))));
		} catch (ROPCryptographyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<BaoUser> reviewers = new ArrayList<BaoUser>();
		for (BaoReviewOrEditionContract r: reviewcontract) {
			reviewers.add(r.getUserIdContractCreator());
		}
		
		sessionContext.setAttribute("context", null);
		request.setAttribute("ATTR_reviewersList", reviewers);
		request.setAttribute("journalID", sessionContext.getAttribute("journalID"));
    	    	
		request.setAttribute("action", "printreviewersforvalidation");
		request.setAttribute("id_papier", request.getParameter("id_papier"));
		includeManager.setTitle(request, languageManager.getLanguageValue("publication_title", langTag));
		includeManager.addJSP(request, "/modules/publications/index.jsp");
		includeManager.addCSS(request, "/modules/publications/css/publications.css");
		returnRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}

}
