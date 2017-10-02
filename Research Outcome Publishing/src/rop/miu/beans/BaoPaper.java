package rop.miu.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_paper")
@NamedQueries({
    @NamedQuery(name = "BaoPaper.findAll", query = "SELECT b FROM BaoPaper b"),
    @NamedQuery(name = "BaoPaper.findByPaperId", query = "SELECT b FROM BaoPaper b WHERE b.paperId = :paperId"),
    @NamedQuery(name = "BaoPaper.findByPaperTitle", query = "SELECT b FROM BaoPaper b WHERE b.paperTitle = :paperTitle"),
    @NamedQuery(name = "BaoPaper.findByPaperAbstract", query = "SELECT b FROM BaoPaper b WHERE b.paperAbstract = :paperAbstract"),
    @NamedQuery(name = "BaoPaper.findByPaperKeywords", query = "SELECT b FROM BaoPaper b WHERE b.paperKeywords = :paperKeywords"),
    @NamedQuery(name = "BaoPaper.findByPaperAttachment", query = "SELECT b FROM BaoPaper b WHERE b.paperAttachment = :paperAttachment"),
    @NamedQuery(name = "BaoPaper.findByPaperCorrectionDate", query = "SELECT b FROM BaoPaper b WHERE b.paperCorrectionDate = :paperCorrectionDate"),
    @NamedQuery(name = "BaoPaper.findByPaperOtherMention", query = "SELECT b FROM BaoPaper b WHERE b.paperOtherMention = :paperOtherMention"),
    @NamedQuery(name = "BaoPaper.findByPaperState", query = "SELECT b FROM BaoPaper b WHERE b.paperState = :paperState"),
    @NamedQuery(name = "BaoPaper.findByPaperSubmissionDate", query = "SELECT b FROM BaoPaper b WHERE b.paperSubmissionDate = :paperSubmissionDate"),
    @NamedQuery(name = "BaoPaper.findByPaperValidationReport", query = "SELECT b FROM BaoPaper b WHERE b.paperValidationReport = :paperValidationReport"),
    @NamedQuery(name = "BaoPaper.findByPaperValidationDate", query = "SELECT b FROM BaoPaper b WHERE b.paperValidationDate = :paperValidationDate"),
    @NamedQuery(name = "BaoPaper.findByPaperValidationMark", query = "SELECT b FROM BaoPaper b WHERE b.paperValidationMark = :paperValidationMark"),
    @NamedQuery(name = "BaoPaper.findByPaperValidationState", query = "SELECT b FROM BaoPaper b WHERE b.paperValidationState = :paperValidationState")})
