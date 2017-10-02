/**
 * 
 */
package rop.miu.modules.elearning;

import java.util.ArrayList;
import java.util.List;

import rop.miu.beans.BaoCourse;
import rop.miu.beans.BaoCourseTimetable;
import rop.miu.beans.BaoGroup;
import rop.miu.beans.BaoIntervention;
import rop.miu.beans.BaoLesson;
import rop.miu.beans.BaoMonitorCourse;
import rop.miu.beans.BaoStudentCourse;
import rop.miu.beans.BaoTeacherCourse;
import rop.miu.beans.BaoTimetable;
import rop.miu.beans.BaoUser;
import rop.miu.dao.ROPCrudDao;
import rop.miu.util.exceptions.ROPDaoException;

/**
 * @author Doris-Kholer Nyabeye
 * 
 */
public class ROPElearningDao {

	public static BaoCourse getCourseById(int courseId) {
		try {
			return (BaoCourse) ROPCrudDao.getById(BaoCourse.class, courseId);
		} catch (Exception e) {
			return null;
		}
	}

	public static Object saveNewCourse(BaoCourse baoCourse)
			throws ROPDaoException {
		return ROPCrudDao.saveOrUpdate(baoCourse);
	}

	public static Object saveNewTimetable(BaoTimetable baoTimetable)
			throws ROPDaoException {
		return ROPCrudDao.saveOrUpdate(baoTimetable);
	}

	public static Object saveNewLesson(BaoLesson baoLesson)
			throws ROPDaoException {
		return ROPCrudDao.saveOrUpdate(baoLesson);
	}

	public static void updateLesson(BaoLesson baoLesson) throws ROPDaoException {
		ROPCrudDao.update(baoLesson);
	}

	public static void updateCourse(BaoCourse baoCourse) throws ROPDaoException {
		ROPCrudDao.update(baoCourse);
	}

	public static void saveNewIntervention(BaoIntervention baoIntervention)
			throws ROPDaoException {
		 ROPCrudDao.saveOrUpdate(baoIntervention);
	}

	public static void saveNewTeacherCourse(BaoTeacherCourse baoTeacherCourse)
			throws ROPDaoException {
		ROPCrudDao.saveOrUpdate(baoTeacherCourse);
	}

	public static void saveNewCourseTimetable(
			BaoCourseTimetable baoCourseTimetable) throws ROPDaoException {
		ROPCrudDao.saveOrUpdate(baoCourseTimetable);
	}

	public static void saveNewMonitorCourse(BaoMonitorCourse baoMonitorCourse)
			throws ROPDaoException {
		ROPCrudDao.saveOrUpdate(baoMonitorCourse);
	}

	public static void saveNewStudentCourse(BaoStudentCourse baoStudentCourse)
			throws ROPDaoException {
		ROPCrudDao.saveOrUpdate(baoStudentCourse);
	}

