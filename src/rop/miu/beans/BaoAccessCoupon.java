package rop.miu.beans;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_access_coupon")
@NamedQueries({
    @NamedQuery(name = "BaoAccessCoupon.findAll", query = "SELECT b FROM BaoAccessCoupon b"),
    @NamedQuery(name = "BaoAccessCoupon.findByAccessCouponId", query = "SELECT b FROM BaoAccessCoupon b WHERE b.accessCouponId = :accessCouponId"),
    @NamedQuery(name = "BaoAccessCoupon.findByAccessCouponNum", query = "SELECT b FROM BaoAccessCoupon b WHERE b.accessCouponNum = :accessCouponNum"),
    @NamedQuery(name = "BaoAccessCoupon.findByAccessCouponValidityEnd", query = "SELECT b FROM BaoAccessCoupon b WHERE b.accessCouponValidityEnd = :accessCouponValidityEnd"),
    @NamedQuery(name = "BaoAccessCoupon.findByAccessCouponState", query = "SELECT b FROM BaoAccessCoupon b WHERE b.accessCouponState = :accessCouponState")})
public class BaoAccessCoupon implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "access_coupon_id", nullable = false)
    private Integer accessCouponId;
    @Basic(optional = false)
    @Column(name = "access_coupon_num", nullable = false)
    private long accessCouponNum;
    @Basic(optional = false)
    @Column(name = "access_coupon_validity_end", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date accessCouponValidityEnd;
    @Basic(optional = false)
    @Column(name = "access_coupon_state", nullable = false)
    private short accessCouponState;
    @JoinColumn(name = "coupon_type_id", referencedColumnName = "coupon_type_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoCouponType couponTypeId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private BaoUser userId;

    public BaoAccessCoupon() {
    }

    public BaoAccessCoupon(Integer accessCouponId) {
        this.accessCouponId = accessCouponId;
    }

    public BaoAccessCoupon(Integer accessCouponId, long accessCouponNum, Date accessCouponValidityEnd, short accessCouponState) {
        this.accessCouponId = accessCouponId;
        this.accessCouponNum = accessCouponNum;
        this.accessCouponValidityEnd = accessCouponValidityEnd;
        this.accessCouponState = accessCouponState;
    }

    public Integer getAccessCouponId() {
        return accessCouponId;
    }

    public void setAccessCouponId(Integer accessCouponId) {
        this.accessCouponId = accessCouponId;
    }

    public long getAccessCouponNum() {
        return accessCouponNum;
    }

    public void setAccessCouponNum(long accessCouponNum) {
        this.accessCouponNum = accessCouponNum;
    }

    public Date getAccessCouponValidityEnd() {
        return accessCouponValidityEnd;
    }

    public void setAccessCouponValidityEnd(Date accessCouponValidityEnd) {
        this.accessCouponValidityEnd = accessCouponValidityEnd;
    }

    public short getAccessCouponState() {
        return accessCouponState;
    }

    public void setAccessCouponState(short accessCouponState) {
        this.accessCouponState = accessCouponState;
    }

    public BaoCouponType getCouponTypeId() {
        return couponTypeId;
    }

    public void setCouponTypeId(BaoCouponType couponTypeId) {
        this.couponTypeId = couponTypeId;
    }

    public BaoUser getUserId() {
        return userId;
    }

    public void setUserId(BaoUser userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessCouponId != null ? accessCouponId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoAccessCoupon)) {
            return false;
        }
        BaoAccessCoupon other = (BaoAccessCoupon) object;
        return !((this.accessCouponId == null && other.accessCouponId != null) || (this.accessCouponId != null && !this.accessCouponId.equals(other.accessCouponId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoAccessCoupon[ accessCouponId=" + accessCouponId + " ]";
    }
}
