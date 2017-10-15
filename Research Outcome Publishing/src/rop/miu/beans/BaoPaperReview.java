package rop.miu.beans;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_paper_review")
@NamedQueries({
    @NamedQuery(name = "BaoPaperReview.findAll", query = "SELECT b FROM BaoPaperReview b"),
    @NamedQuery(name = "BaoPaperReview.findByUserId", query = "SELECT b FROM BaoPaperReview b WHERE b.baoPaperReviewPK.userId = :userId"),
    @NamedQuery(name = "BaoPaperReview.findByPaperId", query = "SELECT b FROM BaoPaperReview b WHERE b.baoPaperReviewPK.paperId = :paperId"),
    @NamedQuery(name = "BaoPaperReview.findByPaperReviewReport", query = "SELECT b FROM BaoPaperReview b WHERE b.paperReviewReport = :paperReviewReport"),
    @NamedQuery(name = "BaoPaperReview.findByPaperReviewDate", query = "SELECT b FROM BaoPaperReview b WHERE b.paperReviewDate = :paperReviewDate"),
    @NamedQuery(name = "BaoPaperReview.findByPaperReviewMark", query = "SELECT b FROM BaoPaperReview b WHERE b.paperReviewMark = :paperReviewMark"),
    @NamedQuery(name = "BaoPaperReview.findByPaperReviewState", query = "SELECT b FROM BaoPaperReview b WHERE b.paperReviewState = :paperReviewState")})
public class BaoPaperReview implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BaoPaperReviewPK baoPaperReviewPK;
    @Column(name = "paper_review_report", length = 2147483647)
    private String paperReviewReport;
    @Column(name = "paper_review_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paperReviewDate;
    @Column(name = "paper_review_mark", precision = 8, scale = 8)
    private Float paperReviewMark;
    @Basic(optional = false)
    @Column(name = "paper_review_state", nullable = false)
    private short paperReviewState;
    @JoinColumn(name = "paper_id", referencedColumnName = "paper_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoPaper baoPaper;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser baoUser;

    public BaoPaperReview() {
    }

    public BaoPaperReview(BaoPaperReviewPK baoPaperReviewPK) {
        this.baoPaperReviewPK = baoPaperReviewPK;
    }

    public BaoPaperReview(BaoPaperReviewPK baoPaperReviewPK, short paperReviewState) {
        this.baoPaperReviewPK = baoPaperReviewPK;
        this.paperReviewState = paperReviewState;
    }

    public BaoPaperReview(long userId, long paperId) {
        this.baoPaperReviewPK = new BaoPaperReviewPK(userId, paperId);
    }

    public BaoPaperReviewPK getBaoPaperReviewPK() {
        return baoPaperReviewPK;
    }

    public void setBaoPaperReviewPK(BaoPaperReviewPK baoPaperReviewPK) {
        this.baoPaperReviewPK = baoPaperReviewPK;
    }

    public String getPaperReviewReport() {
        return paperReviewReport;
    }

    public void setPaperReviewReport(String paperReviewReport) {
        this.paperReviewReport = paperReviewReport;
    }

    public Date getPaperReviewDate() {
        return paperReviewDate;
    }

    public void setPaperReviewDate(Date paperReviewDate) {
        this.paperReviewDate = paperReviewDate;
    }

    public Float getPaperReviewMark() {
        return paperReviewMark;
    }

    public void setPaperReviewMark(Float paperReviewMark) {
        this.paperReviewMark = paperReviewMark;
    }

    public short getPaperReviewState() {
        return paperReviewState;
    }

    public void setPaperReviewState(short paperReviewState) {
        this.paperReviewState = paperReviewState;
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
        hash += (baoPaperReviewPK != null ? baoPaperReviewPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoPaperReview)) {
            return false;
        }
        BaoPaperReview other = (BaoPaperReview) object;
        return !((this.baoPaperReviewPK == null && other.baoPaperReviewPK != null) || (this.baoPaperReviewPK != null && !this.baoPaperReviewPK.equals(other.baoPaperReviewPK)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoPaperReview[ baoPaperReviewPK=" + baoPaperReviewPK + " ]";
    }
    
}
