package rop.miu.modules.elearning;

import java.io.IOException;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import rop.miu.ConfigManager;
import rop.miu.beans.BaoAdditionalInfo;
import rop.miu.beans.BaoCourse;
import rop.miu.beans.BaoCourseTimetable;
import rop.miu.beans.BaoCourseTimetablePK;
import rop.miu.beans.BaoGroup;
import rop.miu.beans.BaoIntervention;
import rop.miu.beans.BaoLesson;
import rop.miu.beans.BaoMonitorCourse;
import rop.miu.beans.BaoStudentCourse;
import rop.miu.beans.BaoTeacherCourse;
import rop.miu.beans.BaoTeacherCoursePK;
import rop.miu.beans.BaoTimetable;
import rop.miu.beans.BaoUser;
import rop.miu.dao.ROPCrudDao;
import rop.miu.dao.ROPUserDao;
import rop.miu.modules.ServletModel;
import rop.miu.util.ROPConstants;
import rop.miu.util.exceptions.MIUIOException;
import rop.miu.util.exceptions.ROPCryptographyException;
import rop.miu.util.exceptions.ROPDaoException;
import rop.miu.util.io.MIUMultipartFormParser;
import rop.miu.util.io.Upload;
import rop.miu.util.io.UploadCondition;

/**
 * 
 * @author Doris-kholer Nyabeye
 */

public class ModElearning extends ServletModel {
	private static final long serialVersionUID = 1L;

	public ModElearning() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		super.doGet(request, response);

		String option = null;
		try {
			String parOpt = request.getParameter("o");
			if (parOpt != null)
				option = encryptor.decrypt(parOpt);
		} catch (Exception e) {
			forward500(request, response);
		}
		if (option == null) {
			request.setAttribute("el_create_course", languageManager
					.getLanguageValue("el_create_course", langTag));
			request.setAttribute("el_subscribe_course", languageManager
					.getLanguageValue("el_subscribe_course", langTag));
			request.setAttribute("el_monitor_course", languageManager
					.getLanguageValue("el_monitor_course", langTag));

			includeManager.setTitle(request, languageManager.getLanguageValue(
					"elearning", langTag));

			doCourse(request, response);
			chooseMenu(request, response, 0);
			this.returnRequest(request, response);
			return;
		}
		if (option.equals("createCourse")) {
			includeManager.setTitle(request, languageManager.getLanguageValue(
					"el_create_course", langTag));
			Date d = Calendar.getInstance().getTime();
			String dateToday = getDateString(d);
			request.getSession().setAttribute("dateToday", dateToday);
			includeManager.addJSP(request, "/modules/elearning/createCourse.jsp");
			chooseMenu(request, response, 0);
			this.returnRequest(request, response);
			return;
		}

