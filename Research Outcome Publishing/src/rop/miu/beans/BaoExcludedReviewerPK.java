package rop.miu.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Ndadji Maxime
 */
@Embeddable
public class BaoExcludedReviewerPK implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "paper_id", nullable = false)
    private long paperId;
    @Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    private long userId;

    public BaoExcludedReviewerPK() {
    }

    public BaoExcludedReviewerPK(long paperId, long userId) {
        this.paperId = paperId;
        this.userId = userId;
    }

    public long getPaperId() {
        return paperId;
    }

    public void setPaperId(long paperId) {
        this.paperId = paperId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) paperId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoExcludedReviewerPK)) {
            return false;
        }
        BaoExcludedReviewerPK other = (BaoExcludedReviewerPK) object;
        if (this.paperId != other.paperId) {
            return false;
        }
        return this.userId == other.userId;
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoExcludedReviewerPK[ paperId=" + paperId + ", userId=" + userId + " ]";
    }
    
}