	@SuppressWarnings("rawtypes")
	public static List<BaoGroup> getUserGroupsById(int userId) {
		String query = "Select * from bao_user_group where user_id =?";
		try {
			List result = ROPCrudDao.selectManyElementsSql(query, userId);
			List<BaoGroup> l = new ArrayList<BaoGroup>();
			Object[] oT;
			BaoGroup gp;
			for (Object o : result) {
				oT = (Object[]) o;
				gp = (BaoGroup) ROPCrudDao.getById(BaoGroup.class,
						Integer.parseInt("" + oT[1]));
				l.add(gp);
			}
			return l;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked" )
	public static List<BaoIntervention> getInterventionByLessonId(
			BaoLesson lessonId) {
		String query = "Select i from BaoIntervention i where i.interventionIdParent is null and i.lessonId =?";
		try {
			List<BaoIntervention> result = ROPCrudDao.selectManyElements(query,
					lessonId);
			System.out.println(result.toString());
			for (BaoIntervention o : result) {
				List<BaoIntervention> result2 = getInterventionChildById(o
						.getInterventionId());
				if(result2==null){
					result2 = new ArrayList<BaoIntervention>();
					System.out.println("taille = "+result2.size());
				}
				o.setBaoInterventionList(result2);
				String likes = o.getInterventionLike();
				String[]like = likes.split("_");
				o.setInterventionLike(""+(like.length - 1));
				System.out.println("like "+like.length);
			}
			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public static List<BaoIntervention> getInterventionChildById(
			int interventionId) {
		String query = "Select i from BaoIntervention i where i.interventionIdParent = ?";
		try {
			List<BaoIntervention> result = ROPCrudDao.selectManyElements(
					query, interventionId);
			return result;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	public static List<BaoUser> getAllUsers(String email) {
		String query = "Select * from bao_user where user_email like '" + email
				+ "%'";
		try {
			List result = ROPCrudDao.selectManyElementsSql(query);
			List<BaoUser> l = new ArrayList<BaoUser>();
			Object[] oT;
			BaoUser gp;
			for (Object o : result) {
				oT = (Object[]) o;
				gp = (BaoUser) ROPCrudDao.getById(BaoUser.class,
						Integer.parseInt("" + oT[0]));
				l.add(gp);
			}
			return l;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	public static List<BaoCourse> getAllCourses() {
		String query = "Select * from bao_course";
		try {
			List result = ROPCrudDao.selectManyElementsSql(query);
			List<BaoCourse> l = new ArrayList<BaoCourse>();
			Object[] oT;
			BaoCourse gp;
			for (Object o : result) {
				oT = (Object[]) o;
				gp = (BaoCourse) ROPCrudDao.getById(BaoCourse.class,
						Integer.parseInt("" + oT[0]));
				l.add(gp);
			}
			return l;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	public static List<BaoCourse> getTeacherCourseById(int userId) {
		String query = "Select * from bao_teacher_course where bao_teacher_course.user_id =?";
		try {
			List result = ROPCrudDao.selectManyElementsSql(query, userId);
			List<BaoCourse> l = new ArrayList<BaoCourse>();
			Object[] oT;
			BaoCourse gp;
			for (Object o : result) {
				oT = (Object[]) o;
				gp = (BaoCourse) ROPCrudDao.getById(BaoCourse.class,
						Integer.parseInt("" + oT[1]));
				l.add(gp);
			}

			return l;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static List<BaoUser> getTeachersCourseById(int courseId) {
		String query = "Select * from bao_teacher_course where bao_teacher_course.course_id =?";
		try {
			List result = ROPCrudDao.selectManyElementsSql(query, courseId);
			List<BaoUser> l = new ArrayList<BaoUser>();
			Object[] oT;
			BaoUser gp;
			for (Object o : result) {
				oT = (Object[]) o;
				gp = (BaoUser) ROPCrudDao.getById(BaoUser.class,
						Integer.parseInt("" + oT[0]));
				l.add(gp);
			}

			return l;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	public static List<BaoCourse> getCourseOfMonitorById(int userId) {
		String query = "Select * from bao_monitor_course where bao_monitor_course.user_id =?";
		try {
			List result = ROPCrudDao.selectManyElementsSql(query, userId);
			List<BaoCourse> l = new ArrayList<BaoCourse>();
			Object[] oT;
			BaoCourse gp;
			for (Object o : result) {
				oT = (Object[]) o;
				gp = (BaoCourse) ROPCrudDao.getById(BaoCourse.class,
						Integer.parseInt("" + oT[1]));
				l.add(gp);
			}

			return l;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	public static List<BaoCourse> getCourseOfStudentById(int userId) {
		String query = "Select * from bao_student_course where bao_student_course.user_id =?";
		try {
			List result = ROPCrudDao.selectManyElementsSql(query, userId);
			List<BaoCourse> l = new ArrayList<BaoCourse>();
			Object[] oT;
			BaoCourse gp;
			for (Object o : result) {
				oT = (Object[]) o;
				gp = (BaoCourse) ROPCrudDao.getById(BaoCourse.class,
						Integer.parseInt("" + oT[1]));
				l.add(gp);
			}

			return l;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	public static List<BaoTimetable> getTimetableCourseById(int courseId) {
		String query = "Select * from bao_course_timetable where bao_course_timetable.course_id =?";
		try {
			List result = ROPCrudDao.selectManyElementsSql(query, courseId);
			List<BaoTimetable> l = new ArrayList<BaoTimetable>();
			Object[] oT;
			BaoTimetable gp;
			for (Object o : result) {
				oT = (Object[]) o;
				gp = (BaoTimetable) ROPCrudDao.getById(BaoTimetable.class,
						Integer.parseInt("" + oT[1]));
				l.add(gp);
			}

			return l;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	public static List<BaoUser> getMonitorCourseById(int courseId) {
		String query = "Select * from bao_monitor_course where bao_monitor_course.course_id =?";
		try {
			List result = ROPCrudDao.selectManyElementsSql(query, courseId);
			List<BaoUser> l = new ArrayList<BaoUser>();
			Object[] oT;
			BaoUser gp;
			for (Object o : result) {
				oT = (Object[]) o;
				gp = (BaoUser) ROPCrudDao.getById(BaoUser.class,
						Integer.parseInt("" + oT[0]));
				l.add(gp);
			}

			return l;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@SuppressWarnings("rawtypes")
	public static List<BaoLesson> getLessonCourseById(int courseId) {
		String query = "Select * from bao_lesson where bao_lesson.course_id =?";
		try {
			List result = ROPCrudDao.selectManyElementsSql(query, courseId);
			List<BaoLesson> l = new ArrayList<BaoLesson>();
			Object[] oT;
			BaoLesson gp;
			for (Object o : result) {
				oT = (Object[]) o;
				gp = (BaoLesson) ROPCrudDao.getById(BaoLesson.class,
						Integer.parseInt("" + oT[0]));
				l.add(gp);
			}

			return l;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static BaoLesson getLessonById(int lessonId) {
		try {
			return (BaoLesson) ROPCrudDao.getById(BaoLesson.class, lessonId);
		} catch (Exception e) {
			return null;
		}
	}

	public static BaoIntervention getInterventionById(int parentID) {
		// TODO Auto-generated method stub
		try {
			return (BaoIntervention) ROPCrudDao.getById(BaoIntervention.class,
					parentID);
		} catch (Exception e) {
			return null;
		}
	}

	public static void updateIntervention(BaoIntervention parent)
			throws ROPDaoException {
		// TODO Auto-generated method stub
		ROPCrudDao.update(parent);
	}
	
	
}
