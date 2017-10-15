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
public class BaoPartnerUserPK implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "partner_id", nullable = false)
    private long partnerId;
    @Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    private long userId;

    public BaoPartnerUserPK() {
    }

    public BaoPartnerUserPK(long partnerId, long userId) {
        this.partnerId = partnerId;
        this.userId = userId;
    }

    public long getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(long partnerId) {
        this.partnerId = partnerId;
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
        hash += (int) partnerId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoPartnerUserPK)) {
            return false;
        }
        BaoPartnerUserPK other = (BaoPartnerUserPK) object;
        if (this.partnerId != other.partnerId) {
            return false;
        }
        return this.userId == other.userId;
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoPartnerUserPK[ partnerId=" + partnerId + ", userId=" + userId + " ]";
    }
}
