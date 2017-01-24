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
				STATE_SUBMITTED = 5,
				
				MAX_REFRESH_TIME = 180;

	public static final String
				PUBLIC_ACCESS = "public",
				MEMBER_ACCESS = "registered",
				ADMIN_ACCESS = "administrator",
				
				MEMBER_ACCESS_RIGHT = "Access member modules options",
				ADMIN_ACCESS_RIGHT = "Access admin modules options",
				ROOT_RIGHT = "All",
				
				DEBIT = "Debit",
				CREDIT = "Credit",
				
				DAO_FILE = "rop/miu/dao/dao.cfg.rop.xml",
				
				COOKIE_SESSION_ID_LABEL = "baossrid";
}
