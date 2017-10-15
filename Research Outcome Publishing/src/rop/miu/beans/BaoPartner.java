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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "bao_partner", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"partner_name"})})
@NamedQueries({
    @NamedQuery(name = "BaoPartner.findAll", query = "SELECT b FROM BaoPartner b"),
    @NamedQuery(name = "BaoPartner.findByPartnerId", query = "SELECT b FROM BaoPartner b WHERE b.partnerId = :partnerId"),
    @NamedQuery(name = "BaoPartner.findByPartnerName", query = "SELECT b FROM BaoPartner b WHERE b.partnerName = :partnerName"),
    @NamedQuery(name = "BaoPartner.findByPartnerWebsite", query = "SELECT b FROM BaoPartner b WHERE b.partnerWebsite = :partnerWebsite"),
    @NamedQuery(name = "BaoPartner.findByPartnerLogo", query = "SELECT b FROM BaoPartner b WHERE b.partnerLogo = :partnerLogo"),
    @NamedQuery(name = "BaoPartner.findByPartnerDesc", query = "SELECT b FROM BaoPartner b WHERE b.partnerDesc = :partnerDesc"),
    @NamedQuery(name = "BaoPartner.findByPartnerState", query = "SELECT b FROM BaoPartner b WHERE b.partnerState = :partnerState")})
public class BaoPartner implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "partner_id", nullable = false)
    private Integer partnerId;
    @Basic(optional = false)
    @Column(name = "partner_name", nullable = false, length = 200)
    private String partnerName;
    @Column(name = "partner_website", length = 150)
    private String partnerWebsite;
    @Column(name = "partner_logo", length = 255)
    private String partnerLogo;
    @Column(name = "partner_desc", length = 2147483647)
    private String partnerDesc;
    @Basic(optional = false)
    @Column(name = "partner_state", nullable = false)
    private short partnerState;
    @JoinColumn(name = "user_id_associated_account", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser userIdAssociatedAccount;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baoPartner", fetch = FetchType.LAZY)
    private List<BaoPartnerUser> baoPartnerUserList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partnerId", fetch = FetchType.LAZY)
    private List<BaoPartnershipContract> baoPartnershipContractList;

    public BaoPartner() {
    }

    public BaoPartner(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public BaoPartner(Integer partnerId, String partnerName, short partnerState) {
        this.partnerId = partnerId;
        this.partnerName = partnerName;
        this.partnerState = partnerState;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getPartnerWebsite() {
        return partnerWebsite;
    }

    public void setPartnerWebsite(String partnerWebsite) {
        this.partnerWebsite = partnerWebsite;
    }

    public String getPartnerLogo() {
        return partnerLogo;
    }

    public void setPartnerLogo(String partnerLogo) {
        this.partnerLogo = partnerLogo;
    }

    public String getPartnerDesc() {
        return partnerDesc;
    }

    public void setPartnerDesc(String partnerDesc) {
        this.partnerDesc = partnerDesc;
    }

    public short getPartnerState() {
        return partnerState;
    }

    public void setPartnerState(short partnerState) {
        this.partnerState = partnerState;
    }

    public BaoUser getUserIdAssociatedAccount() {
        return userIdAssociatedAccount;
    }

    public void setUserIdAssociatedAccount(BaoUser userIdAssociatedAccount) {
        this.userIdAssociatedAccount = userIdAssociatedAccount;
    }

    public List<BaoPartnerUser> getBaoPartnerUserList() {
        return baoPartnerUserList;
    }

    public void setBaoPartnerUserList(List<BaoPartnerUser> baoPartnerUserList) {
        this.baoPartnerUserList = baoPartnerUserList;
    }

    public List<BaoPartnershipContract> getBaoPartnershipContractList() {
        return baoPartnershipContractList;
    }

    public void setBaoPartnershipContractList(List<BaoPartnershipContract> baoPartnershipContractList) {
        this.baoPartnershipContractList = baoPartnershipContractList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partnerId != null ? partnerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BaoPartner)) {
            return false;
        }
        BaoPartner other = (BaoPartner) object;
        if ((this.partnerId == null && other.partnerId != null) || (this.partnerId != null && !this.partnerId.equals(other.partnerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoPartner[ partnerId=" + partnerId + " ]";
    }
    
}
