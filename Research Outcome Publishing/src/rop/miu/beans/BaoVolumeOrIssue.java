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
@Table(name = "bao_volume_or_issue")
@NamedQueries({
    @NamedQuery(name = "BaoVolumeOrIssue.findAll", query = "SELECT b FROM BaoVolumeOrIssue b"),
    @NamedQuery(name = "BaoVolumeOrIssue.findByVolumeOrIssueId", query = "SELECT b FROM BaoVolumeOrIssue b WHERE b.volumeOrIssueId = :volumeOrIssueId"),
    @NamedQuery(name = "BaoVolumeOrIssue.findByVolumeOrIssueIdentifier", query = "SELECT b FROM BaoVolumeOrIssue b WHERE b.volumeOrIssueIdentifier = :volumeOrIssueIdentifier"),
    @NamedQuery(name = "BaoVolumeOrIssue.findByVolumeOrIssueSubmissionDeadline", query = "SELECT b FROM BaoVolumeOrIssue b WHERE b.volumeOrIssueSubmissionDeadline = :volumeOrIssueSubmissionDeadline"),
    @NamedQuery(name = "BaoVolumeOrIssue.findByVolumeOrIssueDesc", query = "SELECT b FROM BaoVolumeOrIssue b WHERE b.volumeOrIssueDesc = :volumeOrIssueDesc"),
    @NamedQuery(name = "BaoVolumeOrIssue.findByVolumeOrIssueState", query = "SELECT b FROM BaoVolumeOrIssue b WHERE b.volumeOrIssueState = :volumeOrIssueState")})
public class BaoVolumeOrIssue implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "volume_or_issue_id", nullable = false)
    private Integer volumeOrIssueId;
    @Basic(optional = false)
    @Column(name = "volume_or_issue_identifier", nullable = false, length = 255)
    private String volumeOrIssueIdentifier;
    @Basic(optional = false)
    @Column(name = "volume_or_issue_submission_deadline", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date volumeOrIssueSubmissionDeadline;
    @Column(name = "volume_or_issue_desc", length = 2147483647)
    private String volumeOrIssueDesc;
    @Basic(optional = false)
    @Column(name = "volume_or_issue_state", nullable = false)
    private short volumeOrIssueState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "volumeOrIssueId", fetch = FetchType.LAZY)
    private List<BaoPaper> baoPaperList;
    @JoinColumn(name = "review_condition_id", referencedColumnName = "review_condition_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private BaoAutomaticReviewCondition reviewConditionId;
    @JoinColumn(name = "journal_or_conf_id", referencedColumnName = "journal_or_conf_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoJournalOrConf journalOrConfId;
    @JoinColumn(name = "news_id_call_for_paper", referencedColumnName = "news_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private BaoNews newsIdCallForPaper;

    public BaoVolumeOrIssue() {
    }

    public BaoVolumeOrIssue(Integer volumeOrIssueId) {
        this.volumeOrIssueId = volumeOrIssueId;
    }

    public BaoVolumeOrIssue(Integer volumeOrIssueId, String volumeOrIssueIdentifier, Date volumeOrIssueSubmissionDeadline, short volumeOrIssueState) {
        this.volumeOrIssueId = volumeOrIssueId;
        this.volumeOrIssueIdentifier = volumeOrIssueIdentifier;
        this.volumeOrIssueSubmissionDeadline = volumeOrIssueSubmissionDeadline;
        this.volumeOrIssueState = volumeOrIssueState;
    }

    public Integer getVolumeOrIssueId() {
        return volumeOrIssueId;
    }

    public void setVolumeOrIssueId(Integer volumeOrIssueId) {
        this.volumeOrIssueId = volumeOrIssueId;
    }

    public String getVolumeOrIssueIdentifier() {
        return volumeOrIssueIdentifier;
    }

    public void setVolumeOrIssueIdentifier(String volumeOrIssueIdentifier) {
        this.volumeOrIssueIdentifier = volumeOrIssueIdentifier;
    }

    public Date getVolumeOrIssueSubmissionDeadline() {
        return volumeOrIssueSubmissionDeadline;
    }

    public void setVolumeOrIssueSubmissionDeadline(Date volumeOrIssueSubmissionDeadline) {
        this.volumeOrIssueSubmissionDeadline = volumeOrIssueSubmissionDeadline;
    }

    public String getVolumeOrIssueDesc() {
        return volumeOrIssueDesc;
    }

    public void setVolumeOrIssueDesc(String volumeOrIssueDesc) {
        this.volumeOrIssueDesc = volumeOrIssueDesc;
    }

    public short getVolumeOrIssueState() {
        return volumeOrIssueState;
    }

    public void setVolumeOrIssueState(short volumeOrIssueState) {
        this.volumeOrIssueState = volumeOrIssueState;
    }

    public List<BaoPaper> getBaoPaperList() {
        return baoPaperList;
    }

    public void setBaoPaperList(List<BaoPaper> baoPaperList) {
        this.baoPaperList = baoPaperList;
    }

    public BaoAutomaticReviewCondition getReviewConditionId() {
        return reviewConditionId;
    }

    public void setReviewConditionId(BaoAutomaticReviewCondition reviewConditionId) {
        this.reviewConditionId = reviewConditionId;
    }

    public BaoJournalOrConf getJournalOrConfId() {
        return journalOrConfId;
    }

    public void setJournalOrConfId(BaoJournalOrConf journalOrConfId) {
        this.journalOrConfId = journalOrConfId;
    }

    public BaoNews getNewsIdCallForPaper() {
        return newsIdCallForPaper;
    }

    public void setNewsIdCallForPaper(BaoNews newsIdCallForPaper) {
        this.newsIdCallForPaper = newsIdCallForPaper;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (volumeOrIssueId != null ? volumeOrIssueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoVolumeOrIssue)) {
            return false;
        }
        BaoVolumeOrIssue other = (BaoVolumeOrIssue) object;
        return !((this.volumeOrIssueId == null && other.volumeOrIssueId != null) || (this.volumeOrIssueId != null && !this.volumeOrIssueId.equals(other.volumeOrIssueId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoVolumeOrIssue[ volumeOrIssueId=" + volumeOrIssueId + " ]";
    }
}
