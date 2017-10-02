package rop.miu.modules.publications.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import rop.miu.beans.BaoEmailAccount;
import rop.miu.beans.BaoEmailTemplate;
import rop.miu.beans.BaoPaper;
import rop.miu.beans.BaoReviewOrEditionContract;
import rop.miu.beans.BaoUser;
import rop.miu.beans.BaoVolumeOrIssue;
import rop.miu.dao.ROPUserDao;
import rop.miu.modules.ServletModel;
import rop.miu.modules.publications.dao.ROPPublicationsDao;
import rop.miu.util.ROPConstants;
import rop.miu.util.io.MIUMultipartFormParser;
import rop.miu.util.mail.Mail;
import rop.miu.util.mail.MailSender;
import rop.miu.util.mail.SMTPBundle;


public class SendMailForValidation extends ServletModel {
	private static final long serialVersionUID = 1L;
   
    public SendMailForValidation() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
				
		HttpSession session=request.getSession();
	    BaoUser user=(BaoUser)session.getAttribute("baoUser");
				ArrayList<BaoEmailAccount> accounts = ROPUserDao.getValidEmailAccounts(user);
				System.out.println(accounts);
				
				ArrayList<BaoUser> reviewers = new ArrayList<BaoUser>();
				ROPPublicationsDao dao = new ROPPublicationsDao();
				BaoPaper paper = new BaoPaper();
				MIUMultipartFormParser	parser = null;
				String messageForReviewers="";
				
				try{
					parser = new MIUMultipartFormParser(request);
					
					String firstReviewer = parser.getString("firstReviewer");
					String secondReviewer = parser.getString("secondReviewer");
					String thirdReviewer = parser.getString("thirdReviewer");
					String fourthReviewer = parser.getString("fourthReviewer");
					int paper_id = parser.getInteger("id_papier");
					messageForReviewers = parser.getString("messageForReviewers");
					
			    	if (!firstReviewer.trim().isEmpty()){
						reviewers.add(dao.getUserByName(firstReviewer));
					}
					
					if (!secondReviewer.trim().isEmpty()){
						reviewers.add(dao.getUserByName(secondReviewer));
					}
					
					if (!thirdReviewer.trim().isEmpty()){
						reviewers.add(dao.getUserByName(thirdReviewer));
					}
					
					if (!fourthReviewer.trim().isEmpty()){
						reviewers.add(dao.getUserByName(fourthReviewer));
					}
					
					paper = dao.getPaperById(paper_id);
				}
				
				catch(Exception e) {
					e.printStackTrace();
				}
		
				
				final GsonBuilder builder = new GsonBuilder();
		        final Gson gson = builder.create();
		        
		        BaoEmailTemplate template = ROPUserDao.getEmailTemplateByName("default_template");
		        String content = "";
		        
		        if(template != null && template.getEmailTemplateState() == ROPConstants.STATE_ACTIVATED){
		        	content = template.getEmailTemplateContent();
		        	String contextBaseUrl = request.getRequestURL().toString().split(request.getContextPath())[0]+request.getContextPath();
		        	content = ROPConstants.setParam("logo", contextBaseUrl+"/ressources/images/logo-baos.png", content);
		        	content = ROPConstants.setParam(2, languageManager.getLanguageValue("send_attachment_title", langTag), content);
		        	content = ROPConstants.setParam(3, languageManager.getLanguageValue("send_attachment_subtitle", langTag), content);
		        	String mc = messageForReviewers;
		        	mc = ROPConstants.setParam(1, user.getUserLogin(), mc);
		        	mc = ROPConstants.setParam(2, languageManager.getLanguageValue("pass_you_specified", langTag), mc);
		        	try{
		        		mc = ROPConstants.setParam(3, contextBaseUrl+"/?m="+encryptor.encrypt("authentication")+"o="+encryptor.encrypt("validate-"+user.getUserId()), mc);
		        	}catch(Exception ex){
		        		
		        	}
		        	content = ROPConstants.setParam(4, mc, content);
		        	content = ROPConstants.setParam(5, "", content);
		        }
		        else{
		        	
		        }
		        
				Mail mail = new Mail();
				String message="";
				for (BaoUser recepteur:reviewers) {
					mail.addToReceiver(recepteur.getUserEmail());
										
				}
				
				mail.setContent(content);
				mail.setSubject(user.getUserLogin()+" "+languageManager.getLanguageValue("register_confirm_subtitle", langTag));
				mail.addAttachment(paper.getPaperAttachment());
				
				
				for(BaoEmailAccount acc : accounts){
					System.out.println("account");
					SMTPBundle smtpBundle = gson.fromJson(acc.getEmailAccountDesc(), SMTPBundle.class);
					try{
						System.out.println("bonjour");
						smtpBundle.setPassword(encryptor.decrypt(smtpBundle.getPassword()));
						System.out.println("password= "+smtpBundle.getPassword());
						MailSender.sendMail(mail, MailSender.smtpBundleToProperties(smtpBundle));
						message="your mail has been sent";
						dao.paperInReview(paper);
						break;
					}catch(Exception ex){
						message="error send mail";
						ex.printStackTrace();
					}
				}
				
				
				
			

				
				HttpSession journalInSession = request.getSession();
				
				int journalID=-1;
				
				try{
					journalID = (Integer)journalInSession.getAttribute("journalID");
				}
				catch(NumberFormatException e) {
					e.printStackTrace();
				}
		
				
				List<BaoPaper> unreadPapers = dao.getAllUnreadPapersByJournal();
				List<BaoVolumeOrIssue> volumesOfThisJournal = dao.getAllVolumesOfAJournal(journalID);
				
				List<BaoReviewOrEditionContract> reviewcontract = dao.getAllReviewersForAJournal(journalID);
				ArrayList<BaoUser> Newreviewers = new ArrayList<BaoUser>();
				for (BaoReviewOrEditionContract r: reviewcontract) {
					reviewers.add(r.getUserIdContractCreator());
				}
				
				journalInSession.setAttribute("journalID", journalID);
				
				
				
				request.setAttribute("action", "userDashboard");
				request.setAttribute("message", message);
				request.setAttribute("journalID", journalID);
				request.setAttribute("ATTR_unreadPapers", unreadPapers);
				request.setAttribute("ATTR_volumeOfJournal", volumesOfThisJournal);
				request.setAttribute("ATTR_reviewersList", Newreviewers);
				includeManager.setTitle(request, languageManager.getLanguageValue("publication_title", langTag));
				includeManager.addJSP(request, "/modules/publications/index.jsp");
				includeManager.addCSS(request, "/modules/publications/css/publications.css");
				includeManager.addJS(request, "/modules/publications/js/jquery-ui-1.8.13.custom.min.js");
				includeManager.addJS(request, "/modules/publications/js/jquery-1.2.3.min.js");
				includeManager.addJS(request, "/modules/publications/js/onglet.js");
				returnRequest(request, response);
		
		
	}

}
