package rop.miu.admin.modules.journal;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rop.miu.admin.modules.AdminServletModel;
import rop.miu.admin.modules.journal.dao.RopJournalDao;
import rop.miu.beans.BaoJournalOrConf;
import rop.miu.dao.ROPCrudDao;
import rop.miu.util.ROPConstants;
import rop.miu.util.exceptions.ROPDaoException;


public class ModAdminJournal extends AdminServletModel {
	private static final long serialVersionUID = 1L;
	public ModAdminJournal() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String option = null;
		try{
			String parOpt = request.getParameter("ob");
			if(parOpt != null)
				option = encryptor.decrypt(parOpt);
		}catch(Exception e){
			forward500(request, response);
			return;
		}
		if(isConnected(request)){
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
			//			if(isAccessGranted(ROPConstants.ADMIN_ACCESS)){
			//returnRequest(request, response);
			//			}
			//			else{
			//				forward403(request, response);
			//			}
			
			String formulaire = null;
			try{
				String parOpt = request.getParameter("formulaire");
				if(parOpt != null)
					formulaire = encryptor.decrypt(parOpt);
			}catch(Exception e){
				forward500(request, response);
				return;
			}
			System.out.println("the formUpdate is: "+formulaire);
			if(formulaire.equals("formCreate")){
				createJournalForm(request);
			}
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
						if(option.equals("listOfJournal")){
							listOfJournalParameter(request);
						}else
							if(option.equals("listOfConf")){
								listOfConfParameter(request);
							}else
								if(option.equals("trashList")){
									listOfTrashParameter(request);
								}else
									deleteJournalParameter(request);


		}
		else{
			if(contextExists1(request)&&contextExists(request)){
				String option1 = null;
				try{
					String parOpt = request.getParameter("formulaire");
					if(parOpt != null)
						option1 = encryptor.decrypt(parOpt);
				}catch(Exception e){
					forward500(request, response);
					return;
				}
				if(option1==null){
					includeManager.addCSS(request, "/admin/modules/journal/inc/style.css");
					includeManager.addJS(request, "/admin/modules/journal/inc/fonction.js");
					includeManager.setTitle(request, languageManager.getLanguageValue("journal_home_page", langTag));
					includeManager.addJSP(request, "/modules/authentication/login.jsp");
				}else
					if(option1.equals("formCreate")){
						createJournalForm(request);
					}else
						if(option1.equals("formUpdate")){
							updateJournalForm(request);
						}else
							if(option1.equals("formUpdate2")){
								update2JournalForm(request);
							}else
								if(option1.equals("formDelete")){
									deleteJournalForm(request);
								}else
									//deleteJournalForm(request);
									update2JournalForm(request);//To remove
			}
			else{
				includeManager.addCSS(request, "/admin/modules/journal/inc/style.css");
				includeManager.addJS(request, "/admin/modules/journal/inc/fonction.js");
				includeManager.setTitle(request, languageManager.getLanguageValue("journal_home_page", langTag));
				includeManager.addJSP(request, "/modules/authentication/login.jsp");
			}
		}
		returnRequest(request, response);

