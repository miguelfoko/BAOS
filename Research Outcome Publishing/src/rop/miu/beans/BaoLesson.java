package rop.miu.beans;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_lesson")
@NamedQueries({
    @NamedQuery(name = "BaoLesson.findAll", query = "SELECT b FROM BaoLesson b"),
    @NamedQuery(name = "BaoLesson.findByLessonId", query = "SELECT b FROM BaoLesson b WHERE b.lessonId = :lessonId"),
    @NamedQuery(name = "BaoLesson.findByLessonName", query = "SELECT b FROM BaoLesson b WHERE b.lessonName = :lessonName"),
    @NamedQuery(name = "BaoLesson.findByLessonStartTime", query = "SELECT b FROM BaoLesson b WHERE b.lessonStartTime = :lessonStartTime"),
    @NamedQuery(name = "BaoLesson.findByLessonEndTime", query = "SELECT b FROM BaoLesson b WHERE b.lessonEndTime = :lessonEndTime"),
    @NamedQuery(name = "BaoLesson.findByLessonDifficultyLevel", query = "SELECT b FROM BaoLesson b WHERE b.lessonDifficultyLevel = :lessonDifficultyLevel"),
    @NamedQuery(name = "BaoLesson.findByLessonContent", query = "SELECT b FROM BaoLesson b WHERE b.lessonContent = :lessonContent"),
    @NamedQuery(name = "BaoLesson.findByLessonCreationDate", query = "SELECT b FROM BaoLesson b WHERE b.lessonCreationDate = :lessonCreationDate"),
    @NamedQuery(name = "BaoLesson.findByLessonAttachment", query = "SELECT b FROM BaoLesson b WHERE b.lessonAttachment = :lessonAttachment"),
    @NamedQuery(name = "BaoLesson.findByLessonDesc", query = "SELECT b FROM BaoLesson b WHERE b.lessonDesc = :lessonDesc"),
    @NamedQuery(name = "BaoLesson.findByLessonState", query = "SELECT b FROM BaoLesson b WHERE b.lessonState = :lessonState")})
public class BaoLesson implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "lesson_id", nullable = false)
    private Integer lessonId;
    @Basic(optional = false)
    @Column(name = "lesson_name", nullable = false, length = 255)
    private String lessonName;
    @Column(name = "lesson_logo", length = 255)
    private String lessonLogo;
    @Basic(optional = false)
    @Column(name = "lesson_start_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lessonStartTime;
    @Basic(optional = false)
    @Column(name = "lesson_end_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lessonEndTime;
    @Basic(optional = false)
    @Column(name = "lesson_difficulty_level", nullable = false)
    private float lessonDifficultyLevel;
    @Basic(optional = false)
    @Column(name = "lesson_content", nullable = false, length = 2147483647)
    private String lessonContent;
    @Basic(optional = false)
    @Column(name = "lesson_creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lessonCreationDate;
    @Column(name = "lesson_attachment", length = 2147483647)
    private String lessonAttachment;
    @Column(name = "lesson_desc", length = 2147483647)
    private String lessonDesc;
    @Basic(optional = false)
    @Column(name = "lesson_state", nullable = false)
    private short lessonState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lessonId", fetch = FetchType.LAZY)
    private List<BaoIntervention> baoInterventionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lessonId", fetch = FetchType.LAZY)
    private List<BaoQuestion> baoQuestionList;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoCourse courseId;

    public BaoLesson() {
    }

    public BaoLesson(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public BaoLesson(Integer lessonId, String lessonName, Date lessonStartTime, Date lessonEndTime, float lessonDifficultyLevel, String lessonContent, Date lessonCreationDate, short lessonState) {
        this.lessonId = lessonId;
        this.lessonName = lessonName;
        this.lessonStartTime = lessonStartTime;
        this.lessonEndTime = lessonEndTime;
        this.lessonDifficultyLevel = lessonDifficultyLevel;
        this.lessonContent = lessonContent;
        this.lessonCreationDate = lessonCreationDate;
        this.lessonState = lessonState;
    }

    public Integer getLessonId() {
        return lessonId;
    }

    public void setLessonId(Integer lessonId) {
        this.lessonId = lessonId;
    }

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public Date getLessonStartTime() {
        return lessonStartTime;
    }

    public void setLessonStartTime(Date lessonStartTime) {
        this.lessonStartTime = lessonStartTime;
    }

    public Date getLessonEndTime() {
        return lessonEndTime;
    }

    public void setLessonEndTime(Date lessonEndTime) {
        this.lessonEndTime = lessonEndTime;
    }

    public float getLessonDifficultyLevel() {
        return lessonDifficultyLevel;
    }

    public void setLessonDifficultyLevel(float lessonDifficultyLevel) {
        this.lessonDifficultyLevel = lessonDifficultyLevel;
    }

    public String getLessonContent() {
        return lessonContent;
    }

    public void setLessonContent(String lessonContent) {
        this.lessonContent = lessonContent;
    }

    public Date getLessonCreationDate() {
        return lessonCreationDate;
    }

    public void setLessonCreationDate(Date lessonCreationDate) {
        this.lessonCreationDate = lessonCreationDate;
    }

    public String getLessonLogo() {
		return lessonLogo;
	}

	public void setLessonLogo(String lessonLogo) {
		this.lessonLogo = lessonLogo;
	}

	public String getLessonAttachment() {
        return lessonAttachment;
    }

    public void setLessonAttachment(String lessonAttachment) {
        this.lessonAttachment = lessonAttachment;
    }

    public String getLessonDesc() {
        return lessonDesc;
    }

    public void setLessonDesc(String lessonDesc) {
        this.lessonDesc = lessonDesc;
    }

    public short getLessonState() {
        return lessonState;
    }

    public void setLessonState(short lessonState) {
        this.lessonState = lessonState;
    }

    public List<BaoIntervention> getBaoInterventionList() {
        return baoInterventionList;
    }

    public void setBaoInterventionList(List<BaoIntervention> baoInterventionList) {
        this.baoInterventionList = baoInterventionList;
    }

    public List<BaoQuestion> getBaoQuestionList() {
        return baoQuestionList;
    }

    public void setBaoQuestionList(List<BaoQuestion> baoQuestionList) {
        this.baoQuestionList = baoQuestionList;
    }

    public BaoCourse getCourseId() {
        return courseId;
    }

    public void setCourseId(BaoCourse courseId) {
        this.courseId = courseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lessonId != null ? lessonId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoLesson)) {
            return false;
        }
        BaoLesson other = (BaoLesson) object;
        return !((this.lessonId == null && other.lessonId != null) || (this.lessonId != null && !this.lessonId.equals(other.lessonId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoLesson[ lessonId=" + lessonId + " ]";
    }
    
}
