package rop.miu.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Ndadji Maxime
 */
@Embeddable
public class BaoExamSheetQuestionPK implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "question_id", nullable = false)
    private long questionId;
    @Basic(optional = false)
    @Column(name = "exam_sheet_id", nullable = false)
    private long examSheetId;

    public BaoExamSheetQuestionPK() {
    }

    public BaoExamSheetQuestionPK(long questionId, long examSheetId) {
        this.questionId = questionId;
        this.examSheetId = examSheetId;
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public long getExamSheetId() {
        return examSheetId;
    }

    public void setExamSheetId(long examSheetId) {
        this.examSheetId = examSheetId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) questionId;
        hash += (int) examSheetId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoExamSheetQuestionPK)) {
            return false;
        }
        BaoExamSheetQuestionPK other = (BaoExamSheetQuestionPK) object;
        if (this.questionId != other.questionId) {
            return false;
        }
        return this.examSheetId == other.examSheetId;
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoExamSheetQuestionPK[ questionId=" + questionId + ", examSheetId=" + examSheetId + " ]";
    }
}