public class BaoPaper implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "paper_id", nullable = false)
    private Integer paperId;
    @Basic(optional = false)
    @Column(name = "paper_title", nullable = false, length = 2147483647)
    private String paperTitle;
    @Basic(optional = false)
    @Column(name = "paper_abstract", nullable = false, length = 2147483647)
    private String paperAbstract;
    @Basic(optional = false)
    @Column(name = "paper_keywords", nullable = false, length = 2147483647)
    private String paperKeywords;
    @Basic(optional = false)
    @Column(name = "paper_attachment", nullable = false, length = 255)
    private String paperAttachment;
    @Column(name = "paper_correction_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paperCorrectionDate;
    @Column(name = "paper_other_mention", length = 2147483647)
    private String paperOtherMention;
    @Basic(optional = false)
    @Column(name = "paper_state", nullable = false)
    private short paperState;
    @Basic(optional = false)
    @Column(name = "paper_submission_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date paperSubmissionDate;
    @Column(name = "paper_validation_report", length = 2147483647)
    private String paperValidationReport;
    @Column(name = "paper_validation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paperValidationDate;
    @Column(name = "paper_validation_mark", precision = 8, scale = 8)
    private Float paperValidationMark;
    @Basic(optional = false)
    @Column(name = "paper_validation_state", nullable = false)
    private short paperValidationState;
    @JoinTable(name = "bao_paper_topic", joinColumns = {
        @JoinColumn(name = "paper_id", referencedColumnName = "paper_id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "topic_id", referencedColumnName = "topic_id", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<BaoTopic> baoTopicList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baoPaper", fetch = FetchType.LAZY)
    private List<BaoPaperAuthor> baoPaperAuthorList;
    @JoinColumn(name = "user_id_paper_owner", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser userIdPaperOwner;
    @JoinColumn(name = "user_id_editor", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser userIdEditor;
    @JoinColumn(name = "volume_or_issue_id", referencedColumnName = "volume_or_issue_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoVolumeOrIssue volumeOrIssueId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baoPaper", fetch = FetchType.LAZY)
    private List<BaoPaperExcludedReviewer> baoExcludedReviewerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baoPaper", fetch = FetchType.LAZY)
    private List<BaoPaperReview> baoPaperReviewList;

    public BaoPaper() {
    }

    public BaoPaper(Integer paperId) {
        this.paperId = paperId;
    }

    public BaoPaper(Integer paperId, String paperTitle, String paperAbstract, String paperKeywords, String paperAttachment, short paperState, Date paperSubmissionDate, short paperValidationState) {
        this.paperId = paperId;
        this.paperTitle = paperTitle;
        this.paperAbstract = paperAbstract;
        this.paperKeywords = paperKeywords;
        this.paperAttachment = paperAttachment;
        this.paperState = paperState;
        this.paperSubmissionDate = paperSubmissionDate;
        this.paperValidationState = paperValidationState;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getPaperTitle() {
        return paperTitle;
    }

    public void setPaperTitle(String paperTitle) {
        this.paperTitle = paperTitle;
    }

    public String getPaperAbstract() {
        return paperAbstract;
    }

    public void setPaperAbstract(String paperAbstract) {
        this.paperAbstract = paperAbstract;
    }

    public String getPaperKeywords() {
        return paperKeywords;
    }

    public void setPaperKeywords(String paperKeywords) {
        this.paperKeywords = paperKeywords;
    }

    public String getPaperAttachment() {
        return paperAttachment;
    }

    public void setPaperAttachment(String paperAttachment) {
        this.paperAttachment = paperAttachment;
    }

    public Date getPaperCorrectionDate() {
        return paperCorrectionDate;
    }

    public void setPaperCorrectionDate(Date paperCorrectionDate) {
        this.paperCorrectionDate = paperCorrectionDate;
    }

    public String getPaperOtherMention() {
        return paperOtherMention;
    }

    public void setPaperOtherMention(String paperOtherMention) {
        this.paperOtherMention = paperOtherMention;
    }

    public short getPaperState() {
        return paperState;
    }

    public void setPaperState(short paperState) {
        this.paperState = paperState;
    }

    public Date getPaperSubmissionDate() {
        return paperSubmissionDate;
    }

    public void setPaperSubmissionDate(Date paperSubmissionDate) {
        this.paperSubmissionDate = paperSubmissionDate;
    }

    public String getPaperValidationReport() {
        return paperValidationReport;
    }

    public void setPaperValidationReport(String paperValidationReport) {
        this.paperValidationReport = paperValidationReport;
    }

    public Date getPaperValidationDate() {
        return paperValidationDate;
    }

    public void setPaperValidationDate(Date paperValidationDate) {
        this.paperValidationDate = paperValidationDate;
    }

    public Float getPaperValidationMark() {
        return paperValidationMark;
    }

    public void setPaperValidationMark(Float paperValidationMark) {
        this.paperValidationMark = paperValidationMark;
    }

    public short getPaperValidationState() {
        return paperValidationState;
    }

    public void setPaperValidationState(short paperValidationState) {
        this.paperValidationState = paperValidationState;
    }

    public List<BaoTopic> getBaoTopicList() {
        return baoTopicList;
    }

    public void setBaoTopicList(List<BaoTopic> baoTopicList) {
        this.baoTopicList = baoTopicList;
    }

    public List<BaoPaperAuthor> getBaoPaperAuthorList() {
        return baoPaperAuthorList;
    }

    public void setBaoPaperAuthorList(List<BaoPaperAuthor> baoPaperAuthorList) {
        this.baoPaperAuthorList = baoPaperAuthorList;
    }

    public BaoUser getUserIdPaperOwner() {
        return userIdPaperOwner;
    }

    public void setUserIdPaperOwner(BaoUser userIdPaperOwner) {
        this.userIdPaperOwner = userIdPaperOwner;
    }

    public BaoUser getUserIdEditor() {
        return userIdEditor;
    }

    public void setUserIdEditor(BaoUser userIdEditor) {
        this.userIdEditor = userIdEditor;
    }

    public BaoVolumeOrIssue getVolumeOrIssueId() {
        return volumeOrIssueId;
    }

    public void setVolumeOrIssueId(BaoVolumeOrIssue volumeOrIssueId) {
        this.volumeOrIssueId = volumeOrIssueId;
    }

    public List<BaoPaperExcludedReviewer> getBaoExcludedReviewerList() {
        return baoExcludedReviewerList;
    }

    public void setBaoExcludedReviewerList(List<BaoPaperExcludedReviewer> baoExcludedReviewerList) {
        this.baoExcludedReviewerList = baoExcludedReviewerList;
    }

    public List<BaoPaperReview> getBaoPaperReviewList() {
        return baoPaperReviewList;
    }

    public void setBaoPaperReviewList(List<BaoPaperReview> baoPaperReviewList) {
        this.baoPaperReviewList = baoPaperReviewList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paperId != null ? paperId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoPaper)) {
            return false;
        }
        BaoPaper other = (BaoPaper) object;
        return !((this.paperId == null && other.paperId != null) || (this.paperId != null && !this.paperId.equals(other.paperId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoPaper[ paperId=" + paperId + " ]";
    }
}
