package rop.miu.modules.journal;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import rop.miu.modules.ServletModel;
import rop.miu.modules.journal.dao.RopJournalDao;
import rop.miu.beans.BaoAutomaticReviewCondition;
import rop.miu.beans.BaoJournalOrConf;
import rop.miu.beans.BaoNews;
import rop.miu.beans.BaoUser;
import rop.miu.beans.BaoVolumeOrIssue;
import rop.miu.dao.ROPCrudDao;
import rop.miu.util.IncludeManager;
import rop.miu.util.ROPConstants;
import rop.miu.util.exceptions.MIUIOException;
import rop.miu.util.exceptions.ROPCryptographyException;
import rop.miu.util.exceptions.ROPDaoException;
import rop.miu.util.io.MIUIOUtilMethod;
import rop.miu.util.io.MIUMultipartFormParser;
import rop.miu.util.io.Upload;
import rop.miu.util.io.UploadCondition;


public class ModAdminJournal extends ServletModel {
	private static final long serialVersionUID = 1L;
	public ModAdminJournal() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
<<<<<<< HEAD
		adminJournalMenu();
=======
		adminJournalMenu(request);
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		String option = null;
		try{
			String parOpt = request.getParameter("ob");
			if(parOpt != null)
				option = encryptor.decrypt(parOpt);
		}catch(Exception e){
			forward500(request, response);
			return;
		}
<<<<<<< HEAD
		if(isConnected()){
=======
		if(isConnected(request)){
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
			//			if(isAccessGranted(ROPConstants.ADMIN_ACCESS)){
			if(option==null||option.equals("login")){
				indexJournalParameter(request);
				returnRequest(request, response);
				return;
			}
			if(option.equals("create")){
				createJournalParameter(request);
				returnRequest(request, response);
				return;
			}
			if(option.equals("update")){
				updateJournalParameter(request);
				returnRequest(request, response);
				return;
			}
			if(option.equals("delete")){
				deleteJournalParameter(request);
				returnRequest(request, response);
				return;
			}
			if(option.equals("listOfJournal")){
				listOfJournalParameter(request);
				returnRequest(request, response);
				return;
			}
			if(option.equals("listOfVolume")){
				listOfVolumeParameter(request);
				returnRequest(request, response);
				return;
			}
			if(option.equals("listOfConf")){
				listOfConfParameter(request);
				returnRequest(request, response);
				return;
			}
			if(option.equals("trashList")){
				listOfTrashParameter(request);
				returnRequest(request, response);
				return;
			}
			if(option.equals("createReviewCondition")){
				createReviewConditionParameter(request);
				returnRequest(request, response);
				return;
			}
			if(option.equals("createVolume")){
				createVolumeParameter(request);
				returnRequest(request, response);
				return;
			}
			//			if(isAccessGranted(ROPConstants.ADMIN_ACCESS)){
			//returnRequest(request, response);
			//			}
			//			else{
			//				forward403(request, response);
			//			}

		}
		else{
			request.getSession().setAttribute("b", "");
			request.setAttribute("o", request.getParameter("ob"));
			requestAuthentication(request, response, "adminJournal");
		}

	}

	private boolean contextExists(HttpServletRequest request){
		request.setAttribute("ob", request.getParameter("ob"));
		return request.getSession().getAttribute("b") != null;
	}

	private boolean contextExists1(HttpServletRequest request){
		request.setAttribute("formulaire", request.getParameter("formulaire"));
		return request.getSession().getAttribute("c") != null;
	}

