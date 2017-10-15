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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "bao_mailing_list")
@NamedQueries({
    @NamedQuery(name = "BaoMailingList.findAll", query = "SELECT b FROM BaoMailingList b"),
    @NamedQuery(name = "BaoMailingList.findByMailingListId", query = "SELECT b FROM BaoMailingList b WHERE b.mailingListId = :mailingListId"),
    @NamedQuery(name = "BaoMailingList.findByMailingListName", query = "SELECT b FROM BaoMailingList b WHERE b.mailingListName = :mailingListName"),
    @NamedQuery(name = "BaoMailingList.findByMailingListCreationDate", query = "SELECT b FROM BaoMailingList b WHERE b.mailingListCreationDate = :mailingListCreationDate"),
    @NamedQuery(name = "BaoMailingList.findByMailingListAdditionalEmail", query = "SELECT b FROM BaoMailingList b WHERE b.mailingListAdditionalEmail = :mailingListAdditionalEmail"),
    @NamedQuery(name = "BaoMailingList.findByMailingListDesc", query = "SELECT b FROM BaoMailingList b WHERE b.mailingListDesc = :mailingListDesc"),
    @NamedQuery(name = "BaoMailingList.findByMailingListState", query = "SELECT b FROM BaoMailingList b WHERE b.mailingListState = :mailingListState")})
public class BaoMailingList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mailing_list_id", nullable = false)
    private Integer mailingListId;
    @Basic(optional = false)
    @Column(name = "mailing_list_name", nullable = false, length = 255)
    private String mailingListName;
    @Basic(optional = false)
    @Column(name = "mailing_list_creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date mailingListCreationDate;
    @Column(name = "mailing_list_additional_email", length = 2147483647)
    private String mailingListAdditionalEmail;
    @Column(name = "mailing_list_desc", length = 2147483647)
    private String mailingListDesc;
    @Basic(optional = false)
    @Column(name = "mailing_list_state", nullable = false)
    private short mailingListState;
    @JoinTable(name = "bao_mailing_list_user", joinColumns = {
        @JoinColumn(name = "mailing_list_id", referencedColumnName = "mailing_list_id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<BaoUser> baoUserList;
    @JoinTable(name = "bao_programmed_email_receiver", joinColumns = {
        @JoinColumn(name = "mailing_list_id", referencedColumnName = "mailing_list_id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "programmed_email_id", referencedColumnName = "programmed_email_id", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<BaoProgrammedEmail> baoProgrammedEmailList;

    public BaoMailingList() {
    }

    public BaoMailingList(Integer mailingListId) {
        this.mailingListId = mailingListId;
    }

    public BaoMailingList(Integer mailingListId, String mailingListName, Date mailingListCreationDate, short mailingListState) {
        this.mailingListId = mailingListId;
        this.mailingListName = mailingListName;
        this.mailingListCreationDate = mailingListCreationDate;
        this.mailingListState = mailingListState;
    }

    public Integer getMailingListId() {
        return mailingListId;
    }

    public void setMailingListId(Integer mailingListId) {
        this.mailingListId = mailingListId;
    }

    public String getMailingListName() {
        return mailingListName;
    }

    public void setMailingListName(String mailingListName) {
        this.mailingListName = mailingListName;
    }

    public Date getMailingListCreationDate() {
        return mailingListCreationDate;
    }

    public void setMailingListCreationDate(Date mailingListCreationDate) {
        this.mailingListCreationDate = mailingListCreationDate;
    }

    public String getMailingListAdditionalEmail() {
        return mailingListAdditionalEmail;
    }

    public void setMailingListAdditionalEmail(String mailingListAdditionalEmail) {
        this.mailingListAdditionalEmail = mailingListAdditionalEmail;
    }

    public String getMailingListDesc() {
        return mailingListDesc;
    }

    public void setMailingListDesc(String mailingListDesc) {
        this.mailingListDesc = mailingListDesc;
    }

    public short getMailingListState() {
        return mailingListState;
    }

    public void setMailingListState(short mailingListState) {
        this.mailingListState = mailingListState;
    }

    public List<BaoUser> getBaoUserList() {
        return baoUserList;
    }

    public void setBaoUserList(List<BaoUser> baoUserList) {
        this.baoUserList = baoUserList;
    }

    public List<BaoProgrammedEmail> getBaoProgrammedEmailList() {
        return baoProgrammedEmailList;
    }

    public void setBaoProgrammedEmailList(List<BaoProgrammedEmail> baoProgrammedEmailList) {
        this.baoProgrammedEmailList = baoProgrammedEmailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mailingListId != null ? mailingListId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoMailingList)) {
            return false;
        }
        BaoMailingList other = (BaoMailingList) object;
        return !((this.mailingListId == null && other.mailingListId != null) || (this.mailingListId != null && !this.mailingListId.equals(other.mailingListId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoMailingList[ mailingListId=" + mailingListId + " ]";
    }
    
}
