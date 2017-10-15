package rop.miu.util;

public class ROPConstants {

	public static final short
				STATE_ACTIVATED = 0,
				STATE_READ = 0,
				STATE_PUBLISHED = 0,
				STATE_ACCEPTED = 0,
				STATE_PROGRAMMED = 0,
				STATE_REVIEWED = 0,
				STATE_DESACTIVATED = 1,
				STATE_UNREAD = 1,
				STATE_UNPUBLISHED = 1,
				STATE_REFUSED = 1,
				STATE_COMPLETED = 1,
				STATE_NOT_REVIEWED = 1,
				STATE_TRASHED = 2,
				STATE_IN_REVIEW = 2,
				STATE_DELETED = 3,
				STATE_WAITING_CORRECTION = 3,
				STATE_WAITING_VALIDATION = 4,
				STATE_DRAFT = 4,
				STATE_CLOSED = 4,
				STATE_SUBMITTED = 5,
				
				MAX_REFRESH_TIME = 180;

	public static final String
				PUBLIC_ACCESS = "public",
				MEMBER_ACCESS = "registered",
				ADMIN_ACCESS = "administrator",
				
				MEMBER_ACCESS_RIGHT = "Member Access Right",
				ADMIN_ACCESS_RIGHT = "Admin Access Right",
				ROOT_RIGHT = "All",
				ADD_STUDENT_RIGHT = "Add Student",
				ADD_COURSE_RIGHT = "Add Course",
				
				DEBIT = "Debit",
				CREDIT = "Credit",
				
				DAO_FILE = "rop/miu/dao/dao.cfg.rop.xml",
				
				COOKIE_SESSION_ID_LABEL = "baossrid",
				COOKIE_AGREE_LABEL = "baosagreecookie",
				
				AVATAR_TYPE_CLASSIC = "classic",
				AVATAR_TYPE_GRAVATAR = "gravatar",
				
				DEFAULT_USER_GROUP = "Registered",
				
				TMP_FOLDER = "/ressources/tmp",
				AVATARS_FOLDER = "/ressources/images/avatars";

	public static String setParam(String paramId, String replacement, String content) {
		return content.replaceAll("#"+paramId+"_[1-9]{1,4}#", replacement);
	}

	public static String setParam(int paramId, String replacement, String content) {
		return content.replaceAll("#[a-zA-Z0-9_]{1,}"+paramId+"#", replacement);
	}
}
