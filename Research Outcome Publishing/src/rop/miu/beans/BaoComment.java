package rop.miu.beans;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "bao_comment")
@NamedQueries({
    @NamedQuery(name = "BaoComment.findAll", query = "SELECT b FROM BaoComment b"),
    @NamedQuery(name = "BaoComment.findByCommentId", query = "SELECT b FROM BaoComment b WHERE b.commentId = :commentId"),
    @NamedQuery(name = "BaoComment.findByCommentContent", query = "SELECT b FROM BaoComment b WHERE b.commentContent = :commentContent"),
    @NamedQuery(name = "BaoComment.findByCommentDate", query = "SELECT b FROM BaoComment b WHERE b.commentDate = :commentDate"),
    @NamedQuery(name = "BaoComment.findByCommentLike", query = "SELECT b FROM BaoComment b WHERE b.commentLike = :commentLike"),
    @NamedQuery(name = "BaoComment.findByCommentState", query = "SELECT b FROM BaoComment b WHERE b.commentState = :commentState")})
public class BaoComment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "comment_id", nullable = false)
    private Integer commentId;
    @Basic(optional = false)
    @Column(name = "comment_content", nullable = false, length = 2147483647)
    private String commentContent;
    @Basic(optional = false)
    @Column(name = "comment_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;
    @Column(name = "comment_like")
    private BigInteger commentLike;
    @Basic(optional = false)
    @Column(name = "comment_state", nullable = false)
    private short commentState;
    @OneToMany(mappedBy = "commentIdParent", fetch = FetchType.LAZY)
    private List<BaoComment> baoCommentList;
    @JoinColumn(name = "comment_id_parent", referencedColumnName = "comment_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private BaoComment commentIdParent;
    @JoinColumn(name = "news_id", referencedColumnName = "news_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoNews newsId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser userId;

    public BaoComment() {
    }

    public BaoComment(Integer commentId) {
        this.commentId = commentId;
    }

    public BaoComment(Integer commentId, String commentContent, Date commentDate, short commentState) {
        this.commentId = commentId;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
        this.commentState = commentState;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public BigInteger getCommentLike() {
        return commentLike;
    }

    public void setCommentLike(BigInteger commentLike) {
        this.commentLike = commentLike;
    }

    public short getCommentState() {
        return commentState;
    }

    public void setCommentState(short commentState) {
        this.commentState = commentState;
    }

    public List<BaoComment> getBaoCommentList() {
        return baoCommentList;
    }

    public void setBaoCommentList(List<BaoComment> baoCommentList) {
        this.baoCommentList = baoCommentList;
    }

    public BaoComment getCommentIdParent() {
        return commentIdParent;
    }

    public void setCommentIdParent(BaoComment commentIdParent) {
        this.commentIdParent = commentIdParent;
    }

    public BaoNews getNewsId() {
        return newsId;
    }

    public void setNewsId(BaoNews newsId) {
        this.newsId = newsId;
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
        hash += (commentId != null ? commentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoComment)) {
            return false;
        }
        BaoComment other = (BaoComment) object;
        return !((this.commentId == null && other.commentId != null) || (this.commentId != null && !this.commentId.equals(other.commentId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoComment[ commentId=" + commentId + " ]";
    }
}