	private void restoreContext(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		if(isAccessGranted(ROPConstants.ADMIN_ACCESS)){
		//String option=(String)request.getSession().getAttribute("o");
		if(!contextExists1(request)&&contextExists(request)){
			String option = null;
			try{
				String parOpt = request.getParameter("ob");
				if(parOpt != null)
					option = encryptor.decrypt(parOpt);
			}catch(Exception e){
				forward500(request, response);
				return;
			}
			if(option==null||option.equals("login")){
				indexJournalParameter(request);
			}else 
				if(option.equals("create")){
					createJournalParameter(request);
				}else
					if(option.equals("update")){
						updateJournalParameter(request);
					}else
						if(option.equals("delete")){
							deleteJournalParameter(request);
						}else
							if(option.equals("createVolume")){
								createVolumeParameter(request);
							}else
								if(option.equals("listOfJournal")){
									listOfJournalParameter(request);
								}else
									if(option.equals("listOfConf")){
										listOfConfParameter(request);
									}else
										if(option.equals("listOfVolume")){
											listOfVolumeParameter(request);
										}else
											if(option.equals("trashList")){
												listOfTrashParameter(request);
											}else
												if(option.equals("createReviewCondition")){
													createReviewConditionParameter(request);
												}else
													deleteJournalParameter(request);


		}
		else{
			if(contextExists1(request)&&contextExists(request)){
				String option1 = null;
				MIUMultipartFormParser parser;
				try{
					parser=new MIUMultipartFormParser(request);
					String parOpt = parser.getString("formulaire");
					if(parOpt != null)
						option1 = encryptor.decrypt(parOpt);
				}catch(Exception e){
					forward500(request, response);
					return;
				}
				if(option1==null){
<<<<<<< HEAD
					includeManager.addCSS("/admin/modules/journal/inc/style.css");
					includeManager.addJS("/admin/modules/journal/inc/fonction.js");
					includeManager.setTitle(languageManager.getLanguageValue("journal_home_page", langTag));
					includeManager.addJSP("/modules/authentication/login.jsp");
=======
					includeManager.addCSS(request, "/admin/modules/journal/inc/style.css");
					includeManager.addJS(request, "/admin/modules/journal/inc/fonction.js");
					includeManager.setTitle(request, languageManager.getLanguageValue("journal_home_page", langTag));
					includeManager.addJSP(request, "/modules/authentication/login.jsp");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
				}else{
					if(option1.equals("formCreate")){
						createJournalForm(request,parser);
					}else
						if(option1.equals("formUpdate")){
							updateJournalForm(request,parser);
						}else
							if(option1.equals("formCreateReviewCondition")){
								createReviewConditionForm(request);
							}else
								if(option1.equals("createVolume")){
									createVolumeForm(request);
								}else
									if(option1.equals("formUpdate2")){
										update2JournalForm(request,parser);
									}else
										if(option1.equals("formDelete")){
											deleteJournalForm(request);
										}else
											//deleteJournalForm(request);
											update2JournalForm(request,parser);//To remove
				}
			}
			else{
<<<<<<< HEAD
				includeManager.addCSS("/admin/modules/journal/inc/style.css");
				includeManager.addJS("/admin/modules/journal/inc/fonction.js");
				includeManager.setTitle(languageManager.getLanguageValue("journal_home_page", langTag));
				includeManager.addJSP("/modules/authentication/login.jsp");
=======
				includeManager.addCSS(request, "/admin/modules/journal/inc/style.css");
				includeManager.addJS(request, "/admin/modules/journal/inc/fonction.js");
				includeManager.setTitle(request, languageManager.getLanguageValue("journal_home_page", langTag));
				includeManager.addJSP(request, "/modules/authentication/login.jsp");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
			}
		}
		returnRequest(request, response);

		//		}
		//		else{
		//			forward403(request, response);
		//		}
	}

	private void updateJournalParameter(HttpServletRequest request){
<<<<<<< HEAD
		includeManager.addJS("/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS("/admin/modules/journal/inc/style.css");
		includeManager.setTitle(languageManager.getLanguageValue("journal_update_title", langTag));
		includeManager.addJSP("/admin/modules/journal/updateJournal.jsp");
	}
	private void indexJournalParameter(HttpServletRequest request){
		includeManager.addJS("/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS("/admin/modules/journal/inc/style.css");
		includeManager.setTitle(languageManager.getLanguageValue("journal_home_page", langTag));
		includeManager.addJSP("/admin/modules/journal/login.jsp");
	}
	private void createJournalParameter(HttpServletRequest request){
		includeManager.addJS("/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS("/admin/modules/journal/inc/style.css");
		includeManager.setTitle(languageManager.getLanguageValue("journal_creation_title", langTag));
		includeManager.addJSP("/admin/modules/journal/createJournal.jsp");
=======
		includeManager.addJS(request, "/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS(request, "/admin/modules/journal/inc/style.css");
		includeManager.setTitle(request, languageManager.getLanguageValue("journal_update_title", langTag));
		includeManager.addJSP(request, "/admin/modules/journal/updateJournal.jsp");
	}
	private void indexJournalParameter(HttpServletRequest request){
		includeManager.addJS(request, "/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS(request, "/admin/modules/journal/inc/style.css");
		includeManager.setTitle(request, languageManager.getLanguageValue("journal_home_page", langTag));
		includeManager.addJSP(request, "/admin/modules/journal/login.jsp");
	}
	private void createJournalParameter(HttpServletRequest request){
		includeManager.addJS(request, "/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS(request, "/admin/modules/journal/inc/style.css");
		includeManager.setTitle(request, languageManager.getLanguageValue("journal_creation_title", langTag));
		includeManager.addJSP(request, "/admin/modules/journal/createJournal.jsp");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
	}
	private void createReviewConditionParameter(HttpServletRequest request){
		ArrayList<BaoUser> baoUser=RopJournalDao.getAllUser();
		request.setAttribute("baoUser", baoUser);
<<<<<<< HEAD
		includeManager.addJS("/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS("/admin/modules/journal/inc/style.css");
		includeManager.setTitle(languageManager.getLanguageValue("journal_review_title", langTag));
		includeManager.addJSP("/admin/modules/journal/createReviewCondition.jsp");
=======
		includeManager.addJS(request, "/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS(request, "/admin/modules/journal/inc/style.css");
		includeManager.setTitle(request, languageManager.getLanguageValue("journal_review_title", langTag));
		includeManager.addJSP(request, "/admin/modules/journal/createReviewCondition.jsp");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
	}
	private void createVolumeParameter(HttpServletRequest request){
		ArrayList<BaoJournalOrConf> baoJournalOrConf=RopJournalDao.getAllJournalOrConf();
		request.setAttribute("baoJournalOrConf", baoJournalOrConf);

		ArrayList<BaoNews> baoNews=RopJournalDao.getAllNews();
		request.setAttribute("baoNews", baoNews);

		ArrayList<BaoAutomaticReviewCondition> baoAutomaticReviewCondition=RopJournalDao.getAllAutomaticReviewCondition();
		request.setAttribute("baoAutomaticReviewCondition", baoAutomaticReviewCondition);

<<<<<<< HEAD
		includeManager.addJS("/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS("/admin/modules/journal/inc/style.css");
		includeManager.setTitle(languageManager.getLanguageValue("journal_volume_title", langTag));
		includeManager.addJSP("/admin/modules/journal/createVolume.jsp");
	}
	private void deleteJournalParameter(HttpServletRequest request){
		includeManager.addJS("/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS("/admin/modules/journal/inc/style.css");
		includeManager.setTitle(languageManager.getLanguageValue("journal_delete_title", langTag));
		includeManager.addJSP("/admin/modules/journal/deleteJournal.jsp");
=======
		includeManager.addJS(request, "/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS(request, "/admin/modules/journal/inc/style.css");
		includeManager.setTitle(request, languageManager.getLanguageValue("journal_volume_title", langTag));
		includeManager.addJSP(request, "/admin/modules/journal/createVolume.jsp");
	}
	private void deleteJournalParameter(HttpServletRequest request){
		includeManager.addJS(request, "/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS(request, "/admin/modules/journal/inc/style.css");
		includeManager.setTitle(request, languageManager.getLanguageValue("journal_delete_title", langTag));
		includeManager.addJSP(request, "/admin/modules/journal/deleteJournal.jsp");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
	}
	private void listOfJournalParameter(HttpServletRequest request){
		ArrayList<BaoJournalOrConf> baoJournalOrConf=RopJournalDao.getAllJournalOrConf("Journal");
		request.setAttribute("baoJournalOrConf", baoJournalOrConf);
<<<<<<< HEAD
		includeManager.addJS("/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS("/admin/modules/journal/inc/style.css");
		includeManager.setTitle(languageManager.getLanguageValue("journal_list_of_journal_title", langTag));
		includeManager.addJSP("/admin/modules/journal/listOfJournal.jsp");
=======
		includeManager.addJS(request, "/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS(request, "/admin/modules/journal/inc/style.css");
		includeManager.setTitle(request, languageManager.getLanguageValue("journal_list_of_journal_title", langTag));
		includeManager.addJSP(request, "/admin/modules/journal/listOfJournal.jsp");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
	}
	private void listOfVolumeParameter(HttpServletRequest request){
		ArrayList<BaoVolumeOrIssue> baoVolumeOrIssue=RopJournalDao.getAllVolumeOrNews();
		request.setAttribute("baoVolumeOrIssue", baoVolumeOrIssue);
<<<<<<< HEAD
		includeManager.addJS("/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS("/admin/modules/journal/inc/style.css");
		includeManager.setTitle(languageManager.getLanguageValue("journal_list_of_volume_title", langTag));
		includeManager.addJSP("/admin/modules/journal/listOfVolume.jsp");
=======
		includeManager.addJS(request, "/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS(request, "/admin/modules/journal/inc/style.css");
		includeManager.setTitle(request, languageManager.getLanguageValue("journal_list_of_volume_title", langTag));
		includeManager.addJSP(request, "/admin/modules/journal/listOfVolume.jsp");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
	}
	private void listOfConfParameter(HttpServletRequest request){
		ArrayList<BaoJournalOrConf> baoJournalOrConf=RopJournalDao.getAllJournalOrConf("Conference");
		request.setAttribute("baoJournalOrConf", baoJournalOrConf);
<<<<<<< HEAD
		includeManager.addJS("/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS("/admin/modules/journal/inc/style.css");
		includeManager.setTitle(languageManager.getLanguageValue("journal_list_of_conf_title", langTag));
		includeManager.addJSP("/admin/modules/journal/listOfConf.jsp");
=======
		includeManager.addJS(request, "/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS(request, "/admin/modules/journal/inc/style.css");
		includeManager.setTitle(request, languageManager.getLanguageValue("journal_list_of_conf_title", langTag));
		includeManager.addJSP(request, "/admin/modules/journal/listOfConf.jsp");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
	}
	private void listOfTrashParameter(HttpServletRequest request){
		ArrayList<BaoJournalOrConf> baoJournalOrConf=RopJournalDao.getAllTrashedJournalOrConf((short)3);
		request.setAttribute("baoJournalOrConf", baoJournalOrConf);
<<<<<<< HEAD
		includeManager.addJS("/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS("/admin/modules/journal/inc/style.css");
		includeManager.setTitle(languageManager.getLanguageValue("journal_trash_list_title", langTag));
		includeManager.addJSP("/admin/modules/journal/trashList.jsp");
=======
		includeManager.addJS(request, "/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS(request, "/admin/modules/journal/inc/style.css");
		includeManager.setTitle(request, languageManager.getLanguageValue("journal_trash_list_title", langTag));
		includeManager.addJSP(request, "/admin/modules/journal/trashList.jsp");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
	}
	private void createJournalForm(HttpServletRequest request, MIUMultipartFormParser parser) {
		try{
			Integer journalOrConfId=new Integer(22);
			//MIUMultipartFormParser parser=new MIUMultipartFormParser(request);
			String journalOrConfName=parser.getString("journalOrConfName");
			String journalOrConfType=parser.getString("journalOrConfType");
			short journalOrConfState= 0;
			String journalOrConfLogo=parser.getString("journalOrConfLogo");
			String journalOrConfShortDesc=parser.getString("journalOrConfShortDesc");
			String journalOrConfLongDesc=parser.getString("journalOrConfLongDesc");

			UploadCondition condition=new UploadCondition(configManager);
			condition.addExtension("doc","docx","png","jpg","jpeg");
			condition.setMaxFileSize(1024000000);// En Octet

			String dirName=null;
			String dirName1=null;
			if(journalOrConfType.equals("Journal")){
				dirName="/ressources/journal_conf/journal/"+journalOrConfName+"/";
				dirName1="ressources/journal_conf/journal/"+journalOrConfName+"/";
			}
			else{
				dirName="/ressources/journal_conf/conf/"+journalOrConfName+"/";
				dirName1="ressources/journal_conf/conf/"+journalOrConfName+"/";
			}

			BaoJournalOrConf baoJournal=new BaoJournalOrConf(journalOrConfId,journalOrConfName,journalOrConfType,journalOrConfState);
			baoJournal.setJournalOrConfLogo(dirName1);
			baoJournal.setJournalOrConfShortDesc(journalOrConfShortDesc);
			baoJournal.setJournalOrConfLongDesc(journalOrConfLongDesc);
			BaoJournalOrConf bao=RopJournalDao.getJournalOrConf(journalOrConfName);
			if(bao!=null){
				request.setAttribute("errorMessage", languageManager.getLanguageValue("journal_creation_error_message", langTag));
			}else{
				try{
					MIUIOUtilMethod inst=new MIUIOUtilMethod();
					inst.createFolder(dirName);
					URL urlDest=new MIUIOUtilMethod().getFolderURL(dirName);
					Upload upload=parser.uploadFileTo("journalOrConfLogo", urlDest.getPath().replace("%20", " "), condition);
					baoJournal.setJournalOrConfLogo(baoJournal.getJournalOrConfLogo()+upload.getNewName());
					if(upload!=null){
						System.out.println("getUploadedFile: "+upload.getUploadedFile().getAbsolutePath());
					}
					else{
						System.out.println("Upload Failed, BadFile="+condition.isBadFileType()+" isSizeExceed= "+condition.isSizeExceed());
					}
					ROPCrudDao.saveOrUpdate(baoJournal);
					request.setAttribute("succesMessage", languageManager.getLanguageValue("journal_creation_succes_message", langTag));
				}
				catch(ROPDaoException re){
					re.printStackTrace();
				}
			}
<<<<<<< HEAD
			includeManager.setTitle(languageManager.getLanguageValue("journal_creation_title", langTag));
			includeManager.addJSP("/admin/modules/journal/createJournal.jsp");
=======
			includeManager.setTitle(request, languageManager.getLanguageValue("journal_creation_title", langTag));
			includeManager.addJSP(request, "/admin/modules/journal/createJournal.jsp");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void updateJournalForm(HttpServletRequest request,MIUMultipartFormParser parser){
		try {
			String journalOrConfName = parser.getString("journalOrConfName");

			int journalOrConfState=parser.getInteger("journalOrConfState");
			String journalOrConfType=parser.getString("journalOrConfType");
			BaoJournalOrConf baoJournalOrConf=RopJournalDao.getJournalOrConf(journalOrConfName, journalOrConfState, journalOrConfType);
			if(baoJournalOrConf!=null){
				request.setAttribute("journalName", baoJournalOrConf.getJournalOrConfName());
				request.setAttribute("journalType", baoJournalOrConf.getJournalOrConfType());
				request.setAttribute("journalState", baoJournalOrConf.getJournalOrConfState());
				request.setAttribute("journalLogo", baoJournalOrConf.getJournalOrConfLogo());
				request.setAttribute("journalId",  baoJournalOrConf.getJournalOrConfId());
				request.setAttribute("journalShortDescription", baoJournalOrConf.getJournalOrConfShortDesc());
				request.setAttribute("journalDescription", baoJournalOrConf.getJournalOrConfLongDesc());
<<<<<<< HEAD
				includeManager.setTitle(languageManager.getLanguageValue("journal_update_title", langTag));
				includeManager.addJSP("/admin/modules/journal/updateJournal2.jsp");
=======
				includeManager.setTitle(request, languageManager.getLanguageValue("journal_update_title", langTag));
				includeManager.addJSP(request, "/admin/modules/journal/updateJournal2.jsp");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
			}else{
				request.setAttribute("journalOrConfName", journalOrConfName);
				request.setAttribute("journalOrConfState", journalOrConfState);
				request.setAttribute("message", languageManager.getLanguageValue("journal_update_error", langTag));
<<<<<<< HEAD
				includeManager.setTitle(languageManager.getLanguageValue("journal_update_title", langTag));
				includeManager.addJSP("/admin/modules/journal/updateJournal.jsp");
=======
				includeManager.setTitle(request, languageManager.getLanguageValue("journal_update_title", langTag));
				includeManager.addJSP(request, "/admin/modules/journal/updateJournal.jsp");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
			}
		} catch (MIUIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void update2JournalForm(HttpServletRequest request,MIUMultipartFormParser parser){
		try {
			String journalOrConfName = parser.getString("journalOrConfName");			
			Integer journalOrConfId=parser.getInteger("journalId");
			String journalOrConfType=parser.getString("journalOrConfType");
			int journalOrConfState= parser.getInteger("journalOrConfState");

			String journalOrConfLogo=parser.getString("journalOrConfLogo");
			UploadCondition condition=new UploadCondition(configManager);
			condition.addExtension("doc","docx","png","jpg","jpeg");
			condition.setMaxFileSize(1024000000);// En Octet

			String dirName=null;
			String dirName1=null;
			if(journalOrConfType.equals("Journal")){
				dirName="/ressources/journal_conf/journal/"+journalOrConfName+"/";
				dirName1="ressources/journal_conf/journal/"+journalOrConfName+"/";
			}
			else{
				dirName="/ressources/journal_conf/conf/"+journalOrConfName+"/";
				dirName1="ressources/journal_conf/conf/"+journalOrConfName+"/";
			}

			String journalOrConfShortDesc=parser.getString("journalOrConfShortDesc");
			String journalOrConfLongDesc=parser.getString("journalOrConfLongDesc");

			BaoJournalOrConf baoJournal=new BaoJournalOrConf(journalOrConfId,journalOrConfName,journalOrConfType,journalOrConfState);
			baoJournal.setJournalOrConfShortDesc(journalOrConfShortDesc);
			baoJournal.setJournalOrConfLongDesc(journalOrConfLongDesc);
			int n;
			try{
				File dossier=new File(dirName);
				if(!dossier.exists()){
					MIUIOUtilMethod inst=new MIUIOUtilMethod();
					inst.createFolder(dirName);
				}
				Upload upload=null;
				if(journalOrConfLogo.equals("")){
					dirName1=parser.getString("journalOrConfLogo1");
				}
				else{
					URL urlDest=new MIUIOUtilMethod().getFolderURL(dirName);
					upload=parser.uploadFileTo("journalOrConfLogo", urlDest.getPath().replace("%20", " "), condition);
					dirName1=dirName1+upload.getNewName();
					if(upload!=null){
						System.out.println("getUploadedFile: "+upload.getUploadedFile().getAbsolutePath());
					}
					else{
						System.out.println("Upload Failed, BadFile="+condition.isBadFileType()+" isSizeExceed= "+condition.isSizeExceed());
					}
				}	
				baoJournal.setJournalOrConfLogo(dirName1);
				
				n=RopJournalDao.updateBaoJournalOrConf(baoJournal);
				System.out.println("The result is: n="+n);
			}
			catch(ROPDaoException re){
				re.printStackTrace();
			}
			request.setAttribute("resultOfUpdate", "Update success");
<<<<<<< HEAD
			includeManager.setTitle(languageManager.getLanguageValue("journal_update_title", langTag));
			includeManager.addJSP("/admin/modules/journal/updateJournal.jsp");
=======
			includeManager.setTitle(request, languageManager.getLanguageValue("journal_update_title", langTag));
			includeManager.addJSP(request, "/admin/modules/journal/updateJournal.jsp");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		} catch (MIUIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void deleteJournalForm(HttpServletRequest request){
		String journalOrConfName=request.getParameter("journalOrConfName");
		String journalOrConfType=request.getParameter("journalOrConfType");
		BaoJournalOrConf baoJournalOrConf=RopJournalDao.getJournalOrConf(journalOrConfName);
		if(baoJournalOrConf!=null){
			if(baoJournalOrConf.getJournalOrConfType().equals(journalOrConfType)){
				baoJournalOrConf.setJournalOrConfState(ROPConstants.STATE_DELETED);
				try {
					RopJournalDao.updateBaoJournalOrConf(baoJournalOrConf);
				} catch (ROPDaoException e) {
					System.out.println("Impossible to Delete the journal");
					e.printStackTrace();
				}
				request.setAttribute("resultOfDelete", languageManager.getLanguageValue("journal_delete_succes_message", langTag));
<<<<<<< HEAD
				includeManager.setTitle(languageManager.getLanguageValue("journal_delete_title", langTag));
				includeManager.addJSP("/admin/modules/journal/deleteJournal.jsp");
			}
			else{
				request.setAttribute("resultOfDelete", languageManager.getLanguageValue("journal_delete_error_message", langTag));
				includeManager.setTitle(languageManager.getLanguageValue("journal_delete_title", langTag));
				includeManager.addJSP("/admin/modules/journal/deleteJournal.jsp");
=======
				includeManager.setTitle(request, languageManager.getLanguageValue("journal_delete_title", langTag));
				includeManager.addJSP(request, "/admin/modules/journal/deleteJournal.jsp");
			}
			else{
				request.setAttribute("resultOfDelete", languageManager.getLanguageValue("journal_delete_error_message", langTag));
				includeManager.setTitle(request, languageManager.getLanguageValue("journal_delete_title", langTag));
				includeManager.addJSP(request, "/admin/modules/journal/deleteJournal.jsp");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
			}

		}else{
			request.setAttribute("resultOfDelete", languageManager.getLanguageValue("journal_delete_error_message", langTag));
<<<<<<< HEAD
			includeManager.setTitle(languageManager.getLanguageValue("journal_delete_title", langTag));
			includeManager.addJSP("/admin/modules/journal/deleteJournal.jsp");
=======
			includeManager.setTitle(request, languageManager.getLanguageValue("journal_delete_title", langTag));
			includeManager.addJSP(request, "/admin/modules/journal/deleteJournal.jsp");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		}
	}

	private void createReviewConditionForm(HttpServletRequest request){
		String journal_review_name=request.getParameter("journal_review_name");
		short journal_review_condition_max_reviewer=new Short(request.getParameter("journal_review_condition_max_reviewer"));
		int journal_review_condition_paper_success_percent=new Integer(request.getParameter("journal_review_condition_paper_success_percent"));
		short journal_review_condition_state=new Short(request.getParameter("journal_review_condition_state"));
		int journal_review_condition_max_paper_allowed=new Integer(request.getParameter("journal_review_condition_max_paper_allowed"));
		boolean journal_review_condition_accept_without_editor=request.getParameter("journal_review_condition_accept_without_editor")!=null;
		int journal_review_condition_user=new Integer(request.getParameter("journal_review_condition_user"));
		BaoUser b=new BaoUser();
		b.setUserId(journal_review_condition_user);
		BaoAutomaticReviewCondition baoAutomaticReviewCondition=new BaoAutomaticReviewCondition(22,journal_review_name, 
				journal_review_condition_max_reviewer, journal_review_condition_paper_success_percent,
				journal_review_condition_accept_without_editor, journal_review_condition_state);
		baoAutomaticReviewCondition.setUserIdAutomaticEditor(b);
		baoAutomaticReviewCondition.setReviewConditionMaxPaperAllowed(journal_review_condition_max_paper_allowed);

		try{
			ROPCrudDao.saveOrUpdate(baoAutomaticReviewCondition);
			request.setAttribute("succesMessage", languageManager.getLanguageValue("journal_creation_succes_message", langTag));
		}
		catch(ROPDaoException re){
			re.printStackTrace();
		}
		ArrayList<BaoUser> baoUser=RopJournalDao.getAllUser();
		request.setAttribute("baoUser", baoUser);
<<<<<<< HEAD
		includeManager.setTitle(languageManager.getLanguageValue("journal_review_title", langTag));
		includeManager.addJSP("/admin/modules/journal/createReviewCondition.jsp");
=======
		includeManager.setTitle(request, languageManager.getLanguageValue("journal_review_title", langTag));
		includeManager.addJSP(request, "/admin/modules/journal/createReviewCondition.jsp");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc


	}

	private void createVolumeForm(HttpServletRequest request){
		String journal_volume_issue_journal_or_conf=request.getParameter("journal_volume_issue_journal_or_conf");
		BaoJournalOrConf baoJournalOrConf=new BaoJournalOrConf();
		baoJournalOrConf.setJournalOrConfId(new Integer(journal_volume_issue_journal_or_conf));

		String journal_volume_issue_review_condition=request.getParameter("journal_volume_issue_review_condition");
		BaoAutomaticReviewCondition baoAutomaticReviewCondition=new BaoAutomaticReviewCondition();
		baoAutomaticReviewCondition.setReviewConditionId(new Integer(journal_volume_issue_review_condition));


		String journal_volume_issue_news=request.getParameter("journal_volume_issue_news");
		BaoNews baoNews=new BaoNews();
		baoNews.setNewsId(new Integer(journal_volume_issue_news));

		String journal_volume_issue_identifier=request.getParameter("journal_volume_issue_identifier");//
		String journal_volume_issue_desc=request.getParameter("journal_volume_issue_desc");//
		short journal_volume_issue_state=new Short(request.getParameter("journal_volume_issue_state"));//
		String journal_volume_issue_submission_deadline=request.getParameter("journal_volume_issue_submission_deadline");//


		GregorianCalendar calendar = new java.util.GregorianCalendar();
		String dateOfDay="";
		dateOfDay+=calendar.get(Calendar.YEAR);
		if(calendar.get(Calendar.MONTH)<10) dateOfDay+="0";
		dateOfDay+=calendar.get(Calendar.MONTH)+1;
		if(calendar.get(Calendar.DAY_OF_MONTH)<10) dateOfDay+="0";
		dateOfDay+=calendar.get(Calendar.DAY_OF_MONTH);
		if(journal_volume_issue_submission_deadline.length()==10){
			calendar.set(new Integer(journal_volume_issue_submission_deadline.substring(0, 4)),
					new Integer(journal_volume_issue_submission_deadline.substring(5, 7)), 
					new Integer(journal_volume_issue_submission_deadline.substring(8, 10)));
		}
		Date d=calendar.getTime();

		BaoVolumeOrIssue baoVolumeOrIssue=new BaoVolumeOrIssue(22,journal_volume_issue_identifier,d,journal_volume_issue_state); 
		baoVolumeOrIssue.setVolumeOrIssueDesc(journal_volume_issue_desc);
		baoVolumeOrIssue.setJournalOrConfId(baoJournalOrConf);
		baoVolumeOrIssue.setNewsIdCallForPaper(baoNews);
		baoVolumeOrIssue.setReviewConditionId(baoAutomaticReviewCondition);

		try{
			ROPCrudDao.saveOrUpdate(baoVolumeOrIssue);
			request.setAttribute("succesMessage", languageManager.getLanguageValue("journal_volume_creation_succes_message", langTag));
		}
		catch(ROPDaoException re){
			request.setAttribute("succesMessage", languageManager.getLanguageValue("journal_volume_creation_error_message", langTag));
			re.printStackTrace();
		}
		ArrayList<BaoJournalOrConf> baoJournalOrConf1=RopJournalDao.getAllJournalOrConf();
		request.setAttribute("baoJournalOrConf", baoJournalOrConf1);

		ArrayList<BaoNews> baoNews1=RopJournalDao.getAllNews();
		request.setAttribute("baoNews", baoNews1);

		ArrayList<BaoAutomaticReviewCondition> baoAutomaticReviewCondition1=RopJournalDao.getAllAutomaticReviewCondition();
		request.setAttribute("baoAutomaticReviewCondition", baoAutomaticReviewCondition1);
<<<<<<< HEAD
		includeManager.setTitle(languageManager.getLanguageValue("journal_volume_title", langTag));
		includeManager.addJSP("/admin/modules/journal/createVolume.jsp");
=======
		includeManager.setTitle(request, languageManager.getLanguageValue("journal_volume_title", langTag));
		includeManager.addJSP(request, "/admin/modules/journal/createVolume.jsp");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc


	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
<<<<<<< HEAD
		adminJournalMenu();
=======
		adminJournalMenu(request);
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		if(contextExists(request)||contextExists1(request)){
			restoreContext(request, response);
			request.getSession().removeAttribute("b");
			request.getSession().removeAttribute("c");
			return;
		}
<<<<<<< HEAD
		if(isConnected()){
=======
		if(isConnected(request)){
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
			String formulaire = null;
			MIUMultipartFormParser parser;
			try{
				parser=new MIUMultipartFormParser(request);
				String parOpt = parser.getString("formulaire");
				if(parOpt != null)
					formulaire = encryptor.decrypt(parOpt);
			}catch(Exception e){
				forward500(request, response);
				return;
			}
			System.out.println("the formUpdate is: "+formulaire);
			if(formulaire.equals("formCreate")){
				createJournalForm(request, parser);
			}
			if(formulaire.equals("formUpdate")){
				updateJournalForm(request,parser);
			}
			if(formulaire.equals("formUpdate2")){
				update2JournalForm(request,parser);
			}
			if(formulaire.equals("formDelete")){
				deleteJournalForm(request);
			}
			if(formulaire.equals("formCreateReviewCondition")){
				createReviewConditionForm(request);
			}
			if(formulaire.equals("createVolume")){
				createVolumeForm(request);
			}
			returnRequest(request, response);
		}else{
			request.getSession().setAttribute("c", "");
			request.setAttribute("formulaire", request.getParameter("formulaire"));
			System.out.println("the form type is: "+request.getParameter("formulaire"));
			requestAuthentication(request, response, "adminJournal");
		}
	}

<<<<<<< HEAD
	public void adminJournalMenu(){
		int id=includeManager.createSideMenu(languageManager.getLanguageValue("journal_or_conf_menu_title", langTag));
		try {
			includeManager.addMenuItem(id, languageManager.getLanguageValue("journal_create_journal", langTag),"/?m="+encryptor.encrypt("adminJournal")+"&ob="+encryptor.encrypt("create"));
			includeManager.addMenuItem(id, languageManager.getLanguageValue("journal_update_journal", langTag),"/?m="+encryptor.encrypt("adminJournal")+"&ob="+encryptor.encrypt("update"));
			includeManager.addMenuItem(id, languageManager.getLanguageValue("journal_delete_journal", langTag),"/?m="+encryptor.encrypt("adminJournal")+"&ob="+encryptor.encrypt("delete"));
			includeManager.addMenuItem(id, languageManager.getLanguageValue("journal_list_of_journal", langTag),"/?m="+encryptor.encrypt("adminJournal")+"&ob="+encryptor.encrypt("listOfJournal"));
			includeManager.addMenuItem(id, languageManager.getLanguageValue("journal_list_of_conf", langTag),"/?m="+encryptor.encrypt("adminJournal")+"&ob="+encryptor.encrypt("listOfConf"));
			includeManager.addMenuItem(id, languageManager.getLanguageValue("journal_trash_list", langTag),"/?m="+encryptor.encrypt("adminJournal")+"&ob="+encryptor.encrypt("trashList"));
			includeManager.addMenuItem(id, languageManager.getLanguageValue("journal_review_creation", langTag),"/?m="+encryptor.encrypt("adminJournal")+"&ob="+encryptor.encrypt("createReviewCondition"));
			includeManager.addMenuItem(id, languageManager.getLanguageValue("journal_volume_creation", langTag),"/?m="+encryptor.encrypt("adminJournal")+"&ob="+encryptor.encrypt("createVolume"));
			includeManager.addMenuItem(id, languageManager.getLanguageValue("journal_volume_list", langTag),"/?m="+encryptor.encrypt("adminJournal")+"&ob="+encryptor.encrypt("listOfVolume"));
=======
	public void adminJournalMenu(HttpServletRequest request){
		int id=includeManager.createSideMenu(request, languageManager.getLanguageValue("journal_or_conf_menu_title", langTag));
		try {
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue("journal_create_journal", langTag),"/?m="+encryptor.encrypt("adminJournal")+"&ob="+encryptor.encrypt("create"));
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue("journal_update_journal", langTag),"/?m="+encryptor.encrypt("adminJournal")+"&ob="+encryptor.encrypt("update"));
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue("journal_delete_journal", langTag),"/?m="+encryptor.encrypt("adminJournal")+"&ob="+encryptor.encrypt("delete"));
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue("journal_list_of_journal", langTag),"/?m="+encryptor.encrypt("adminJournal")+"&ob="+encryptor.encrypt("listOfJournal"));
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue("journal_list_of_conf", langTag),"/?m="+encryptor.encrypt("adminJournal")+"&ob="+encryptor.encrypt("listOfConf"));
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue("journal_trash_list", langTag),"/?m="+encryptor.encrypt("adminJournal")+"&ob="+encryptor.encrypt("trashList"));
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue("journal_review_creation", langTag),"/?m="+encryptor.encrypt("adminJournal")+"&ob="+encryptor.encrypt("createReviewCondition"));
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue("journal_volume_creation", langTag),"/?m="+encryptor.encrypt("adminJournal")+"&ob="+encryptor.encrypt("createVolume"));
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue("journal_volume_list", langTag),"/?m="+encryptor.encrypt("adminJournal")+"&ob="+encryptor.encrypt("listOfVolume"));
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc

			//includeManager.addMenuSubItem(id, id2, "Test 2", "#");
		} catch (ROPCryptographyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//	}
}
