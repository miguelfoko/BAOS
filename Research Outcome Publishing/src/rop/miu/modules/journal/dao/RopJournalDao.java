package rop.miu.modules.journal.dao;
import java.util.ArrayList;

import rop.miu.beans.BaoAutomaticReviewCondition;
import rop.miu.beans.BaoJournalOrConf;
import rop.miu.beans.BaoNews;
import rop.miu.beans.BaoReviewOrEditionContract;
import rop.miu.beans.BaoUser;
import rop.miu.beans.BaoVolumeOrIssue;
import rop.miu.dao.ROPCrudDao;
import rop.miu.util.ROPConstants;
import rop.miu.util.exceptions.ROPDaoException;
public class RopJournalDao {
	public static BaoJournalOrConf getJournalOrConf(String journalOrConfName,int journalOrConfstate,String journalOrConfType) {
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
	public static ArrayList<BaoJournalOrConf> getAllTrashedJournalOrConf(int journalOrConState) {
		ArrayList<BaoJournalOrConf> list=new ArrayList<BaoJournalOrConf>();
		String req = "SELECT m FROM BaoJournalOrConf m WHERE m.journalOrConfState = ? ORDER BY journalOrConfId";
		list = (ArrayList<BaoJournalOrConf>)ROPCrudDao.selectManyElements(req, journalOrConState);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<BaoUser> getAllUser() {
		ArrayList<BaoUser> list=new ArrayList<BaoUser>();
		String req = "SELECT m FROM BaoUser m ORDER BY userLogin";
		list = (ArrayList<BaoUser>)ROPCrudDao.selectManyElements(req);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<BaoJournalOrConf> getAllJournalOrConf() {
		ArrayList<BaoJournalOrConf> list=new ArrayList<BaoJournalOrConf>();
		String req = "SELECT m FROM BaoJournalOrConf m ORDER BY journalOrConfName";
		list = (ArrayList<BaoJournalOrConf>)ROPCrudDao.selectManyElements(req);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<BaoAutomaticReviewCondition> getAllAutomaticReviewCondition() {
		ArrayList<BaoAutomaticReviewCondition> list=new ArrayList<BaoAutomaticReviewCondition>();
		String req = "SELECT m FROM BaoAutomaticReviewCondition m ORDER BY reviewConditionName";
		list = (ArrayList<BaoAutomaticReviewCondition>)ROPCrudDao.selectManyElements(req);
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<BaoNews> getAllNews() {
		ArrayList<BaoNews> list=new ArrayList<BaoNews>();
		String req = "SELECT m FROM BaoNews m ORDER BY newsTitle";
		list = (ArrayList<BaoNews>)ROPCrudDao.selectManyElements(req);
		return list;
	}
	public static int updateBaoJournalOrConf(BaoJournalOrConf b) throws ROPDaoException {
		String req = "UPDATE BaoJournalOrConf SET journalOrConfName=?,journalOrConfState=?,journalOrConfLogo=?,journalOrConfShortDesc=?,journalOrConfLongDesc=? WHERE journalOrConfId=?";
		return  ROPCrudDao.executeInsUpdDelCreQuery(req,b.getJournalOrConfName(),b.getJournalOrConfState(),b.getJournalOrConfLogo(),b.getJournalOrConfShortDesc(),b.getJournalOrConfLongDesc(),b.getJournalOrConfId());
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<BaoVolumeOrIssue>  getAllVolumeOrNews() {
		ArrayList<BaoVolumeOrIssue> list=new ArrayList<BaoVolumeOrIssue>();
		ArrayList<BaoVolumeOrIssue> list2=new ArrayList<BaoVolumeOrIssue>();
		String req = "SELECT m FROM BaoVolumeOrIssue m ORDER BY volumeOrIssueIdentifier";

		list= (ArrayList<BaoVolumeOrIssue>)ROPCrudDao.selectManyElements(req);
		for(BaoVolumeOrIssue b:list){
			if(b.getVolumeOrIssueState()==ROPConstants.STATE_DELETED)
				list2.add(b);
		}
		for(BaoVolumeOrIssue b:list2){
			list.remove(b);
		}
		return list;
	}
	
}