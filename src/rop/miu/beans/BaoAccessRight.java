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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_access_right", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"access_right_name"})})
@NamedQueries({
    @NamedQuery(name = "BaoAccessRight.findAll", query = "SELECT b FROM BaoAccessRight b"),
    @NamedQuery(name = "BaoAccessRight.findByAccessRightId", query = "SELECT b FROM BaoAccessRight b WHERE b.accessRightId = :accessRightId"),
    @NamedQuery(name = "BaoAccessRight.findByAccessRightName", query = "SELECT b FROM BaoAccessRight b WHERE b.accessRightName = :accessRightName"),
    @NamedQuery(name = "BaoAccessRight.findByAccessRightDesc", query = "SELECT b FROM BaoAccessRight b WHERE b.accessRightDesc = :accessRightDesc"),
    @NamedQuery(name = "BaoAccessRight.findByAccessRightState", query = "SELECT b FROM BaoAccessRight b WHERE b.accessRightState = :accessRightState")})
public class BaoAccessRight implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "access_right_id", nullable = false)
    private Integer accessRightId;
    @Basic(optional = false)
    @Column(name = "access_right_name", nullable = false, length = 70)
    private String accessRightName;
    @Column(name = "access_right_desc", length = 2147483647)
    private String accessRightDesc;
    @Basic(optional = false)
    @Column(name = "access_right_state", nullable = false)
    private short accessRightState;
    @JoinTable(name = "bao_group_access_right", joinColumns = {
        @JoinColumn(name = "access_right_id", referencedColumnName = "access_right_id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<BaoGroup> baoGroupList;

    public BaoAccessRight() {
    }

    public BaoAccessRight(Integer accessRightId) {
        this.accessRightId = accessRightId;
    }

    public BaoAccessRight(Integer accessRightId, String accessRightName, short accessRightState) {
        this.accessRightId = accessRightId;
        this.accessRightName = accessRightName;
        this.accessRightState = accessRightState;
    }

    public Integer getAccessRightId() {
        return accessRightId;
    }

    public void setAccessRightId(Integer accessRightId) {
        this.accessRightId = accessRightId;
    }

    public String getAccessRightName() {
        return accessRightName;
    }

    public void setAccessRightName(String accessRightName) {
        this.accessRightName = accessRightName;
    }

    public String getAccessRightDesc() {
        return accessRightDesc;
    }

    public void setAccessRightDesc(String accessRightDesc) {
        this.accessRightDesc = accessRightDesc;
    }

    public short getAccessRightState() {
        return accessRightState;
    }

    public void setAccessRightState(short accessRightState) {
        this.accessRightState = accessRightState;
    }

    public List<BaoGroup> getBaoGroupList() {
        return baoGroupList;
    }

    public void setBaoGroupList(List<BaoGroup> baoGroupList) {
        this.baoGroupList = baoGroupList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessRightId != null ? accessRightId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoAccessRight)) {
            return false;
        }
        BaoAccessRight other = (BaoAccessRight) object;
        return !((this.accessRightId == null && other.accessRightId != null) || (this.accessRightId != null && !this.accessRightId.equals(other.accessRightId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoAccessRight[ accessRightId=" + accessRightId + " ]";
    }
}
