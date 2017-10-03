package rop.miu.modules.publications.dao;


import java.util.List;

import rop.miu.beans.BaoPaperExcludedReviewer;
import rop.miu.beans.BaoJournalOrConf;
import rop.miu.beans.BaoPaper;
import rop.miu.beans.BaoPaperAuthor;
import rop.miu.beans.BaoPaperAuthorPK;
import rop.miu.beans.BaoPaperReview;
import rop.miu.beans.BaoReviewOrEditionContract;
import rop.miu.beans.BaoTopic;
import rop.miu.beans.BaoUser;
import rop.miu.beans.BaoVolumeOrIssue;
import rop.miu.dao.ROPCrudDao;
import rop.miu.util.ROPConstants;
import rop.miu.util.exceptions.ROPDaoException;




public class ROPPublicationsDao {
	
	public void saveTopic(BaoTopic topic) throws ROPDaoException {
		ROPCrudDao.saveOrUpdate(topic);
	}
	
	
	public void savePaperReview (BaoPaperReview paperReview) throws ROPDaoException {
		ROPCrudDao.saveOrUpdate(paperReview);
	}
	
	public void paperInReview (BaoPaper paper) throws ROPDaoException {
		String sql = "UPDATE BaoPaper p set p.paperState=? WHERE p.paperId=?";
		ROPCrudDao.executeInsUpdDelCreQuery(sql, ROPConstants.STATE_IN_REVIEW, paper.getPaperId());
	}
	
	
	public void savePaperAuthor (BaoPaperAuthor paperAuthor) throws ROPDaoException {
		ROPCrudDao.saveOrUpdate(paperAuthor);
	}
	
	
	public void saveExcludedReviewer (BaoPaperExcludedReviewer excludedReviewer) throws ROPDaoException {
		ROPCrudDao.saveOrUpdate(excludedReviewer);
	}
	
	
	public void savePaper (BaoPaper paper, BaoPaperAuthor paperAuthor) throws ROPDaoException {
		BaoPaper p = (BaoPaper)ROPCrudDao.saveOrUpdate(paper);
		/*String Querry = "INSERT INTO bao_paper(volume_or_issue_id, user_id_editor, user_id_paper_owner,paper_title, paper_abstract, paper_keywords, paper_attachment, paper_other_mention, paper_state, paper_submission_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";
		int status = ROPCrudDao.executeInsUpdDelCreSQLQuery(Querry,paper.getVolumeOrIssueId().getVolumeOrIssueId(), paper.getUserIdEditor().getUserId(),paper.getUserIdPaperOwner().getUserId(),paper.getPaperTitle(),paper.getPaperAbstract(),paper.getPaperKeywords(),paper.getPaperAttachment(),paper.getPaperOtherMention(),paper.getPaperState());
		return status;*/
		BaoPaperAuthorPK pk =new BaoPaperAuthorPK(p.getUserIdPaperOwner().getUserId(), p.getPaperId());
		paperAuthor.setBaoPaperAuthorPK(pk);
		ROPCrudDao.saveOrUpdate(paperAuthor);
	}
	
	
	public BaoPaper getOnePaper(int paper_id) {
		String query = "SELECT p FROM BaoPaper  p WHERE p.paperId = ?";
		Object o = ROPCrudDao.selectSingleElement(query, paper_id);
		return (BaoPaper)o;
	}
	
	
	@SuppressWarnings({ "unchecked", "cast" })
	public List<BaoPaper> getAllPapers () {
		String query = "SELECT p FROM BaoPaper p";
		List<BaoPaper> listToReturn = (List<BaoPaper>)ROPCrudDao.selectManyElements(query);
		return listToReturn;
	}
	
	@SuppressWarnings({ "unchecked", "cast" })
	public List<BaoPaper> getAllUnreadPapersByJournal () {
		String query = "SELECT p FROM BaoPaper p where p.paperState=?  ORDER BY p.paperSubmissionDate desc";
<<<<<<< HEAD
		List<BaoPaper> listToReturn = (List<BaoPaper>)ROPCrudDao.selectManyElements(query,ROPConstants.STATE_WAITING_VALIDATION);
=======
		List<BaoPaper> listToReturn = (List<BaoPaper>)ROPCrudDao.selectManyElements(query,ROPConstants.STATE_NOT_REVIEWED);
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		return listToReturn;
	}
	
	
	@SuppressWarnings({ "unchecked", "cast" })
	public List<BaoPaperExcludedReviewer> getAllExcludedReviewers () {
		String query = "SELECT e FROM BaoExcludedReviewer  e";
		List<BaoPaperExcludedReviewer> listToReturn = (List<BaoPaperExcludedReviewer>)ROPCrudDao.selectManyElements(query);
		return listToReturn;
	}
	
	@SuppressWarnings({ "unchecked", "cast" })
	public List<BaoPaperAuthor> getAllPaperAuthors () {
		String query = "SELECT p FROM BaoPaperAuthor  p";
		List<BaoPaperAuthor> listToReturn = (List<BaoPaperAuthor>)ROPCrudDao.selectManyElements(query);
		return listToReturn;
	}
	
	
	@SuppressWarnings({ "unchecked", "cast" })
	public List<BaoPaperReview> getAllPaperReview () {
		String query = "SELECT p FROM BaoPaperReview  p";
		List<BaoPaperReview> listToReturn = (List<BaoPaperReview>)ROPCrudDao.selectManyElements(query);
		return listToReturn;
	}
	
	
	@SuppressWarnings({ "unchecked", "cast" })
	public List<BaoTopic> getAllTopics () {
		String query = "SELECT t FROM BaoTopic  t";
		List<BaoTopic> listToReturn = (List<BaoTopic>)ROPCrudDao.selectManyElements(query);
		return listToReturn;
	}
	
