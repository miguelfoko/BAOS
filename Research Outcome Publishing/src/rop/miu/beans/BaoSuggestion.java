package rop.miu.beans;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_suggestion")
@NamedQueries({
    @NamedQuery(name = "BaoSuggestion.findAll", query = "SELECT b FROM BaoSuggestion b"),
    @NamedQuery(name = "BaoSuggestion.findBySuggestionId", query = "SELECT b FROM BaoSuggestion b WHERE b.suggestionId = :suggestionId"),
    @NamedQuery(name = "BaoSuggestion.findBySuggestionTitle", query = "SELECT b FROM BaoSuggestion b WHERE b.suggestionTitle = :suggestionTitle"),
    @NamedQuery(name = "BaoSuggestion.findBySuggestionContent", query = "SELECT b FROM BaoSuggestion b WHERE b.suggestionContent = :suggestionContent"),
    @NamedQuery(name = "BaoSuggestion.findBySuggestionDate", query = "SELECT b FROM BaoSuggestion b WHERE b.suggestionDate = :suggestionDate"),
    @NamedQuery(name = "BaoSuggestion.findBySuggestionSubmitterName", query = "SELECT b FROM BaoSuggestion b WHERE b.suggestionSubmitterName = :suggestionSubmitterName"),
    @NamedQuery(name = "BaoSuggestion.findBySuggestionSubmitterEmail", query = "SELECT b FROM BaoSuggestion b WHERE b.suggestionSubmitterEmail = :suggestionSubmitterEmail"),
    @NamedQuery(name = "BaoSuggestion.findBySuggestionLike", query = "SELECT b FROM BaoSuggestion b WHERE b.suggestionLike = :suggestionLike"),
    @NamedQuery(name = "BaoSuggestion.findBySuggestionState", query = "SELECT b FROM BaoSuggestion b WHERE b.suggestionState = :suggestionState")})
public class BaoSuggestion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "suggestion_id", nullable = false)
    private Integer suggestionId;
    @Basic(optional = false)
    @Column(name = "suggestion_title", nullable = false, length = 255)
    private String suggestionTitle;
    @Basic(optional = false)
    @Column(name = "suggestion_content", nullable = false, length = 2147483647)
    private String suggestionContent;
    @Basic(optional = false)
    @Column(name = "suggestion_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date suggestionDate;
    @Column(name = "suggestion_submitter_name", length = 150)
    private String suggestionSubmitterName;
    @Column(name = "suggestion_submitter_email", length = 150)
    private String suggestionSubmitterEmail;
    @Column(name = "suggestion_like")
    private BigInteger suggestionLike;
    @Basic(optional = false)
    @Column(name = "suggestion_state", nullable = false)
    private short suggestionState;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser userId;

    public BaoSuggestion() {
    }

    public BaoSuggestion(Integer suggestionId) {
        this.suggestionId = suggestionId;
    }

    public BaoSuggestion(Integer suggestionId, String suggestionTitle, String suggestionContent, Date suggestionDate, short suggestionState) {
        this.suggestionId = suggestionId;
        this.suggestionTitle = suggestionTitle;
        this.suggestionContent = suggestionContent;
        this.suggestionDate = suggestionDate;
        this.suggestionState = suggestionState;
    }

    public Integer getSuggestionId() {
        return suggestionId;
    }

    public void setSuggestionId(Integer suggestionId) {
        this.suggestionId = suggestionId;
    }

    public String getSuggestionTitle() {
        return suggestionTitle;
    }

    public void setSuggestionTitle(String suggestionTitle) {
        this.suggestionTitle = suggestionTitle;
    }

    public String getSuggestionContent() {
        return suggestionContent;
    }

    public void setSuggestionContent(String suggestionContent) {
        this.suggestionContent = suggestionContent;
    }

    public Date getSuggestionDate() {
        return suggestionDate;
    }

    public void setSuggestionDate(Date suggestionDate) {
        this.suggestionDate = suggestionDate;
    }

    public String getSuggestionSubmitterName() {
        return suggestionSubmitterName;
    }

    public void setSuggestionSubmitterName(String suggestionSubmitterName) {
        this.suggestionSubmitterName = suggestionSubmitterName;
    }

    public String getSuggestionSubmitterEmail() {
        return suggestionSubmitterEmail;
    }

    public void setSuggestionSubmitterEmail(String suggestionSubmitterEmail) {
        this.suggestionSubmitterEmail = suggestionSubmitterEmail;
    }

    public BigInteger getSuggestionLike() {
        return suggestionLike;
    }

    public void setSuggestionLike(BigInteger suggestionLike) {
        this.suggestionLike = suggestionLike;
    }

    public short getSuggestionState() {
        return suggestionState;
    }

    public void setSuggestionState(short suggestionState) {
        this.suggestionState = suggestionState;
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
        hash += (suggestionId != null ? suggestionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BaoSuggestion)) {
            return false;
        }
        BaoSuggestion other = (BaoSuggestion) object;
        if ((this.suggestionId == null && other.suggestionId != null) || (this.suggestionId != null && !this.suggestionId.equals(other.suggestionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoSuggestion[ suggestionId=" + suggestionId + " ]";
    }
    
}
