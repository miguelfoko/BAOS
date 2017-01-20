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
@Table(name = "bao_examination")
@NamedQueries({
    @NamedQuery(name = "BaoExamination.findAll", query = "SELECT b FROM BaoExamination b"),
    @NamedQuery(name = "BaoExamination.findByExaminationId", query = "SELECT b FROM BaoExamination b WHERE b.examinationId = :examinationId"),
    @NamedQuery(name = "BaoExamination.findByExaminationName", query = "SELECT b FROM BaoExamination b WHERE b.examinationName = :examinationName"),
    @NamedQuery(name = "BaoExamination.findByExaminationStartTime", query = "SELECT b FROM BaoExamination b WHERE b.examinationStartTime = :examinationStartTime"),
    @NamedQuery(name = "BaoExamination.findByExaminationEndTime", query = "SELECT b FROM BaoExamination b WHERE b.examinationEndTime = :examinationEndTime"),
    @NamedQuery(name = "BaoExamination.findByExaminationDifficultyLevel", query = "SELECT b FROM BaoExamination b WHERE b.examinationDifficultyLevel = :examinationDifficultyLevel"),
    @NamedQuery(name = "BaoExamination.findByExaminationNumberOfQuestion", query = "SELECT b FROM BaoExamination b WHERE b.examinationNumberOfQuestion = :examinationNumberOfQuestion"),
    @NamedQuery(name = "BaoExamination.findByExaminationQuestionMark", query = "SELECT b FROM BaoExamination b WHERE b.examinationQuestionMark = :examinationQuestionMark"),
    @NamedQuery(name = "BaoExamination.findByExaminationDuration", query = "SELECT b FROM BaoExamination b WHERE b.examinationDuration = :examinationDuration"),
    @NamedQuery(name = "BaoExamination.findByExaminationPauseDuration", query = "SELECT b FROM BaoExamination b WHERE b.examinationPauseDuration = :examinationPauseDuration"),
    @NamedQuery(name = "BaoExamination.findByExaminationResultPublishDelay", query = "SELECT b FROM BaoExamination b WHERE b.examinationResultPublishDelay = :examinationResultPublishDelay"),
    @NamedQuery(name = "BaoExamination.findByExaminationMinAdmissionLevel", query = "SELECT b FROM BaoExamination b WHERE b.examinationMinAdmissionLevel = :examinationMinAdmissionLevel"),
    @NamedQuery(name = "BaoExamination.findByExaminationDesc", query = "SELECT b FROM BaoExamination b WHERE b.examinationDesc = :examinationDesc"),
    @NamedQuery(name = "BaoExamination.findByExaminationState", query = "SELECT b FROM BaoExamination b WHERE b.examinationState = :examinationState")})