	public BaoTopic getOneTopic (int topic_id) {
		String query = "SELECT t FROM BaoTopic  t WHERE t.topicId = ?";
		Object o = ROPCrudDao.selectSingleElement(query, topic_id);
		return (BaoTopic)o;
	}
	
	@SuppressWarnings({ "unchecked", "cast" })
	public List<BaoPaper> getRecentValidatedArticles () {
		String query = "SELECT p FROM BaoPaper  p WHERE p.paperValidationState=0";
		List<BaoPaper> listToReturn = (List<BaoPaper>)ROPCrudDao.selectManyElements(query);
		return listToReturn;
	}
	
	@SuppressWarnings({ "unchecked", "cast" })
	public List<BaoPaper> getAllArticlesByJournal (int volume_id) {
		String query = "SELECT * FROM bao_paper where volume_or_issue_id=?";
		List<BaoPaper> listToReturn = (List<BaoPaper>)ROPCrudDao.selectManyElementsSql(query, volume_id);
		return listToReturn;
	}
	
	@SuppressWarnings({ "unchecked", "cast" })
	public List<BaoJournalOrConf> getAllJournalOrConf () {
		String query = "SELECT j FROM BaoJournalOrConf  j WHERE j.journalOrConfState=0";
		List<BaoJournalOrConf> listToReturn = (List<BaoJournalOrConf>)ROPCrudDao.selectManyElements(query);
		return listToReturn;
	}
	
	public BaoJournalOrConf getAJournalByID (int journalID) {
		String query = "SELECT j FROM BaoJournalOrConf  j WHERE j.journalOrConfId=?";
		BaoJournalOrConf journal = (BaoJournalOrConf)ROPCrudDao.selectSingleElement(query, journalID);
		return journal;
	}
	
	@SuppressWarnings({ "unchecked", "cast" })
	public List<BaoVolumeOrIssue> getAllVolumesOfAJournal (int journalID) {
		String query = "SELECT v FROM BaoVolumeOrIssue v where v.journalOrConfId.journalOrConfId =?";
		List<BaoVolumeOrIssue> listToReturn = (List<BaoVolumeOrIssue>)ROPCrudDao.selectManyElements(query, journalID);
		return listToReturn;
	}
	
	public BaoVolumeOrIssue getAVolumeByIdentifier (String volumeIdentifier) {
		String query = "SELECT v FROM BaoVolumeOrIssue  v WHERE v.volumeOrIssueIdentifier=?";
		BaoVolumeOrIssue volume = (BaoVolumeOrIssue)ROPCrudDao.selectSingleElement(query, volumeIdentifier);
		return volume;
	}
	
	@SuppressWarnings({ "unchecked", "cast" })
	public List<BaoReviewOrEditionContract> getAllReviewersForAJournal (int journalID) {
<<<<<<< HEAD
		String query = "SELECT r FROM BaoReviewOrEditionContract r where r.journalOrConfId.journalOrConfId =?";
=======
		String query = "SELECT r FROM BaoReviewOrEditionContract r WHERE r.journalOrConfId.journalOrConfId =?";
>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
		List<BaoReviewOrEditionContract> listToReturn = (List<BaoReviewOrEditionContract>)ROPCrudDao.selectManyElements(query, journalID);
		return listToReturn;
	}
	
	
	public BaoUser getUserByName (String userName) {
		String query = "SELECT u FROM BaoUser  u WHERE u.userName=?";
		BaoUser user = (BaoUser)ROPCrudDao.selectSingleElement(query, userName);
		return user;
	}
	
	public BaoPaper getPaperById (int paper_id) {
		String query = "SELECT p FROM BaoPaper  p WHERE p.paperId=?";
		BaoPaper paper = (BaoPaper)ROPCrudDao.selectSingleElement(query, paper_id);
		return paper;
	}
	
	
	public BaoPaper getPreviousIssues () {
		String query = "SELECT p FROM BaoPaper  p WHERE p.paperState=?";
		BaoPaper paper = (BaoPaper)ROPCrudDao.selectSingleElement(query, ROPConstants.STATE_PUBLISHED);
		return paper;
	}
	
	public BaoPaper getForthcomingIssues () {
		String query = "SELECT p FROM BaoPaper  p WHERE p.paperState=?";
		BaoPaper paper = (BaoPaper)ROPCrudDao.selectSingleElement(query, ROPConstants.STATE_ACCEPTED);
		return paper;
	}
	
	public BaoPaper getCurrentIssues () {
		String query = "SELECT p FROM BaoPaper  p WHERE p.paperState=?";
		BaoPaper paper = (BaoPaper)ROPCrudDao.selectSingleElement(query, ROPConstants.STATE_COMPLETED);
		return paper;
	}
<<<<<<< HEAD
=======

>>>>>>> 480cda9ed27267cf1d83f1e4de7d6e19346494fc
	
	
}
