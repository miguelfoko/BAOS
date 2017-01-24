package rop.miu.dao;

import rop.miu.beans.BaoUser;

public class ROPUserDao {
	public static BaoUser getUserById(int userId){
		try{
			return (BaoUser)ROPCrudDao.getById(BaoUser.class, userId);
		}catch(Exception e){
			return null;
		}
	}

	public static BaoUser getUserByEmailAndPassword(String email, String pass) {
		String req = "SELECT u FROM BaoUser u WHERE u.userEmail = ? AND u.userPassword = ?";
		return (BaoUser) ROPCrudDao.selectSingleElement(req, email, pass);
	}
	
	public static BaoUser getUserByLoginAndPassword(String login, String pass) {
		String req = "SELECT u FROM BaoUser u WHERE u.userLogin = ? AND u.userPassword = ?";
		return (BaoUser) ROPCrudDao.selectSingleElement(req, login, pass);
	}
}