public class BaoExamination implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "examination_id", nullable = false)
    private Integer examinationId;
    @Basic(optional = false)
    @Column(name = "examination_name", nullable = false, length = 255)
    private String examinationName;
    @Basic(optional = false)
    @Column(name = "examination_start_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date examinationStartTime;
    @Basic(optional = false)
    @Column(name = "examination_end_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date examinationEndTime;
    @Basic(optional = false)
    @Column(name = "examination_difficulty_level", nullable = false)
    private float examinationDifficultyLevel;
    @Basic(optional = false)
    @Column(name = "examination_number_of_question", nullable = false)
    private short examinationNumberOfQuestion;
    @Basic(optional = false)
    @Column(name = "examination_question_mark", nullable = false, length = 30)
    private String examinationQuestionMark;
    @Basic(optional = false)
    @Column(name = "examination_duration", nullable = false)
    private float examinationDuration;
    @Basic(optional = false)
    @Column(name = "examination_pause_duration", nullable = false)
    private float examinationPauseDuration;
    @Basic(optional = false)
    @Column(name = "examination_result_publish_delay", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date examinationResultPublishDelay;
    @Basic(optional = false)
    @Column(name = "examination_min_admission_level", nullable = false)
    private float examinationMinAdmissionLevel;
    @Column(name = "examination_desc", length = 2147483647)
    private String examinationDesc;
    @Basic(optional = false)
    @Column(name = "examination_state", nullable = false)
    private short examinationState;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoCourse courseId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examinationId", fetch = FetchType.LAZY)
    private List<BaoExamSheet> baoExamSheetList;

    public BaoExamination() {
    }

    public BaoExamination(Integer examinationId) {
        this.examinationId = examinationId;
    }

    public BaoExamination(Integer examinationId, String examinationName, Date examinationStartTime, Date examinationEndTime, float examinationDifficultyLevel, short examinationNumberOfQuestion, String examinationQuestionMark, float examinationDuration, float examinationPauseDuration, Date examinationResultPublishDelay, float examinationMinAdmissionLevel, short examinationState) {
        this.examinationId = examinationId;
        this.examinationName = examinationName;
        this.examinationStartTime = examinationStartTime;
        this.examinationEndTime = examinationEndTime;
        this.examinationDifficultyLevel = examinationDifficultyLevel;
        this.examinationNumberOfQuestion = examinationNumberOfQuestion;
        this.examinationQuestionMark = examinationQuestionMark;
        this.examinationDuration = examinationDuration;
        this.examinationPauseDuration = examinationPauseDuration;
        this.examinationResultPublishDelay = examinationResultPublishDelay;
        this.examinationMinAdmissionLevel = examinationMinAdmissionLevel;
        this.examinationState = examinationState;
    }

    public Integer getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(Integer examinationId) {
        this.examinationId = examinationId;
    }

    public String getExaminationName() {
        return examinationName;
    }

    public void setExaminationName(String examinationName) {
        this.examinationName = examinationName;
    }

    public Date getExaminationStartTime() {
        return examinationStartTime;
    }

    public void setExaminationStartTime(Date examinationStartTime) {
        this.examinationStartTime = examinationStartTime;
    }

    public Date getExaminationEndTime() {
        return examinationEndTime;
    }

    public void setExaminationEndTime(Date examinationEndTime) {
        this.examinationEndTime = examinationEndTime;
    }

    public float getExaminationDifficultyLevel() {
        return examinationDifficultyLevel;
    }

    public void setExaminationDifficultyLevel(float examinationDifficultyLevel) {
        this.examinationDifficultyLevel = examinationDifficultyLevel;
    }

    public short getExaminationNumberOfQuestion() {
        return examinationNumberOfQuestion;
    }

    public void setExaminationNumberOfQuestion(short examinationNumberOfQuestion) {
        this.examinationNumberOfQuestion = examinationNumberOfQuestion;
    }

    public String getExaminationQuestionMark() {
        return examinationQuestionMark;
    }

    public void setExaminationQuestionMark(String examinationQuestionMark) {
        this.examinationQuestionMark = examinationQuestionMark;
    }

    public float getExaminationDuration() {
        return examinationDuration;
    }

    public void setExaminationDuration(float examinationDuration) {
        this.examinationDuration = examinationDuration;
    }

    public float getExaminationPauseDuration() {
        return examinationPauseDuration;
    }

    public void setExaminationPauseDuration(float examinationPauseDuration) {
        this.examinationPauseDuration = examinationPauseDuration;
    }

    public Date getExaminationResultPublishDelay() {
        return examinationResultPublishDelay;
    }

    public void setExaminationResultPublishDelay(Date examinationResultPublishDelay) {
        this.examinationResultPublishDelay = examinationResultPublishDelay;
    }

    public float getExaminationMinAdmissionLevel() {
        return examinationMinAdmissionLevel;
    }

    public void setExaminationMinAdmissionLevel(float examinationMinAdmissionLevel) {
        this.examinationMinAdmissionLevel = examinationMinAdmissionLevel;
    }

    public String getExaminationDesc() {
        return examinationDesc;
    }

    public void setExaminationDesc(String examinationDesc) {
        this.examinationDesc = examinationDesc;
    }

    public short getExaminationState() {
        return examinationState;
    }

    public void setExaminationState(short examinationState) {
        this.examinationState = examinationState;
    }

    public BaoCourse getCourseId() {
        return courseId;
    }

    public void setCourseId(BaoCourse courseId) {
        this.courseId = courseId;
    }

    public List<BaoExamSheet> getBaoExamSheetList() {
        return baoExamSheetList;
    }

    public void setBaoExamSheetList(List<BaoExamSheet> baoExamSheetList) {
        this.baoExamSheetList = baoExamSheetList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (examinationId != null ? examinationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoExamination)) {
            return false;
        }
        BaoExamination other = (BaoExamination) object;
        return !((this.examinationId == null && other.examinationId != null) || (this.examinationId != null && !this.examinationId.equals(other.examinationId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoExamination[ examinationId=" + examinationId + " ]";
    }
}
