package rop.miu.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_automatic_review_condition")
@NamedQueries({
    @NamedQuery(name = "BaoAutomaticReviewCondition.findAll", query = "SELECT b FROM BaoAutomaticReviewCondition b"),
    @NamedQuery(name = "BaoAutomaticReviewCondition.findByReviewConditionId", query = "SELECT b FROM BaoAutomaticReviewCondition b WHERE b.reviewConditionId = :reviewConditionId"),
    @NamedQuery(name = "BaoAutomaticReviewCondition.findByReviewConditionName", query = "SELECT b FROM BaoAutomaticReviewCondition b WHERE b.reviewConditionName = :reviewConditionName"),
    @NamedQuery(name = "BaoAutomaticReviewCondition.findByReviewConditionMaxReviewers", query = "SELECT b FROM BaoAutomaticReviewCondition b WHERE b.reviewConditionMaxReviewers = :reviewConditionMaxReviewers"),
    @NamedQuery(name = "BaoAutomaticReviewCondition.findByReviewConditionPaperSuccessPourcentage", query = "SELECT b FROM BaoAutomaticReviewCondition b WHERE b.reviewConditionPaperSuccessPourcentage = :reviewConditionPaperSuccessPourcentage"),
    @NamedQuery(name = "BaoAutomaticReviewCondition.findByReviewConditionMaxPaperAllowed", query = "SELECT b FROM BaoAutomaticReviewCondition b WHERE b.reviewConditionMaxPaperAllowed = :reviewConditionMaxPaperAllowed"),
    @NamedQuery(name = "BaoAutomaticReviewCondition.findByReviewConditionAcceptWithoutEditor", query = "SELECT b FROM BaoAutomaticReviewCondition b WHERE b.reviewConditionAcceptWithoutEditor = :reviewConditionAcceptWithoutEditor"),
    @NamedQuery(name = "BaoAutomaticReviewCondition.findByReviewConditionState", query = "SELECT b FROM BaoAutomaticReviewCondition b WHERE b.reviewConditionState = :reviewConditionState")})
public class BaoAutomaticReviewCondition implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "review_condition_id", nullable = false)
    private Integer reviewConditionId;
    @Basic(optional = false)
    @Column(name = "review_condition_name", nullable = false, length = 255)
    private String reviewConditionName;
    @Basic(optional = false)
    @Column(name = "review_condition_max_reviewers", nullable = false)
    private short reviewConditionMaxReviewers;
    @Basic(optional = false)
    @Column(name = "review_condition_paper_success_pourcentage", nullable = false)
    private float reviewConditionPaperSuccessPourcentage;
    @Column(name = "review_condition_max_paper_allowed")
    private Integer reviewConditionMaxPaperAllowed;
    @Basic(optional = false)
    @Column(name = "review_condition_accept_without_editor", nullable = false)
    private boolean reviewConditionAcceptWithoutEditor;
    @Basic(optional = false)
    @Column(name = "review_condition_state", nullable = false)
    private short reviewConditionState;
    @JoinColumn(name = "user_id_automatic_editor", referencedColumnName = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private BaoUser userIdAutomaticEditor;
    @OneToMany(mappedBy = "reviewConditionId", fetch = FetchType.LAZY)
    private List<BaoVolumeOrIssue> baoVolumeOrIssueList;

    public BaoAutomaticReviewCondition() {
    }

    public BaoAutomaticReviewCondition(Integer reviewConditionId) {
        this.reviewConditionId = reviewConditionId;
    }

    public BaoAutomaticReviewCondition(Integer reviewConditionId, String reviewConditionName, short reviewConditionMaxReviewers, float reviewConditionPaperSuccessPourcentage, boolean reviewConditionAcceptWithoutEditor, short reviewConditionState) {
        this.reviewConditionId = reviewConditionId;
        this.reviewConditionName = reviewConditionName;
        this.reviewConditionMaxReviewers = reviewConditionMaxReviewers;
        this.reviewConditionPaperSuccessPourcentage = reviewConditionPaperSuccessPourcentage;
        this.reviewConditionAcceptWithoutEditor = reviewConditionAcceptWithoutEditor;
        this.reviewConditionState = reviewConditionState;
    }

    public Integer getReviewConditionId() {
        return reviewConditionId;
    }

    public void setReviewConditionId(Integer reviewConditionId) {
        this.reviewConditionId = reviewConditionId;
    }

    public String getReviewConditionName() {
        return reviewConditionName;
    }

    public void setReviewConditionName(String reviewConditionName) {
        this.reviewConditionName = reviewConditionName;
    }

    public short getReviewConditionMaxReviewers() {
        return reviewConditionMaxReviewers;
    }

    public void setReviewConditionMaxReviewers(short reviewConditionMaxReviewers) {
        this.reviewConditionMaxReviewers = reviewConditionMaxReviewers;
    }

    public float getReviewConditionPaperSuccessPourcentage() {
        return reviewConditionPaperSuccessPourcentage;
    }

    public void setReviewConditionPaperSuccessPourcentage(float reviewConditionPaperSuccessPourcentage) {
        this.reviewConditionPaperSuccessPourcentage = reviewConditionPaperSuccessPourcentage;
    }

    public Integer getReviewConditionMaxPaperAllowed() {
        return reviewConditionMaxPaperAllowed;
    }

    public void setReviewConditionMaxPaperAllowed(Integer reviewConditionMaxPaperAllowed) {
        this.reviewConditionMaxPaperAllowed = reviewConditionMaxPaperAllowed;
    }

    public boolean getReviewConditionAcceptWithoutEditor() {
        return reviewConditionAcceptWithoutEditor;
    }

    public void setReviewConditionAcceptWithoutEditor(boolean reviewConditionAcceptWithoutEditor) {
        this.reviewConditionAcceptWithoutEditor = reviewConditionAcceptWithoutEditor;
    }

    public short getReviewConditionState() {
        return reviewConditionState;
    }

    public void setReviewConditionState(short reviewConditionState) {
        this.reviewConditionState = reviewConditionState;
    }

    public BaoUser getUserIdAutomaticEditor() {
        return userIdAutomaticEditor;
    }

    public void setUserIdAutomaticEditor(BaoUser userIdAutomaticEditor) {
        this.userIdAutomaticEditor = userIdAutomaticEditor;
    }

    public List<BaoVolumeOrIssue> getBaoVolumeOrIssueList() {
        return baoVolumeOrIssueList;
    }

    public void setBaoVolumeOrIssueList(List<BaoVolumeOrIssue> baoVolumeOrIssueList) {
        this.baoVolumeOrIssueList = baoVolumeOrIssueList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewConditionId != null ? reviewConditionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoAutomaticReviewCondition)) {
            return false;
        }
        BaoAutomaticReviewCondition other = (BaoAutomaticReviewCondition) object;
        return !((this.reviewConditionId == null && other.reviewConditionId != null) || (this.reviewConditionId != null && !this.reviewConditionId.equals(other.reviewConditionId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoAutomaticReviewCondition[ reviewConditionId=" + reviewConditionId + " ]";
    }
}