		if (option.equals("taughtCourse")) {
			includeManager.addJSP(request, "/modules/elearning/myCourses.jsp");
			doCourseTaught(request, response);
			chooseMenu(request, response, 0);
			this.returnRequest(request, response);
			return;
		}
		if (option.equals("directedCourse")) {
			includeManager.addJSP(request, "/modules/elearning/myCourses.jsp");
			doCourseDirected(request, response);
			chooseMenu(request, response, 0);
			this.returnRequest(request, response);
			return;
		}
		if (option.equals("followedCourse")) {
			includeManager.addJSP(request, "/modules/elearning/myCourses.jsp");
			doCourseFollowed(request, response);
			chooseMenu(request, response, 0);
			this.returnRequest(request, response);
			return;
		}
		if (option.equals("subscribeCourse")) {
			includeManager.setTitle(request, languageManager.getLanguageValue(
					"el_subscribe_course", langTag));

			String courseId = null;
			try {
				String parOpt = request.getParameter("d");
				if (parOpt != null)
					courseId = encryptor.decrypt(parOpt);
			} catch (Exception e) {
				forward500(request, response);
			}
			BaoCourse baoCourse = ROPElearningDao.getCourseById(Integer
					.parseInt(courseId));

			if (isConnected(request)) {
				BaoUser baoU = (BaoUser) request.getSession().getAttribute(
						"baoUser");
				request.getSession().setAttribute("currentCourse", baoCourse);
				request.getSession().setAttribute("baoUser", baoU);
				includeManager.addJSP(request, "/modules/elearning/payCourse.jsp");
				this.returnRequest(request, response);
				return;
			} else {
				requestAuthentication(request, response, "elearning");
				return;

			}

		}
		if (option.equals("timetableCourse")) {
			includeManager.setTitle(request, languageManager.getLanguageValue(
					"el_timetable_course", langTag));
			BaoCourse course = (BaoCourse) request.getSession().getAttribute(
					"currentCourse");
			request.getSession().setAttribute("currentCourse", course);
			includeManager.addJSP(request, "/modules/elearning/timetableCourse.jsp");
			chooseMenu(request, response, 1);
			this.returnRequest(request, response);
			return;

		}
		if (option.equals("monitorCourse")) {
			includeManager.setTitle(request, languageManager.getLanguageValue(
					"el_monitor_course", langTag));
			BaoCourse course = (BaoCourse) request.getSession().getAttribute(
					"currentCourse");
			request.getSession().setAttribute("currentCourse", course);
			includeManager.addJS(request, "/modules/elearning/js/util.js");
			includeManager.addJSP(request, "/modules/elearning/monitorCourse.jsp");
			chooseMenu(request, response, 1);
			this.returnRequest(request, response);
			return;

		}
		if (option.equals("monitorCourseNew")) {
			includeManager.setTitle(request, languageManager.getLanguageValue(
					"el_monitor_course", langTag));
			BaoCourse course = (BaoCourse) request.getSession().getAttribute(
					"currentCourse");
			request.getSession().setAttribute("currentCourse", course);
			includeManager.addJS(request, "/modules/elearning/js/util.js");
			includeManager.addJSP(request, "/modules/elearning/monitorCourseNew.jsp");
			chooseMenu(request, response, 1);
			this.returnRequest(request, response);
			return;

		}
		if (option.equals("ajaxMonitorCourse")) {
			System.out.println("ajaxMonitorCourse");
			includeManager.setTitle(request, languageManager.getLanguageValue(
					"el_monitor_course", langTag));
			BaoCourse course = (BaoCourse) request.getSession().getAttribute(
					"currentCourse");
			request.getSession().setAttribute("currentCourse", course);
			String email = null;
			try {
				String parOpt = request.getParameter("d");
				if (parOpt != null)
					email = encryptor.decrypt(parOpt);
			} catch (Exception e) {
				forward500(request, response);
			}
			List<BaoUser> allUsers = ROPElearningDao.getAllUsers(email);
			String dataEmail = "<div>";
			for (int i = 0; i < allUsers.size(); i++) {
				dataEmail = dataEmail + allUsers.get(i).getUserEmail() + "<br>";
			}
			dataEmail = dataEmail + "</div>";
			System.out.println(dataEmail);
			response.getWriter().println(dataEmail);
			includeManager.addJS(request, "/modules/elearning/js/util.js");
			includeManager.addJSP(request, "/modules/elearning/monitorCourse.jsp");
			this.returnRequest(request, response);
			return;

		}
		if (option.equals("viewCourse")) {
			includeManager.setTitle(request, languageManager.getLanguageValue(
					"el_view_course", langTag));
			String courseId = null;
			try {
				String parOpt = request.getParameter("d");
				if (parOpt != null)
					courseId = encryptor.decrypt(parOpt);
			} catch (Exception e) {
				e.printStackTrace();
			}
			BaoCourse course = ROPElearningDao.getCourseById(Integer
					.parseInt(courseId));
			chooseMenu(request, response, 1);
			doViewCourseByOthers(request, response, course);
			return;

		}

		if (option.equals("lessonCourse")) {
			includeManager.setTitle(request, languageManager.getLanguageValue(
					"el_lesson_course", langTag));
			System.out.println("lessonCourse");
			BaoCourse course = (BaoCourse) request.getSession().getAttribute(
					"currentCourse");
			System.out.println(course.getCourseId());
			request.getSession().setAttribute("currentCourse", course);
			Date d = course.getCourseStartTime();
			String dateToday = getDateString(d);
			request.getSession().setAttribute("dateToday", dateToday);
			includeManager.addJS(request, "/modules/elearning/js/util.js");
			includeManager.addJSP(request, "/modules/elearning/lessonCourse.jsp");
			chooseMenu(request, response, 1);
			this.returnRequest(request, response);
			return;

		}

