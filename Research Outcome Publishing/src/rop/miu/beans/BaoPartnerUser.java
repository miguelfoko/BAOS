package rop.miu.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_partner_user")
@NamedQueries({
    @NamedQuery(name = "BaoPartnerUser.findAll", query = "SELECT b FROM BaoPartnerUser b"),
    @NamedQuery(name = "BaoPartnerUser.findByPartnerId", query = "SELECT b FROM BaoPartnerUser b WHERE b.baoPartnerUserPK.partnerId = :partnerId"),
    @NamedQuery(name = "BaoPartnerUser.findByUserId", query = "SELECT b FROM BaoPartnerUser b WHERE b.baoPartnerUserPK.userId = :userId"),
    @NamedQuery(name = "BaoPartnerUser.findByPartnerUserDate", query = "SELECT b FROM BaoPartnerUser b WHERE b.partnerUserDate = :partnerUserDate")})
public class BaoPartnerUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BaoPartnerUserPK baoPartnerUserPK;
    @Column(name = "partner_user_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date partnerUserDate;
    @JoinColumn(name = "partner_id", referencedColumnName = "partner_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoPartner baoPartner;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser baoUser;

    public BaoPartnerUser() {
    }

    public BaoPartnerUser(BaoPartnerUserPK baoPartnerUserPK) {
        this.baoPartnerUserPK = baoPartnerUserPK;
    }

    public BaoPartnerUser(long partnerId, long userId) {
        this.baoPartnerUserPK = new BaoPartnerUserPK(partnerId, userId);
    }

    public BaoPartnerUserPK getBaoPartnerUserPK() {
        return baoPartnerUserPK;
    }

    public void setBaoPartnerUserPK(BaoPartnerUserPK baoPartnerUserPK) {
        this.baoPartnerUserPK = baoPartnerUserPK;
    }

    public Date getPartnerUserDate() {
        return partnerUserDate;
    }

    public void setPartnerUserDate(Date partnerUserDate) {
        this.partnerUserDate = partnerUserDate;
    }

    public BaoPartner getBaoPartner() {
        return baoPartner;
    }

    public void setBaoPartner(BaoPartner baoPartner) {
        this.baoPartner = baoPartner;
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
        hash += (baoPartnerUserPK != null ? baoPartnerUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoPartnerUser)) {
            return false;
        }
        BaoPartnerUser other = (BaoPartnerUser) object;
        return !((this.baoPartnerUserPK == null && other.baoPartnerUserPK != null) || (this.baoPartnerUserPK != null && !this.baoPartnerUserPK.equals(other.baoPartnerUserPK)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoPartnerUser[ baoPartnerUserPK=" + baoPartnerUserPK + " ]";
    }
}
