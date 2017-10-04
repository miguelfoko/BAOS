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
		
		includeManager.setTitle(languageManager.getLanguageValue("control_panel", langTag));
		includeManager.addJSP("/modules/controlpanel/index.jsp");
		includeManager.addCSS("/modules/controlpanel/css/style.css");
		includeManager.addJS("/modules/controlpanel/js/util.js");
		
		this.returnRequest(request, response);
		return;
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}
}
