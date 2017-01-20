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
@Table(name = "bao_review_or_edition_contract")
@NamedQueries({
    @NamedQuery(name = "BaoReviewOrEditionContract.findAll", query = "SELECT b FROM BaoReviewOrEditionContract b"),
    @NamedQuery(name = "BaoReviewOrEditionContract.findByReviewOrEditionContractId", query = "SELECT b FROM BaoReviewOrEditionContract b WHERE b.reviewOrEditionContractId = :reviewOrEditionContractId"),
    @NamedQuery(name = "BaoReviewOrEditionContract.findByReviewOrEditionContractType", query = "SELECT b FROM BaoReviewOrEditionContract b WHERE b.reviewOrEditionContractType = :reviewOrEditionContractType"),
    @NamedQuery(name = "BaoReviewOrEditionContract.findByReviewOrEditionContractStartTime", query = "SELECT b FROM BaoReviewOrEditionContract b WHERE b.reviewOrEditionContractStartTime = :reviewOrEditionContractStartTime"),
    @NamedQuery(name = "BaoReviewOrEditionContract.findByReviewOrEditionContractLength", query = "SELECT b FROM BaoReviewOrEditionContract b WHERE b.reviewOrEditionContractLength = :reviewOrEditionContractLength"),
    @NamedQuery(name = "BaoReviewOrEditionContract.findByReviewOrEditionContractLengthUnit", query = "SELECT b FROM BaoReviewOrEditionContract b WHERE b.reviewOrEditionContractLengthUnit = :reviewOrEditionContractLengthUnit"),
    @NamedQuery(name = "BaoReviewOrEditionContract.findByReviewOrEditionContractDesc", query = "SELECT b FROM BaoReviewOrEditionContract b WHERE b.reviewOrEditionContractDesc = :reviewOrEditionContractDesc"),
    @NamedQuery(name = "BaoReviewOrEditionContract.findByReviewOrEditionContractState", query = "SELECT b FROM BaoReviewOrEditionContract b WHERE b.reviewOrEditionContractState = :reviewOrEditionContractState")})
