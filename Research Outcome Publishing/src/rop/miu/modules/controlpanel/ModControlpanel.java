package rop.miu.modules.controlpanel;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rop.miu.modules.ServletModel;

public class ModControlpanel extends ServletModel {
	private static final long serialVersionUID = 1L;
       
    public ModControlpanel() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		
		getIncludeManager(request).setTitle(request, languageManager.getLanguageValue("control_panel", langTag));
		getIncludeManager(request).addJSP(request, "/modules/controlpanel/slide.jsp");
		getIncludeManager(request).addJSP(request, "/modules/controlpanel/baos_learning.jsp");
		getIncludeManager(request).addJSP(request, "/modules/controlpanel/baos_publishing.jsp");
		getIncludeManager(request).addJSP(request, "/modules/controlpanel/baos_community.jsp");
		getIncludeManager(request).addCSS(request, "/ressources/miu_slideshow/themes/default/css/miu_slideshow.css");
		getIncludeManager(request).addCSS(request, "/modules/controlpanel/css/style.css");
		getIncludeManager(request).addJS(request, "/ressources/miu_slideshow/js/miu_slideshow.js");
		getIncludeManager(request).addJS(request, "/modules/controlpanel/js/util.js");
		
		this.returnRequest(request, response);
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
}
