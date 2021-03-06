package rop.miu.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import rop.miu.beans.BaoAccessCoupon;
import rop.miu.beans.BaoAdditionalInfo;
import rop.miu.beans.BaoEmailAccount;
import rop.miu.beans.BaoEmailTemplate;
import rop.miu.beans.BaoGroup;
import rop.miu.beans.BaoNotification;
import rop.miu.beans.BaoUser;
import rop.miu.util.ROPConstants;
import rop.miu.util.exceptions.ROPDaoException;

public class ROPUserDao {
	public static BaoUser getUserById(int userId){
		try{
			return (BaoUser)ROPCrudDao.getById(BaoUser.class, userId);
		}catch(Exception e){
			return null;
		}
	}

	public static BaoUser getValidUserByEmailAndPassword(String email, String pass) {
		String req = "SELECT u FROM BaoUser u WHERE u.userEmail = ? AND u.userPassword = ? AND u.userAccountState != ? AND u.userAccountState != ? AND u.userAccountState != ?";
		return (BaoUser) ROPCrudDao.selectSingleElement(req, email, pass, ROPConstants.STATE_DELETED, ROPConstants.STATE_DESACTIVATED, ROPConstants.STATE_WAITING_VALIDATION);
	}
	
	public static BaoUser getValidUserByLoginAndPassword(String login, String pass) {
		String req = "SELECT u FROM BaoUser u WHERE u.userLogin = ? AND u.userPassword = ? AND u.userAccountState != ? AND u.userAccountState != ? AND u.userAccountState != ?";
		return (BaoUser) ROPCrudDao.selectSingleElement(req, login, pass, ROPConstants.STATE_DELETED, ROPConstants.STATE_DESACTIVATED, ROPConstants.STATE_WAITING_VALIDATION);
	}
	
	public static BaoUser getUserByEmail(String email) {
		String req = "SELECT u FROM BaoUser u WHERE u.userEmail = ?";
		return (BaoUser) ROPCrudDao.selectSingleElement(req, email);
	}
	
	public static BaoUser getUserByLogin(String login) {
		String req = "SELECT u FROM BaoUser u WHERE u.userLogin = ?";
		return (BaoUser) ROPCrudDao.selectSingleElement(req, login);
	}

	public static boolean isEmailUsed(String email) {
		return getUserByEmail(email) != null;
	}
	
	public static boolean isLoginUsed(String login) {
		return getUserByLogin(login) != null;
	}

	public static boolean validatePassword(String pass) {
		if(pass.length() >= 8){
			for(int i = 0; i <= 9; i++)
				if(pass.contains("" + i))
					return true;
		}
		return false;
	}

	public static void saveNewUser(BaoUser user) throws ROPDaoException {
		ROPCrudDao.save(user);
	}
	
	public static BaoUser saveUser(BaoUser user) throws ROPDaoException {
		return (BaoUser)ROPCrudDao.saveOrUpdate(user);
	}

	public static BaoAdditionalInfo saveAdditionalInfo(BaoAdditionalInfo info) throws ROPDaoException {
		return (BaoAdditionalInfo)ROPCrudDao.saveOrUpdate(info);
	}

	public static int assignGroupToUser(String groupName, BaoUser user) throws ROPDaoException {
		String req = "SELECT g FROM BaoGroup g WHERE g.groupName = ?";
		BaoGroup group = (BaoGroup)ROPCrudDao.selectSingleElement(req, groupName);
		if(group != null){
			req = "INSERT INTO bao_user_group (user_id, group_id) VALUES (?, ?)";
			return ROPCrudDao.executeInsUpdDelCreSQLQuery(req, user.getUserId(), group.getGroupId());
		}
		return 0;
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<BaoEmailAccount> getValidEmailAccounts(BaoUser user) {
		ArrayList<BaoEmailAccount> list = new ArrayList<BaoEmailAccount>();
		String req = "SELECT DISTINCT bao_email_account.email_account_id, email_account_name, email_account_email, email_account_desc, email_account_state " +
				"FROM bao_email_account, bao_user_group, bao_group_email_account, bao_group WHERE user_id = ? AND bao_group_email_account.group_id = bao_user_group.group_id " +
				"AND bao_email_account.email_account_id = bao_group_email_account.email_account_id AND group_state = ? AND email_account_state = ?";
		List<Object> l = ROPCrudDao.selectManyElementsSql(req, user.getUserId(), ROPConstants.STATE_ACTIVATED, ROPConstants.STATE_ACTIVATED);
		Object[] obj;
		BaoEmailAccount acc;
		for(Object o : l){
			obj = (Object[])o;
			acc = new BaoEmailAccount();
			acc.setEmailAccountId((Integer)obj[0]);
			acc.setEmailAccountName((String)obj[1]);
			acc.setEmailAccountEmail((String)obj[2]);
			acc.setEmailAccountDesc((String)obj[3]);
			acc.setEmailAccountState((short)obj[4]);
			list.add(acc);
		}
		return list;
	}

	public static BaoEmailTemplate getEmailTemplateByName(String name) {
		String req = "SELECT et FROM BaoEmailTemplate et WHERE et.emailTemplateName = ?";
		return (BaoEmailTemplate) ROPCrudDao.selectSingleElement(req, name);
	}

	public static int validateUser(int userId) throws ROPDaoException {
		String req = "UPDATE bao_user SET user_account_state = ? WHERE user_id = ? AND user_account_state = ?";
		return ROPCrudDao.executeInsUpdDelCreSQLQuery(req, ROPConstants.STATE_ACTIVATED, userId, ROPConstants.STATE_WAITING_VALIDATION);
	}

	@SuppressWarnings("unchecked")
	public static int getUnreadNotificationNum(BaoUser baoUser) {
		String req = "SELECT notif FROM BaoNotification notif WHERE notif.userId = ? AND notif.notificationState = ?";
		List<Object> l = ROPCrudDao.selectManyElements(req, baoUser, ROPConstants.STATE_UNREAD);
		return l.size();
	}

	@SuppressWarnings("unchecked")
	public static ArrayList<BaoNotification> getAllNotifications(BaoUser baoUser) {
		String req = "SELECT notif FROM BaoNotification notif WHERE notif.userId = ? ORDER BY notif.notificationId DESC";
		List<Object> l = ROPCrudDao.selectManyElements(req, baoUser);
		ArrayList<BaoNotification> list = new ArrayList<BaoNotification>();
		for(Object o : l)
			list.add((BaoNotification)o);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<BaoAccessCoupon> getAllAccessCoupons(BaoUser baoUser) {
		String req = "SELECT coupon FROM BaoAccessCoupon coupon WHERE coupon.userId = ? ORDER BY coupon.accessCouponId DESC";
		List<Object> l = ROPCrudDao.selectManyElements(req, baoUser);
		ArrayList<BaoAccessCoupon> list = new ArrayList<BaoAccessCoupon>();
		for(Object o : l)
			list.add((BaoAccessCoupon)o);
		return list;
	}
	
	public static int readNotifications(int userId) throws ROPDaoException {
		String req = "UPDATE bao_notification SET notification_state = ?, notification_reception_date = ? WHERE user_id = ?";
		return ROPCrudDao.executeInsUpdDelCreSQLQuery(req, ROPConstants.STATE_READ, new Date(), userId);
	}
}