public class BaoReviewOrEditionContract implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "review_or_edition_contract_id", nullable = false)
    private Integer reviewOrEditionContractId;
    @Basic(optional = false)
    @Column(name = "review_or_edition_contract_type", nullable = false, length = 20)
    private String reviewOrEditionContractType;
    @Basic(optional = false)
    @Column(name = "review_or_edition_contract_start_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date reviewOrEditionContractStartTime;
    @Basic(optional = false)
    @Column(name = "review_or_edition_contract_length", nullable = false)
    private int reviewOrEditionContractLength;
    @Basic(optional = false)
    @Column(name = "review_or_edition_contract_length_unit", nullable = false, length = 10)
    private String reviewOrEditionContractLengthUnit;
    @Column(name = "review_or_edition_contract_desc", length = 2147483647)
    private String reviewOrEditionContractDesc;
    @Basic(optional = false)
    @Column(name = "review_or_edition_contract_state", nullable = false)
    private short reviewOrEditionContractState;
    @JoinTable(name = "bao_review_contract_topic", joinColumns = {
        @JoinColumn(name = "review_or_edition_contract_id", referencedColumnName = "review_or_edition_contract_id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "topic_id", referencedColumnName = "topic_id", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<BaoTopic> baoTopicList;
    @JoinColumn(name = "journal_or_conf_id", referencedColumnName = "journal_or_conf_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoJournalOrConf journalOrConfId;
    @JoinColumn(name = "user_id_reviewer_or_editor", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser userIdReviewerOrEditor;
    @JoinColumn(name = "user_id_contract_creator", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser userIdContractCreator;

    public BaoReviewOrEditionContract() {
    }

    public BaoReviewOrEditionContract(Integer reviewOrEditionContractId) {
        this.reviewOrEditionContractId = reviewOrEditionContractId;
    }

    public BaoReviewOrEditionContract(Integer reviewOrEditionContractId, String reviewOrEditionContractType, Date reviewOrEditionContractStartTime, int reviewOrEditionContractLength, String reviewOrEditionContractLengthUnit, short reviewOrEditionContractState) {
        this.reviewOrEditionContractId = reviewOrEditionContractId;
        this.reviewOrEditionContractType = reviewOrEditionContractType;
        this.reviewOrEditionContractStartTime = reviewOrEditionContractStartTime;
        this.reviewOrEditionContractLength = reviewOrEditionContractLength;
        this.reviewOrEditionContractLengthUnit = reviewOrEditionContractLengthUnit;
        this.reviewOrEditionContractState = reviewOrEditionContractState;
    }

    public Integer getReviewOrEditionContractId() {
        return reviewOrEditionContractId;
    }

    public void setReviewOrEditionContractId(Integer reviewOrEditionContractId) {
        this.reviewOrEditionContractId = reviewOrEditionContractId;
    }

    public String getReviewOrEditionContractType() {
        return reviewOrEditionContractType;
    }

    public void setReviewOrEditionContractType(String reviewOrEditionContractType) {
        this.reviewOrEditionContractType = reviewOrEditionContractType;
    }

    public Date getReviewOrEditionContractStartTime() {
        return reviewOrEditionContractStartTime;
    }

    public void setReviewOrEditionContractStartTime(Date reviewOrEditionContractStartTime) {
        this.reviewOrEditionContractStartTime = reviewOrEditionContractStartTime;
    }

    public int getReviewOrEditionContractLength() {
        return reviewOrEditionContractLength;
    }

    public void setReviewOrEditionContractLength(int reviewOrEditionContractLength) {
        this.reviewOrEditionContractLength = reviewOrEditionContractLength;
    }

    public String getReviewOrEditionContractLengthUnit() {
        return reviewOrEditionContractLengthUnit;
    }

    public void setReviewOrEditionContractLengthUnit(String reviewOrEditionContractLengthUnit) {
        this.reviewOrEditionContractLengthUnit = reviewOrEditionContractLengthUnit;
    }

    public String getReviewOrEditionContractDesc() {
        return reviewOrEditionContractDesc;
    }

    public void setReviewOrEditionContractDesc(String reviewOrEditionContractDesc) {
        this.reviewOrEditionContractDesc = reviewOrEditionContractDesc;
    }

    public short getReviewOrEditionContractState() {
        return reviewOrEditionContractState;
    }

    public void setReviewOrEditionContractState(short reviewOrEditionContractState) {
        this.reviewOrEditionContractState = reviewOrEditionContractState;
    }

    public List<BaoTopic> getBaoTopicList() {
        return baoTopicList;
    }

    public void setBaoTopicList(List<BaoTopic> baoTopicList) {
        this.baoTopicList = baoTopicList;
    }

    public BaoJournalOrConf getJournalOrConfId() {
        return journalOrConfId;
    }

    public void setJournalOrConfId(BaoJournalOrConf journalOrConfId) {
        this.journalOrConfId = journalOrConfId;
    }

    public BaoUser getUserIdReviewerOrEditor() {
        return userIdReviewerOrEditor;
    }

    public void setUserIdReviewerOrEditor(BaoUser userIdReviewerOrEditor) {
        this.userIdReviewerOrEditor = userIdReviewerOrEditor;
    }

    public BaoUser getUserIdContractCreator() {
        return userIdContractCreator;
    }

    public void setUserIdContractCreator(BaoUser userIdContractCreator) {
        this.userIdContractCreator = userIdContractCreator;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewOrEditionContractId != null ? reviewOrEditionContractId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoReviewOrEditionContract)) {
            return false;
        }
        BaoReviewOrEditionContract other = (BaoReviewOrEditionContract) object;
        return !((this.reviewOrEditionContractId == null && other.reviewOrEditionContractId != null) || (this.reviewOrEditionContractId != null && !this.reviewOrEditionContractId.equals(other.reviewOrEditionContractId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoReviewOrEditionContract[ reviewOrEditionContractId=" + reviewOrEditionContractId + " ]";
    }
}
