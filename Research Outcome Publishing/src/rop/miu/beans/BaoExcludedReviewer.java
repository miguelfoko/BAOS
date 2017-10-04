package rop.miu.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_excluded_reviewer")
@NamedQueries({
    @NamedQuery(name = "BaoExcludedReviewer.findAll", query = "SELECT b FROM BaoExcludedReviewer b"),
    @NamedQuery(name = "BaoExcludedReviewer.findByPaperId", query = "SELECT b FROM BaoExcludedReviewer b WHERE b.baoExcludedReviewerPK.paperId = :paperId"),
    @NamedQuery(name = "BaoExcludedReviewer.findByUserId", query = "SELECT b FROM BaoExcludedReviewer b WHERE b.baoExcludedReviewerPK.userId = :userId"),
    @NamedQuery(name = "BaoExcludedReviewer.findByExcludedReviewerMotivation", query = "SELECT b FROM BaoExcludedReviewer b WHERE b.excludedReviewerMotivation = :excludedReviewerMotivation")})
public class BaoExcludedReviewer implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BaoExcludedReviewerPK baoExcludedReviewerPK;
    @Basic(optional = false)
    @Column(name = "excluded_reviewer_motivation", nullable = false, length = 2147483647)
    private String excludedReviewerMotivation;
    @JoinColumn(name = "paper_id", referencedColumnName = "paper_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoPaper baoPaper;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser baoUser;

    public BaoExcludedReviewer() {
    }

    public BaoExcludedReviewer(BaoExcludedReviewerPK baoExcludedReviewerPK) {
        this.baoExcludedReviewerPK = baoExcludedReviewerPK;
    }

    public BaoExcludedReviewer(BaoExcludedReviewerPK baoExcludedReviewerPK, String excludedReviewerMotivation) {
        this.baoExcludedReviewerPK = baoExcludedReviewerPK;
        this.excludedReviewerMotivation = excludedReviewerMotivation;
    }

    public BaoExcludedReviewer(long paperId, long userId) {
        this.baoExcludedReviewerPK = new BaoExcludedReviewerPK(paperId, userId);
    }

    public BaoExcludedReviewerPK getBaoExcludedReviewerPK() {
        return baoExcludedReviewerPK;
    }

    public void setBaoExcludedReviewerPK(BaoExcludedReviewerPK baoExcludedReviewerPK) {
        this.baoExcludedReviewerPK = baoExcludedReviewerPK;
    }

    public String getExcludedReviewerMotivation() {
        return excludedReviewerMotivation;
    }

    public void setExcludedReviewerMotivation(String excludedReviewerMotivation) {
        this.excludedReviewerMotivation = excludedReviewerMotivation;
    }

    public BaoPaper getBaoPaper() {
        return baoPaper;
    }

    public void setBaoPaper(BaoPaper baoPaper) {
        this.baoPaper = baoPaper;
    }

    public BaoUser getBaoUser() {
        return baoUser;
    }

    public void setBaoUser(BaoUser baoUser) {
        this.baoUser = baoUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (baoExcludedReviewerPK != null ? baoExcludedReviewerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoExcludedReviewer)) {
            return false;
        }
        BaoExcludedReviewer other = (BaoExcludedReviewer) object;
        return !((this.baoExcludedReviewerPK == null && other.baoExcludedReviewerPK != null) || (this.baoExcludedReviewerPK != null && !this.baoExcludedReviewerPK.equals(other.baoExcludedReviewerPK)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoExcludedReviewer[ baoExcludedReviewerPK=" + baoExcludedReviewerPK + " ]";
    }
}
