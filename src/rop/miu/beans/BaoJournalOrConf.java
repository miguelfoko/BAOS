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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_journal_or_conf")
@NamedQueries({
    @NamedQuery(name = "BaoJournalOrConf.findAll", query = "SELECT b FROM BaoJournalOrConf b"),
    @NamedQuery(name = "BaoJournalOrConf.findByJournalOrConfId", query = "SELECT b FROM BaoJournalOrConf b WHERE b.journalOrConfId = :journalOrConfId"),
    @NamedQuery(name = "BaoJournalOrConf.findByJournalOrConfName", query = "SELECT b FROM BaoJournalOrConf b WHERE b.journalOrConfName = :journalOrConfName"),
    @NamedQuery(name = "BaoJournalOrConf.findByJournalOrConfType", query = "SELECT b FROM BaoJournalOrConf b WHERE b.journalOrConfType = :journalOrConfType"),
    @NamedQuery(name = "BaoJournalOrConf.findByJournalOrConfLogo", query = "SELECT b FROM BaoJournalOrConf b WHERE b.journalOrConfLogo = :journalOrConfLogo"),
    @NamedQuery(name = "BaoJournalOrConf.findByJournalOrConfShortDesc", query = "SELECT b FROM BaoJournalOrConf b WHERE b.journalOrConfShortDesc = :journalOrConfShortDesc"),
    @NamedQuery(name = "BaoJournalOrConf.findByJournalOrConfLongDesc", query = "SELECT b FROM BaoJournalOrConf b WHERE b.journalOrConfLongDesc = :journalOrConfLongDesc"),
    @NamedQuery(name = "BaoJournalOrConf.findByJournalOrConfState", query = "SELECT b FROM BaoJournalOrConf b WHERE b.journalOrConfState = :journalOrConfState")})
public class BaoJournalOrConf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "journal_or_conf_id", nullable = false)
    private Integer journalOrConfId;
    @Basic(optional = false)
    @Column(name = "journal_or_conf_name", nullable = false, length = 255)
    private String journalOrConfName;
    @Basic(optional = false)
    @Column(name = "journal_or_conf_type", nullable = false, length = 10)
    private String journalOrConfType;
    @Column(name = "journal_or_conf_logo", length = 255)
    private String journalOrConfLogo;
    @Column(name = "journal_or_conf_short_desc", length = 255)
    private String journalOrConfShortDesc;
    @Column(name = "journal_or_conf_long_desc", length = 2147483647)
    private String journalOrConfLongDesc;
    @Basic(optional = false)
    @Column(name = "journal_or_conf_state", nullable = false)
    private short journalOrConfState;
    @JoinTable(name = "bao_journal_topic", joinColumns = {
        @JoinColumn(name = "journal_or_conf_id", referencedColumnName = "journal_or_conf_id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "topic_id", referencedColumnName = "topic_id", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<BaoTopic> baoTopicList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "journalOrConfId", fetch = FetchType.LAZY)
    private List<BaoVolumeOrIssue> baoVolumeOrIssueList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "journalOrConfId", fetch = FetchType.LAZY)
    private List<BaoReviewOrEditionContract> baoReviewOrEditionContractList;

    public BaoJournalOrConf() {
    }

    public BaoJournalOrConf(Integer journalOrConfId) {
        this.journalOrConfId = journalOrConfId;
    }

    public BaoJournalOrConf(Integer journalOrConfId, String journalOrConfName, String journalOrConfType, short journalOrConfState) {
        this.journalOrConfId = journalOrConfId;
        this.journalOrConfName = journalOrConfName;
        this.journalOrConfType = journalOrConfType;
        this.journalOrConfState = journalOrConfState;
    }

    public Integer getJournalOrConfId() {
        return journalOrConfId;
    }

    public void setJournalOrConfId(Integer journalOrConfId) {
        this.journalOrConfId = journalOrConfId;
    }

    public String getJournalOrConfName() {
        return journalOrConfName;
    }

    public void setJournalOrConfName(String journalOrConfName) {
        this.journalOrConfName = journalOrConfName;
    }

    public String getJournalOrConfType() {
        return journalOrConfType;
    }

    public void setJournalOrConfType(String journalOrConfType) {
        this.journalOrConfType = journalOrConfType;
    }

    public String getJournalOrConfLogo() {
        return journalOrConfLogo;
    }

    public void setJournalOrConfLogo(String journalOrConfLogo) {
        this.journalOrConfLogo = journalOrConfLogo;
    }

    public String getJournalOrConfShortDesc() {
        return journalOrConfShortDesc;
    }

    public void setJournalOrConfShortDesc(String journalOrConfShortDesc) {
        this.journalOrConfShortDesc = journalOrConfShortDesc;
    }

    public String getJournalOrConfLongDesc() {
        return journalOrConfLongDesc;
    }

    public void setJournalOrConfLongDesc(String journalOrConfLongDesc) {
        this.journalOrConfLongDesc = journalOrConfLongDesc;
    }

    public short getJournalOrConfState() {
        return journalOrConfState;
    }

    public void setJournalOrConfState(short journalOrConfState) {
        this.journalOrConfState = journalOrConfState;
    }

    public List<BaoTopic> getBaoTopicList() {
        return baoTopicList;
    }

    public void setBaoTopicList(List<BaoTopic> baoTopicList) {
        this.baoTopicList = baoTopicList;
    }

    public List<BaoVolumeOrIssue> getBaoVolumeOrIssueList() {
        return baoVolumeOrIssueList;
    }

    public void setBaoVolumeOrIssueList(List<BaoVolumeOrIssue> baoVolumeOrIssueList) {
        this.baoVolumeOrIssueList = baoVolumeOrIssueList;
    }

    public List<BaoReviewOrEditionContract> getBaoReviewOrEditionContractList() {
        return baoReviewOrEditionContractList;
    }

    public void setBaoReviewOrEditionContractList(List<BaoReviewOrEditionContract> baoReviewOrEditionContractList) {
        this.baoReviewOrEditionContractList = baoReviewOrEditionContractList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (journalOrConfId != null ? journalOrConfId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoJournalOrConf)) {
            return false;
        }
        BaoJournalOrConf other = (BaoJournalOrConf) object;
        return !((this.journalOrConfId == null && other.journalOrConfId != null) || (this.journalOrConfId != null && !this.journalOrConfId.equals(other.journalOrConfId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoJournalOrConf[ journalOrConfId=" + journalOrConfId + " ]";
    }
}
