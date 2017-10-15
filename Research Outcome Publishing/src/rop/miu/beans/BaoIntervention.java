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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_intervention")
@NamedQueries({
    @NamedQuery(name = "BaoIntervention.findAll", query = "SELECT b FROM BaoIntervention b"),
    @NamedQuery(name = "BaoIntervention.findByInterventionId", query = "SELECT b FROM BaoIntervention b WHERE b.interventionId = :interventionId"),
    @NamedQuery(name = "BaoIntervention.findByInterventionContent", query = "SELECT b FROM BaoIntervention b WHERE b.interventionContent = :interventionContent"),
    @NamedQuery(name = "BaoIntervention.findByInterventionDate", query = "SELECT b FROM BaoIntervention b WHERE b.interventionDate = :interventionDate"),
    @NamedQuery(name = "BaoIntervention.findByInterventionLike", query = "SELECT b FROM BaoIntervention b WHERE b.interventionLike = :interventionLike"),
    @NamedQuery(name = "BaoIntervention.findByInterventionState", query = "SELECT b FROM BaoIntervention b WHERE b.interventionState = :interventionState")})
public class BaoIntervention implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "intervention_id", nullable = false)
    private Integer interventionId;
    @Basic(optional = false)
    @Column(name = "intervention_content", nullable = false, length = 2147483647)
    private String interventionContent;
    @Basic(optional = false)
    @Column(name = "intervention_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date interventionDate;
    @Column(name = "intervention_like")
    private String interventionLike;
    @Basic(optional = false)
    @Column(name = "intervention_state", nullable = false)
    private short interventionState;
    @OneToMany(mappedBy = "interventionIdParent", fetch = FetchType.LAZY)
    private List<BaoIntervention> baoInterventionList;
    @JoinColumn(name = "intervention_id_parent", referencedColumnName = "intervention_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private BaoIntervention interventionIdParent;
    @JoinColumn(name = "lesson_id", referencedColumnName = "lesson_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoLesson lessonId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser userId;

    public BaoIntervention() {
    }

    public BaoIntervention(Integer interventionId) {
        this.interventionId = interventionId;
    }

    public BaoIntervention(Integer interventionId, String interventionContent, Date interventionDate, short interventionState) {
        this.interventionId = interventionId;
        this.interventionContent = interventionContent;
        this.interventionDate = interventionDate;
        this.interventionState = interventionState;
    }

    public Integer getInterventionId() {
        return interventionId;
    }

    public void setInterventionId(Integer interventionId) {
        this.interventionId = interventionId;
    }

    public String getInterventionContent() {
        return interventionContent;
    }

    public void setInterventionContent(String interventionContent) {
        this.interventionContent = interventionContent;
    }

    public Date getInterventionDate() {
        return interventionDate;
    }

    public void setInterventionDate(Date interventionDate) {
        this.interventionDate = interventionDate;
    }

    public String getInterventionLike() {
        return interventionLike;
    }

    public void setInterventionLike(String interventionLike) {
        this.interventionLike = interventionLike;
    }

    public short getInterventionState() {
        return interventionState;
    }

    public void setInterventionState(short interventionState) {
        this.interventionState = interventionState;
    }

    public List<BaoIntervention> getBaoInterventionList() {
        return baoInterventionList;
    }

    public void setBaoInterventionList(List<BaoIntervention> baoInterventionList) {
        this.baoInterventionList = baoInterventionList;
    }

    public BaoIntervention getInterventionIdParent() {
        return interventionIdParent;
    }

    public void setInterventionIdParent(BaoIntervention interventionIdParent) {
        this.interventionIdParent = interventionIdParent;
    }

    public BaoLesson getLessonId() {
        return lessonId;
    }

    public void setLessonId(BaoLesson lessonId) {
        this.lessonId = lessonId;
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
        hash += (interventionId != null ? interventionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoIntervention)) {
            return false;
        }
        BaoIntervention other = (BaoIntervention) object;
        return !((this.interventionId == null && other.interventionId != null) || (this.interventionId != null && !this.interventionId.equals(other.interventionId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoIntervention[ interventionId=" + interventionId + " ]";
    }
}
