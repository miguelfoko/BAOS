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
@Table(name = "bao_exam_sheet")
@NamedQueries({
    @NamedQuery(name = "BaoExamSheet.findAll", query = "SELECT b FROM BaoExamSheet b"),
    @NamedQuery(name = "BaoExamSheet.findByExamSheetId", query = "SELECT b FROM BaoExamSheet b WHERE b.examSheetId = :examSheetId"),
    @NamedQuery(name = "BaoExamSheet.findByExamSheetCreationDate", query = "SELECT b FROM BaoExamSheet b WHERE b.examSheetCreationDate = :examSheetCreationDate"),
    @NamedQuery(name = "BaoExamSheet.findByExamSheetStartDate", query = "SELECT b FROM BaoExamSheet b WHERE b.examSheetStartDate = :examSheetStartDate"),
    @NamedQuery(name = "BaoExamSheet.findByExamSheetPauseDate", query = "SELECT b FROM BaoExamSheet b WHERE b.examSheetPauseDate = :examSheetPauseDate"),
    @NamedQuery(name = "BaoExamSheet.findByExamSheetDifficulty", query = "SELECT b FROM BaoExamSheet b WHERE b.examSheetDifficulty = :examSheetDifficulty"),
    @NamedQuery(name = "BaoExamSheet.findByExamSheetResult", query = "SELECT b FROM BaoExamSheet b WHERE b.examSheetResult = :examSheetResult"),
    @NamedQuery(name = "BaoExamSheet.findByExamSheetState", query = "SELECT b FROM BaoExamSheet b WHERE b.examSheetState = :examSheetState")})
public class BaoExamSheet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "exam_sheet_id", nullable = false)
    private Integer examSheetId;
    @Basic(optional = false)
    @Column(name = "exam_sheet_creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date examSheetCreationDate;
    @Column(name = "exam_sheet_start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date examSheetStartDate;
    @Column(name = "exam_sheet_pause_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date examSheetPauseDate;
    @Basic(optional = false)
    @Column(name = "exam_sheet_difficulty", nullable = false)
    private float examSheetDifficulty;
    @Basic(optional = false)
    @Column(name = "exam_sheet_result", nullable = false)
    private float examSheetResult;
    @Basic(optional = false)
    @Column(name = "exam_sheet_state", nullable = false)
    private short examSheetState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baoExamSheet", fetch = FetchType.LAZY)
    private List<BaoExamSheetQuestion> baoExamSheetQuestionList;
    @JoinColumn(name = "examination_id", referencedColumnName = "examination_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoExamination examinationId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser userId;

    public BaoExamSheet() {
    }

    public BaoExamSheet(Integer examSheetId) {
        this.examSheetId = examSheetId;
    }

    public BaoExamSheet(Integer examSheetId, Date examSheetCreationDate, float examSheetDifficulty, float examSheetResult, short examSheetState) {
        this.examSheetId = examSheetId;
        this.examSheetCreationDate = examSheetCreationDate;
        this.examSheetDifficulty = examSheetDifficulty;
        this.examSheetResult = examSheetResult;
        this.examSheetState = examSheetState;
    }

    public Integer getExamSheetId() {
        return examSheetId;
    }

    public void setExamSheetId(Integer examSheetId) {
        this.examSheetId = examSheetId;
    }

    public Date getExamSheetCreationDate() {
        return examSheetCreationDate;
    }

    public void setExamSheetCreationDate(Date examSheetCreationDate) {
        this.examSheetCreationDate = examSheetCreationDate;
    }

    public Date getExamSheetStartDate() {
        return examSheetStartDate;
    }

    public void setExamSheetStartDate(Date examSheetStartDate) {
        this.examSheetStartDate = examSheetStartDate;
    }

    public Date getExamSheetPauseDate() {
        return examSheetPauseDate;
    }

    public void setExamSheetPauseDate(Date examSheetPauseDate) {
        this.examSheetPauseDate = examSheetPauseDate;
    }

    public float getExamSheetDifficulty() {
        return examSheetDifficulty;
    }

    public void setExamSheetDifficulty(float examSheetDifficulty) {
        this.examSheetDifficulty = examSheetDifficulty;
    }

    public float getExamSheetResult() {
        return examSheetResult;
    }

    public void setExamSheetResult(float examSheetResult) {
        this.examSheetResult = examSheetResult;
    }

    public short getExamSheetState() {
        return examSheetState;
    }

    public void setExamSheetState(short examSheetState) {
        this.examSheetState = examSheetState;
    }

    public List<BaoExamSheetQuestion> getBaoExamSheetQuestionList() {
        return baoExamSheetQuestionList;
    }

    public void setBaoExamSheetQuestionList(List<BaoExamSheetQuestion> baoExamSheetQuestionList) {
        this.baoExamSheetQuestionList = baoExamSheetQuestionList;
    }

    public BaoExamination getExaminationId() {
        return examinationId;
    }

    public void setExaminationId(BaoExamination examinationId) {
        this.examinationId = examinationId;
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
        hash += (examSheetId != null ? examSheetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoExamSheet)) {
            return false;
        }
        BaoExamSheet other = (BaoExamSheet) object;
        return !((this.examSheetId == null && other.examSheetId != null) || (this.examSheetId != null && !this.examSheetId.equals(other.examSheetId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoExamSheet[ examSheetId=" + examSheetId + " ]";
    }
}
