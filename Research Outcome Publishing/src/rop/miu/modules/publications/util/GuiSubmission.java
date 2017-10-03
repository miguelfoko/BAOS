package rop.miu.modules.publications.util;

import java.io.Serializable;
import java.util.ArrayList;

import rop.miu.beans.BaoJournalOrConf;

public class GuiSubmission implements Serializable{
	private static final long serialVersionUID = 1L;
	private int subId;
	private SubStepOne subStepOne;
	private SubStepTwo subStepTwo;
	private SubStepThree subStepThree;
	private SubStepFour subStepFour;
	private SubStepFive subStepFive;
	
	public GuiSubmission(int subId) {
		this.subId = subId;
		subStepOne = new SubStepOne();
		subStepTwo = new SubStepTwo();
		subStepThree = new SubStepThree();
		subStepFour = new SubStepFour();
		subStepFive = new SubStepFive();
	}

	public GuiSubmission(int subId, String paperType, BaoJournalOrConf journalOrConf) {
		this.subId = subId;
		this.subStepOne = new SubStepOne(paperType, journalOrConf);
		subStepTwo = new SubStepTwo();
		subStepThree = new SubStepThree();
		subStepFour = new SubStepFour();
		subStepFive = new SubStepFive();
	}
	
	public void setSubStepOne(String paperType, BaoJournalOrConf journalOrConf){
		this.subStepOne.setPaperType(paperType);
		this.subStepOne.setJournalOrConf(journalOrConf);
	}
	
	public void addAuthor(String name, String institution, String email, boolean principal){
		this.subStepTwo.addAuthor(name, institution, email, principal);
	}
	
	public void setPrincipalAuthor(int authorId){
		this.subStepTwo.setPrincipalAuthor(authorId);
	}
	
	public void setGenTermOfUseAccepted(boolean genTermOfUseAccepted){
		this.subStepTwo.setGenTermOfUseAccepted(genTermOfUseAccepted);
	}
	
	public void addProposedReviewerOrEditor(String name, String institution, String email, String motivation){
		for(GuiAuthor auth : getAuthors())
			if(auth.getEmail().equals(email))
				return;
		this.subStepThree.addProposedReviewerOrEditor(name, institution, email, motivation);
	}
	
	public void addExcludedReviewerOrEditor(String name, String institution, String email, String motivation){
		for(GuiRefereeOrEditor ref : getProposedReviewerOrEditors())
			if(ref.getEmail().equals(email))
				return;
		this.subStepFour.addExcludedReviewerOrEditor(name, institution, email, motivation);
	}
	
	public void setSubSetFive(String highlight, String latexArchiveFile,
			String otherMentions){
		this.subStepFive.setHighlight(highlight);
		this.subStepFive.setLatexArchiveFile(latexArchiveFile);
		this.subStepFive.setOtherMentions(otherMentions);
	}

	public int getSubId() {
		return subId;
	}
	
	public String getPaperType() {
		return this.subStepOne.getPaperType();
	}

	public BaoJournalOrConf getJournalOrConf() {
		return this.subStepOne.getJournalOrConf();
	}
	
	public ArrayList<GuiAuthor> getAuthors() {
		return this.subStepTwo.getAuthors();
	}
	
	public GuiAuthor getPrincipalAuthor() {
		return this.subStepTwo.getPrincipalAuthor();
	}

	public boolean isGenTermOfUseAccepted() {
		return this.subStepTwo.isGenTermOfUseAccepted();
	}
	
	public ArrayList<GuiRefereeOrEditor> getProposedReviewerOrEditors() {
		return this.subStepThree.getProposedReviewerOrEditors();
	}
	
	public ArrayList<GuiRefereeOrEditor> getExcludedReviewerOrEditors() {
		return this.subStepFour.getExcludedReviewerOrEditors();
	}
	
	public String getHighlight() {
		return this.subStepFive.getHighlight();
	}

	public String getLatexArchiveFile() {
		return this.subStepFive.getLatexArchiveFile();
	}

	public String getOtherMentions() {
		return this.subStepFive.getOtherMentions();
	}

	private class SubStepOne implements Serializable{
		private static final long serialVersionUID = 1L;
		private String paperType;
		private BaoJournalOrConf journalOrConf;
		
		public SubStepOne(String paperType, BaoJournalOrConf journalOrConf) {
			this.paperType = paperType;
			this.journalOrConf = journalOrConf;
		}

