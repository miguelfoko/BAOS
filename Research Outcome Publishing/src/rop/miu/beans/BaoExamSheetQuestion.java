package rop.miu.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
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
@Table(name = "bao_exam_sheet_question")
@NamedQueries({
    @NamedQuery(name = "BaoExamSheetQuestion.findAll", query = "SELECT b FROM BaoExamSheetQuestion b"),
    @NamedQuery(name = "BaoExamSheetQuestion.findByQuestionId", query = "SELECT b FROM BaoExamSheetQuestion b WHERE b.baoExamSheetQuestionPK.questionId = :questionId"),
    @NamedQuery(name = "BaoExamSheetQuestion.findByExamSheetId", query = "SELECT b FROM BaoExamSheetQuestion b WHERE b.baoExamSheetQuestionPK.examSheetId = :examSheetId"),
    @NamedQuery(name = "BaoExamSheetQuestion.findByExamSheetQuestionAnswer", query = "SELECT b FROM BaoExamSheetQuestion b WHERE b.examSheetQuestionAnswer = :examSheetQuestionAnswer"),
    @NamedQuery(name = "BaoExamSheetQuestion.findByExamSheetQuestionJustification", query = "SELECT b FROM BaoExamSheetQuestion b WHERE b.examSheetQuestionJustification = :examSheetQuestionJustification"),
    @NamedQuery(name = "BaoExamSheetQuestion.findByExamSheetQuestionAnswerDate", query = "SELECT b FROM BaoExamSheetQuestion b WHERE b.examSheetQuestionAnswerDate = :examSheetQuestionAnswerDate"),
    @NamedQuery(name = "BaoExamSheetQuestion.findByExamSheetQuestionMark", query = "SELECT b FROM BaoExamSheetQuestion b WHERE b.examSheetQuestionMark = :examSheetQuestionMark")})
public class BaoExamSheetQuestion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BaoExamSheetQuestionPK baoExamSheetQuestionPK;
    @Column(name = "exam_sheet_question_answer")
    private Short examSheetQuestionAnswer;
    @Column(name = "exam_sheet_question_justification", length = 2147483647)
    private String examSheetQuestionJustification;
    @Column(name = "exam_sheet_question_attachment", length = 2147483647)
    private String examSheetQuestionAttachment;
    @Column(name = "exam_sheet_question_answer_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date examSheetQuestionAnswerDate;
    @Column(name = "exam_sheet_question_mark", precision = 8, scale = 8)
    private Float examSheetQuestionMark;
    @JoinColumn(name = "exam_sheet_id", referencedColumnName = "exam_sheet_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoExamSheet baoExamSheet;
    @JoinColumn(name = "question_id", referencedColumnName = "question_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoQuestion baoQuestion;

    public BaoExamSheetQuestion() {
    }

    public BaoExamSheetQuestion(BaoExamSheetQuestionPK baoExamSheetQuestionPK) {
        this.baoExamSheetQuestionPK = baoExamSheetQuestionPK;
    }

    public BaoExamSheetQuestion(long questionId, long examSheetId) {
        this.baoExamSheetQuestionPK = new BaoExamSheetQuestionPK(questionId, examSheetId);
    }

    public BaoExamSheetQuestionPK getBaoExamSheetQuestionPK() {
        return baoExamSheetQuestionPK;
    }

    public void setBaoExamSheetQuestionPK(BaoExamSheetQuestionPK baoExamSheetQuestionPK) {
        this.baoExamSheetQuestionPK = baoExamSheetQuestionPK;
    }

    public Short getExamSheetQuestionAnswer() {
        return examSheetQuestionAnswer;
    }

    public void setExamSheetQuestionAnswer(Short examSheetQuestionAnswer) {
        this.examSheetQuestionAnswer = examSheetQuestionAnswer;
    }

    public String getExamSheetQuestionJustification() {
        return examSheetQuestionJustification;
    }

    public void setExamSheetQuestionJustification(String examSheetQuestionJustification) {
        this.examSheetQuestionJustification = examSheetQuestionJustification;
    }

    public Date getExamSheetQuestionAnswerDate() {
        return examSheetQuestionAnswerDate;
    }

    public void setExamSheetQuestionAnswerDate(Date examSheetQuestionAnswerDate) {
        this.examSheetQuestionAnswerDate = examSheetQuestionAnswerDate;
    }

    public Float getExamSheetQuestionMark() {
        return examSheetQuestionMark;
    }

    public void setExamSheetQuestionMark(Float examSheetQuestionMark) {
        this.examSheetQuestionMark = examSheetQuestionMark;
    }

    public String getExamSheetQuestionAttachment() {
		return examSheetQuestionAttachment;
	}

	public void setExamSheetQuestionAttachment(String examSheetQuestionAttachment) {
		this.examSheetQuestionAttachment = examSheetQuestionAttachment;
	}

	public BaoExamSheet getBaoExamSheet() {
        return baoExamSheet;
    }

    public void setBaoExamSheet(BaoExamSheet baoExamSheet) {
        this.baoExamSheet = baoExamSheet;
    }

    public BaoQuestion getBaoQuestion() {
        return baoQuestion;
    }

    public void setBaoQuestion(BaoQuestion baoQuestion) {
        this.baoQuestion = baoQuestion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (baoExamSheetQuestionPK != null ? baoExamSheetQuestionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoExamSheetQuestion)) {
            return false;
        }
        BaoExamSheetQuestion other = (BaoExamSheetQuestion) object;
        return !((this.baoExamSheetQuestionPK == null && other.baoExamSheetQuestionPK != null) || (this.baoExamSheetQuestionPK != null && !this.baoExamSheetQuestionPK.equals(other.baoExamSheetQuestionPK)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoExamSheetQuestion[ baoExamSheetQuestionPK=" + baoExamSheetQuestionPK + " ]";
    }
}