		if (option.equals("viewLesson")) {
			includeManager.setTitle(request, languageManager.getLanguageValue(
					"el_view_lesson", langTag));
			String lessonId = null;
			try {
				String parOpt = request.getParameter("d");
				if (parOpt != null)
					lessonId = encryptor.decrypt(parOpt);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int lessonID = Integer.parseInt(lessonId);
			System.out.println(lessonID);
			BaoCourse course = (BaoCourse) request.getSession().getAttribute(
					"currentCourse");
			BaoLesson lesson = ROPElearningDao.getLessonById(lessonID);
			System.out.println(lesson.toString());
			chooseMenu(request, response, 1);
			doViewLesson(request, response, course, lesson);
			return;
		}

		if (option.equals("likeIntervention")) {
			BaoCourse course = (BaoCourse) request.getSession().getAttribute(
					"currentCourse");
			BaoLesson lesson = (BaoLesson) request.getSession().getAttribute(
					"currentLesson");
			BaoUser baoUser = (BaoUser) request.getSession().getAttribute(
					"baoUser");
			String id = null;
			try {
				String parOpt = request.getParameter("d");
				if (parOpt != null)
					id = encryptor.decrypt(parOpt);
			} catch (Exception e) {
				forward500(request, response);
			}
			doInterventionCourseLike(request, response, baoUser, course,
					lesson, Integer.parseInt(id));
			chooseMenu(request, response, 1);
			doViewLesson(request, response, course, lesson);

		}

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
		String option = null;
		try {
			String parOpt = request.getParameter("o");
			if (parOpt != null)
				option = encryptor.decrypt(parOpt);
		} catch (Exception e) {
			forward500(request, response);
		}

		if (option.equals("CreateCourse")) {
			includeManager.setTitle(request, languageManager.getLanguageValue(
					"elearning", langTag));
			doCreateCourse(request, response);
			Date d = Calendar.getInstance().getTime();
			String dateToday = getDateString(d);
			request.getSession().setAttribute("dateToday", dateToday);
			includeManager.addJSP(request, "/modules/elearning/createCourse.jsp");
			chooseMenu(request, response, 0);
			this.returnRequest(request, response);
			return;
		}
		if (option.equals("TimetableCourse")) {
			BaoCourse course = (BaoCourse) request.getSession().getAttribute(
					"currentCourse");
			doTimetableCourse(request, response, course);
			request.getSession().setAttribute("currentCourse", course);
			chooseMenu(request, response, 1);
			doViewCourseByOthers(request, response, course);
			return;
		}
		if (option.equals("MonitorCourseOld")) {
			BaoCourse course = (BaoCourse) request.getSession().getAttribute(
					"currentCourse");
			System.out.println(course.toString());
			doMonitorCourseOld(request, response, course.getCourseId());
			request.getSession().setAttribute("currentCourse", course);
			chooseMenu(request, response, 1);
			doViewCourseByOthers(request, response, course);

		}
		if (option.equals("MonitorCourseNew")) {
			BaoCourse course = (BaoCourse) request.getSession().getAttribute(
					"currentCourse");
			System.out.println(course.toString());
			doMonitorCourseNew(request, response, course.getCourseId());
			request.getSession().setAttribute("currentCourse", course);
			chooseMenu(request, response, 1);
			doViewCourseByOthers(request, response, course);

		}
		if (option.equals("LessonCourse")) {
			BaoCourse course = (BaoCourse) request.getSession().getAttribute(
					"currentCourse");
			doLessonCourse(request, response, course);
			request.getSession().setAttribute("currentCourse", course);
			chooseMenu(request, response, 1);
			doViewCourseByOthers(request, response, course);

		}
		if (option.equals("AddIntervention")) {
			BaoCourse course = (BaoCourse) request.getSession().getAttribute(
					"currentCourse");
			BaoLesson lesson = (BaoLesson) request.getSession().getAttribute(
					"currentLesson");
			doInterventionCourse(request, response, course, lesson, -1);
			chooseMenu(request, response, 1);
			doViewLesson(request, response, course, lesson);

		}
		if (option.equals("AnswerIntervention")) {
			BaoCourse course = (BaoCourse) request.getSession().getAttribute(
					"currentCourse");
			BaoLesson lesson = (BaoLesson) request.getSession().getAttribute(
					"currentLesson");
			String id = null;
			try {
				String parOpt = request.getParameter("d");
				if (parOpt != null)
					id = encryptor.decrypt(parOpt);
			} catch (Exception e) {
				forward500(request, response);
			}
			doInterventionCourse(request, response, course, lesson,
					Integer.parseInt(id));
			chooseMenu(request, response, 1);
			doViewLesson(request, response, course, lesson);

		}
		if (option.equals("PayCourse")) {
			BaoCourse course = (BaoCourse) request.getSession().getAttribute(
					"currentCourse");
			doSubscribeCourse(request, response, course);
			chooseMenu(request, response, 0);
			doViewCourseByOthers(request, response, course);
		}

	}

