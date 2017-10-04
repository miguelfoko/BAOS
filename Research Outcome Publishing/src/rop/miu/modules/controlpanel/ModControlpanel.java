package rop.miu.modules.controlpanel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rop.miu.modules.ServletModel;
import rop.miu.util.exceptions.ROPCryptographyException;

public class ModControlpanel extends ServletModel {
	private static final long serialVersionUID = 1L;
       
    public ModControlpanel() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
<<<<<<< HEAD
		controlPanelMenu(request);
		includeManager.setTitle(request, languageManager.getLanguageValue("control_panel", langTag));
		includeManager.addJSP(request, "/modules/controlpanel/index.jsp");
		includeManager.addCSS(request, "/modules/controlpanel/css/style.css");
		includeManager.addJS(request, "/modules/controlpanel/js/util.js");
=======
		
		getIncludeManager(request).setTitle(request, languageManager.getLanguageValue("control_panel", langTag));
		getIncludeManager(request).addJSP(request, "/modules/controlpanel/slide.jsp");
		getIncludeManager(request).addJSP(request, "/modules/controlpanel/baos_learning.jsp");
		getIncludeManager(request).addJSP(request, "/modules/controlpanel/baos_publishing.jsp");
		getIncludeManager(request).addJSP(request, "/modules/controlpanel/baos_community.jsp");
		getIncludeManager(request).addCSS(request, "/ressources/miu_slideshow/themes/default/css/miu_slideshow.css");
		getIncludeManager(request).addCSS(request, "/modules/controlpanel/css/style.css");
		getIncludeManager(request).addJS(request, "/ressources/miu_slideshow/js/miu_slideshow.js");
		getIncludeManager(request).addJS(request, "/modules/controlpanel/js/util.js");
>>>>>>> 8dd851048c6e70797b20b83ae8201f6cdc09b191
		
		this.returnRequest(request, response);
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
	public void controlPanelMenu(HttpServletRequest request){
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

			//includeManager.addMenuSubItem(id, id2, "Test 2", "#");
		} catch (ROPCryptographyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
