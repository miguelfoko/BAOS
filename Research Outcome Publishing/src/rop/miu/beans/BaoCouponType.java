package rop.miu.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_coupon_type", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"coupon_type_name"})})
@NamedQueries({
    @NamedQuery(name = "BaoCouponType.findAll", query = "SELECT b FROM BaoCouponType b"),
    @NamedQuery(name = "BaoCouponType.findByCouponTypeId", query = "SELECT b FROM BaoCouponType b WHERE b.couponTypeId = :couponTypeId"),
    @NamedQuery(name = "BaoCouponType.findByCouponTypeName", query = "SELECT b FROM BaoCouponType b WHERE b.couponTypeName = :couponTypeName"),
    @NamedQuery(name = "BaoCouponType.findByCouponTypeDesc", query = "SELECT b FROM BaoCouponType b WHERE b.couponTypeDesc = :couponTypeDesc"),
    @NamedQuery(name = "BaoCouponType.findByCouponTypeState", query = "SELECT b FROM BaoCouponType b WHERE b.couponTypeState = :couponTypeState")})
public class BaoCouponType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "coupon_type_id", nullable = false)
    private Integer couponTypeId;
    @Basic(optional = false)
    @Column(name = "coupon_type_name", nullable = false, length = 70)
    private String couponTypeName;
    @Column(name = "coupon_type_desc", length = 2147483647)
    private String couponTypeDesc;
    @Basic(optional = false)
    @Column(name = "coupon_type_state", nullable = false)
    private short couponTypeState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "couponTypeId", fetch = FetchType.LAZY)
    private List<BaoAccessCoupon> baoAccessCouponList;

    public BaoCouponType() {
    }

    public BaoCouponType(Integer couponTypeId) {
        this.couponTypeId = couponTypeId;
    }

    public BaoCouponType(Integer couponTypeId, String couponTypeName, short couponTypeState) {
        this.couponTypeId = couponTypeId;
        this.couponTypeName = couponTypeName;
        this.couponTypeState = couponTypeState;
    }

    public Integer getCouponTypeId() {
        return couponTypeId;
    }

    public void setCouponTypeId(Integer couponTypeId) {
        this.couponTypeId = couponTypeId;
    }

    public String getCouponTypeName() {
        return couponTypeName;
    }

    public void setCouponTypeName(String couponTypeName) {
        this.couponTypeName = couponTypeName;
    }

    public String getCouponTypeDesc() {
        return couponTypeDesc;
    }

    public void setCouponTypeDesc(String couponTypeDesc) {
        this.couponTypeDesc = couponTypeDesc;
    }

    public short getCouponTypeState() {
        return couponTypeState;
    }

    public void setCouponTypeState(short couponTypeState) {
        this.couponTypeState = couponTypeState;
    }

    public List<BaoAccessCoupon> getBaoAccessCouponList() {
        return baoAccessCouponList;
    }

    public void setBaoAccessCouponList(List<BaoAccessCoupon> baoAccessCouponList) {
        this.baoAccessCouponList = baoAccessCouponList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (couponTypeId != null ? couponTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoCouponType)) {
            return false;
        }
        BaoCouponType other = (BaoCouponType) object;
        if ((this.couponTypeId == null && other.couponTypeId != null) || (this.couponTypeId != null && !this.couponTypeId.equals(other.couponTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoCouponType[ couponTypeId=" + couponTypeId + " ]";
    }
}
