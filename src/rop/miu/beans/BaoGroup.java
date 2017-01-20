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
@Table(name = "bao_group", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"group_name"})})
@NamedQueries({
    @NamedQuery(name = "BaoGroup.findAll", query = "SELECT b FROM BaoGroup b"),
    @NamedQuery(name = "BaoGroup.findByGroupId", query = "SELECT b FROM BaoGroup b WHERE b.groupId = :groupId"),
    @NamedQuery(name = "BaoGroup.findByGroupName", query = "SELECT b FROM BaoGroup b WHERE b.groupName = :groupName"),
    @NamedQuery(name = "BaoGroup.findByGroupDesc", query = "SELECT b FROM BaoGroup b WHERE b.groupDesc = :groupDesc"),
    @NamedQuery(name = "BaoGroup.findByGroupState", query = "SELECT b FROM BaoGroup b WHERE b.groupState = :groupState")})
public class BaoGroup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "group_id", nullable = false)
    private Integer groupId;
    @Basic(optional = false)
    @Column(name = "group_name", nullable = false, length = 50)
    private String groupName;
    @Column(name = "group_desc", length = 2147483647)
    private String groupDesc;
    @Basic(optional = false)
    @Column(name = "group_state", nullable = false)
    private short groupState;
    @JoinTable(name = "bao_user_group", joinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<BaoUser> baoUserList;
    @ManyToMany(mappedBy = "baoGroupList", fetch = FetchType.LAZY)
    private List<BaoEmailAccount> baoEmailAccountList;
    @ManyToMany(mappedBy = "baoGroupList", fetch = FetchType.LAZY)
    private List<BaoAccessRight> baoAccessRightList;

    public BaoGroup() {
    }

    public BaoGroup(Integer groupId) {
        this.groupId = groupId;
    }

    public BaoGroup(Integer groupId, String groupName, short groupState) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupState = groupState;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public short getGroupState() {
        return groupState;
    }

    public void setGroupState(short groupState) {
        this.groupState = groupState;
    }

    public List<BaoUser> getBaoUserList() {
        return baoUserList;
    }

    public void setBaoUserList(List<BaoUser> baoUserList) {
        this.baoUserList = baoUserList;
    }

    public List<BaoEmailAccount> getBaoEmailAccountList() {
        return baoEmailAccountList;
    }

    public void setBaoEmailAccountList(List<BaoEmailAccount> baoEmailAccountList) {
        this.baoEmailAccountList = baoEmailAccountList;
    }

    public List<BaoAccessRight> getBaoAccessRightList() {
        return baoAccessRightList;
    }

    public void setBaoAccessRightList(List<BaoAccessRight> baoAccessRightList) {
        this.baoAccessRightList = baoAccessRightList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoGroup)) {
            return false;
        }
        BaoGroup other = (BaoGroup) object;
        return !((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoGroup[ groupId=" + groupId + " ]";
    }
}