	private void doViewCourseByOthers(HttpServletRequest request,
			HttpServletResponse response, BaoCourse course)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		List<BaoLesson> lessonCourse = ROPElearningDao
				.getLessonCourseById(course.getCourseId());
		List<BaoUser> monitorCourse = ROPElearningDao
				.getMonitorCourseById(course.getCourseId());
		List<BaoTimetable> timetableCourse = ROPElearningDao
				.getTimetableCourseById(course.getCourseId());
		List<BaoUser> teacherCourse = ROPElearningDao
				.getTeachersCourseById(course.getCourseId());
		request.getSession().setAttribute("currentCourse", course);
		request.getSession().setAttribute("lessonCourse", lessonCourse);
		request.getSession().setAttribute("monitorCourse", monitorCourse);
		request.getSession().setAttribute("timetableCourse", timetableCourse);
		request.getSession().setAttribute("teacherCourse", teacherCourse);
		includeManager.addJS(request, "/modules/elearning/js/util.js");
		includeManager.addJSP(request, "/modules/elearning/viewCourseByOthers.jsp");
		this.returnRequest(request, response);
		return;

	}

	private void doSubscribeCourse(HttpServletRequest request,
			HttpServletResponse response, BaoCourse course) {
		// TODO Auto-generated method stub

		BaoUser student = (BaoUser) request.getSession()
				.getAttribute("baoUser");
		BaoStudentCourse baoSC = new BaoStudentCourse(student.getUserId(),
				course.getCourseId());
		baoSC.setSubscriptionDate(new Date());
		try {
			ROPElearningDao.saveNewStudentCourse(baoSC);
		} catch (ROPDaoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	private void doViewLesson(HttpServletRequest request,
			HttpServletResponse response, BaoCourse course, BaoLesson lesson)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("test " + lesson.getLessonId());
		List<BaoIntervention> listOfIntervention = ROPElearningDao
				.getInterventionByLessonId(lesson);
		System.out.println(listOfIntervention.toString());
		request.getSession().setAttribute("currentLesson", lesson);
		request.getSession().setAttribute("currentCourse", course);
		request.getSession().setAttribute("listOfIntervention",
				listOfIntervention);
		request.getSession().setAttribute("listOfInterventionSize",
				listOfIntervention.size());
		includeManager.addJS(request, "/modules/elearning/js/util.js");
		includeManager.addJSP(request, "/modules/elearning/viewLesson.jsp");
		this.returnRequest(request, response);
		return;

	}

	void doInterventionCourse(HttpServletRequest request,
			HttpServletResponse response, BaoCourse course, BaoLesson lesson,
			int parentID) {
		// TODO Auto-generated method stub
		BaoUser baoUser = (BaoUser) request.getSession()
				.getAttribute("baoUser");

		String interventionContent = request.getParameter("comment");
		Date interventionDate = new Date();
		Short interventionState = ROPConstants.STATE_DESACTIVATED;

		try {
			BaoIntervention baoI = new BaoIntervention();
			baoI.setUserId(baoUser);
			baoI.setLessonId(lesson);
			baoI.setInterventionContent(interventionContent);
			baoI.setInterventionDate(interventionDate);
			baoI.setInterventionState(interventionState);
			baoI.setInterventionLike("");
			if (parentID != -1) {
				BaoIntervention parent = ROPElearningDao
						.getInterventionById(parentID);
				baoI.setInterventionIdParent(parent);
			}

			ROPElearningDao.saveNewIntervention(baoI);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	void doInterventionCourseLike(HttpServletRequest request,
			HttpServletResponse response, BaoUser baoUser, BaoCourse course,
			BaoLesson lesson, int interventionID) {
		// TODO Auto-generated method stub
		System.out.println(interventionID);
		BaoIntervention intervention = ROPElearningDao.getInterventionById(interventionID);
		String likes = intervention.getInterventionLike();
		String[] like = likes.split("_");
		boolean contain = false;
		for (int i = 0; i < like.length; i++) {
			if (like[i].equals("" + baoUser.getUserId())) {
				contain = true;
				break;
			}
		}
		if (!contain) {
			intervention.setInterventionLike(likes + "_" + baoUser.getUserId());
		} else {
			System.out.println("already like");
		}
		try {
			ROPElearningDao.updateIntervention(intervention);
		} catch (ROPDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void doLessonCourse(HttpServletRequest request,
			HttpServletResponse response, BaoCourse course) {
		// TODO Auto-generated method stub

		try {
			MIUMultipartFormParser parser = new MIUMultipartFormParser(request);
			UploadCondition cond = new UploadCondition(new ConfigManager());
			cond.getExtensions().add("pdf");

			UploadCondition cond2 = new UploadCondition(new ConfigManager());
			cond2.getExtensions().add("png");
			cond2.getExtensions().add("jpg");
			cond2.getExtensions().add("jpeg");
			HashMap<String, UploadCondition> conditions = new HashMap<String, UploadCondition>();
			conditions.put("icon", cond2);
			conditions.put("file", cond);

			HashMap<String, Object> result = parser.collectData(conditions);
			System.out.println(result.toString());
			BaoLesson baoL = new BaoLesson();
			baoL.setCourseId(course);
			baoL.setLessonName((String) result.get("name"));
			baoL.setLessonLogo("/ressources/tmp/"
					+ ((Upload) (result.get("icon"))).getUploadedFile()
							.getName());
			baoL.setLessonDifficultyLevel(Integer.parseInt((String) result
					.get("level")));
			baoL.setLessonContent((String) result.get("content"));
			baoL.setLessonDesc((String) result.get("desc"));
			System.out.println(((Upload) (result.get("file")))
					.getUploadedFile().getName());
			baoL.setLessonAttachment("/ressources/tmp/"
					+ ((Upload) (result.get("file"))).getUploadedFile()
							.getName());
			baoL.setLessonCreationDate(new Date());
			Date start = getDate((String) result.get("start"));
			Date end = getDate((String) result.get("end"));
			if ((getDate(getDateString(new Date()))).before(start)) {
				baoL.setLessonState(ROPConstants.STATE_DESACTIVATED);
			} else {
				baoL.setLessonState(ROPConstants.STATE_ACTIVATED);
				System.out.println("STATE_ACTIVATED");
			}
			baoL.setLessonStartTime(start);
			baoL.setLessonEndTime(end);
			ROPElearningDao.saveNewLesson(baoL);
		} catch (MIUIOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ROPDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void doMonitorCourseOld(HttpServletRequest request,
			HttpServletResponse response, Integer courseId) {
		// TODO Auto-generated method stub
		String monitorEmail = request.getParameter("email");
		BaoUser monitor = ROPUserDao.getUserByEmail(monitorEmail);
		BaoMonitorCourse baoMC = new BaoMonitorCourse(monitor.getUserId(),
				courseId);
		baoMC.setMonitorCourseDate(new Date());
		try {
			ROPElearningDao.saveNewMonitorCourse(baoMC);
		} catch (ROPDaoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	void doMonitorCourseNew(HttpServletRequest request,
			HttpServletResponse response, Integer courseId) {
		// TODO Auto-generated method stub
		String monitorName = request.getParameter("name");
		String monitorSurname = request.getParameter("surname");
		String monitorEmail = request.getParameter("email");
		String monitorLogin = generateLogin();
		String monitorPassword = generatePassword();

		try {
			BaoUser user = new BaoUser();
			user.setUserName(monitorName);
			user.setUserSurname(monitorSurname);
			user.setUserEmail(monitorEmail);
			user.setUserLogin(monitorLogin);
			user.setUserPassword(encryptor.encrypt(encryptor
					.encrypt(monitorPassword)));
			user.setUserAccountState(ROPConstants.STATE_WAITING_VALIDATION);
			BaoAdditionalInfo info = new BaoAdditionalInfo();
			info.setUserRegistrationDate(DateTime.now().toDate());
			info = ROPUserDao.saveAdditionalInfo(info);
			user.setAdditionalInfoId(info);
			ROPUserDao.saveNewUser(user);
			ROPCrudDao.refresh(user);
			ROPUserDao.assignGroupToUser(ROPConstants.DEFAULT_USER_GROUP, user);
			// sendConfirmEmail(user, request);

			BaoMonitorCourse baoMC = new BaoMonitorCourse(user.getUserId(),
					courseId);
			baoMC.setMonitorCourseDate(new Date());
			try {
				ROPElearningDao.saveNewMonitorCourse(baoMC);
			} catch (ROPDaoException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	void doCourse(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// if (isConnected(request)) {
		// BaoUser baoU = (BaoUser) request.getSession().getAttribute(
		// "baoUser");
		// int baouId = baoU.getUserId();
		// List<BaoGroup> userGroups = ROPElearningDao
		// .getUserGroupsById(baouId);
		// boolean isTeacher = false;
		// for (BaoGroup bg : userGroups) {
		// if (((BaoGroup) bg).getGroupName().equalsIgnoreCase("Teacher")) {
		// isTeacher = true;
		// }
		// }
		//
		// if (isTeacher) {
		// List<BaoCourse> userCourse = ROPElearningDao
		// .getTeacherCourseById(baouId);
		//
		// request.getSession().setAttribute("userCourse", userCourse);
		// request.getSession().setAttribute("userCourseSize",
		// userCourse.size());
		// request.getSession().setAttribute("baoUser", baoUser);
		// request.getSession().setAttribute("isTeacher", true);
		// Date d = Calendar.getInstance().getTime();
		// String dateToday = getDateString(d);
		// request.getSession().setAttribute("dateToday", dateToday);
		// includeManager.addJS(request, "/modules/elearning/js/util.js");
		// includeManager.addJSP(request, "/modules/elearning/index.jsp");
		// } else {
		// List<BaoCourse> monitorCourse = ROPElearningDao
		// .getCourseOfMonitorById(baouId);
		// List<BaoCourse> studentCourse = ROPElearningDao
		// .getCourseOfMonitorById(baouId);
		// System.out.println(monitorCourse.toString());
		// List<BaoCourse> userCourse = ROPElearningDao.getAllCourses();
		//
		// request.getSession().setAttribute("userCourse", userCourse);
		// request.getSession().setAttribute("userCourseSize",
		// userCourse.size());
		// request.getSession().setAttribute("monitorCourse",
		// monitorCourse);
		// request.getSession().setAttribute("monitorCourseSize",
		// monitorCourse.size());
		// request.getSession().setAttribute("studentCourse",
		// studentCourse);
		// request.getSession().setAttribute("studentCourseSize",
		// studentCourse.size());
		// request.getSession().setAttribute("baoUser", baoUser);
		// request.getSession().setAttribute("isTeacher", false);
		// includeManager.addJSP(request, "/modules/elearning/index.jsp");
		// }
		//
		// } else {
		// request.getSession().setAttribute("baoUser", null);
		List<BaoCourse> userCourse = ROPElearningDao.getAllCourses();

		request.getSession().setAttribute("userCourse", userCourse);
		includeManager.addJSP(request, "/modules/elearning/index.jsp");
	}

	void doViewCourse(HttpServletRequest request, HttpServletResponse response,
			String courseId) throws ServletException, IOException {
		if (isConnected(request)) {
			BaoUser baoU = (BaoUser) request.getSession().getAttribute(
					"baoUser");
			int baouId = baoU.getUserId();
			List<BaoGroup> userGroups = ROPElearningDao
					.getUserGroupsById(baouId);
			boolean isTeacher = false;
			for (BaoGroup bg : userGroups) {
				if (((BaoGroup) bg).getGroupName().equalsIgnoreCase("Teacher")) {
					isTeacher = true;
				}
			}

			if (isTeacher) {

				List<BaoTimetable> timetableCourse = ROPElearningDao
						.getTimetableCourseById(Integer.parseInt("" + courseId));
				List<BaoLesson> lessonCourse = ROPElearningDao
						.getLessonCourseById(Integer.parseInt("" + courseId));
				List<BaoUser> monitorCourse = ROPElearningDao
						.getMonitorCourseById(Integer.parseInt("" + courseId));
				BaoCourse course = ROPElearningDao.getCourseById(Integer
						.parseInt("" + courseId));

				request.getSession().setAttribute("timetableCourse",
						timetableCourse);
				request.getSession().setAttribute("timetableCourseSize",
						timetableCourse.size());
				request.getSession().setAttribute("lessonCourse", lessonCourse);
				request.getSession().setAttribute("lessonCourseSize",
						lessonCourse.size());
				request.getSession().setAttribute("monitorCourse",
						monitorCourse);
				request.getSession().setAttribute("monitorCourseSize",
						monitorCourse.size());
				request.getSession().setAttribute("baoUser", baoUser);
				request.getSession().setAttribute("currentCourse", course);
				includeManager.addJSP(request, "/modules/elearning/viewCourse.jsp");
				this.returnRequest(request, response);
			} else {
				forward403(request, response);
			}

		} else {
			requestAuthentication(request, response, "elearning");
			return;
		}
	}

	void doTimetableCourse(HttpServletRequest request,
			HttpServletResponse response, BaoCourse course)
			throws ServletException, IOException {

		String nom = request.getParameter("name");
		String day = request.getParameter("day");
		String start = request.getParameter("start");
		String end = request.getParameter("end");

		BaoTimetable baoT = new BaoTimetable();
		baoT.setTimetableName(nom);
		baoT.setTimetableDay(day);
		baoT.setTimetableStartTime(getTime(start + ":00"));
		baoT.setTimetableEndTime(getTime(end + ":00"));

		try {

			baoT = (BaoTimetable) ROPElearningDao.saveNewTimetable(baoT);
			BaoCourseTimetable baoCT = new BaoCourseTimetable(
					new BaoCourseTimetablePK(course.getCourseId(),
							baoT.getTimetableId()));
			ROPElearningDao.saveNewCourseTimetable(baoCT);
		} catch (ROPDaoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	private void doCourseTaught(HttpServletRequest request,
			HttpServletResponse response) {
		BaoUser baoU = (BaoUser) request.getSession().getAttribute("baoUser");
		int baouId = baoU.getUserId();
		List<BaoCourse> userCourse = ROPElearningDao
				.getTeacherCourseById(baouId);

		request.getSession().setAttribute("userCourse", userCourse);
		request.getSession().setAttribute("courseTaught", true);
		request.getSession().setAttribute("courseDirected", false);
		request.getSession().setAttribute("courseFollowed", false);
		if (userCourse != null) {
			request.getSession().setAttribute("userCourseSize",
					userCourse.size());
		} else {
			request.getSession().setAttribute("userCourseSize", 0);
		}
	}

	private void doCourseDirected(HttpServletRequest request,
			HttpServletResponse response) {
		BaoUser baoU = (BaoUser) request.getSession().getAttribute("baoUser");
		int baouId = baoU.getUserId();
		List<BaoCourse> userCourse = ROPElearningDao
				.getCourseOfMonitorById(baouId);

		request.getSession().setAttribute("monitorCourse", userCourse);
		request.getSession().setAttribute("courseTaught", false);
		request.getSession().setAttribute("courseDirected", true);
		request.getSession().setAttribute("courseFollowed", false);
		if (userCourse != null) {
			request.getSession().setAttribute("monitorCourseSize",
					userCourse.size());
		} else {
			request.getSession().setAttribute("monitorCourseSize", 0);
		}
	}

	private void doCourseFollowed(HttpServletRequest request,
			HttpServletResponse response) {
		BaoUser baoU = (BaoUser) request.getSession().getAttribute("baoUser");
		int baouId = baoU.getUserId();
		List<BaoCourse> userCourse = ROPElearningDao
				.getCourseOfStudentById(baouId);

		request.getSession().setAttribute("studentCourse", userCourse);
		request.getSession().setAttribute("courseTaught", false);
		request.getSession().setAttribute("courseDirected", false);
		request.getSession().setAttribute("courseFollowed", true);
		if (userCourse != null) {
			request.getSession().setAttribute("studentCourseSize",
					userCourse.size());
		} else {
			request.getSession().setAttribute("studentCourseSize", 0);
		}
	}

	private void doCreateCourse(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

		try {
			MIUMultipartFormParser parser = new MIUMultipartFormParser(request);
			UploadCondition cond = new UploadCondition(new ConfigManager());
			cond.getExtensions().add("png");
			cond.getExtensions().add("jpg");
			cond.getExtensions().add("jpeg");
			HashMap<String, UploadCondition> conditions = new HashMap<String, UploadCondition>();
			conditions.put("file", cond);

			HashMap<String, Object> result = parser.collectData(conditions);
			System.out.println(result.toString());
			BaoCourse baoC = new BaoCourse();
			baoC.setCourseName((String) result.get("name"));
			baoC.setCourseLogo("/ressources/tmp/"
					+ ((Upload) (result.get("file"))).getUploadedFile()
							.getName());
			Date start = getDate((String) result.get("start"));
			baoC.setCourseStartTime(start);
			baoC.setCourseLength(Integer.parseInt((String) result.get("length")));
			baoC.setCourseLengthUnit((String) result.get("lengthUnit"));
			baoC.setCourseCreationDate(new Date());
			baoC.setCourseDesc((String) result.get("desc"));

			if ((getDate(getDateString(new Date()))).before(start)) {
				baoC.setCourseState(ROPConstants.STATE_DESACTIVATED);
			} else {
				baoC.setCourseState(ROPConstants.STATE_ACTIVATED);
				System.out.println("STATE_ACTIVATED");
			}

			baoC = (BaoCourse) ROPElearningDao.saveNewCourse(baoC);

			BaoTeacherCourse baoTeacherCourse = new BaoTeacherCourse(
					new BaoTeacherCoursePK(baoUser.getUserId(),
							baoC.getCourseId()), true);
			ROPElearningDao.saveNewTeacherCourse(baoTeacherCourse);

		} catch (MIUIOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ROPDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	String generateLogin() {
		String word = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String mat = "";
		for (int i = 0; i < 8; i++) {
			int j = (int) (Math.random() * word.length());
			mat = mat + word.charAt(j);
		}
		return mat;
	}

	String generatePassword() {
		String word = "abcdefghijklmnopqrstuvwxyz1234567890";
		String mat = "";
		for (int i = 0; i < 8; i++) {
			int j = (int) (Math.random() * word.length());
			mat = mat + word.charAt(j);
		}
		return mat;
	}

	Date getDate(String ch) {
		Date d = null;
		try {
			d = (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")).parse(ch
					+ " 00:00:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;

	}

	Date getTime(String ch) {
		Date d = null;
		try {
			d = (new SimpleDateFormat("hh:mm:ss")).parse(ch);
			System.out.println(ch);
			System.out.println(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;

	}

	String getDateString(Date ch) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String d = dateFormat.format(ch);
		return d;

	}

	String getTimeString(Date ch) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
		String d = dateFormat.format(ch);
		return d;

	}

	public void setElearningMenu(HttpServletRequest request) {
		try {
			String firstLinkPart = "/?m=" + encryptor.encrypt("elearning");
			int id = includeManager.createSideMenu(request, languageManager
					.getLanguageValue("el_elearning_menu", langTag), "user");
			includeManager.addMenuItem(request, id,
					languageManager.getLanguageValue("el_all_course", langTag),
					firstLinkPart + "&o=" + encryptor.encrypt("createCourse"),
					"user");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_subscribe_course", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("viewCourse"), "bell");
		} catch (ROPCryptographyException e) {

		}
	}

	public void setTeacherMenu(HttpServletRequest request) {
		try {
			String firstLinkPart = "/?m=" + encryptor.encrypt("elearning");
			int id = includeManager.createSideMenu(request, languageManager
					.getLanguageValue("el_elearning_menu", langTag), "user");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_create_course", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("createCourse"), "user");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_subscribe_course", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("viewCourse"), "bell");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_course_taught", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("taughtCourse"), "user");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_course_directed", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("directedCourse"), "edit");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_course_followed", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("followedCourse"), "bell");

		} catch (ROPCryptographyException e) {

		}
	}

	public void setTeacherCourseMenu(HttpServletRequest request) {
		try {
			String firstLinkPart = "/?m=" + encryptor.encrypt("elearning");
			int id = includeManager.createSideMenu(request, languageManager
					.getLanguageValue("el_elearning_menu", langTag), "user");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_create_course", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("createCourse"), "user");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_subscribe_course", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("viewCourse"), "bell");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_course_taught", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("taughtCourse"), "user");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_course_directed", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("directedCourse"), "edit");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_course_followed", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("followedCourse"), "bell");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_timetable_course", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("timetableCourse"), "user");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_monitor_course", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("monitorCourse"), "edit");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_lesson_course", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("lessonCourse"), "bell");

		} catch (ROPCryptographyException e) {

		}
	}

	public void setStudentMenu(HttpServletRequest request) {
		try {
			String firstLinkPart = "/?m=" + encryptor.encrypt("elearning");
			int id = includeManager.createSideMenu(request, languageManager
					.getLanguageValue("el_elearning_menu", langTag), "user");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_subscribe_course", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("viewCourse"), "bell");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_course_followed", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("followedCourse"), "bell");
		} catch (ROPCryptographyException e) {
		}
	}

	public void setMonitorMenu(HttpServletRequest request) {
		try {
			String firstLinkPart = "/?m=" + encryptor.encrypt("elearning");
			int id = includeManager.createSideMenu(request, languageManager
					.getLanguageValue("el_elearning_menu", langTag), "user");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_subscribe_course", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("viewCourse"), "bell");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_course_directed", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("directedCourse"), "edit");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_course_followed", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("followedCourse"), "bell");

		} catch (ROPCryptographyException e) {

		}
	}

	public void setElearningGuidesMenu(HttpServletRequest request) {
		try {
			String firstLinkPart = "/?m=" + encryptor.encrypt("elearning");
			int id = includeManager.createSideMenu(request, 
					languageManager.getLanguageValue("el_guide_menu", langTag),
					"user");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_guide_teacher", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("guideTeacher"), "user");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_guide_monitor", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("guideMonitor"), "edit");
			includeManager.addMenuItem(request, id, languageManager.getLanguageValue(
					"el_guide_student", langTag), firstLinkPart + "&o="
					+ encryptor.encrypt("guideStudent"), "bell");
		} catch (ROPCryptographyException e) {

		}
	}

	private void chooseMenu(HttpServletRequest request,
			HttpServletResponse response, int teacherMenu)
			throws ServletException, IOException {
		if (isConnected(request)) {
			BaoUser baoU = (BaoUser) request.getSession().getAttribute(
					"baoUser");
			int baouId = baoU.getUserId();
			List<BaoGroup> userGroups = ROPElearningDao
					.getUserGroupsById(baouId);
			boolean isTeacher = false;
			for (BaoGroup bg : userGroups) {
				if (((BaoGroup) bg).getGroupName().equalsIgnoreCase("Teacher")) {
					isTeacher = true;
				}
			}
			if (isTeacher) {
				if (teacherMenu == 0) {
					setTeacherMenu(request);
				} else if (teacherMenu == 1) {
					setTeacherCourseMenu(request);
				}
			} else {
				List<BaoCourse> monitorCourse = ROPElearningDao
						.getCourseOfMonitorById(baouId);
				List<BaoCourse> studentCourse = ROPElearningDao
						.getCourseOfStudentById(baouId);
				if (monitorCourse != null) {
					setMonitorMenu(request);
				} else if (studentCourse != null) {
					setStudentMenu(request);
				} else {
					setElearningMenu(request);
				}
			}
		} else {
			setElearningMenu(request);
		}

		setElearningGuidesMenu(request);
	}

}
