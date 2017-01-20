package rop.miu.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_paper_author")
@NamedQueries({
    @NamedQuery(name = "BaoPaperAuthor.findAll", query = "SELECT b FROM BaoPaperAuthor b"),
    @NamedQuery(name = "BaoPaperAuthor.findByUserId", query = "SELECT b FROM BaoPaperAuthor b WHERE b.baoPaperAuthorPK.userId = :userId"),
    @NamedQuery(name = "BaoPaperAuthor.findByPaperId", query = "SELECT b FROM BaoPaperAuthor b WHERE b.baoPaperAuthorPK.paperId = :paperId"),
    @NamedQuery(name = "BaoPaperAuthor.findByAuthorInstitution", query = "SELECT b FROM BaoPaperAuthor b WHERE b.authorInstitution = :authorInstitution"),
    @NamedQuery(name = "BaoPaperAuthor.findByAuthorEmail", query = "SELECT b FROM BaoPaperAuthor b WHERE b.authorEmail = :authorEmail")})
public class BaoPaperAuthor implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BaoPaperAuthorPK baoPaperAuthorPK;
    @Basic(optional = false)
    @Column(name = "author_institution", nullable = false, length = 255)
    private String authorInstitution;
    @Basic(optional = false)
    @Column(name = "author_email", nullable = false, length = 150)
    private String authorEmail;
    @JoinColumn(name = "paper_id", referencedColumnName = "paper_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoPaper baoPaper;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser baoUser;

    public BaoPaperAuthor() {
    }

    public BaoPaperAuthor(BaoPaperAuthorPK baoPaperAuthorPK) {
        this.baoPaperAuthorPK = baoPaperAuthorPK;
    }

    public BaoPaperAuthor(BaoPaperAuthorPK baoPaperAuthorPK, String authorInstitution, String authorEmail) {
        this.baoPaperAuthorPK = baoPaperAuthorPK;
        this.authorInstitution = authorInstitution;
        this.authorEmail = authorEmail;
    }

    public BaoPaperAuthor(long userId, long paperId) {
        this.baoPaperAuthorPK = new BaoPaperAuthorPK(userId, paperId);
    }

    public BaoPaperAuthorPK getBaoPaperAuthorPK() {
        return baoPaperAuthorPK;
    }

    public void setBaoPaperAuthorPK(BaoPaperAuthorPK baoPaperAuthorPK) {
        this.baoPaperAuthorPK = baoPaperAuthorPK;
    }

    public String getAuthorInstitution() {
        return authorInstitution;
    }

    public void setAuthorInstitution(String authorInstitution) {
        this.authorInstitution = authorInstitution;
    }

    public String getAuthorEmail() {
        return authorEmail;
    }

    public void setAuthorEmail(String authorEmail) {
        this.authorEmail = authorEmail;
    }

    public BaoPaper getBaoPaper() {
        return baoPaper;
    }

    public void setBaoPaper(BaoPaper baoPaper) {
        this.baoPaper = baoPaper;
    }

    public BaoUser getBaoUser() {
        return baoUser;
    }

    public void setBaoUser(BaoUser baoUser) {
        this.baoUser = baoUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (baoPaperAuthorPK != null ? baoPaperAuthorPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoPaperAuthor)) {
            return false;
        }
        BaoPaperAuthor other = (BaoPaperAuthor) object;
        return !((this.baoPaperAuthorPK == null && other.baoPaperAuthorPK != null) || (this.baoPaperAuthorPK != null && !this.baoPaperAuthorPK.equals(other.baoPaperAuthorPK)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoPaperAuthor[ baoPaperAuthorPK=" + baoPaperAuthorPK + " ]";
    }
}
