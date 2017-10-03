package rop.miu.modules.journal;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rop.miu.beans.BaoJournalOrConf;
import rop.miu.dao.ROPCrudDao;
import rop.miu.modules.ServletModel;
import rop.miu.util.exceptions.ROPDaoException;


public class ModJournal extends ServletModel {
	private static final long serialVersionUID = 1L;
	 public ModJournal() {
	        super();
	    }

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			super.doGet(request, response);
			request.setAttribute("journal_name", languageManager.getLanguageValue("journal_name", langTag));
			request.setAttribute("journal_type", languageManager.getLanguageValue("journal_type", langTag));
			request.setAttribute("journal_state", languageManager.getLanguageValue("journal_state", langTag));
			request.setAttribute("journal_choose_type", languageManager.getLanguageValue("journal_choose_type", langTag));
			request.setAttribute("journal_logo", languageManager.getLanguageValue("journal_logo", langTag));
			request.setAttribute("journal_short_desc", languageManager.getLanguageValue("journal_short_desc", langTag));
			request.setAttribute("journal_long_desc", languageManager.getLanguageValue("journal_long_desc", langTag));
			request.setAttribute("journal_creation_cancel_button", languageManager.getLanguageValue("journal_creation_cancel_button", langTag));
			request.setAttribute("journal_creation_submit_button", languageManager.getLanguageValue("journal_creation_submit_button", langTag));
			includeManager.setTitle(request, languageManager.getLanguageValue("journal_title", langTag));
			includeManager.addJSP(request, "/modules/journal/login.jsp");
			
			returnRequest(request, response);
		}
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Integer journalOrConfId=new Integer(22);
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
			try{
				ROPCrudDao.saveOrUpdate(baoJournal);
			}
			catch(ROPDaoException re){
				re.printStackTrace();
			}
		}

}
