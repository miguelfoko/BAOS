package rop.miu.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "bao_partnership_contract")
@NamedQueries({
    @NamedQuery(name = "BaoPartnershipContract.findAll", query = "SELECT b FROM BaoPartnershipContract b"),
    @NamedQuery(name = "BaoPartnershipContract.findByPartnershipContractId", query = "SELECT b FROM BaoPartnershipContract b WHERE b.partnershipContractId = :partnershipContractId"),
    @NamedQuery(name = "BaoPartnershipContract.findByPartnershipContractStartTime", query = "SELECT b FROM BaoPartnershipContract b WHERE b.partnershipContractStartTime = :partnershipContractStartTime"),
    @NamedQuery(name = "BaoPartnershipContract.findByPartnershipContractLength", query = "SELECT b FROM BaoPartnershipContract b WHERE b.partnershipContractLength = :partnershipContractLength"),
    @NamedQuery(name = "BaoPartnershipContract.findByPartnershipContractLengthUnit", query = "SELECT b FROM BaoPartnershipContract b WHERE b.partnershipContractLengthUnit = :partnershipContractLengthUnit"),
    @NamedQuery(name = "BaoPartnershipContract.findByPartnershipContractDesc", query = "SELECT b FROM BaoPartnershipContract b WHERE b.partnershipContractDesc = :partnershipContractDesc"),
    @NamedQuery(name = "BaoPartnershipContract.findByPartnershipContractState", query = "SELECT b FROM BaoPartnershipContract b WHERE b.partnershipContractState = :partnershipContractState")})
public class BaoPartnershipContract implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "partnership_contract_id", nullable = false)
    private Integer partnershipContractId;
    @Basic(optional = false)
    @Column(name = "partnership_contract_start_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date partnershipContractStartTime;
    @Basic(optional = false)
    @Column(name = "partnership_contract_length", nullable = false)
    private int partnershipContractLength;
    @Basic(optional = false)
    @Column(name = "partnership_contract_length_unit", nullable = false, length = 10)
    private String partnershipContractLengthUnit;
    @Column(name = "partnership_contract_desc", length = 2147483647)
    private String partnershipContractDesc;
    @Basic(optional = false)
    @Column(name = "partnership_contract_state", nullable = false)
    private short partnershipContractState;
    @ManyToMany(mappedBy = "baoPartnershipContractList", fetch = FetchType.LAZY)
    private List<BaoPartnershipAccessRight> baoPartnershipAccessRightList;
    @JoinColumn(name = "partner_id", referencedColumnName = "partner_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoPartner partnerId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser userId;

    public BaoPartnershipContract() {
    }

    public BaoPartnershipContract(Integer partnershipContractId) {
        this.partnershipContractId = partnershipContractId;
    }

    public BaoPartnershipContract(Integer partnershipContractId, Date partnershipContractStartTime, int partnershipContractLength, String partnershipContractLengthUnit, short partnershipContractState) {
        this.partnershipContractId = partnershipContractId;
        this.partnershipContractStartTime = partnershipContractStartTime;
        this.partnershipContractLength = partnershipContractLength;
        this.partnershipContractLengthUnit = partnershipContractLengthUnit;
        this.partnershipContractState = partnershipContractState;
    }

    public Integer getPartnershipContractId() {
        return partnershipContractId;
    }

    public void setPartnershipContractId(Integer partnershipContractId) {
        this.partnershipContractId = partnershipContractId;
    }

    public Date getPartnershipContractStartTime() {
        return partnershipContractStartTime;
    }

    public void setPartnershipContractStartTime(Date partnershipContractStartTime) {
        this.partnershipContractStartTime = partnershipContractStartTime;
    }

    public int getPartnershipContractLength() {
        return partnershipContractLength;
    }

    public void setPartnershipContractLength(int partnershipContractLength) {
        this.partnershipContractLength = partnershipContractLength;
    }

    public String getPartnershipContractLengthUnit() {
        return partnershipContractLengthUnit;
    }

    public void setPartnershipContractLengthUnit(String partnershipContractLengthUnit) {
        this.partnershipContractLengthUnit = partnershipContractLengthUnit;
    }

    public String getPartnershipContractDesc() {
        return partnershipContractDesc;
    }

    public void setPartnershipContractDesc(String partnershipContractDesc) {
        this.partnershipContractDesc = partnershipContractDesc;
    }

    public short getPartnershipContractState() {
        return partnershipContractState;
    }

    public void setPartnershipContractState(short partnershipContractState) {
        this.partnershipContractState = partnershipContractState;
    }

    public List<BaoPartnershipAccessRight> getBaoPartnershipAccessRightList() {
        return baoPartnershipAccessRightList;
    }

    public void setBaoPartnershipAccessRightList(List<BaoPartnershipAccessRight> baoPartnershipAccessRightList) {
        this.baoPartnershipAccessRightList = baoPartnershipAccessRightList;
    }

    public BaoPartner getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(BaoPartner partnerId) {
        this.partnerId = partnerId;
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
        hash += (partnershipContractId != null ? partnershipContractId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoPartnershipContract)) {
            return false;
        }
        BaoPartnershipContract other = (BaoPartnershipContract) object;
        return !((this.partnershipContractId == null && other.partnershipContractId != null) || (this.partnershipContractId != null && !this.partnershipContractId.equals(other.partnershipContractId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoPartnershipContract[ partnershipContractId=" + partnershipContractId + " ]";
    }
}
