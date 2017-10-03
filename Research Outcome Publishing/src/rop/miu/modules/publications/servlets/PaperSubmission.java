package rop.miu.modules.publications.servlets;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joda.time.DateTime;

import rop.miu.ConfigManager;
import rop.miu.beans.BaoJournalOrConf;
import rop.miu.beans.BaoPaper;
import rop.miu.beans.BaoPaperAuthor;
import rop.miu.beans.BaoUser;
import rop.miu.beans.BaoVolumeOrIssue;
import rop.miu.modules.ServletModel;
import rop.miu.modules.publications.dao.ROPPublicationsDao;
import rop.miu.modules.publications.util.PublicationUtil;
import rop.miu.util.ROPConstants;
import rop.miu.util.exceptions.MIUIOException;
import rop.miu.util.exceptions.ROPDaoException;
import rop.miu.util.io.MIUIOUtilMethod;
import rop.miu.util.io.MIUMultipartFormParser;
import rop.miu.util.io.Upload;
import rop.miu.util.io.UploadCondition;



public class PaperSubmission extends ServletModel {
	private static final long serialVersionUID = 1L;
 
    public PaperSubmission() {
        super();
     
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		HttpSession sessionContext = request.getSession();
		
	    
    	
    		ROPPublicationsDao dao = new ROPPublicationsDao();
    		
    		
    	    if (!isConnected()){
    	    	//sauvegarder le contexte
    	    	sessionContext.setAttribute("context", "paperSubmission");
    	    	//sessionContext.setAttribute("volumeID", request.getParameter("id_volume"));
    	    	requestAuthentication(request, response, "publications");
    	    }
    	    else{
    		
    		
    		
    		int journalID=-1;
    		try{
    			journalID = (Integer)sessionContext.getAttribute("journalID");
    		}
    		catch (NumberFormatException e){
    			e.printStackTrace();
    		}
    		
    		BaoJournalOrConf journal = dao.getAJournalByID(journalID);
    		List<BaoJournalOrConf> journalList = dao.getAllJournalOrConf();
    		  		   		
    		List<BaoVolumeOrIssue> volumeList = dao.getAllVolumesOfAJournal(journal.getJournalOrConfId());
    		
    			    		
    		sessionContext.setAttribute("context", null);
    		request.setAttribute("Attr_journalList", journalList);
    		request.setAttribute("ATTR_volumeList", volumeList);
    		request.setAttribute("journalID", sessionContext.getAttribute("journalID"));
	    	request.setAttribute("volume_ID", request.getParameter("id_volume"));
	    	
	    	int a=0;
	    	
			request.setAttribute("action", "submitPaper");
			request.setAttribute("a", a);
			request.setAttribute("journalID", journalID);
			includeManager.setTitle(languageManager.getLanguageValue("publication_title", langTag));
			includeManager.addJSP("/modules/publications/index.jsp");
			includeManager.addCSS("/modules/publications/css/publications.css");
			includeManager.addJS("/modules/publications/js/ajax.js");
			returnRequest(request, response);
	    
    	}
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		HttpSession sessionContext = request.getSession();
		MIUMultipartFormParser parser = null;
		//String paramSuppl="";
		try {
			parser = new MIUMultipartFormParser(request);
			
		} catch (MIUIOException e2) {
			e2.printStackTrace();
		}
		
		/*paramSuppl = request.getParameter("paramSuppl");
		System.out.println(paramSuppl);
		
		
		if(paramSuppl.equalsIgnoreCase("authorManagement")) {
			
			request.getServletContext().getRequestDispatcher("/modules/publications/ajax.jsp").forward(request, response);
			return;
		}
		*/
		/*if(paramSuppl.equalsIgnoreCase("reviewerManagement")) {
			
			request.getServletContext().getRequestDispatcher("/modules/publications/ajax.jsp").forward(request, response);
			return;
		}*/
	
		
		ROPPublicationsDao dao = new ROPPublicationsDao();
		
		ArrayList<String > extensions = new ArrayList<String>();
		extensions.add("pdf");
		extensions.add("docx");
		
		
		ConfigManager config = new ConfigManager();
		
		HttpSession session=request.getSession();
	    BaoUser user=(BaoUser)session.getAttribute("baoUser");
	   	    
	    PublicationUtil publiUtil = new PublicationUtil(); 
	    
	    BaoPaper paper = new BaoPaper();
	    BaoPaperAuthor paperAuthor = new BaoPaperAuthor();
	    
	    UploadCondition uploadC = null;
	    Upload upload = null;
		
		try {
			
			
			uploadC = new UploadCondition(config);
			uploadC.setExtensions(extensions);
			//uploadC.setMaxFileSize(5000);
			paper.setUserIdPaperOwner(user);
			paper.setUserIdEditor(user);
			paper.setPaperState(ROPConstants.STATE_UNREAD);
			
			paper.setPaperKeywords(parser.getString("keywords"));
						
			paper.setPaperTitle(parser.getString("paperTitle"));
						
			paper.setPaperAbstract(parser.getString("abstract"));
					
			paper.setPaperOtherMention(parser.getString("otherMentions"));
						
			paper.setPaperSubmissionDate(DateTime.now().toDate());
			
			//reviewers management
			
			/*int a = parser.getInteger("a");
			a+=1;
			request.setAttribute("a", a);*/
			List<BaoVolumeOrIssue> volumesOfThisJournal = dao.getAllVolumesOfAJournal((Integer)sessionContext.getAttribute("journalID"));
			

		
			
			try{
				upload = parser.uploadFile("attachments", uploadC);
				if (upload != null) {
					File fileDest=new File((getClass().getResource("/../.." + publiUtil.getPaperFolderUrl()).getFile()+upload.getUploadedFile().getName()).replace("%20", " "));
					MIUIOUtilMethod.copyFile(upload.getUploadedFile(), fileDest);
					paper.setPaperAttachment((getClass().getResource("/../.." + publiUtil.getPaperFolderUrl()).getFile()+upload.getUploadedFile().getName()).replace("%20", " "));
				}
			}catch (Exception e){
				System.out.println("extension " + uploadC.isBadFileType());
				System.out.println("file name " + uploadC.isBadName());
				System.out.println("file size " + uploadC.isSizeExceed());
				e.printStackTrace();
				return;
			}
			
			
		    //volume = dao.getAVolumeByIdentifier(parser.getString("volumeList"));
		    
		    List<BaoPaper> paperList = dao.getAllArticlesByJournal((Integer)sessionContext.getAttribute("journalID"));
			List<BaoPaper> unreadPapers = dao.getAllUnreadPapersByJournal();
			
			
			
			String message="";
			
			try {
				System.out.println(paper);
				dao.savePaper(paper,paperAuthor);
				message = "success";
			} catch (ROPDaoException e) {
				message = "submission failed";
				e.printStackTrace();
			}
			
			
			request.setAttribute("ATTR_messagePubli", message);
			request.setAttribute("journalID", (Integer)sessionContext.getAttribute("journalID"));
			request.setAttribute("action", "articlesOfAJournal");
			request.setAttribute("ATTR_unreadPapers", unreadPapers);
			request.setAttribute("ATTR_paperList", paperList);
			request.setAttribute("ATTR_volumeOfJournal", volumesOfThisJournal);
			includeManager.setTitle(languageManager.getLanguageValue("publication_title", langTag));
			includeManager.addJSP("/modules/publications/index.jsp");
			includeManager.addCSS("/modules/publications/css/publications.css");
			
			
			includeManager.addJS("/modules/publications/js/jquery-ui-1.8.13.custom.min.js");
			includeManager.addJS("/modules/publications/js/jquery-1.2.3.min.js");
			includeManager.addJS("/modules/publications/js/onglet.js");
			
			returnRequest(request, response);
			
			
		} catch (MIUIOException e1) {
			e1.printStackTrace();
		}
		
		}
		


}
