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

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_email_account")
@NamedQueries({
    @NamedQuery(name = "BaoEmailAccount.findAll", query = "SELECT b FROM BaoEmailAccount b"),
    @NamedQuery(name = "BaoEmailAccount.findByEmailAccountId", query = "SELECT b FROM BaoEmailAccount b WHERE b.emailAccountId = :emailAccountId"),
    @NamedQuery(name = "BaoEmailAccount.findByEmailAccountName", query = "SELECT b FROM BaoEmailAccount b WHERE b.emailAccountName = :emailAccountName"),
    @NamedQuery(name = "BaoEmailAccount.findByEmailAccountEmail", query = "SELECT b FROM BaoEmailAccount b WHERE b.emailAccountEmail = :emailAccountEmail"),
    @NamedQuery(name = "BaoEmailAccount.findByEmailAccountDesc", query = "SELECT b FROM BaoEmailAccount b WHERE b.emailAccountDesc = :emailAccountDesc"),
    @NamedQuery(name = "BaoEmailAccount.findByEmailAccountState", query = "SELECT b FROM BaoEmailAccount b WHERE b.emailAccountState = :emailAccountState")})
public class BaoEmailAccount implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "email_account_id", nullable = false)
    private Integer emailAccountId;
    @Basic(optional = false)
    @Column(name = "email_account_name", nullable = false, length = 255)
    private String emailAccountName;
    @Basic(optional = false)
    @Column(name = "email_account_email", nullable = false, length = 150)
    private String emailAccountEmail;
    @Column(name = "email_account_desc", length = 2147483647)
    private String emailAccountDesc;
    @Basic(optional = false)
    @Column(name = "email_account_state", nullable = false)
    private short emailAccountState;
    @JoinTable(name = "bao_group_email_account", joinColumns = {
        @JoinColumn(name = "email_account_id", referencedColumnName = "email_account_id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<BaoGroup> baoGroupList;

    public BaoEmailAccount() {
    }

    public BaoEmailAccount(Integer emailAccountId) {
        this.emailAccountId = emailAccountId;
    }

    public BaoEmailAccount(Integer emailAccountId, String emailAccountName, String emailAccountEmail, short emailAccountState) {
        this.emailAccountId = emailAccountId;
        this.emailAccountName = emailAccountName;
        this.emailAccountEmail = emailAccountEmail;
        this.emailAccountState = emailAccountState;
    }

    public Integer getEmailAccountId() {
        return emailAccountId;
    }

    public void setEmailAccountId(Integer emailAccountId) {
        this.emailAccountId = emailAccountId;
    }

    public String getEmailAccountName() {
        return emailAccountName;
    }

    public void setEmailAccountName(String emailAccountName) {
        this.emailAccountName = emailAccountName;
    }

    public String getEmailAccountEmail() {
        return emailAccountEmail;
    }

    public void setEmailAccountEmail(String emailAccountEmail) {
        this.emailAccountEmail = emailAccountEmail;
    }

    public String getEmailAccountDesc() {
        return emailAccountDesc;
    }

    public void setEmailAccountDesc(String emailAccountDesc) {
        this.emailAccountDesc = emailAccountDesc;
    }

    public short getEmailAccountState() {
        return emailAccountState;
    }

    public void setEmailAccountState(short emailAccountState) {
        this.emailAccountState = emailAccountState;
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
        hash += (emailAccountId != null ? emailAccountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoEmailAccount)) {
            return false;
        }
        BaoEmailAccount other = (BaoEmailAccount) object;
        return !((this.emailAccountId == null && other.emailAccountId != null) || (this.emailAccountId != null && !this.emailAccountId.equals(other.emailAccountId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoEmailAccount[ emailAccountId=" + emailAccountId + " ]";
    }
}
