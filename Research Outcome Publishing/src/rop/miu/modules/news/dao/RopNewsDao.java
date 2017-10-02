package rop.miu.modules.news.dao;

import java.util.ArrayList;

import rop.miu.beans.BaoJournalOrConf;
import rop.miu.beans.BaoNews;
import rop.miu.beans.BaoUser;
import rop.miu.dao.ROPCrudDao;
import rop.miu.util.ROPConstants;

public class RopNewsDao {
	@SuppressWarnings("unchecked")
	public static ArrayList<BaoUser> getAllUser() {
		ArrayList<BaoUser> list=new ArrayList<BaoUser>();
		String req = "SELECT m FROM BaoUser m ORDER BY userLogin";
		list = (ArrayList<BaoUser>)ROPCrudDao.selectManyElements(req);
		return list;
	}
	@SuppressWarnings("unchecked")
	public static ArrayList<BaoNews>  getAllNews() {
		ArrayList<BaoNews> list=new ArrayList<BaoNews>();
		ArrayList<BaoNews> list2=new ArrayList<BaoNews>();
		String req = "SELECT m FROM BaoNews m ORDER BY newsTitle";

		list= (ArrayList<BaoNews>)ROPCrudDao.selectManyElements(req);
		for(BaoNews b:list){
			if(b.getNewsState()==ROPConstants.STATE_DELETED)
				list2.add(b);
		}
		for(BaoNews b:list2){
			list.remove(b);
		}
		return list;
	}
}