		public SubStepOne() {
			
		}

		public String getPaperType() {
			return paperType;
		}

		public void setPaperType(String paperType) {
			this.paperType = paperType;
		}

		public BaoJournalOrConf getJournalOrConf() {
			return journalOrConf;
		}

		public void setJournalOrConf(BaoJournalOrConf journalOrConf) {
			this.journalOrConf = journalOrConf;
		}
	}
	
	private class SubStepTwo implements Serializable{
		private static final long serialVersionUID = 1L;
		private ArrayList<GuiAuthor> authors;
		private boolean genTermOfUseAccepted;

		public SubStepTwo() {
			this.authors = new ArrayList<GuiAuthor>();
		}

		public ArrayList<GuiAuthor> getAuthors() {
			return authors;
		}
		
		public void addAuthor(String name, String institution, String email, boolean principal){
			GuiAuthor auth = new GuiAuthor(authors.size(), name, institution, email, principal);
			if(authors.contains(auth))
				return;
			if(authors.size() == 0)
				auth.setPrincipal(true);
			else{
				if(getPrincipalAuthor() == null)
					auth.setPrincipal(true);
				if(principal && getPrincipalAuthor() != null)
					getPrincipalAuthor().setPrincipal(false);
			}
			authors.add(auth);
		}

		public boolean isGenTermOfUseAccepted() {
			return genTermOfUseAccepted;
		}

		public void setGenTermOfUseAccepted(boolean genTermOfUseAccepted) {
			this.genTermOfUseAccepted = genTermOfUseAccepted;
		}

		public GuiAuthor getPrincipalAuthor() {
			for(GuiAuthor auth : authors)
				if(auth.isPrincipal())
					return auth;
			return null;
		}

		public void setPrincipalAuthor(int authorId) {
			getPrincipalAuthor().setPrincipal(false);
			authors.get(authorId).setPrincipal(true);
		}
	}
	
	private class SubStepThree implements Serializable{
		private static final long serialVersionUID = 1L;
		private ArrayList<GuiRefereeOrEditor> proposedReviewerOrEditors;

		public SubStepThree() {
			this.proposedReviewerOrEditors = new ArrayList<GuiRefereeOrEditor>();
		}

		public ArrayList<GuiRefereeOrEditor> getProposedReviewerOrEditors() {
			return proposedReviewerOrEditors;
		}
		
		public void addProposedReviewerOrEditor(String name, String institution, String email, String motivation){
			GuiRefereeOrEditor auth = new GuiRefereeOrEditor(proposedReviewerOrEditors.size(), name, institution, email, motivation);
			if(proposedReviewerOrEditors.contains(auth))
				return;
			proposedReviewerOrEditors.add(auth);
		}
	}

	private class SubStepFour implements Serializable{
		private static final long serialVersionUID = 1L;
		private ArrayList<GuiRefereeOrEditor> excludedReviewerOrEditors;

		public SubStepFour() {
			this.excludedReviewerOrEditors = new ArrayList<GuiRefereeOrEditor>();
		}

		public ArrayList<GuiRefereeOrEditor> getExcludedReviewerOrEditors() {
			return excludedReviewerOrEditors;
		}

		public void addExcludedReviewerOrEditor(String name, String institution, String email, String motivation){
			GuiRefereeOrEditor auth = new GuiRefereeOrEditor(excludedReviewerOrEditors.size(), name, institution, email, motivation);
			if(excludedReviewerOrEditors.contains(auth))
				return;
			excludedReviewerOrEditors.add(auth);
		}
	}

	private class SubStepFive implements Serializable{
		private static final long serialVersionUID = 1L;
		private String highlight;
		private String latexArchiveFile;
		private String otherMentions;

		public SubStepFive() {
			
		}

		public String getHighlight() {
			return highlight;
		}

		public void setHighlight(String highlight) {
			this.highlight = highlight;
		}

		public String getLatexArchiveFile() {
			return latexArchiveFile;
		}

		public void setLatexArchiveFile(String latexArchiveFile) {
			this.latexArchiveFile = latexArchiveFile;
		}

		public String getOtherMentions() {
			return otherMentions;
		}

		public void setOtherMentions(String otherMentions) {
			this.otherMentions = otherMentions;
		}
	}
}
