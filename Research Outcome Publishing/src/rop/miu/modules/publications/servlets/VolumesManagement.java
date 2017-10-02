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


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		HttpSession sessionContext = request.getSession();
		
	    
	    if (!isConnected(request)){
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
			includeManager.setTitle(request, languageManager.getLanguageValue("publication_title", langTag));
			includeManager.addJSP(request, "/modules/publications/index.jsp");
			includeManager.addCSS(request, "/modules/publications/css/publications.css");
			returnRequest(request, response);
	    }
		
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}

}
