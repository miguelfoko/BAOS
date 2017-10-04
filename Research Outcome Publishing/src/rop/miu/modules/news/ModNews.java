package rop.miu.modules.news;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rop.miu.beans.BaoJournalOrConf;
import rop.miu.beans.BaoNews;
import rop.miu.beans.BaoUser;
import rop.miu.dao.ROPCrudDao;
import rop.miu.modules.ServletModel;
import rop.miu.modules.journal.dao.RopJournalDao;
import rop.miu.modules.news.dao.RopNewsDao;
import rop.miu.util.exceptions.ROPCryptographyException;
import rop.miu.util.exceptions.ROPDaoException;

public class ModNews extends ServletModel {
	private static final long serialVersionUID = 1L;

	public ModNews() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		super.doGet(request, response);
		newsMenu();
		String option = null;
		try{
			String parOpt = request.getParameter("ob");
			if(parOpt != null)
				option = encryptor.decrypt(parOpt);
		}catch(Exception e){
			forward500(request, response);
			return;
		}
		if(isConnected()){
			//			if(isAccessGranted(ROPConstants.ADMIN_ACCESS)){
			if(option==null||option.equals("login")){
				indexNewsParameter(request);
				returnRequest(request, response);
				return;
			}
			if(option.equals("create")){
				createNewsParameter(request);
				returnRequest(request, response);
				return;
			}
			if(option.equals("list")){
				listOfNewsParameter(request);
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
			requestAuthentication(request, response, "news");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		if(contextExists(request)||contextExists1(request)){
			restoreContext(request, response);
			request.getSession().removeAttribute("b");
			request.getSession().removeAttribute("c");
			return;
		}
		if(isConnected()){
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
			if(formulaire.equals("formCreateNews")){
				createNewsForm(request);
			}
			returnRequest(request, response);
		}else{
			request.getSession().setAttribute("c", "");
			request.setAttribute("formulaire", request.getParameter("formulaire"));
			System.out.println("the form type is: "+request.getParameter("formulaire"));
			requestAuthentication(request, response, "adminJournal");
		}
}

private void indexNewsParameter(HttpServletRequest request){
	includeManager.addJS("/modules/news/inc/fonction.js");
	includeManager.addCSS("/modules/news/inc/style.css");
	includeManager.setTitle(languageManager.getLanguageValue("news_home_page", langTag));
	includeManager.addJSP("/modules/news/login.jsp");
}
private void createNewsParameter(HttpServletRequest request){
	ArrayList<BaoUser> baoUser=RopNewsDao.getAllUser();
	request.setAttribute("baoUser", baoUser);
	includeManager.addJS("/modules/news/inc/fonction.js");
	includeManager.addCSS("/modules/news/inc/style.css");
	includeManager.setTitle(languageManager.getLanguageValue("news_creation_title", langTag));
	includeManager.addJSP("/modules/news/createNews.jsp");
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
			indexNewsParameter(request);
		}else 
			if(option.equals("create")){
				createNewsParameter(request);
			}else	
				createNewsParameter(request);


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
				includeManager.addCSS("/modules/news/inc/style.css");
				includeManager.addJS("/modules/news/inc/fonction.js");
				includeManager.setTitle(languageManager.getLanguageValue("news_home_page", langTag));
				includeManager.addJSP("/modules/authentication/login.jsp");
			}else
				if(option1.equals("formCreateNews")){
					createNewsForm(request);
				}else
					createNewsForm(request);//To remove
		}
		else{
			includeManager.addCSS("/modules/news/inc/style.css");
			includeManager.addJS("/modules/news/inc/fonction.js");
			includeManager.setTitle(languageManager.getLanguageValue("news_home_page", langTag));
			includeManager.addJSP("/modules/authentication/login.jsp");
		}
	}
	returnRequest(request, response);

	//		}
	//		else{
	//			forward403(request, response);
	//		}
}

private void createNewsForm(HttpServletRequest request){
	String news_title=request.getParameter("news_title");
	String news_key=request.getParameter("news_key");
	String news_language=request.getParameter("news_language");
	String news_keyword=request.getParameter("news_keyword");
	short news_state=new Short(request.getParameter("news_state"));
	String news_content=request.getParameter("news_content");
	int news_user=new Integer(request.getParameter("news_user"));////
	boolean news_is_traduction=request.getParameter("news_is_traduction")!=null;

	GregorianCalendar calendar = new java.util.GregorianCalendar();
	String dateOfDay="";
	dateOfDay+=calendar.get(Calendar.YEAR);
	if(calendar.get(Calendar.MONTH)<10) dateOfDay+="0";
	dateOfDay+=calendar.get(Calendar.MONTH)+1;
	if(calendar.get(Calendar.DAY_OF_MONTH)<10) dateOfDay+="0";
	dateOfDay+=calendar.get(Calendar.DAY_OF_MONTH);

	Date d=calendar.getTime();
	BaoNews baoNews=new BaoNews(22,news_title,news_key,news_language, news_is_traduction, news_content, d,news_state);
	baoNews.setNewsKeywords(news_keyword);
	BaoUser b=new BaoUser();
	b.setUserId(news_user);
	baoNews.setUserId(b);
	try{
		ROPCrudDao.saveOrUpdate(baoNews);
		request.setAttribute("succesMessage", languageManager.getLanguageValue("news_creation_succes_message", langTag));
	}
	catch(ROPDaoException re){
		request.setAttribute("succesMessage", languageManager.getLanguageValue("news_creation_error_message", langTag));
		re.printStackTrace();
	}
	ArrayList<BaoUser> baoUser=RopNewsDao.getAllUser();
	request.setAttribute("baoUser", baoUser);
	includeManager.setTitle(languageManager.getLanguageValue("news_creation_title", langTag));
	includeManager.addJSP("/modules/news/createNews.jsp");
}
private void listOfNewsParameter(HttpServletRequest request){
	ArrayList<BaoNews> baoNews=RopNewsDao.getAllNews();
	request.setAttribute("baoNews", baoNews);
	includeManager.addJS("/admin/modules/journal/inc/fonction.js");
	includeManager.addCSS("/admin/modules/journal/inc/style.css");
	includeManager.setTitle(languageManager.getLanguageValue("journal_list_of_journal_title", langTag));
	includeManager.addJSP("/modules/news/listOfNews.jsp");
}

public void newsMenu(){
	int id=includeManager.createSideMenu("NEWS");
	try {
		includeManager.addMenuItem(id, languageManager.getLanguageValue("news_create_news", langTag),"/?m="+encryptor.encrypt("news")+"&ob="+encryptor.encrypt("create"));
		includeManager.addMenuItem(id, languageManager.getLanguageValue("news_list", langTag),"/?m="+encryptor.encrypt("news")+"&ob="+encryptor.encrypt("list"));
		//includeManager.addMenuSubItem(id, id2, "Test 2", "#");
	} catch (ROPCryptographyException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
