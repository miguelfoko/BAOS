package rop.miu.modules.authentication;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import rop.miu.ConfigManager;
import rop.miu.beans.BaoAdditionalInfo;
import rop.miu.beans.BaoEmailAccount;
import rop.miu.beans.BaoEmailTemplate;
import rop.miu.beans.BaoUser;
import rop.miu.dao.ROPCrudDao;
import rop.miu.dao.ROPUserDao;
import rop.miu.modules.ServletModel;
import rop.miu.util.GuiStatus;
import rop.miu.util.ROPConstants;
import rop.miu.util.exceptions.ROPCryptographyException;
import rop.miu.util.exceptions.ROPDaoException;
import rop.miu.util.io.MIUIOUtilMethod;
import rop.miu.util.io.MIUMultipartFormParser;
import rop.miu.util.io.Upload;
import rop.miu.util.io.UploadCondition;
import rop.miu.util.mail.Mail;
import rop.miu.util.mail.MailSender;
import rop.miu.util.mail.SMTPBundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ModAuthentication extends ServletModel {
	private static final long serialVersionUID = 1L;
       
    public ModAuthentication() {
        super();
    }
    
    private void setIncludesForProfile(HttpServletRequest request, int activeTab) throws ServletException, IOException {
    	if(activeTab == 1)
    		includeManager.setTitle(languageManager.getLanguageValue("profile_title", langTag));
    	if(activeTab == 2)
    		includeManager.setTitle(languageManager.getLanguageValue("edit_profile", langTag));
    	if(activeTab == 3)
    		includeManager.setTitle(languageManager.getLanguageValue("auth_notification", langTag));
    	if(activeTab == 4)
    		includeManager.setTitle(languageManager.getLanguageValue("auth_research_summary", langTag));
    	if(activeTab == 5)
    		includeManager.setTitle(languageManager.getLanguageValue("auth_courses_summary", langTag));
		includeManager.addJSP("/modules/authentication/profile.jsp");
		request.setAttribute("mod_auth_active_tab", activeTab);
		includeManager.addJS("/modules/authentication/js/profile.js");
		includeManager.addJS("/modules/authentication/js/profile-check.js");
		includeManager.addCSS("/modules/authentication/css/style.css");
		setAuthenticationMenu();
    }
    
    private void setIncludeForLogin(HttpServletRequest request) throws ServletException, IOException {
    	includeManager.setTitle(languageManager.getLanguageValue("login_title", langTag));
		includeManager.addJSP("/modules/authentication/login.jsp");
		includeManager.addCSS("/modules/authentication/css/style.css");
		setAuthenticationLogoutMenu();
    }
    
    private void setIncludeForRegister(HttpServletRequest request) throws ServletException, IOException {
    	includeManager.setTitle(languageManager.getLanguageValue("register_title", langTag));
		includeManager.addJSP("/modules/authentication/register.jsp");
		includeManager.addJS("/modules/authentication/js/register.js");
		includeManager.addCSS("/modules/authentication/css/style.css");
		setAuthenticationLogoutMenu();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		String option = null;
		try{
			String parOpt = request.getParameter("o");
			if(parOpt != null)
				option = encryptor.decrypt(parOpt);
		}catch(Exception e){
			forward500(request, response);
		}
		
		if(option == null || option.equals("login") || request.getAttribute("auth_redirect") != null){
			if(isConnected())
				setIncludesForProfile(request, 1);
			else
				setIncludeForLogin(request);
			returnRequest(request, response);
			return;
		}
		
		if(option.equals("logout")){
			if(isConnected()){
				baoUser = null;
				request.getSession().setAttribute("baoUser", baoUser);
				Cookie cook = new Cookie(ROPConstants.COOKIE_SESSION_ID_LABEL, "");
				cook.setPath("/");
				cook.setMaxAge(0);
				response.addCookie(cook);
			}
			setIncludeForLogin(request);
			returnRequest(request, response);
			return;
		}
		
		if(option.equals("reset_password")){
			
			return;
		}
		
		if(option.equals("register")){
			if(isConnected()){
				baoUser = null;
				request.getSession().setAttribute("baoUser", baoUser);
				Cookie cook = new Cookie(ROPConstants.COOKIE_SESSION_ID_LABEL, "");
				cook.setPath("/");
				cook.setMaxAge(0);
				response.addCookie(cook);
			}
			setIncludeForRegister(request);
			returnRequest(request, response);
			return;
		}
		
		if(option.equals("check")){
			String email = request.getParameter("email");
			String echeck = request.getParameter("echeck");
			if(email != null){
				if(ROPUserDao.isEmailUsed(email) && (echeck == null || !email.equalsIgnoreCase(baoUser.getUserEmail())))
					request.setAttribute("checkEmail", languageManager.getLanguageValue("email_used", langTag));
			}
			String login = request.getParameter("login");
			if(login != null){
				if(ROPUserDao.isLoginUsed(login) && (echeck == null || !login.equals(baoUser.getUserLogin())))
					request.setAttribute("checkLogin", languageManager.getLanguageValue("login_used", langTag));
			}
			String pass = request.getParameter("pass");
			if(pass != null){
				if(!ROPUserDao.validatePassword(pass))
					request.setAttribute("checkPass", languageManager.getLanguageValue("wrong_pass", langTag));
			}
			request.getServletContext().getRequestDispatcher("/modules/authentication/ajax.jsp").forward(request, response);
			return;
		}
		
		if(option.matches("validate-[0-9]{1,}")){
			int userId = Integer.parseInt(option.split("-")[1]);
			try {
				ROPUserDao.activateUser(userId);
				includeManager.createSuccessStatus(languageManager.getLanguageValue("email_confirmed", langTag));
			}catch (ROPDaoException e) {
				includeManager.createErrorStatus(languageManager.getLanguageValue("email_confirmError", langTag));
			}finally{
				if(isConnected())
					setIncludesForProfile(request, 1);
				else
					setIncludeForLogin(request);
				returnRequest(request, response);
			}
			return;
		}
		
		if(option.equals("profile")){
			setIncludesForProfile(request, 1);
			returnRequest(request, response);
			return;
		}
		
		if(option.equals("edit-profile")){
			setIncludesForProfile(request, 2);
			returnRequest(request, response);
			return;
		}
		
		if(option.startsWith("notification")){
			if(option.endsWith("ajax")){
				request.getServletContext().getRequestDispatcher("/modules/authentication/notification.jsp").forward(request, response);
				return;
			}
			setIncludesForProfile(request, 3);
			returnRequest(request, response);
			return;
		}
		
		if(option.startsWith("research")){
			if(option.endsWith("ajax")){
				request.getServletContext().getRequestDispatcher("/modules/authentication/research.jsp").forward(request, response);
				return;
			}
			setIncludesForProfile(request, 4);
			returnRequest(request, response);
			return;
		}
		
		if(option.startsWith("courses")){
			if(option.endsWith("ajax")){
				request.getServletContext().getRequestDispatcher("/modules/authentication/courses.jsp").forward(request, response);
				return;
			}
			setIncludesForProfile(request, 5);
			returnRequest(request, response);
			return;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		String option = null;
		try{
			String parOpt = request.getParameter("o");
			if(parOpt != null)
				option = encryptor.decrypt(parOpt);
		}catch(Exception e){
			forward500(request, response);
			return;
		}
		
		if(option == null || option.equals("login") || request.getAttribute("auth_redirect") != null){
			String login = request.getParameter("login");
			if(login == null){
				if(isConnected())
					setIncludesForProfile(request, 1);
				else
					setIncludeForLogin(request);
				returnRequest(request, response);
				return;
			}
			String pass = request.getParameter("pass");
			try{
				if(pass != null)
					pass = encryptor.encrypt(encryptor.encrypt(pass));
			}catch(Exception e){
				
			}
			String stayLogged = request.getParameter("stayLogged");
			String redirect = request.getParameter("auth_redirect");
			BaoUser user = null;
			if(login.contains("@")){
				user = ROPUserDao.getValidUserByEmailAndPassword(login, pass);
				if(user == null)
					user = ROPUserDao.getValidUserByLoginAndPassword(login, pass);
			}else
				user = ROPUserDao.getValidUserByLoginAndPassword(login, pass);
			if(user != null){
				request.getSession().setAttribute("baoUser", user);
				if(stayLogged != null){
					try{
						Cookie cookie = new Cookie(ROPConstants.COOKIE_SESSION_ID_LABEL, encryptor.encrypt(user.getUserId()+""));
						cookie.setPath("/");
						cookie.setMaxAge(2 * 7 * 24 * 60 * 60);
						response.addCookie(cookie);
					}catch(Exception e){
						
					}
				}
				includeManager.createSuccessStatus(languageManager.getLanguageValue("login_success", langTag));
				if(redirect != null){
					try{
						if(redirect != null)
							redirect = encryptor.decrypt(redirect);
						forwardToModule(request, response, redirect);
						return;
					}catch(Exception e){
						setIncludesForProfile(request, 1);
						returnRequest(request, response);
						return;
					}
				}
				setIncludesForProfile(request, 1);
				returnRequest(request, response);
				return;
			}
			request.setAttribute("loginError", languageManager.getLanguageValue("login_error", langTag));
			setIncludeForLogin(request);
			returnRequest(request, response);
			return;
		}
		if(option.equals("register")){
			try{
				String name = request.getParameter("name");
				boolean error = false;
				if(name != null && !name.trim().isEmpty()){
					String[] tab = name.trim().split(" ");
					name = ConfigManager.setFirstUppercaseAndRestLowercase(tab[0]);
					for(int i = 1; i < tab.length; i++)
						name += " "+ConfigManager.setFirstUppercaseAndRestLowercase(tab[i]);
				}else{
					request.setAttribute("registerNameError", languageManager.getLanguageValue("register_name_error", langTag));
					error = true;
				}
				String surname = request.getParameter("surname");
				if(surname != null){
					String[] tab = surname.trim().split(" ");
					surname = ConfigManager.setFirstUppercaseAndRestLowercase(tab[0]);
					for(int i = 1; i < tab.length; i++)
						surname += " "+ConfigManager.setFirstUppercaseAndRestLowercase(tab[i]);
				}
				String email = request.getParameter("email");
				String login = request.getParameter("login");
				String pass = request.getParameter("pass");
				String confirmPass = request.getParameter("confirmPass");
				if(!ROPUserDao.validatePassword(pass)){
					request.setAttribute("registerPassError", languageManager.getLanguageValue("wrong_pass", langTag));
					error = true;
				}
				if(pass != null && confirmPass != null && !pass.equals(confirmPass)){
					request.setAttribute("registerConfirmPassError", languageManager.getLanguageValue("auth_wrong_confirm_pass", langTag));
					error = true;
				}
				if(ROPUserDao.isLoginUsed(login)){
					request.setAttribute("registerLoginError", languageManager.getLanguageValue("login_used", langTag));
					error = true;
				}
				if(ROPUserDao.isEmailUsed(login)){
					request.setAttribute("registerEmailError", languageManager.getLanguageValue("email_used", langTag));
					error = true;
				}
				if(error)
					throw new Exception("");
				BaoUser user = new BaoUser();
				user.setUserName(name);
				user.setUserSurname(surname);
				user.setUserEmail(email);
				user.setUserLogin(login);
				user.setUserPassword(encryptor.encrypt(encryptor.encrypt(pass)));
				user.setUserAccountState(ROPConstants.STATE_WAITING_VALIDATION);
				BaoAdditionalInfo info = new BaoAdditionalInfo();
				info.setUserRegistrationDate(DateTime.now().toDate());
				info = ROPUserDao.saveAdditionalInfo(info);
				user.setAdditionalInfoId(info);
				ROPUserDao.saveNewUser(user);
				ROPCrudDao.refresh(user);
				ROPUserDao.assignGroupToUser(ROPConstants.DEFAULT_USER_GROUP, user);
				sendConfirmEmail(user, request);
				
				request.getSession().setAttribute("baoUser", user);
				includeManager.createSuccessStatus(languageManager.getLanguageValue("register_success", langTag));
				setIncludesForProfile(request, 1);
				returnRequest(request, response);
				return;
			}catch(Exception e){
				//e.printStackTrace();
				request.setAttribute("registerError", languageManager.getLanguageValue("register_error", langTag));
				setIncludeForRegister(request);
				returnRequest(request, response);
				return;
			}
		}
		if(option.equals("edit-profile")){
			try{
				MIUMultipartFormParser parser = new MIUMultipartFormParser(request);
				String name = parser.getString("name");
				if(name != null){
					String[] tab = name.trim().split(" ");
					name = ConfigManager.setFirstUppercaseAndRestLowercase(tab[0]);
					for(int i = 1; i < tab.length; i++)
						name += " "+ConfigManager.setFirstUppercaseAndRestLowercase(tab[i]);
				}
				String surname = parser.getString("surname");
				if(surname != null){
					String[] tab = surname.trim().split(" ");
					surname = ConfigManager.setFirstUppercaseAndRestLowercase(tab[0]);
					for(int i = 1; i < tab.length; i++)
						surname += " "+ConfigManager.setFirstUppercaseAndRestLowercase(tab[i]);
				}
				String email = parser.getString("email");
				String login = parser.getString("login");
				String pass = parser.getString("pass");
				String prevpass = parser.getString("prevpass");
				String biography = parser.getString("biography");
				String lastEmail = baoUser.getUserEmail();
				String defaultLang = parser.getString("defaultLang");
				if(defaultLang == null || defaultLang.equals("auth_defaultLang"))
					defaultLang = configManager.getLangNames().get(0);
				String currentWork = parser.getString("currentWork");
				String currentInstitution = parser.getString("currentInstitution");
				String phoneNumber = parser.getStringMatching("phoneNumber", "([+]{0,1}[0-9]{9,}){0,1}");
			
				if(prevpass != null && !prevpass.isEmpty() && (!ROPUserDao.validatePassword(pass) || !baoUser.getUserPassword().equals(encryptor.encrypt(encryptor.encrypt(prevpass))))){
					
				}else{
					boolean passChanged = false, loginChanged = false, emailChanged = false;
					if(pass != null && !pass.trim().isEmpty())
						passChanged = true;
					if(login != null && !login.equals(baoUser.getUserLogin()))
						loginChanged = true;
					if(email != null && !email.equals(baoUser.getUserEmail()))
						emailChanged = true;
					
					BaoUser user = new BaoUser();
					user.setUserAccountState(baoUser.getUserAccountState());
					user.setAdditionalInfoId(baoUser.getAdditionalInfoId());
					user.setUserBiography(baoUser.getUserBiography());
					user.setUserBirthday(baoUser.getUserBirthday());
					user.setUserEmail(baoUser.getUserEmail());
					user.setUserId(baoUser.getUserId());
					user.setUserLogin(baoUser.getUserLogin());
					user.setUserName(baoUser.getUserName());
					user.setUserPassword(baoUser.getUserPassword());
					user.setUserSurname(baoUser.getUserSurname());
					
					user.setUserName(name);
					user.setUserSurname(surname);
					if(emailChanged)
						user.setUserEmail(email);
					user.setUserBiography(biography);
					if(loginChanged)
						user.setUserLogin(login);
					if(passChanged)
						user.setUserPassword(encryptor.encrypt(encryptor.encrypt(pass)));
					if(emailChanged || loginChanged || passChanged)
						user.setUserAccountState(ROPConstants.STATE_WAITING_VALIDATION);
					user.getAdditionalInfoId().setUserDefaultLanguage(defaultLang);
					user.getAdditionalInfoId().setUserCurrentWork(currentWork);
					user.getAdditionalInfoId().setUserCurrentInstitution(currentInstitution);
					user.getAdditionalInfoId().setUserPhoneNumber(phoneNumber);
					
					if(!parser.getString("avatarFile").trim().isEmpty()){
						UploadCondition condition = new UploadCondition(configManager);
						condition.addExtension("png", "PNG", "jpg", "JPG", "jpeg", "JPEG");
						condition.setMaxFileSize(1536 * 1024);
						URL url = new MIUIOUtilMethod().getFolderURL(ROPConstants.AVATARS_FOLDER);
						try{
							Upload upload = parser.uploadFileTo("avatarFile", url.getPath().replace("%20", " "), condition);
							if(upload != null){
								String extension = "." + ((upload.getUploadedFile().getName().split("[.]"))[1]);
								String namePrefix = user.getUserLogin()+ "-" +DateTime.now().getMillis();
								MIUIOUtilMethod.rename(upload.getUploadedFile(), namePrefix);
								namePrefix += extension;
								user.getAdditionalInfoId().setUserAvatarType("classic");
								user.getAdditionalInfoId().setUserAvatar(namePrefix);
							}else
								throw new Exception("");
						}catch(Exception e){
							request.setAttribute("avatarFileError", languageManager.getLanguageValue("auth_avatar_file_error", langTag));
							throw new Exception("");
						}
					}else
						user.getAdditionalInfoId().setUserAvatarType("gravatar");
					
					user.setAdditionalInfoId(ROPUserDao.saveAdditionalInfo(user.getAdditionalInfoId()));
					user = ROPUserDao.saveUser(user);
					if(emailChanged || loginChanged || passChanged)
						sendConfirmChangesEmail(user, request);
					if(emailChanged)
						sendEditConfirmEmail(user, lastEmail, request);
					baoUser = user;
					
					request.getSession().setAttribute("baoUser", user);
					includeManager.createSuccessStatus(languageManager.getLanguageValue("edit_profile_success", langTag));
					setIncludesForProfile(request, 1);
					returnRequest(request, response);
					return;
				}
			}catch(Exception e){
				//e.printStackTrace();
				request.setAttribute("editProfileError", languageManager.getLanguageValue("edit_profile_error", langTag));
				setIncludesForProfile(request, 2);
				returnRequest(request, response);
				return;
			}
		}
	}

	private void sendConfirmEmail(BaoUser user, HttpServletRequest request) {
		ArrayList<BaoEmailAccount> accounts = ROPUserDao.getValidEmailAccounts(user);
		
		final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        
        BaoEmailTemplate template = ROPUserDao.getEmailTemplateByName("default_template");
        String content = "";
        if(template != null && template.getEmailTemplateState() == ROPConstants.STATE_ACTIVATED){
        	content = template.getEmailTemplateContent();
        	String contextBaseUrl = request.getRequestURL().toString().split(request.getContextPath())[0]+request.getContextPath();
        	content = ROPConstants.setParam("logo", contextBaseUrl+"/ressources/images/logo-baos.png", content);
        	content = ROPConstants.setParam("title", languageManager.getLanguageValue("register_confirm_title", langTag), content);
        	content = ROPConstants.setParam("subtitle", languageManager.getLanguageValue("register_confirm_subtitle", langTag), content);
        	String mc = languageManager.getLanguageValue("register_confirm_content", langTag);
        	mc = ROPConstants.setParam("login", user.getUserLogin(), mc);
        	mc = ROPConstants.setParam("password", languageManager.getLanguageValue("pass_you_specified", langTag), mc);
        	try{
        		mc = ROPConstants.setParam("confirm_url", contextBaseUrl+"/?m="+encryptor.encrypt("authentication")+"o="+encryptor.encrypt("validate-"+user.getUserId()), mc);
        	}catch(Exception ex){
        		
        	}
        	content = ROPConstants.setParam("main_content", mc, content);
        	content = ROPConstants.setParam("content_blocks", "", content);
        }else{
        	
        }
		Mail mail = new Mail();
		mail.addToReceiver(user.getUserEmail());
		mail.setContent(content);
		mail.setSubject(user.getUserLogin()+" : "+languageManager.getLanguageValue("register_confirm_subtitle", langTag));
		
		for(BaoEmailAccount acc : accounts){
			SMTPBundle smtpBundle = gson.fromJson(acc.getEmailAccountDesc(), SMTPBundle.class);
			try{
				smtpBundle.setPassword(encryptor.decrypt(smtpBundle.getPassword()));
				MailSender.sendMail(mail, MailSender.smtpBundleToProperties(smtpBundle));
				break;
			}catch(Exception ex){
				
			}
		}
	}
	
	private void sendConfirmChangesEmail(BaoUser user, HttpServletRequest request) {
		ArrayList<BaoEmailAccount> accounts = ROPUserDao.getValidEmailAccounts(user);
		
		final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        
        BaoEmailTemplate template = ROPUserDao.getEmailTemplateByName("default_template");
        String content = "";
        if(template != null && template.getEmailTemplateState() == ROPConstants.STATE_ACTIVATED){
        	content = template.getEmailTemplateContent();
        	String contextBaseUrl = request.getRequestURL().toString().split(request.getContextPath())[0]+request.getContextPath();
        	content = ROPConstants.setParam("logo", contextBaseUrl+"/ressources/images/logo-baos.png", content);
        	content = ROPConstants.setParam("title", languageManager.getLanguageValue("register_confirm_title", langTag), content);
        	content = ROPConstants.setParam("subtitle", languageManager.getLanguageValue("register_confirm_subtitle", langTag), content);
        	String mc = languageManager.getLanguageValue("register_confirm_content", langTag);
        	mc = ROPConstants.setParam("login", user.getUserLogin(), mc);
        	mc = ROPConstants.setParam("password", languageManager.getLanguageValue("pass_you_specified", langTag), mc);
        	try{
        		mc = ROPConstants.setParam("confirm_url", contextBaseUrl+"/?m="+encryptor.encrypt("authentication")+"o="+encryptor.encrypt("validate-"+user.getUserId()), mc);
        	}catch(Exception ex){
        		
        	}
        	content = ROPConstants.setParam("main_content", mc, content);
        	content = ROPConstants.setParam("content_blocks", "", content);
        }else{
        	
        }
		Mail mail = new Mail();
		mail.addToReceiver(user.getUserEmail());
		mail.setContent(content);
		mail.setSubject(user.getUserLogin()+" : "+languageManager.getLanguageValue("register_confirm_subtitle", langTag));
		
		for(BaoEmailAccount acc : accounts){
			SMTPBundle smtpBundle = gson.fromJson(acc.getEmailAccountDesc(), SMTPBundle.class);
			try{
				smtpBundle.setPassword(encryptor.decrypt(smtpBundle.getPassword()));
				MailSender.sendMail(mail, MailSender.smtpBundleToProperties(smtpBundle));
				break;
			}catch(Exception ex){
				
			}
		}
	}
	
	private void sendEditConfirmEmail(BaoUser user, String lastEmail, HttpServletRequest request) {
		ArrayList<BaoEmailAccount> accounts = ROPUserDao.getValidEmailAccounts(user);
		
		final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        
        BaoEmailTemplate template = ROPUserDao.getEmailTemplateByName("default_template");
        String content = "";
        if(template != null && template.getEmailTemplateState() == ROPConstants.STATE_ACTIVATED){
        	content = template.getEmailTemplateContent();
        	String contextBaseUrl = request.getRequestURL().toString().split(request.getContextPath())[0]+request.getContextPath();
        	content = ROPConstants.setParam("logo", contextBaseUrl+"/ressources/images/logo-baos.png", content);
        	content = ROPConstants.setParam("title", languageManager.getLanguageValue("register_confirm_title", langTag), content);
        	content = ROPConstants.setParam("subtitle", languageManager.getLanguageValue("register_confirm_subtitle", langTag), content);
        	String mc = languageManager.getLanguageValue("register_confirm_content", langTag);
        	mc = ROPConstants.setParam("login", user.getUserLogin(), mc);
        	mc = ROPConstants.setParam("password", languageManager.getLanguageValue("pass_you_specified", langTag), mc);
        	try{
        		mc = ROPConstants.setParam("confirm_url", contextBaseUrl+"/?m="+encryptor.encrypt("authentication")+"o="+encryptor.encrypt("validate-"+user.getUserId()), mc);
        	}catch(Exception ex){
        		
        	}
        	content = ROPConstants.setParam("main_content", mc, content);
        	content = ROPConstants.setParam("content_blocks", "", content);
        }else{
        	
        }
		Mail mail = new Mail();
		mail.addToReceiver(lastEmail);
		mail.setContent(content);
		mail.setSubject(user.getUserLogin()+" : "+languageManager.getLanguageValue("register_confirm_subtitle", langTag));
		
		for(BaoEmailAccount acc : accounts){
			SMTPBundle smtpBundle = gson.fromJson(acc.getEmailAccountDesc(), SMTPBundle.class);
			try{
				smtpBundle.setPassword(encryptor.decrypt(smtpBundle.getPassword()));
				MailSender.sendMail(mail, MailSender.smtpBundleToProperties(smtpBundle));
				break;
			}catch(Exception ex){
				
			}
		}
	}
	
	public void setAuthenticationMenu(){
		try {
			String firstLinkPart = "/?m=" + encryptor.encrypt("authentication");
			int id = includeManager.createSideMenu(languageManager.getLanguageValue("auth_user_menu", langTag), "user");
			includeManager.addMenuItem(id, languageManager.getLanguageValue("profile_title", langTag), firstLinkPart + "&o=" + encryptor.encrypt("profile"), "user");
			includeManager.addMenuItem(id, languageManager.getLanguageValue("edit_profile", langTag), firstLinkPart + "&o=" + encryptor.encrypt("edit-profile"), "edit");
			includeManager.addMenuItem(id, languageManager.getLanguageValue("auth_notification", langTag), firstLinkPart + "&o=" + encryptor.encrypt("notification"), "bell");
			includeManager.addMenuItem(id, languageManager.getLanguageValue("auth_research_summary", langTag), firstLinkPart + "&o=" + encryptor.encrypt("research"), "book");
			includeManager.addMenuItem(id, languageManager.getLanguageValue("auth_courses_summary", langTag), firstLinkPart + "&o=" + encryptor.encrypt("courses"), "education");
			includeManager.addMenuItem(id, languageManager.getLanguageValue("logout_title", langTag), firstLinkPart + "&o=" + encryptor.encrypt("logout"), "log-out");
		} catch (ROPCryptographyException e) {
			
		}
	}
	
	public void setAuthenticationLogoutMenu(){
		try {
			String firstLinkPart = "/?m=" + encryptor.encrypt("authentication");
			int id = includeManager.createSideMenu(languageManager.getLanguageValue("auth_user_menu", langTag));
			includeManager.addMenuItem(id, languageManager.getLanguageValue("auth_login_menu_title", langTag), firstLinkPart + "&o=" + encryptor.encrypt("login"), "log-in");
			includeManager.addMenuItem(id, languageManager.getLanguageValue("auth_register_menu_title", langTag), firstLinkPart + "&o=" + encryptor.encrypt("register"), "plus-sign");
			includeManager.addMenuItem(id, languageManager.getLanguageValue("auth_reset_pwd_menu_title", langTag), firstLinkPart + "&o=" + encryptor.encrypt("reset_password"), "refresh");
			
			/*int pid = includeManager.createLeftSidePanel(languageManager.getLanguageValue("auth_login_menu_title", langTag), "log-in");
			includeManager.addLeftSidePanelContent(pid, "/modules/authentication/login.jsp", true);
			
			pid = includeManager.createRightSidePanel(languageManager.getLanguageValue("auth_register_menu_title", langTag), "plus-sign");
			includeManager.addRightSidePanelContent(pid, "/modules/authentication/register.jsp", true);
			
			includeManager.addJS("/modules/authentication/js/register.js");
			
			int sid = includeManager.createDangerStatus("Un vrai statut par défaut avec deux actions");
			includeManager.addStatusAction(sid, GuiStatus.DEFAULT, GuiStatus.STANDARD_LINK, "index.jsp", "Accueil");
			includeManager.addStatusDefaultAction(sid, GuiStatus.JAVASCRIPT_FUNCTION, "pgb_close_status_bar()", "Fermer");
			includeManager.createDefaultStatus("Un vrai statut par défaut avec deux actions");*/
		} catch (ROPCryptographyException e) {
			
		}
	}
}
