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
import rop.miu.modules.publications.util.GuiAuthor;
import rop.miu.modules.publications.util.GuiRefereeOrEditor;
import rop.miu.modules.publications.util.GuiSubmission;
import rop.miu.modules.publications.util.PublicationUtil;
import rop.miu.util.IncludeManager;
import rop.miu.util.ROPConstants;
import rop.miu.util.exceptions.MIUIOException;
import rop.miu.util.exceptions.ROPCryptographyException;
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
		String subStep = null;
		int sid;
		ROPPublicationsDao dao = new ROPPublicationsDao();
		try {
			if(request.getParameter("pstep") != null)
				subStep= encryptor.decrypt(request.getParameter("pstep"));
			if(request.getParameter("sid") != null){
				String p = encryptor.decrypt(request.getParameter("sid"));
				sid = Integer.parseInt(p);
			}else
				sid = createSubmission(request);
			request.setAttribute("mod_pub_submission_id", sid);
    	} catch (Exception e) {
    		subStep = null;
    		sid = createSubmission(request);
		}
		
		if(subStep == null || subStep.equals("select_journal")){
    		String param = null;
    		Integer journalOrConfId = null;
    		try {
    			if(request.getParameter("jocid") != null){
    				param = encryptor.decrypt(request.getParameter("jocid"));
    				journalOrConfId = Integer.parseInt(param);
    			}
	    	} catch (Exception e) {
	    		journalOrConfId = null;
			}
    		
    		if(journalOrConfId != null){
    			BaoJournalOrConf journalOrConf = dao.getAJournalByID(journalOrConfId);
    			setSubStepOne(sid, journalOrConf.getJournalOrConfType(), journalOrConf, request);
    			if(getSubmission(sid, request).getAuthors() != null && getSubmission(sid, request).getAuthors().isEmpty())
    				getSubmission(sid, request).addAuthor((getBaoUser(request).getUserSurname() == null ? "" : getBaoUser(request).getUserSurname() + " ") + getBaoUser(request).getUserName(), "", getBaoUser(request).getUserEmail(), true);
    			request.setAttribute("mod_pub_authors", getSubmission(sid, request).getAuthors());
    			request.setAttribute("mod_pub_gtu_selected", false);
    			setIncludesForSubmission(request, 2);
    			returnRequest(request, response);
    			return;
    		}
    		
    		List<BaoJournalOrConf> journalList = dao.getAllJournalOrConf();
    		request.setAttribute("mod_pub_journal_list", journalList);
    		String type;
	    	if((type = getSubmission(sid, request).getPaperType()) != null)
	    		request.setAttribute("mod_pub_paper_type", type);
	    	
	    	BaoJournalOrConf journalOrConf;
	    	if((journalOrConf = getSubmission(sid, request).getJournalOrConf()) != null)
	    		request.setAttribute("mod_pub_journal_or_conf", journalOrConf);
    		
			setIncludesForSubmission(request, 1);
			returnRequest(request, response);
			return;
		}
		
		if(subStep != null && subStep.equals("add_authors")){
			request.setAttribute("mod_pub_authors", getSubmission(sid, request).getAuthors());
			request.setAttribute("mod_pub_gtu_selected", getSubmission(sid, request).isGenTermOfUseAccepted());
			setIncludesForSubmission(request, 2);
			returnRequest(request, response);
			return;
		}
		
		if(subStep != null && subStep.equals("add_referees_editors")){
			request.setAttribute("mod_pub_referees", getSubmission(sid, request).getProposedReviewerOrEditors());
			setIncludesForSubmission(request, 3);
			returnRequest(request, response);
			return;
		}
		
		if(subStep != null && subStep.equals("exclude_referees_editors")){
			request.setAttribute("mod_pub_referees", getSubmission(sid, request).getExcludedReviewerOrEditors());
			setIncludesForSubmission(request, 4);
			returnRequest(request, response);
			return;
		}
	}
	
	private void setIncludesForSubmission(HttpServletRequest request, int activeTab) throws ServletException, IOException {
    	IncludeManager inclManager = getIncludeManager(request);
    	if(activeTab == 1)
    		inclManager.setTitle(request, languageManager.getLanguageValue("pub_paper_submission_process", getLangTag(request)) + " : " + languageManager.getLanguageValue("pub_process_step_1", getLangTag(request)));
    	if(activeTab == 2)
    		inclManager.setTitle(request, languageManager.getLanguageValue("pub_paper_submission_process", getLangTag(request)) + " : " + languageManager.getLanguageValue("pub_process_step_2", getLangTag(request)));
    	if(activeTab == 3)
    		inclManager.setTitle(request, languageManager.getLanguageValue("pub_paper_submission_process", getLangTag(request)) + " : " + languageManager.getLanguageValue("pub_process_step_3", getLangTag(request)));
    	if(activeTab == 4)
    		inclManager.setTitle(request, languageManager.getLanguageValue("pub_paper_submission_process", getLangTag(request)) + " : " + languageManager.getLanguageValue("pub_process_step_4", getLangTag(request)));
    	if(activeTab == 5){
    		inclManager.setTitle(request, languageManager.getLanguageValue("pub_paper_submission_process", getLangTag(request)) + " : " + languageManager.getLanguageValue("pub_process_step_5", getLangTag(request)));
    		inclManager.addJS(request, "/ressources/tinymce/tinymce.min.js");
    	}
		inclManager.addJSP(request, "/modules/publications/submission.jsp");
		request.setAttribute("mod_pub_step", activeTab);
		inclManager.addCSS(request, "/modules/publications/css/publications.css");
		inclManager.addJS(request, "/modules/publications/js/submission.js");
		inclManager.addJS(request, "/modules/publications/js/ajax.js");
		//setAuthenticationMenu(request);
    }

	@SuppressWarnings("unchecked")
	private int createSubmission(HttpServletRequest request) {
		ArrayList<GuiSubmission> submissionList = (ArrayList<GuiSubmission>)request.getSession().getAttribute("pub_submission_list");
		if(submissionList == null){
			submissionList = new ArrayList<GuiSubmission>();
			request.getSession().setAttribute("pub_submission_list", submissionList);
		}
		int sid = submissionList.size();
		submissionList.add(new GuiSubmission(sid));
		return sid;
	}
	
	@SuppressWarnings("unchecked")
	private ArrayList<GuiSubmission> getSubmissionList(HttpServletRequest request){
		ArrayList<GuiSubmission> submissionList = (ArrayList<GuiSubmission>)request.getSession().getAttribute("pub_submission_list");
		return submissionList;
	}
	
	private GuiSubmission getSubmission(int sid, HttpServletRequest request){
		return getSubmissionList(request).get(sid);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		
		String subStep = null;
		int sid;
		ROPPublicationsDao dao = new ROPPublicationsDao();
		try {
			if(request.getParameter("pstep") != null)
				subStep= encryptor.decrypt(request.getParameter("pstep"));
			if(request.getParameter("sid") != null){
				String p = encryptor.decrypt(request.getParameter("sid"));
				sid = Integer.parseInt(p);
			}else
				sid = createSubmission(request);
			request.setAttribute("mod_pub_submission_id", sid);
    	} catch (Exception e) {
    		subStep = null;
    		sid = createSubmission(request);
		}
		
		if(subStep == null || subStep.equals("select_journal")){
			String paperType = request.getParameter("paperType");
			int jocid;
			if(paperType.equals("Journal"))
				jocid = Integer.parseInt(request.getParameter("journal"));
			else
				jocid = Integer.parseInt(request.getParameter("conference"));
			BaoJournalOrConf journalOrConf = dao.getAJournalByID(jocid);
			setSubStepOne(sid, journalOrConf.getJournalOrConfType(), journalOrConf, request);
			if(getSubmission(sid, request).getAuthors() != null && getSubmission(sid, request).getAuthors().isEmpty())
				getSubmission(sid, request).addAuthor((getBaoUser(request).getUserSurname() == null ? "" : getBaoUser(request).getUserSurname() + " ") + getBaoUser(request).getUserName(), "", getBaoUser(request).getUserEmail(), true);
			request.setAttribute("mod_pub_authors", getSubmission(sid, request).getAuthors());
			request.setAttribute("mod_pub_gtu_selected", getSubmission(sid, request).isGenTermOfUseAccepted());
			setIncludesForSubmission(request, 2);
			returnRequest(request, response);
			return;
		}
		
		if(subStep != null && subStep.equals("add_author")){
			String name = request.getParameter("name");
			String[] tab = name.trim().split(" ");
			name = ConfigManager.setFirstUppercaseAndRestLowercase(tab[0]);
			for(int i = 1; i < tab.length; i++)
				name += " "+ConfigManager.setFirstUppercaseAndRestLowercase(tab[i]);
			String email = request.getParameter("email");
			String institution = request.getParameter("institution");
			String isPrincipal = request.getParameter("isPrincipal");
			getSubmission(sid, request).addAuthor(name, institution, email, "on".equalsIgnoreCase(isPrincipal) ? true : false);
			request.setAttribute("mod_pub_authors", getSubmission(sid, request).getAuthors());
			request.getServletContext().getRequestDispatcher("/modules/publications/authors.jsp").forward(request, response);
			return;
		}
		
		if(subStep != null && subStep.equals("edit_author")){
			String authorId = request.getParameter("authorId");
			int aid = Integer.parseInt(authorId);
			GuiAuthor author = getSubmission(sid, request).getAuthors().get(aid);
			if(request.getParameter("markAsPrincipal") != null){
				try{getSubmission(sid, request).getPrincipalAuthor().setPrincipal(false);}catch(Exception e){}
				author.setPrincipal(true);
			}
			if(request.getParameter("delete") != null){
				ArrayList<GuiAuthor> authors = getSubmission(sid, request).getAuthors();
				authors.remove(aid);
				for(int i = aid; i < authors.size(); i++)
					authors.get(i).setAuthorId(i);
				if(!authors.isEmpty() && getSubmission(sid, request).getPrincipalAuthor() == null)
					authors.get(0).setPrincipal(true);
			}
			if(request.getParameter("markAsPrincipal") == null && request.getParameter("delete") == null){
				String name = request.getParameter("name");
				String[] tab = name.trim().split(" ");
				name = ConfigManager.setFirstUppercaseAndRestLowercase(tab[0]);
				for(int i = 1; i < tab.length; i++)
					name += " "+ConfigManager.setFirstUppercaseAndRestLowercase(tab[i]);
				String email = request.getParameter("email");
				String institution = request.getParameter("institution");
				String isPrincipal = request.getParameter("isPrincipal");
				boolean princ = "on".equalsIgnoreCase(isPrincipal) ? true : false;
				author.setName(name);
				author.setEmail(email);
				author.setInstitution(institution);
				if(princ)
					try{getSubmission(sid, request).getPrincipalAuthor().setPrincipal(false);}catch(Exception e){}
				author.setPrincipal(princ);
			}
			request.setAttribute("mod_pub_authors", getSubmission(sid, request).getAuthors());
			request.getServletContext().getRequestDispatcher("/modules/publications/authors.jsp").forward(request, response);
			return;
		}
		
		if(subStep != null && subStep.equals("add_proposed_referee")){
			String name = request.getParameter("name");
			String[] tab = name.trim().split(" ");
			name = ConfigManager.setFirstUppercaseAndRestLowercase(tab[0]);
			for(int i = 1; i < tab.length; i++)
				name += " "+ConfigManager.setFirstUppercaseAndRestLowercase(tab[i]);
			String email = request.getParameter("email");
			String institution = request.getParameter("institution");
			String motivation = request.getParameter("motivation");
			getSubmission(sid, request).addProposedReviewerOrEditor(name, institution, email, motivation);
			request.setAttribute("mod_pub_referees", getSubmission(sid, request).getProposedReviewerOrEditors());
			request.getServletContext().getRequestDispatcher("/modules/publications/referees.jsp").forward(request, response);
			return;
		}
		
		if(subStep != null && subStep.equals("edit_proposed_referee")){
			String refereeId = request.getParameter("refereeId");
			int aid = Integer.parseInt(refereeId);
			GuiRefereeOrEditor referee = getSubmission(sid, request).getProposedReviewerOrEditors().get(aid);
			if(request.getParameter("delete") != null){
				ArrayList<GuiRefereeOrEditor> referees = getSubmission(sid, request).getProposedReviewerOrEditors();
				referees.remove(aid);
				for(int i = aid; i < referees.size(); i++)
					referees.get(i).setRefereeId(i);
			}
			else{
				String name = request.getParameter("name");
				String[] tab = name.trim().split(" ");
				name = ConfigManager.setFirstUppercaseAndRestLowercase(tab[0]);
				for(int i = 1; i < tab.length; i++)
					name += " "+ConfigManager.setFirstUppercaseAndRestLowercase(tab[i]);
				String email = request.getParameter("email");
				String institution = request.getParameter("institution");
				String motivation = request.getParameter("motivation");
				referee.setName(name);
				referee.setEmail(email);
				referee.setInstitution(institution);
				referee.setMotivation(motivation);
			}
			request.setAttribute("mod_pub_referees", getSubmission(sid, request).getProposedReviewerOrEditors());
			request.getServletContext().getRequestDispatcher("/modules/publications/referees.jsp").forward(request, response);
			return;
		}
		
		if(subStep != null && subStep.equals("add_excluded_referee")){
			String name = request.getParameter("name");
			String[] tab = name.trim().split(" ");
			name = ConfigManager.setFirstUppercaseAndRestLowercase(tab[0]);
			for(int i = 1; i < tab.length; i++)
				name += " "+ConfigManager.setFirstUppercaseAndRestLowercase(tab[i]);
			String email = request.getParameter("email");
			String institution = request.getParameter("institution");
			String motivation = request.getParameter("motivation");
			getSubmission(sid, request).addExcludedReviewerOrEditor(name, institution, email, motivation);
			request.setAttribute("mod_pub_referees", getSubmission(sid, request).getExcludedReviewerOrEditors());
			request.getServletContext().getRequestDispatcher("/modules/publications/excl_referees.jsp").forward(request, response);
			return;
		}
		
		if(subStep != null && subStep.equals("edit_excluded_referee")){
			String refereeId = request.getParameter("refereeId");
			int aid = Integer.parseInt(refereeId);
			GuiRefereeOrEditor referee = getSubmission(sid, request).getExcludedReviewerOrEditors().get(aid);
			if(request.getParameter("delete") != null){
				ArrayList<GuiRefereeOrEditor> referees = getSubmission(sid, request).getExcludedReviewerOrEditors();
				referees.remove(aid);
				for(int i = aid; i < referees.size(); i++)
					referees.get(i).setRefereeId(i);
			}
			else{
				String name = request.getParameter("name");
				String[] tab = name.trim().split(" ");
				name = ConfigManager.setFirstUppercaseAndRestLowercase(tab[0]);
				for(int i = 1; i < tab.length; i++)
					name += " "+ConfigManager.setFirstUppercaseAndRestLowercase(tab[i]);
				String email = request.getParameter("email");
				String institution = request.getParameter("institution");
				String motivation = request.getParameter("motivation");
				referee.setName(name);
				referee.setEmail(email);
				referee.setInstitution(institution);
				referee.setMotivation(motivation);
			}
			request.setAttribute("mod_pub_referees", getSubmission(sid, request).getExcludedReviewerOrEditors());
			request.getServletContext().getRequestDispatcher("/modules/publications/excl_referees.jsp").forward(request, response);
			return;
		}
		
		if(subStep != null && subStep.equals("add_authors")){
			getSubmission(sid, request).setGenTermOfUseAccepted(true);
			request.setAttribute("mod_pub_referees", getSubmission(sid, request).getProposedReviewerOrEditors());
			setIncludesForSubmission(request, 3);
			returnRequest(request, response);
			return;
		}
		
		if(subStep != null && subStep.equals("add_referees_editors")){
			request.setAttribute("mod_pub_referees", getSubmission(sid, request).getExcludedReviewerOrEditors());
			setIncludesForSubmission(request, 4);
			returnRequest(request, response);
			return;
		}
		
		if(subStep != null && subStep.equals("exclude_referees_editors")){
			//Dernière étape
			//request.setAttribute("mod_pub_referees", getSubmission(sid, request).getExcludedReviewerOrEditors());
			setIncludesForSubmission(request, 5);
			returnRequest(request, response);
			return;
		}
		
		
		
		HttpSession sessionContext = request.getSession();
		MIUMultipartFormParser parser = null;
		String paramSuppl="";
		try {
			parser = new MIUMultipartFormParser(request);
			
		} catch (MIUIOException e2) {
			e2.printStackTrace();
		}
		
		paramSuppl = request.getParameter("paramSuppl");
		System.out.println(paramSuppl);
		
		
		if(paramSuppl.equalsIgnoreCase("authorManagement")) {
			
			request.getServletContext().getRequestDispatcher("/modules/publications/ajax.jsp").forward(request, response);
			return;
		}
		
		/*if(paramSuppl.equalsIgnoreCase("reviewerManagement")) {
			
			request.getServletContext().getRequestDispatcher("/modules/publications/ajax.jsp").forward(request, response);
			return;
		}*/
		
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
			
			paperAuthor.setAuthorEmail(parser.getString("Authormail"));
			paperAuthor.setAuthorInstitution(parser.getString("AuthorInstitution"));
			
			
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
			includeManager.setTitle(request, languageManager.getLanguageValue("publication_title", langTag));
			includeManager.addJSP(request, "/modules/publications/index.jsp");
			includeManager.addCSS(request, "/modules/publications/css/publications.css");
			
			
			includeManager.addJS(request, "/modules/publications/js/jquery-ui-1.8.13.custom.min.js");
			includeManager.addJS(request, "/modules/publications/js/jquery-1.2.3.min.js");
			includeManager.addJS(request, "/modules/publications/js/onglet.js");
			
			returnRequest(request, response);
			
			
		} catch (MIUIOException e1) {
			e1.printStackTrace();
		}
		
		}
		
		public void setSubStepOne(int sid, String paperType, BaoJournalOrConf journalOrConf, HttpServletRequest request){
			getSubmission(sid, request).setSubStepOne(paperType, journalOrConf);
		}

}
