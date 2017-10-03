package rop.miu.modules;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import rop.miu.ConfigManager;
import rop.miu.beans.BaoAccessRight;
import rop.miu.beans.BaoGroup;
import rop.miu.beans.BaoUser;
import rop.miu.dao.ROPCrudDao;
import rop.miu.util.IncludeManager;
import rop.miu.util.ROPConstants;
import rop.miu.util.ROPEncryptor;
import rop.miu.util.ROPLanguageManager;


public class ServletModel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected ROPLanguageManager languageManager;
	protected ROPEncryptor encryptor;
	protected IncludeManager includeManager;
	protected String langTag;
	protected BaoUser baoUser;
	protected ConfigManager configManager;
<<<<<<< HEAD
	private HttpServletRequest request;
=======
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
       
    public ServletModel() {
        super();
    }

    @Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		languageManager = (ROPLanguageManager)config.getServletContext().getAttribute("languageManager");
		encryptor = (ROPEncryptor)config.getServletContext().getAttribute("encryptor");
		configManager = (ConfigManager)config.getServletContext().getAttribute("configManager");
	}

	public void returnRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	ConfigManager testeur = new ConfigManager();
    	request.getServletContext().getRequestDispatcher("/templates/"+testeur.getDefaultTemplate()+"/index.jsp").forward(request, response);
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
<<<<<<< HEAD
		this.request = request;
=======
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		includeManager = (IncludeManager)request.getAttribute("includeManager");
		langTag = (String)request.getSession().getAttribute("tag");
		baoUser = (BaoUser)request.getSession().getAttribute("baoUser");
	}
	
	protected IncludeManager getIncludeManager(HttpServletRequest request) throws ServletException, IOException{
		return (IncludeManager)request.getAttribute("includeManager");
	}
	
	protected BaoUser getBaoUser(HttpServletRequest request) throws ServletException, IOException{
		return (BaoUser)request.getSession().getAttribute("baoUser");
	}
	
	protected void setBaoUser(HttpServletRequest request, BaoUser user) throws ServletException, IOException{
		request.getSession().setAttribute("baoUser", user);
	}
	
	protected String getLangTag(HttpServletRequest request) throws ServletException, IOException{
		return (String)request.getSession().getAttribute("tag");
	}
	
	protected boolean isConnected(HttpServletRequest request) throws ServletException, IOException{
		return getBaoUser(request) != null;
	}
	
	public boolean isAccessGranted(HttpServletRequest request, String access){
		if(access.equals(ROPConstants.PUBLIC_ACCESS))
			return true;
		if(access.equals(ROPConstants.MEMBER_ACCESS))
			return haveRight(request, ROPConstants.MEMBER_ACCESS_RIGHT);
		if(access.equals(ROPConstants.ADMIN_ACCESS))
			return haveRight(request, ROPConstants.ADMIN_ACCESS_RIGHT);
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean haveRight(HttpServletRequest request, String right){
		if(baoUser == null)
			return false;
		DateTime time = null;
		if(request != null)
			time = (DateTime)request.getSession().getAttribute("refresh_time");
		if(time == null || (DateTime.now().minusSeconds(ROPConstants.MAX_REFRESH_TIME).compareTo(time) >= 0)){
			try{
				time = DateTime.now();
				if(request != null)
					request.getSession().setAttribute("refresh_time", time);
				String sql = "SELECT * FROM bao_user_group WHERE user_id = ?";
				ArrayList<BaoGroup> groupList = new ArrayList<BaoGroup>();
				ArrayList<BaoAccessRight> rightList;
				List l = ROPCrudDao.selectManyElementsSql(sql, baoUser.getUserId()), l1;
				BaoGroup group;
				Object[] obj, obj1;
				for(Object o : l){
					obj = (Object[])o;
					rightList = new ArrayList<BaoAccessRight>();
					group = (BaoGroup) ROPCrudDao.getById(BaoGroup.class, (Integer)obj[0]);
					sql = "SELECT * FROM bao_group_access_right WHERE group_id = ?";
					l1 = ROPCrudDao.selectManyElementsSql(sql, (Integer)obj[0]);
					for(Object o1 : l1){
						obj1 = (Object[])o1;
						rightList.add((BaoAccessRight)ROPCrudDao.getById(BaoAccessRight.class, (Integer)obj1[0]));
					}
					group.setBaoAccessRightList(rightList);
					groupList.add(group);
				}
				baoUser.setBaoGroupList(groupList);
			}
			catch(Exception e){
				
			}
		}
		for(BaoGroup g : baoUser.getBaoGroupList()){
			for(BaoAccessRight ar : g.getBaoAccessRightList())
				return ar.getAccessRightName().equals(ROPConstants.ROOT_RIGHT) || ar.getAccessRightName().equals(right);
		}
		return false;
	}
	
	public void requestAuthentication(HttpServletRequest request, HttpServletResponse response, String redirect) throws ServletException, IOException{
    	request.setAttribute("auth_redirect", redirect);
    	request.getServletContext().getRequestDispatcher("/ModAuthentication").forward(request, response);
    }
	
	public void forwardToModule(HttpServletRequest request, HttpServletResponse response, String module) throws ServletException, IOException{
		request.getServletContext().getRequestDispatcher("/Mod"+ConfigManager.setFirstUppercase(module)).forward(request, response);
	}
	
	public void forward404(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
<<<<<<< HEAD
		includeManager.resetIncludeList();
=======
		includeManager.resetIncludeList(request);
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		//Compléter par l'inclusion des fichiers correspondants
		returnRequest(request, response);
	}
	
	public void forward403(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
<<<<<<< HEAD
		includeManager.resetIncludeList();
=======
		includeManager.resetIncludeList(request);
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		//Compléter par l'inclusion des fichiers correspondants
		returnRequest(request, response);
	}
	
	public void forward500(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
<<<<<<< HEAD
		includeManager.resetIncludeList();
=======
		includeManager.resetIncludeList(request);
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		//Compléter par l'inclusion des fichiers correspondants
		returnRequest(request, response);
	}
}
