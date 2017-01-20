package rop.miu.admin.modules;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rop.miu.TesteurFiltrePrincipal;
import rop.miu.util.IncludeManager;
import rop.miu.util.ROPEncryptor;
import rop.miu.util.ROPLanguageManager;


public class AdminServletModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected ROPLanguageManager languageManager;
	protected ROPEncryptor encryptor;
	protected IncludeManager includeManager;
	protected String langTag;
       
    public AdminServletModel() {
        super();
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		languageManager = (ROPLanguageManager)config.getServletContext().getAttribute("languageManager");
		encryptor = (ROPEncryptor)config.getServletContext().getAttribute("encryptor");
	}

	public void returnRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	TesteurFiltrePrincipal testeur = new TesteurFiltrePrincipal();
    	request.getServletContext().getRequestDispatcher("/admin/templates/"+testeur.getDefaultAdminTemplate()+"/index.jsp").forward(request, response);
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		initRequest(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		initRequest(request, response);
	}
	
	protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		initRequest(request, response);
	}
	
	private void initRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		includeManager = new IncludeManager(request);
		langTag = (String)request.getSession().getAttribute("tag");
	}
}
