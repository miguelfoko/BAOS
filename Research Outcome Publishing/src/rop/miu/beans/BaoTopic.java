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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_topic")
@NamedQueries({
    @NamedQuery(name = "BaoTopic.findAll", query = "SELECT b FROM BaoTopic b"),
    @NamedQuery(name = "BaoTopic.findByTopicId", query = "SELECT b FROM BaoTopic b WHERE b.topicId = :topicId"),
    @NamedQuery(name = "BaoTopic.findByTopicName", query = "SELECT b FROM BaoTopic b WHERE b.topicName = :topicName"),
    @NamedQuery(name = "BaoTopic.findByTopicDesc", query = "SELECT b FROM BaoTopic b WHERE b.topicDesc = :topicDesc"),
    @NamedQuery(name = "BaoTopic.findByTopicState", query = "SELECT b FROM BaoTopic b WHERE b.topicState = :topicState")})
public class BaoTopic implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "topic_id", nullable = false)
    private Integer topicId;
    @Basic(optional = false)
    @Column(name = "topic_name", nullable = false, length = 255)
    private String topicName;
    @Column(name = "topic_desc", length = 2147483647)
    private String topicDesc;
    @Basic(optional = false)
    @Column(name = "topic_state", nullable = false)
    private short topicState;
    @ManyToMany(mappedBy = "baoTopicList", fetch = FetchType.LAZY)
    private List<BaoReviewOrEditionContract> baoReviewOrEditionContractList;
    @ManyToMany(mappedBy = "baoTopicList", fetch = FetchType.LAZY)
    private List<BaoPaper> baoPaperList;
    @ManyToMany(mappedBy = "baoTopicList", fetch = FetchType.LAZY)
    private List<BaoJournalOrConf> baoJournalOrConfList;
    @OneToMany(mappedBy = "topicIdParent", fetch = FetchType.LAZY)
    private List<BaoTopic> baoTopicList;
    @JoinColumn(name = "topic_id_parent", referencedColumnName = "topic_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private BaoTopic topicIdParent;

    public BaoTopic() {
    }

    public BaoTopic(Integer topicId) {
        this.topicId = topicId;
    }

    public BaoTopic(Integer topicId, String topicName, short topicState) {
        this.topicId = topicId;
        this.topicName = topicName;
        this.topicState = topicState;
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public short getTopicState() {
        return topicState;
    }

    public void setTopicState(short topicState) {
        this.topicState = topicState;
    }

    public List<BaoReviewOrEditionContract> getBaoReviewOrEditionContractList() {
        return baoReviewOrEditionContractList;
    }

    public void setBaoReviewOrEditionContractList(List<BaoReviewOrEditionContract> baoReviewOrEditionContractList) {
        this.baoReviewOrEditionContractList = baoReviewOrEditionContractList;
    }

    public List<BaoPaper> getBaoPaperList() {
        return baoPaperList;
    }

    public void setBaoPaperList(List<BaoPaper> baoPaperList) {
        this.baoPaperList = baoPaperList;
    }

    public List<BaoJournalOrConf> getBaoJournalOrConfList() {
        return baoJournalOrConfList;
    }

    public void setBaoJournalOrConfList(List<BaoJournalOrConf> baoJournalOrConfList) {
        this.baoJournalOrConfList = baoJournalOrConfList;
    }

    public List<BaoTopic> getBaoTopicList() {
        return baoTopicList;
    }

    public void setBaoTopicList(List<BaoTopic> baoTopicList) {
        this.baoTopicList = baoTopicList;
    }

    public BaoTopic getTopicIdParent() {
        return topicIdParent;
    }

    public void setTopicIdParent(BaoTopic topicIdParent) {
        this.topicIdParent = topicIdParent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (topicId != null ? topicId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoTopic)) {
            return false;
        }
        BaoTopic other = (BaoTopic) object;
        return !((this.topicId == null && other.topicId != null) || (this.topicId != null && !this.topicId.equals(other.topicId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoTopic[ topicId=" + topicId + " ]";
    }
}
