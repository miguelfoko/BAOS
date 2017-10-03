package rop.miu.modules.publications.servlets;

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


public class VolumesManagement extends ServletModel {
	private static final long serialVersionUID = 1L;
  
    public VolumesManagement() {
        super();
       
    }


<<<<<<< HEAD
	@Override
=======
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		HttpSession sessionContext = request.getSession();
		
	    
<<<<<<< HEAD
	    if (!isConnected()){
=======
	    if (!isConnected(request)){
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
	    	//sauvegarder le contexte
	    	sessionContext.setAttribute("context", "printvolumes");
	    	sessionContext.setAttribute("volumeID", request.getParameter("id_volume"));
	    	requestAuthentication(request, response, "publications");
	    }
	    else{
	    	HttpSession journalSession = request.getSession();
			
			ROPPublicationsDao dao = new ROPPublicationsDao();
			
			int journalID=-1;
			try{
				journalID = (Integer)journalSession.getAttribute("journalID");
			}
			catch (NumberFormatException e){
				e.printStackTrace();
			}
			
			BaoJournalOrConf journal = dao.getAJournalByID(journalID);
			
			List<BaoVolumeOrIssue> volumeList = dao.getAllVolumesOfAJournal(journal.getJournalOrConfId());
			request.setAttribute("ATTR_volumeList", volumeList);
			
			request.setAttribute("action", "printvolumes");
<<<<<<< HEAD
			includeManager.setTitle(languageManager.getLanguageValue("publication_title", langTag));
			includeManager.addJSP("/modules/publications/index.jsp");
			includeManager.addCSS("/modules/publications/css/publications.css");
=======
			includeManager.setTitle(request, languageManager.getLanguageValue("publication_title", langTag));
			includeManager.addJSP(request, "/modules/publications/index.jsp");
			includeManager.addCSS(request, "/modules/publications/css/publications.css");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
			returnRequest(request, response);
	    }
		
		
		
		
		
	}


<<<<<<< HEAD
	@Override
=======
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}

}
