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
<<<<<<< HEAD
=======
import rop.miu.beans.BaoNotification;
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
import rop.miu.beans.BaoUser;
import rop.miu.dao.ROPCrudDao;
import rop.miu.dao.ROPUserDao;
import rop.miu.modules.ServletModel;
<<<<<<< HEAD
import rop.miu.util.GuiStatus;
=======
import rop.miu.util.IncludeManager;
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
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
<<<<<<< HEAD
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
=======
    	IncludeManager inclManager = getIncludeManager(request);
    	if(activeTab == 1)
    		inclManager.setTitle(request, languageManager.getLanguageValue("profile_title", getLangTag(request)));
    	if(activeTab == 2)
    		inclManager.setTitle(request, languageManager.getLanguageValue("edit_profile", getLangTag(request)));
    	if(activeTab == 3)
    		inclManager.setTitle(request, languageManager.getLanguageValue("auth_notification", getLangTag(request)));
    	if(activeTab == 4)
    		inclManager.setTitle(request, languageManager.getLanguageValue("auth_research_summary", getLangTag(request)));
    	if(activeTab == 5)
    		inclManager.setTitle(request, languageManager.getLanguageValue("auth_courses_summary", getLangTag(request)));
		inclManager.addJSP(request, "/modules/authentication/profile.jsp");
		request.setAttribute("mod_auth_active_tab", activeTab);
		inclManager.addJS(request, "/ressources/cropit/jquery.cropit.js");
		inclManager.addJS(request, "/modules/authentication/js/profile.js");
		inclManager.addJS(request, "/modules/authentication/js/profile-check.js");
		inclManager.addCSS(request, "/modules/authentication/css/style.css");
		setAuthenticationMenu(request);
    }
    
    private void setIncludeForLogin(HttpServletRequest request) throws ServletException, IOException {
    	IncludeManager inclManager = getIncludeManager(request);
    	inclManager.setTitle(request, languageManager.getLanguageValue("login_title", getLangTag(request)));
		inclManager.addJSP(request, "/modules/authentication/login.jsp");
		inclManager.addCSS(request, "/modules/authentication/css/style.css");
		setAuthenticationLogoutMenu(request);
    }
    
    private void setIncludeForResetPassword(HttpServletRequest request) throws ServletException, IOException {
    	IncludeManager inclManager = getIncludeManager(request);
    	inclManager.setTitle(request, languageManager.getLanguageValue("auth_reset_password_title", getLangTag(request)));
		inclManager.addJSP(request, "/modules/authentication/reset_pwd.jsp");
		inclManager.addCSS(request, "/modules/authentication/css/style.css");
		setAuthenticationLogoutMenu(request);
    }
    
    private void setIncludeForRegister(HttpServletRequest request) throws ServletException, IOException {
    	IncludeManager inclManager = getIncludeManager(request);
    	inclManager.setTitle(request, languageManager.getLanguageValue("register_title", getLangTag(request)));
		inclManager.addJSP(request, "/modules/authentication/register.jsp");
		inclManager.addJS(request, "/modules/authentication/js/register.js");
		inclManager.addCSS(request, "/modules/authentication/css/style.css");
		setAuthenticationLogoutMenu(request);
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);
		IncludeManager inclManager = getIncludeManager(request);
		String option = null;
		try{
			String parOpt = request.getParameter("o");
			if(parOpt != null)
				option = encryptor.decrypt(parOpt);
		}catch(Exception e){
			forward500(request, response);
		}
		
		if(option == null || option.equals("login") || request.getAttribute("auth_redirect") != null){
<<<<<<< HEAD
			if(isConnected())
=======
			if(isConnected(request))
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
				setIncludesForProfile(request, 1);
			else
				setIncludeForLogin(request);
			returnRequest(request, response);
			return;
		}
		
		if(option.equals("logout")){
<<<<<<< HEAD
			if(isConnected()){
				baoUser = null;
				request.getSession().setAttribute("baoUser", baoUser);
=======
			if(isConnected(request)){
				setBaoUser(request, null);
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
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
<<<<<<< HEAD
			
=======
			setIncludeForResetPassword(request);
			returnRequest(request, response);
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
			return;
		}
		
		if(option.equals("register")){
<<<<<<< HEAD
			if(isConnected()){
				baoUser = null;
				request.getSession().setAttribute("baoUser", baoUser);
=======
			if(isConnected(request)){
				setBaoUser(request, null);
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
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
<<<<<<< HEAD
					request.setAttribute("checkEmail", languageManager.getLanguageValue("email_used", langTag));
=======
					request.setAttribute("checkEmail", languageManager.getLanguageValue("email_used", getLangTag(request)));
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
			}
			String login = request.getParameter("login");
			if(login != null){
				if(ROPUserDao.isLoginUsed(login) && (echeck == null || !login.equals(baoUser.getUserLogin())))
<<<<<<< HEAD
					request.setAttribute("checkLogin", languageManager.getLanguageValue("login_used", langTag));
=======
					request.setAttribute("checkLogin", languageManager.getLanguageValue("login_used", getLangTag(request)));
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
			}
			String pass = request.getParameter("pass");
			if(pass != null){
				if(!ROPUserDao.validatePassword(pass))
<<<<<<< HEAD
					request.setAttribute("checkPass", languageManager.getLanguageValue("wrong_pass", langTag));
=======
					request.setAttribute("checkPass", languageManager.getLanguageValue("wrong_pass", getLangTag(request)));
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
			}
			request.getServletContext().getRequestDispatcher("/modules/authentication/ajax.jsp").forward(request, response);
			return;
		}
		
<<<<<<< HEAD
=======
		if(option.equals("unread-notifications")){
			int unreadNotificationNum = 0;
			if(isConnected(request)){
				unreadNotificationNum = ROPUserDao.getUnreadNotificationNum(getBaoUser(request));
			}
			request.setAttribute("unreadNotificationNum", unreadNotificationNum);
			request.getServletContext().getRequestDispatcher("/modules/authentication/unread-notification.jsp").forward(request, response);
			return;
		}
		
		if(option.equals("read-notifications")){
			if(isConnected(request)){
				try {
					ROPUserDao.readNotifications(getBaoUser(request).getUserId());
				} catch (ROPDaoException e) {
				}
			}
			return;
		}
		
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		if(option.matches("validate-[0-9]{1,}")){
			int userId = Integer.parseInt(option.split("-")[1]);
			try {
				ROPUserDao.activateUser(userId);
<<<<<<< HEAD
				includeManager.createSuccessStatus(languageManager.getLanguageValue("email_confirmed", langTag));
			}catch (ROPDaoException e) {
				includeManager.createErrorStatus(languageManager.getLanguageValue("email_confirmError", langTag));
			}finally{
				if(isConnected())
=======
				inclManager.createSuccessStatus(request, languageManager.getLanguageValue("email_confirmed", getLangTag(request)));
			}catch (ROPDaoException e) {
				inclManager.createErrorStatus(request, languageManager.getLanguageValue("email_confirmError", getLangTag(request)));
			}finally{
				if(isConnected(request))
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
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
<<<<<<< HEAD
=======
			ArrayList<BaoNotification> list = ROPUserDao.getAllNotifications(getBaoUser(request));
			request.setAttribute("notificationList", list);
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
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
		IncludeManager inclManager = getIncludeManager(request);
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
<<<<<<< HEAD
				if(isConnected())
=======
				if(isConnected(request))
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
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
<<<<<<< HEAD
				includeManager.createSuccessStatus(languageManager.getLanguageValue("login_success", langTag));
=======
				inclManager.createSuccessStatus(request, languageManager.getLanguageValue("login_success", getLangTag(request)));
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
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
<<<<<<< HEAD
			request.setAttribute("loginError", languageManager.getLanguageValue("login_error", langTag));
=======
			request.setAttribute("loginError", languageManager.getLanguageValue("login_error", getLangTag(request)));
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
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
<<<<<<< HEAD
					request.setAttribute("registerNameError", languageManager.getLanguageValue("register_name_error", langTag));
=======
					request.setAttribute("registerNameError", languageManager.getLanguageValue("register_name_error", getLangTag(request)));
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
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
<<<<<<< HEAD
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
=======
					request.setAttribute("registerPassError", languageManager.getLanguageValue("wrong_pass", getLangTag(request)));
					error = true;
				}
				if(pass != null && confirmPass != null && !pass.equals(confirmPass)){
					request.setAttribute("registerConfirmPassError", languageManager.getLanguageValue("auth_wrong_confirm_pass", getLangTag(request)));
					error = true;
				}
				if(ROPUserDao.isLoginUsed(login)){
					request.setAttribute("registerLoginError", languageManager.getLanguageValue("login_used", getLangTag(request)));
					error = true;
				}
				if(ROPUserDao.isEmailUsed(login)){
					request.setAttribute("registerEmailError", languageManager.getLanguageValue("email_used", getLangTag(request)));
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
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
				
<<<<<<< HEAD
				request.getSession().setAttribute("baoUser", user);
				includeManager.createSuccessStatus(languageManager.getLanguageValue("register_success", langTag));
				setIncludesForProfile(request, 1);
=======
				//setBaoUser(request, user);
				inclManager.createSuccessStatus(request, languageManager.getLanguageValue("register_success", getLangTag(request)));
				//setIncludesForProfile(request, 1);
				setIncludeForLogin(request);
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
				returnRequest(request, response);
				return;
			}catch(Exception e){
				//e.printStackTrace();
<<<<<<< HEAD
				request.setAttribute("registerError", languageManager.getLanguageValue("register_error", langTag));
=======
				request.setAttribute("registerError", languageManager.getLanguageValue("register_error", getLangTag(request)));
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
				setIncludeForRegister(request);
				returnRequest(request, response);
				return;
			}
		}
		if(option.equals("edit-profile")){
			try{
				MIUMultipartFormParser parser = new MIUMultipartFormParser(request);
				String name = parser.getString("name");
<<<<<<< HEAD
				if(name != null){
=======
				boolean error = false;
				if(name != null && !name.trim().isEmpty()){
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
					String[] tab = name.trim().split(" ");
					name = ConfigManager.setFirstUppercaseAndRestLowercase(tab[0]);
					for(int i = 1; i < tab.length; i++)
						name += " "+ConfigManager.setFirstUppercaseAndRestLowercase(tab[i]);
<<<<<<< HEAD
=======
				}else{
					request.setAttribute("editProfileNameError", languageManager.getLanguageValue("register_name_error", getLangTag(request)));
					error = true;
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
				}
				String surname = parser.getString("surname");
				if(surname != null){
					String[] tab = surname.trim().split(" ");
					surname = ConfigManager.setFirstUppercaseAndRestLowercase(tab[0]);
					for(int i = 1; i < tab.length; i++)
						surname += " "+ConfigManager.setFirstUppercaseAndRestLowercase(tab[i]);
				}
<<<<<<< HEAD
=======
				BaoUser baoUser = getBaoUser(request);
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
				String email = parser.getString("email");
				String login = parser.getString("login");
				String pass = parser.getString("pass");
				String prevpass = parser.getString("prevpass");
<<<<<<< HEAD
=======
				String confirmPass = parser.getString("confirmPass");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
				String biography = parser.getString("biography");
				String lastEmail = baoUser.getUserEmail();
				String defaultLang = parser.getString("defaultLang");
				if(defaultLang == null || defaultLang.equals("auth_defaultLang"))
					defaultLang = configManager.getLangNames().get(0);
				String currentWork = parser.getString("currentWork");
				String currentInstitution = parser.getString("currentInstitution");
<<<<<<< HEAD
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
=======
				String phoneNumber = null;
				try{
					phoneNumber = parser.getStringMatching("phoneNumber", "([+]{0,1}[0-9]{9,}){0,1}");
				}catch(Exception ex){
					request.setAttribute("editProfilePhoneNumberError", languageManager.getLanguageValue("wrong_phone_number", getLangTag(request)));
					error = true;
				}
				if(pass != null && !pass.trim().isEmpty() && !ROPUserDao.validatePassword(pass)){
					request.setAttribute("editProfilePassError", languageManager.getLanguageValue("wrong_pass", getLangTag(request)));
					error = true;
				}
				if(pass != null && confirmPass != null && !pass.equals(confirmPass)){
					request.setAttribute("editProfileConfirmPassError", languageManager.getLanguageValue("auth_wrong_confirm_pass", getLangTag(request)));
					error = true;
				}
				if(!baoUser.getUserLogin().equals(login) && ROPUserDao.isLoginUsed(login)){
					request.setAttribute("editProfileLoginError", languageManager.getLanguageValue("login_used", getLangTag(request)));
					error = true;
				}
				if(!baoUser.getUserEmail().equals(email) && ROPUserDao.isEmailUsed(email)){
					request.setAttribute("editProfileEmailError", languageManager.getLanguageValue("email_used", getLangTag(request)));
					error = true;
				}
				if(prevpass != null && !prevpass.isEmpty() && (!ROPUserDao.validatePassword(pass) || !baoUser.getUserPassword().equals(encryptor.encrypt(encryptor.encrypt(prevpass))))){
					request.setAttribute("editProfilePrevpassError", languageManager.getLanguageValue("wrong_prevpass", getLangTag(request)));
					error = true;
				}
				
				if(error)
					throw new Exception("");
			
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
						request.setAttribute("editProfileAvatarFileError", languageManager.getLanguageValue("auth_avatar_file_error", getLangTag(request)));
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
				
				setBaoUser(request, user);
				inclManager.createSuccessStatus(request, languageManager.getLanguageValue("edit_profile_success", getLangTag(request)));
				setIncludesForProfile(request, 1);
				returnRequest(request, response);
				return;
			}catch(Exception e){
				//e.printStackTrace();
				request.setAttribute("editProfileError", languageManager.getLanguageValue("edit_profile_error", getLangTag(request)));
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
				setIncludesForProfile(request, 2);
				returnRequest(request, response);
				return;
			}
		}
	}

<<<<<<< HEAD
	private void sendConfirmEmail(BaoUser user, HttpServletRequest request) {
=======
	private void sendConfirmEmail(BaoUser user, HttpServletRequest request) throws ServletException, IOException {
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		ArrayList<BaoEmailAccount> accounts = ROPUserDao.getValidEmailAccounts(user);
		
		final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        
        BaoEmailTemplate template = ROPUserDao.getEmailTemplateByName("default_template");
        String content = "";
        if(template != null && template.getEmailTemplateState() == ROPConstants.STATE_ACTIVATED){
        	content = template.getEmailTemplateContent();
        	String contextBaseUrl = request.getRequestURL().toString().split(request.getContextPath())[0]+request.getContextPath();
        	content = ROPConstants.setParam("logo", contextBaseUrl+"/ressources/images/logo-baos.png", content);
<<<<<<< HEAD
        	content = ROPConstants.setParam("title", languageManager.getLanguageValue("register_confirm_title", langTag), content);
        	content = ROPConstants.setParam("subtitle", languageManager.getLanguageValue("register_confirm_subtitle", langTag), content);
        	String mc = languageManager.getLanguageValue("register_confirm_content", langTag);
        	mc = ROPConstants.setParam("login", user.getUserLogin(), mc);
        	mc = ROPConstants.setParam("password", languageManager.getLanguageValue("pass_you_specified", langTag), mc);
        	try{
        		mc = ROPConstants.setParam("confirm_url", contextBaseUrl+"/?m="+encryptor.encrypt("authentication")+"o="+encryptor.encrypt("validate-"+user.getUserId()), mc);
=======
        	content = ROPConstants.setParam("title", languageManager.getLanguageValue("register_confirm_title", getLangTag(request)), content);
        	content = ROPConstants.setParam("subtitle", languageManager.getLanguageValue("register_confirm_subtitle", getLangTag(request)), content);
        	String mc = languageManager.getLanguageValue("register_confirm_content", getLangTag(request));
        	mc = ROPConstants.setParam("login", user.getUserLogin(), mc);
        	mc = ROPConstants.setParam("password", languageManager.getLanguageValue("pass_you_specified", getLangTag(request)), mc);
        	try{
        		mc = ROPConstants.setParam("confirm_url", contextBaseUrl+"/index.jsp?m="+encryptor.encrypt("authentication")+"&o="+encryptor.encrypt("validate-"+user.getUserId()), mc);
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
        	}catch(Exception ex){
        		
        	}
        	content = ROPConstants.setParam("main_content", mc, content);
        	content = ROPConstants.setParam("content_blocks", "", content);
        }else{
        	
        }
		Mail mail = new Mail();
		mail.addToReceiver(user.getUserEmail());
		mail.setContent(content);
<<<<<<< HEAD
		mail.setSubject(user.getUserLogin()+" : "+languageManager.getLanguageValue("register_confirm_subtitle", langTag));
=======
		mail.setSubject(user.getUserLogin()+" : "+languageManager.getLanguageValue("register_confirm_subtitle", getLangTag(request)));
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		
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
	
<<<<<<< HEAD
	private void sendConfirmChangesEmail(BaoUser user, HttpServletRequest request) {
=======
	private void sendConfirmChangesEmail(BaoUser user, HttpServletRequest request) throws ServletException, IOException {
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		ArrayList<BaoEmailAccount> accounts = ROPUserDao.getValidEmailAccounts(user);
		
		final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        
        BaoEmailTemplate template = ROPUserDao.getEmailTemplateByName("default_template");
        String content = "";
        if(template != null && template.getEmailTemplateState() == ROPConstants.STATE_ACTIVATED){
        	content = template.getEmailTemplateContent();
        	String contextBaseUrl = request.getRequestURL().toString().split(request.getContextPath())[0]+request.getContextPath();
        	content = ROPConstants.setParam("logo", contextBaseUrl+"/ressources/images/logo-baos.png", content);
<<<<<<< HEAD
        	content = ROPConstants.setParam("title", languageManager.getLanguageValue("register_confirm_title", langTag), content);
        	content = ROPConstants.setParam("subtitle", languageManager.getLanguageValue("register_confirm_subtitle", langTag), content);
        	String mc = languageManager.getLanguageValue("register_confirm_content", langTag);
        	mc = ROPConstants.setParam("login", user.getUserLogin(), mc);
        	mc = ROPConstants.setParam("password", languageManager.getLanguageValue("pass_you_specified", langTag), mc);
=======
        	content = ROPConstants.setParam("title", languageManager.getLanguageValue("register_confirm_title", getLangTag(request)), content);
        	content = ROPConstants.setParam("subtitle", languageManager.getLanguageValue("register_confirm_subtitle", getLangTag(request)), content);
        	String mc = languageManager.getLanguageValue("register_confirm_content", getLangTag(request));
        	mc = ROPConstants.setParam("login", user.getUserLogin(), mc);
        	mc = ROPConstants.setParam("password", languageManager.getLanguageValue("pass_you_specified", getLangTag(request)), mc);
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
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
<<<<<<< HEAD
		mail.setSubject(user.getUserLogin()+" : "+languageManager.getLanguageValue("register_confirm_subtitle", langTag));
=======
		mail.setSubject(user.getUserLogin()+" : "+languageManager.getLanguageValue("register_confirm_subtitle", getLangTag(request)));
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		
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
	
<<<<<<< HEAD
	private void sendEditConfirmEmail(BaoUser user, String lastEmail, HttpServletRequest request) {
=======
	private void sendEditConfirmEmail(BaoUser user, String lastEmail, HttpServletRequest request) throws ServletException, IOException {
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		ArrayList<BaoEmailAccount> accounts = ROPUserDao.getValidEmailAccounts(user);
		
		final GsonBuilder builder = new GsonBuilder();
        final Gson gson = builder.create();
        
        BaoEmailTemplate template = ROPUserDao.getEmailTemplateByName("default_template");
        String content = "";
        if(template != null && template.getEmailTemplateState() == ROPConstants.STATE_ACTIVATED){
        	content = template.getEmailTemplateContent();
        	String contextBaseUrl = request.getRequestURL().toString().split(request.getContextPath())[0]+request.getContextPath();
        	content = ROPConstants.setParam("logo", contextBaseUrl+"/ressources/images/logo-baos.png", content);
<<<<<<< HEAD
        	content = ROPConstants.setParam("title", languageManager.getLanguageValue("register_confirm_title", langTag), content);
        	content = ROPConstants.setParam("subtitle", languageManager.getLanguageValue("register_confirm_subtitle", langTag), content);
        	String mc = languageManager.getLanguageValue("register_confirm_content", langTag);
        	mc = ROPConstants.setParam("login", user.getUserLogin(), mc);
        	mc = ROPConstants.setParam("password", languageManager.getLanguageValue("pass_you_specified", langTag), mc);
=======
        	content = ROPConstants.setParam("title", languageManager.getLanguageValue("register_confirm_title", getLangTag(request)), content);
        	content = ROPConstants.setParam("subtitle", languageManager.getLanguageValue("register_confirm_subtitle", getLangTag(request)), content);
        	String mc = languageManager.getLanguageValue("register_confirm_content", getLangTag(request));
        	mc = ROPConstants.setParam("login", user.getUserLogin(), mc);
        	mc = ROPConstants.setParam("password", languageManager.getLanguageValue("pass_you_specified", getLangTag(request)), mc);
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
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
<<<<<<< HEAD
		mail.setSubject(user.getUserLogin()+" : "+languageManager.getLanguageValue("register_confirm_subtitle", langTag));
=======
		mail.setSubject(user.getUserLogin()+" : "+languageManager.getLanguageValue("register_confirm_subtitle", getLangTag(request)));
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		
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
	
<<<<<<< HEAD
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
=======
	public void setAuthenticationMenu(HttpServletRequest request) throws ServletException, IOException {
		try {
			IncludeManager inclManager = getIncludeManager(request);
			String firstLinkPart = "/?m=" + encryptor.encrypt("authentication");
			int id = inclManager.createSideMenu(request, languageManager.getLanguageValue("auth_user_menu", getLangTag(request)), "user");
			inclManager.addMenuItem(request, id, languageManager.getLanguageValue("profile_title", getLangTag(request)), firstLinkPart + "&o=" + encryptor.encrypt("profile"), "user");
			inclManager.addMenuItem(request, id, languageManager.getLanguageValue("edit_profile", getLangTag(request)), firstLinkPart + "&o=" + encryptor.encrypt("edit-profile"), "edit");
			inclManager.addMenuItem(request, id, languageManager.getLanguageValue("auth_notification", getLangTag(request)), firstLinkPart + "&o=" + encryptor.encrypt("notification"), "bell");
			inclManager.addMenuItem(request, id, languageManager.getLanguageValue("auth_research_summary", getLangTag(request)), firstLinkPart + "&o=" + encryptor.encrypt("research"), "book");
			inclManager.addMenuItem(request, id, languageManager.getLanguageValue("auth_courses_summary", getLangTag(request)), firstLinkPart + "&o=" + encryptor.encrypt("courses"), "education");
			inclManager.addMenuItem(request, id, languageManager.getLanguageValue("logout_title", getLangTag(request)), firstLinkPart + "&o=" + encryptor.encrypt("logout"), "log-out");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		} catch (ROPCryptographyException e) {
			
		}
	}
	
<<<<<<< HEAD
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
=======
	public void setAuthenticationLogoutMenu(HttpServletRequest request) throws ServletException, IOException {
		try {
			IncludeManager inclManager = getIncludeManager(request);
			String firstLinkPart = "/?m=" + encryptor.encrypt("authentication");
			int id = inclManager.createSideMenu(request, languageManager.getLanguageValue("auth_user_menu", getLangTag(request)));
			inclManager.addMenuItem(request, id, languageManager.getLanguageValue("auth_login_menu_title", getLangTag(request)), firstLinkPart + "&o=" + encryptor.encrypt("login"), "log-in");
			inclManager.addMenuItem(request, id, languageManager.getLanguageValue("auth_register_menu_title", getLangTag(request)), firstLinkPart + "&o=" + encryptor.encrypt("register"), "plus-sign");
			inclManager.addMenuItem(request, id, languageManager.getLanguageValue("auth_reset_pwd_menu_title", getLangTag(request)), firstLinkPart + "&o=" + encryptor.encrypt("reset_password"), "refresh");
			
			/*int pid = includeManager.createLeftSidePanel(languageManager.getLanguageValue("auth_login_menu_title", getLangTag(request)), "log-in");
			includeManager.addLeftSidePanelContent(pid, "/modules/authentication/login.jsp", true);
			
			pid = includeManager.createRightSidePanel(languageManager.getLanguageValue("auth_register_menu_title", getLangTag(request)), "plus-sign");
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
			includeManager.addRightSidePanelContent(pid, "/modules/authentication/register.jsp", true);
			
			includeManager.addJS("/modules/authentication/js/register.js");
			
			int sid = includeManager.createDangerStatus("Un vrai statut par d�faut avec deux actions");
			includeManager.addStatusAction(sid, GuiStatus.DEFAULT, GuiStatus.STANDARD_LINK, "index.jsp", "Accueil");
			includeManager.addStatusDefaultAction(sid, GuiStatus.JAVASCRIPT_FUNCTION, "pgb_close_status_bar()", "Fermer");
			includeManager.createDefaultStatus("Un vrai statut par d�faut avec deux actions");*/
		} catch (ROPCryptographyException e) {
			
		}
	}
}
