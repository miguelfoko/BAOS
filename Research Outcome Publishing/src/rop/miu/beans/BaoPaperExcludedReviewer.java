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
@Table(name = "bao_paper_excluded_reviewer")
@NamedQueries({
    @NamedQuery(name = "BaoPaperExcludedReviewer.findAll", query = "SELECT b FROM BaoPaperExcludedReviewer b"),
    @NamedQuery(name = "BaoPaperExcludedReviewer.findByPaperId", query = "SELECT b FROM BaoPaperExcludedReviewer b WHERE b.baoPaperExcludedReviewerPK.paperId = :paperId"),
    @NamedQuery(name = "BaoPaperExcludedReviewer.findByUserId", query = "SELECT b FROM BaoPaperExcludedReviewer b WHERE b.baoPaperExcludedReviewerPK.userId = :userId"),
    @NamedQuery(name = "BaoPaperExcludedReviewer.findByExcludedReviewerMotivation", query = "SELECT b FROM BaoPaperExcludedReviewer b WHERE b.excludedReviewerMotivation = :excludedReviewerMotivation")})
public class BaoPaperExcludedReviewer implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BaoPaperExcludedReviewerPK baoPaperExcludedReviewerPK;
    @Basic(optional = false)
    @Column(name = "excluded_reviewer_motivation", nullable = false, length = 2147483647)
    private String excludedReviewerMotivation;
    @JoinColumn(name = "paper_id", referencedColumnName = "paper_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoPaper baoPaper;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser baoUser;

    public BaoPaperExcludedReviewer() {
    }

    public BaoPaperExcludedReviewer(BaoPaperExcludedReviewerPK baoPaperExcludedReviewerPK) {
        this.baoPaperExcludedReviewerPK = baoPaperExcludedReviewerPK;
    }

    public BaoPaperExcludedReviewer(BaoPaperExcludedReviewerPK baoPaperExcludedReviewerPK, String excludedReviewerMotivation) {
        this.baoPaperExcludedReviewerPK = baoPaperExcludedReviewerPK;
        this.excludedReviewerMotivation = excludedReviewerMotivation;
    }

    public BaoPaperExcludedReviewer(long paperId, long userId) {
        this.baoPaperExcludedReviewerPK = new BaoPaperExcludedReviewerPK(paperId, userId);
    }

    public BaoPaperExcludedReviewerPK getBaoExcludedReviewerPK() {
        return baoPaperExcludedReviewerPK;
    }

    public void setBaoExcludedReviewerPK(BaoPaperExcludedReviewerPK baoPaperExcludedReviewerPK) {
        this.baoPaperExcludedReviewerPK = baoPaperExcludedReviewerPK;
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
        hash += (baoPaperExcludedReviewerPK != null ? baoPaperExcludedReviewerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoPaperExcludedReviewer)) {
            return false;
        }
        BaoPaperExcludedReviewer other = (BaoPaperExcludedReviewer) object;
        return !((this.baoPaperExcludedReviewerPK == null && other.baoPaperExcludedReviewerPK != null) || (this.baoPaperExcludedReviewerPK != null && !this.baoPaperExcludedReviewerPK.equals(other.baoPaperExcludedReviewerPK)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoPaperExcludedReviewer[ baoPaperExcludedReviewerPK=" + baoPaperExcludedReviewerPK + " ]";
    }
}
