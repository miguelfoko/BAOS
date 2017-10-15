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
public class BaoPaperAuthorPK implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    private long userId;
    @Basic(optional = false)
    @Column(name = "paper_id", nullable = false)
    private long paperId;

    public BaoPaperAuthorPK() {
    }

    public BaoPaperAuthorPK(long userId, long paperId) {
        this.userId = userId;
        this.paperId = paperId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getPaperId() {
        return paperId;
    }

    public void setPaperId(long paperId) {
        this.paperId = paperId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) paperId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoPaperAuthorPK)) {
            return false;
        }
        BaoPaperAuthorPK other = (BaoPaperAuthorPK) object;
        if (this.userId != other.userId) {
            return false;
        }
        return this.paperId == other.paperId;
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoPaperAuthorPK[ userId=" + userId + ", paperId=" + paperId + " ]";
    }
}