		//		}
		//		else{
		//			forward403(request, response);
		//		}
	}

	private void updateJournalParameter(HttpServletRequest request){
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
	}
	private void deleteJournalParameter(HttpServletRequest request){
		includeManager.addJS(request, "/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS(request, "/admin/modules/journal/inc/style.css");
		includeManager.setTitle(request, languageManager.getLanguageValue("journal_delete_title", langTag));
		includeManager.addJSP(request, "/admin/modules/journal/deleteJournal.jsp");
	}
	private void listOfJournalParameter(HttpServletRequest request){
		ArrayList<BaoJournalOrConf> baoJournalOrConf=RopJournalDao.getAllJournalOrConf("Journal");
		request.setAttribute("baoJournalOrConf", baoJournalOrConf);
		includeManager.addJS(request, "/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS(request, "/admin/modules/journal/inc/style.css");
		includeManager.setTitle(request, languageManager.getLanguageValue("journal_list_of_journal_title", langTag));
		includeManager.addJSP(request, "/admin/modules/journal/listOfJournal.jsp");
	}
	private void listOfConfParameter(HttpServletRequest request){
		ArrayList<BaoJournalOrConf> baoJournalOrConf=RopJournalDao.getAllJournalOrConf("Conference");
		request.setAttribute("baoJournalOrConf", baoJournalOrConf);
		includeManager.addJS(request, "/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS(request, "/admin/modules/journal/inc/style.css");
		includeManager.setTitle(request, languageManager.getLanguageValue("journal_list_of_conf_title", langTag));
		includeManager.addJSP(request, "/admin/modules/journal/listOfConf.jsp");
	}
	private void listOfTrashParameter(HttpServletRequest request){
		ArrayList<BaoJournalOrConf> baoJournalOrConf=RopJournalDao.getAllTrashedJournalOrConf((short)3);
		request.setAttribute("baoJournalOrConf", baoJournalOrConf);
		includeManager.addJS(request, "/admin/modules/journal/inc/fonction.js");
		includeManager.addCSS(request, "/admin/modules/journal/inc/style.css");
		includeManager.setTitle(request, languageManager.getLanguageValue("journal_trash_list_title", langTag));
		includeManager.addJSP(request, "/admin/modules/journal/trashList.jsp");
	}
	private void createJournalForm(HttpServletRequest request){
		Integer journalOrConfId=new Integer(22);
		String journalOrConfName=request.getParameter("journalOrConfName");
		String journalOrConfType=request.getParameter("journalOrConfType");
		short journalOrConfState= 0;
		//new Short(request.getParameter("journalOrConfState"));
		String journalOrConfLogo=request.getParameter("journalOrConfLogo");
		String path="ressources/journal_conf/"+journalOrConfLogo;
		System.out.println("path:  "+path);
		String journalOrConfShortDesc=request.getParameter("journalOrConfShortDesc");
		String journalOrConfLongDesc=request.getParameter("journalOrConfLongDesc");
		BaoJournalOrConf baoJournal=new BaoJournalOrConf(journalOrConfId,journalOrConfName,journalOrConfType,journalOrConfState);
		baoJournal.setJournalOrConfLogo(path);
		baoJournal.setJournalOrConfShortDesc(journalOrConfShortDesc);
		baoJournal.setJournalOrConfLongDesc(journalOrConfLongDesc);
		BaoJournalOrConf bao=RopJournalDao.getJournalOrConf(journalOrConfName);
		if(bao!=null){
			request.setAttribute("errorMessage", languageManager.getLanguageValue("journal_creation_error_message", langTag));
		}else{
			try{
				ROPCrudDao.saveOrUpdate(baoJournal);
				request.setAttribute("succesMessage", languageManager.getLanguageValue("journal_creation_succes_message", langTag));
			}
			catch(ROPDaoException re){
				re.printStackTrace();
			}
		}
		includeManager.setTitle(request, languageManager.getLanguageValue("journal_creation_title", langTag));
		includeManager.addJSP(request, "/admin/modules/journal/createJournal.jsp");
	}

	private void updateJournalForm(HttpServletRequest request){
		String journalOrConfName=request.getParameter("journalOrConfName");
		short journalOrConfState=new Short(request.getParameter("journalOrConfState"));
		String journalOrConfType=request.getParameter("journalOrConfType");
		BaoJournalOrConf baoJournalOrConf=RopJournalDao.getJournalOrConf(journalOrConfName, journalOrConfState, journalOrConfType);
		if(baoJournalOrConf!=null){
			request.setAttribute("journalName", baoJournalOrConf.getJournalOrConfName());
			request.setAttribute("journalType", baoJournalOrConf.getJournalOrConfType());
			request.setAttribute("journalState", baoJournalOrConf.getJournalOrConfState());
			request.setAttribute("journalLogo", baoJournalOrConf.getJournalOrConfLogo());
			request.setAttribute("journalId",  baoJournalOrConf.getJournalOrConfId());
			request.setAttribute("journalShortDescription", baoJournalOrConf.getJournalOrConfShortDesc());
			request.setAttribute("journalDescription", baoJournalOrConf.getJournalOrConfLongDesc());
			includeManager.setTitle(request, languageManager.getLanguageValue("journal_update_title", langTag));
			includeManager.addJSP(request, "/admin/modules/journal/updateJournal2.jsp");
		}else{
			request.setAttribute("journalOrConfName", journalOrConfName);
			request.setAttribute("journalOrConfState", journalOrConfState);
			request.setAttribute("message", languageManager.getLanguageValue("journal_update_error", langTag));
			includeManager.setTitle(request, languageManager.getLanguageValue("journal_update_title", langTag));
			includeManager.addJSP(request, "/admin/modules/journal/updateJournal.jsp");
		}
	}
	private void update2JournalForm(HttpServletRequest request){
		Integer journalOrConfId=new Integer(request.getParameter("journalId"));
		String journalOrConfName=request.getParameter("journalOrConfName");
		String journalOrConfType=request.getParameter("journalOrConfType");
		short journalOrConfState= new Short(request.getParameter("journalOrConfState"));
		String journalOrConfLogo=request.getParameter("journalOrConfLogo");
		String journalOrConfShortDesc=request.getParameter("journalOrConfShortDesc");
		String journalOrConfLongDesc=request.getParameter("journalOrConfLongDesc");
		BaoJournalOrConf baoJournal=new BaoJournalOrConf(journalOrConfId,journalOrConfName,journalOrConfType,journalOrConfState);
		baoJournal.setJournalOrConfLogo(journalOrConfLogo);
		baoJournal.setJournalOrConfShortDesc(journalOrConfShortDesc);
		baoJournal.setJournalOrConfLongDesc(journalOrConfLongDesc);
		int n;
		try {
			n = RopJournalDao.updateBaoJournalOrConf(baoJournal);
			System.out.println("The result is: "+n);
		} catch (ROPDaoException e) {
			System.out.println("Impossible to update the journal");
			e.printStackTrace();
		}

		request.setAttribute("resultOfUpdate", "Update success");
		includeManager.setTitle(request, languageManager.getLanguageValue("journal_update_title", langTag));
		includeManager.addJSP(request, "/admin/modules/journal/updateJournal.jsp");
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
				includeManager.setTitle(request, languageManager.getLanguageValue("journal_delete_title", langTag));
				includeManager.addJSP(request, "/admin/modules/journal/deleteJournal.jsp");
			}
			else{
				request.setAttribute("resultOfDelete", languageManager.getLanguageValue("journal_delete_error_message", langTag));
				includeManager.setTitle(request, languageManager.getLanguageValue("journal_delete_title", langTag));
				includeManager.addJSP(request, "/admin/modules/journal/deleteJournal.jsp");
			}

		}else{
			request.setAttribute("resultOfDelete", languageManager.getLanguageValue("journal_delete_error_message", langTag));
			includeManager.setTitle(request, languageManager.getLanguageValue("journal_delete_title", langTag));
			includeManager.addJSP(request, "/admin/modules/journal/deleteJournal.jsp");
		}
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		if(contextExists(request)||contextExists1(request)){
			restoreContext(request, response);
			request.getSession().removeAttribute("b");
			request.getSession().removeAttribute("c");
			return;
		}
		if(isConnected(request)){
			String formulaire = null;
			try{
				String parOpt = request.getParameter("formulaire");
				if(parOpt != null)
					formulaire = encryptor.decrypt(parOpt);
			}catch(Exception e){
				forward500(request, response);
				return;
			}
			System.out.println("the formUpdate is: "+formulaire);
			if(formulaire.equals("formCreate")){
				createJournalForm(request);
			}
			if(formulaire.equals("formUpdate")){
				updateJournalForm(request);
			}
			if(formulaire.equals("formUpdate2")){
				update2JournalForm(request);
			}
			if(formulaire.equals("formDelete")){
				deleteJournalForm(request);
			}
			returnRequest(request, response);
		}else{
			request.getSession().setAttribute("c", "");
			request.setAttribute("formulaire", request.getParameter("formulaire"));
			System.out.println("the form type is: "+request.getParameter("formulaire"));
			requestAuthentication(request, response, "adminJournal");
		}
	}

	//	}
}
