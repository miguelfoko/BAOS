package rop.miu.admin.modules.journal.dao;
import java.util.ArrayList;

import rop.miu.beans.BaoJournalOrConf;
import rop.miu.dao.ROPCrudDao;
import rop.miu.util.ROPConstants;
import rop.miu.util.exceptions.ROPDaoException;
public class RopJournalDao {
	public static BaoJournalOrConf getJournalOrConf(String journalOrConfName,short journalOrConfstate,String journalOrConfType) {
		String req = "SELECT j FROM BaoJournalOrConf j WHERE j.journalOrConfName = ? AND j.journalOrConfState = ? AND j.journalOrConfType= ?";
		return (BaoJournalOrConf) ROPCrudDao.selectSingleElement(req, journalOrConfName, journalOrConfstate,journalOrConfType);
	}
	
	public static BaoJournalOrConf getJournalOrConf(String journalOrConfName) {
		String req = "SELECT j FROM BaoJournalOrConf j WHERE j.journalOrConfName = ? ";
		return (BaoJournalOrConf) ROPCrudDao.selectSingleElement(req, journalOrConfName);
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<BaoJournalOrConf>  getAllJournalOrConf(String journalOrConType) {
		ArrayList<BaoJournalOrConf> list=new ArrayList<BaoJournalOrConf>();
		ArrayList<BaoJournalOrConf> list2=new ArrayList<BaoJournalOrConf>();
		String req = "SELECT m FROM BaoJournalOrConf m WHERE m.journalOrConfType = ? ORDER BY journalOrConfId";

		list= (ArrayList<BaoJournalOrConf>)ROPCrudDao.selectManyElements(req, journalOrConType);
		for(BaoJournalOrConf b:list){
			if(b.getJournalOrConfState()==ROPConstants.STATE_DELETED)
				list2.add(b);
		}
		for(BaoJournalOrConf b:list2){
			list.remove(b);
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<BaoJournalOrConf> getAllTrashedJournalOrConf(Short journalOrConState) {
		ArrayList<BaoJournalOrConf> list=new ArrayList<BaoJournalOrConf>();
		String req = "SELECT m FROM BaoJournalOrConf m WHERE m.journalOrConfState = ? ORDER BY journalOrConfId";
		list = (ArrayList<BaoJournalOrConf>)ROPCrudDao.selectManyElements(req, journalOrConState);
		return list;
	}
	
	public static int updateBaoJournalOrConf(BaoJournalOrConf b) throws ROPDaoException {
		String req = "UPDATE BaoJournalOrConf SET journalOrConfName=?,journalOrConfState=?,journalOrConfLogo=?,journalOrConfShortDesc=?,journalOrConfLongDesc=? WHERE journalOrConfId=?";
		return  ROPCrudDao.executeInsUpdDelCreQuery(req,b.getJournalOrConfName(),b.getJournalOrConfState(),b.getJournalOrConfLogo(),b.getJournalOrConfShortDesc(),b.getJournalOrConfLongDesc(),b.getJournalOrConfId());
	}
}
