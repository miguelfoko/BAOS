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
@Table(name = "bao_question")
@NamedQueries({
    @NamedQuery(name = "BaoQuestion.findAll", query = "SELECT b FROM BaoQuestion b"),
    @NamedQuery(name = "BaoQuestion.findByQuestionId", query = "SELECT b FROM BaoQuestion b WHERE b.questionId = :questionId"),
    @NamedQuery(name = "BaoQuestion.findByQuestionContent", query = "SELECT b FROM BaoQuestion b WHERE b.questionContent = :questionContent"),
    @NamedQuery(name = "BaoQuestion.findByQuestionAnswerProposals", query = "SELECT b FROM BaoQuestion b WHERE b.questionAnswerProposals = :questionAnswerProposals"),
    @NamedQuery(name = "BaoQuestion.findByQuestionAnswer", query = "SELECT b FROM BaoQuestion b WHERE b.questionAnswer = :questionAnswer"),
    @NamedQuery(name = "BaoQuestion.findByQuestionIsOnlyForExam", query = "SELECT b FROM BaoQuestion b WHERE b.questionIsOnlyForExam = :questionIsOnlyForExam"),
    @NamedQuery(name = "BaoQuestion.findByQuestionIsJustificationRequired", query = "SELECT b FROM BaoQuestion b WHERE b.questionIsJustificationRequired = :questionIsJustificationRequired"),
    @NamedQuery(name = "BaoQuestion.findByQuestionJustification", query = "SELECT b FROM BaoQuestion b WHERE b.questionJustification = :questionJustification"),
    @NamedQuery(name = "BaoQuestion.findByQuestionDifficultyLevel", query = "SELECT b FROM BaoQuestion b WHERE b.questionDifficultyLevel = :questionDifficultyLevel"),
    @NamedQuery(name = "BaoQuestion.findByQuestionState", query = "SELECT b FROM BaoQuestion b WHERE b.questionState = :questionState")})
public class BaoQuestion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "question_id", nullable = false)
    private Integer questionId;
    @Basic(optional = false)
    @Column(name = "question_content", nullable = false, length = 2147483647)
    private String questionContent;
    @Column(name = "question_attachment", length = 2147483647)
    private String questionAttachment;
    @Basic(optional = false)
    @Column(name = "question_answer_proposals", nullable = false, length = 2147483647)
    private String questionAnswerProposals;
    @Basic(optional = false)
    @Column(name = "question_answer", nullable = false)
    private short questionAnswer;
    @Basic(optional = false)
    @Column(name = "question_mark", nullable = false)
    private Double questionMark;
    @Basic(optional = false)
    @Column(name = "question_is_only_for_exam", nullable = false)
    private boolean questionIsOnlyForExam;
    @Basic(optional = false)
    @Column(name = "question_is_justification_required", nullable = false)
    private boolean questionIsJustificationRequired;
    @Basic(optional = false)
    @Column(name = "question_justification", nullable = false, length = 2147483647)
    private String questionJustification;
    @Basic(optional = false)
    @Column(name = "question_difficulty_level", nullable = false)
    private float questionDifficultyLevel;
    @Basic(optional = false)
    @Column(name = "question_state", nullable = false)
    private short questionState;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baoQuestion", fetch = FetchType.LAZY)
    private List<BaoExamSheetQuestion> baoExamSheetQuestionList;
    @JoinColumn(name = "lesson_id", referencedColumnName = "lesson_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoLesson lessonId;

    public BaoQuestion() {
    }

    public BaoQuestion(Integer questionId) {
        this.questionId = questionId;
    }

    public BaoQuestion(Integer questionId, String questionContent, String questionAnswerProposals, short questionAnswer, boolean questionIsOnlyForExam, boolean questionIsJustificationRequired, String questionJustification, float questionDifficultyLevel, short questionState) {
        this.questionId = questionId;
        this.questionContent = questionContent;
        this.questionAnswerProposals = questionAnswerProposals;
        this.questionAnswer = questionAnswer;
        this.questionIsOnlyForExam = questionIsOnlyForExam;
        this.questionIsJustificationRequired = questionIsJustificationRequired;
        this.questionJustification = questionJustification;
        this.questionDifficultyLevel = questionDifficultyLevel;
        this.questionState = questionState;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public String getQuestionAttachment() {
		return questionAttachment;
	}

	public void setQuestionAttachment(String questionAttachment) {
		this.questionAttachment = questionAttachment;
	}

	public Double getQuestionMark() {
		return questionMark;
	}

	public void setQuestionMark(Double questionMark) {
		this.questionMark = questionMark;
	}

	public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public String getQuestionAnswerProposals() {
        return questionAnswerProposals;
    }

    public void setQuestionAnswerProposals(String questionAnswerProposals) {
        this.questionAnswerProposals = questionAnswerProposals;
    }

    public short getQuestionAnswer() {
        return questionAnswer;
    }

    public void setQuestionAnswer(short questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public boolean getQuestionIsOnlyForExam() {
        return questionIsOnlyForExam;
    }

    public void setQuestionIsOnlyForExam(boolean questionIsOnlyForExam) {
        this.questionIsOnlyForExam = questionIsOnlyForExam;
    }

    public boolean getQuestionIsJustificationRequired() {
        return questionIsJustificationRequired;
    }

    public void setQuestionIsJustificationRequired(boolean questionIsJustificationRequired) {
        this.questionIsJustificationRequired = questionIsJustificationRequired;
    }

    public String getQuestionJustification() {
        return questionJustification;
    }

    public void setQuestionJustification(String questionJustification) {
        this.questionJustification = questionJustification;
    }

    public float getQuestionDifficultyLevel() {
        return questionDifficultyLevel;
    }

    public void setQuestionDifficultyLevel(float questionDifficultyLevel) {
        this.questionDifficultyLevel = questionDifficultyLevel;
    }

    public short getQuestionState() {
        return questionState;
    }

    public void setQuestionState(short questionState) {
        this.questionState = questionState;
    }

    public List<BaoExamSheetQuestion> getBaoExamSheetQuestionList() {
        return baoExamSheetQuestionList;
    }

    public void setBaoExamSheetQuestionList(List<BaoExamSheetQuestion> baoExamSheetQuestionList) {
        this.baoExamSheetQuestionList = baoExamSheetQuestionList;
    }

    public BaoLesson getLessonId() {
        return lessonId;
    }

    public void setLessonId(BaoLesson lessonId) {
        this.lessonId = lessonId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionId != null ? questionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoQuestion)) {
            return false;
        }
        BaoQuestion other = (BaoQuestion) object;
        return !((this.questionId == null && other.questionId != null) || (this.questionId != null && !this.questionId.equals(other.questionId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoQuestion[ questionId=" + questionId + " ]";
    }
}
