package rop.miu.modules.publications;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rop.miu.beans.BaoJournalOrConf;
import rop.miu.beans.BaoVolumeOrIssue;
import rop.miu.modules.ServletModel;
import rop.miu.modules.publications.dao.ROPPublicationsDao;

import rop.miu.util.ROPEncryptor;
import rop.miu.util.exceptions.ROPCryptographyException;


public class ModPublications extends ServletModel {
	private static final long serialVersionUID = 1L;


    public ModPublications() {
        super();
       
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	super.doGet(request, response);
    	
    	HttpSession sessionContext = request.getSession();
		String context = (String)sessionContext.getAttribute("context");
    	
		ROPEncryptor encryptor = new ROPEncryptor();
    	String action="";
    	
    	if (request.getParameter("action") == null && context == null) {
    		request.getServletContext().getRequestDispatcher("/IndexPublications").forward(request, response);
    	}
    	
    	else if (request.getParameter("action") != null && context == null){
	    	try {
	    		action = encryptor.decrypt(request.getParameter("action"));
	    	} catch (ROPCryptographyException e) {
				e.printStackTrace();
			}
	    	
	    	if (action.equalsIgnoreCase("registerTopic")) {
				request.getServletContext().getRequestDispatcher("/AddTopic").forward(request, response);
	    	}
	    	
	    	if (action.equalsIgnoreCase("paperSubmission")) {
				request.getServletContext().getRequestDispatcher("/PaperSubmission").forward(request, response);
	    	}
	    	
	    	if (action.equalsIgnoreCase("articlesOfAJournal")) {
				request.getServletContext().getRequestDispatcher("/GetAllArticlesOfAJournal").forward(request, response);
	    	}
	    	
	    	if (action.equalsIgnoreCase("userDashboard")) {
				request.getServletContext().getRequestDispatcher("/UserDashBoard").forward(request, response);
	    	}
	    	
	    	if (action.equalsIgnoreCase("validationPaper1")) {
				request.getServletContext().getRequestDispatcher("/ReviewersForValidation").forward(request, response);
	    	}
	    	
	    	if (action.equalsIgnoreCase("printvolumes")) {
	    		request.getServletContext().getRequestDispatcher("/PrintVolumes").forward(request, response);
	    	}
	    	
	    	if (action.equalsIgnoreCase("sendMailForValidation")) {
				request.getServletContext().getRequestDispatcher("/SendMailForValidation").forward(request, response);
	    	}
	    	
	    		    	
    	}
    	
    	else if (request.getParameter("action") == null && context != null) {
    		if (context.equalsIgnoreCase("registerTopic")) {
				request.getServletContext().getRequestDispatcher("/AddTopic").forward(request, response);
	    	}
	    	
	    	if (context.equalsIgnoreCase("paperSubmission")) {
				request.getServletContext().getRequestDispatcher("/PaperSubmission").forward(request, response);
	    	}
	    	
	    	if (context.equalsIgnoreCase("articlesOfAJournal")) {
				request.getServletContext().getRequestDispatcher("/GetAllArticlesOfAJournal").forward(request, response);
	    	}
	    	
	    	if (context.equalsIgnoreCase("userDashboard")) {
				request.getServletContext().getRequestDispatcher("/UserDashBoard").forward(request, response);
	    	}
	    	
	    	if (context.equalsIgnoreCase("validationPaper1")) {
				request.getServletContext().getRequestDispatcher("/ReviewersForValidation").forward(request, response);
	    	}
	    	
	    	if (context.equalsIgnoreCase("printvolumes")) {
				request.getServletContext().getRequestDispatcher("/PrintVolumes").forward(request, response);
	    	}
	    	
	    	if (context.equalsIgnoreCase("sendMailForValidation")) {
				request.getServletContext().getRequestDispatcher("/SendMailForValidation").forward(request, response);
	    	}
	   
    	}
    	   	
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		HttpSession sessionContext = request.getSession();
		String context = (String)sessionContext.getAttribute("context");
		
		ROPEncryptor encryptor = new ROPEncryptor();
    	String action="";
    
    	if (request.getParameter("action") == null && context == null) {
    		request.getServletContext().getRequestDispatcher("/IndexPublications").forward(request, response);
    	}
    	
    	else if (request.getParameter("action") != null && context == null){
	    	try {
	    		action = encryptor.decrypt(request.getParameter("action"));
	    	} catch (ROPCryptographyException e) {
				e.printStackTrace();
			}
	    	
	    	if (action.equalsIgnoreCase("registerTopic")) {
				request.getServletContext().getRequestDispatcher("/AddTopic").forward(request, response);
	    	}
	    	
	    	if (action.equalsIgnoreCase("paperSubmission")) {
				request.getServletContext().getRequestDispatcher("/PaperSubmission").forward(request, response);
	    	}
	    	
	    	if (action.equalsIgnoreCase("articlesOfAJournal")) {
				request.getServletContext().getRequestDispatcher("/GetAllArticlesOfAJournal").forward(request, response);
	    	}
	    	
	    	if (action.equalsIgnoreCase("sendMailForValidation")) {
				request.getServletContext().getRequestDispatcher("/SendMailForValidation").forward(request, response);
	    	}
	    	
    	}
    	
    	else if (request.getParameter("action") == null && context != null) {
    		if (context.equalsIgnoreCase("registerTopic")) {
    			sessionContext.setAttribute("context", null);
    			request.setAttribute("journalID", sessionContext.getAttribute("journalID"));
    			restoreContext(request,response);
    			returnRequest(request, response);
	    	}
	    	
	    	if (context.equalsIgnoreCase("paperSubmission")) {
	    		ROPPublicationsDao dao = new ROPPublicationsDao();
	    		
	    		int journalID=-1;
	    		try{
	    			journalID = (Integer)sessionContext.getAttribute("journalID");
	    		}
	    		catch (NumberFormatException e){
	    			e.printStackTrace();
	    		}
	    		
	    		BaoJournalOrConf journal = dao.getAJournalByID(journalID);
	    		
	    		List<BaoVolumeOrIssue> volumeList = dao.getAllVolumesOfAJournal(journal.getJournalOrConfId());
	    		List<BaoJournalOrConf> journalList = dao.getAllJournalOrConf();
	    		
	    		/*a represente le nombre de fois qu'on aura déja appelé la fonction validateReviewer
	    		dans le fichier ajax*/
	    		int a=0;
	    		request.setAttribute("a", a);
	    		
	    		String moduleName=""
;	    		String actionName="";
	    		
	    		try {
					moduleName = encryptor.encrypt("publication");
					actionName = encryptor.encrypt("paperSubmission");
				} catch (ROPCryptographyException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    		
	    		sessionContext.setAttribute("context", null);
	    		request.setAttribute("moduleName", moduleName);
	    		request.setAttribute("actionName", actionName);
	    		request.setAttribute("ATTR_volumeList", volumeList);
	    		request.setAttribute("Attr_journalList", journalList);
	    		request.setAttribute("action", "submitPaper");
	    		request.setAttribute("journalID", sessionContext.getAttribute("journalID"));
	    		restoreContext(request, response);
	    		returnRequest(request, response);
	    	}
	    	
	    	if (context.equalsIgnoreCase("articlesOfAJournal")) {
	    		sessionContext.setAttribute("context", null);
	    		request.setAttribute("journalID", sessionContext.getAttribute("journalID"));
	    		restoreContext(request, response);
	    		returnRequest(request, response);
	    	}
	    	
	    	if (context.equalsIgnoreCase("printvolumes")) {
	    		ROPPublicationsDao dao = new ROPPublicationsDao();
	    		
	    		int journalID=-1;
	    		try{
	    			journalID = (Integer)sessionContext.getAttribute("journalID");
	    		}
	    		catch (NumberFormatException e){
	    			e.printStackTrace();
	    		}
	    		
	    		BaoJournalOrConf journal = dao.getAJournalByID(journalID);
	    		
	    		List<BaoVolumeOrIssue> volumeList = dao.getAllVolumesOfAJournal(journal.getJournalOrConfId());
	    		
	    			    		
	    		sessionContext.setAttribute("context", null);
	    		request.setAttribute("ATTR_volumeList", volumeList);
	    		
	    		
	    		request.setAttribute("action", "printvolumes");
	    		sessionContext.setAttribute("context", null);
	    		request.setAttribute("journalID", sessionContext.getAttribute("journalID"));
	    		restoreContext(request, response);
	    		returnRequest(request, response);
	    	}
	    	
	    	if (context.equalsIgnoreCase("validationPaper1")) {
	    		
	    	}
	    	
	    	if (context.equalsIgnoreCase("sendMailForValidation")) {
				request.getServletContext().getRequestDispatcher("/SendMailForValidation").forward(request, response);
	    	}
	    	

    	}
 }
    
    public void restoreContext (HttpServletRequest request, HttpServletResponse response){
  		includeManager.setTitle(languageManager.getLanguageValue("publication_title", langTag));
		includeManager.addJSP("/modules/publications/index.jsp");
		includeManager.addCSS("/modules/publications/css/publications.css");
		includeManager.addJS("/modules/publications/js/ajax.js");
    }


}
