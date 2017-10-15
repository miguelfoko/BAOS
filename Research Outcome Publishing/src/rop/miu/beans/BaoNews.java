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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_news", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"news_key"})})
@NamedQueries({
    @NamedQuery(name = "BaoNews.findAll", query = "SELECT b FROM BaoNews b"),
    @NamedQuery(name = "BaoNews.findByNewsId", query = "SELECT b FROM BaoNews b WHERE b.newsId = :newsId"),
    @NamedQuery(name = "BaoNews.findByNewsTitle", query = "SELECT b FROM BaoNews b WHERE b.newsTitle = :newsTitle"),
    @NamedQuery(name = "BaoNews.findByNewsKey", query = "SELECT b FROM BaoNews b WHERE b.newsKey = :newsKey"),
    @NamedQuery(name = "BaoNews.findByNewsLanguage", query = "SELECT b FROM BaoNews b WHERE b.newsLanguage = :newsLanguage"),
    @NamedQuery(name = "BaoNews.findByNewsIsTraduction", query = "SELECT b FROM BaoNews b WHERE b.newsIsTraduction = :newsIsTraduction"),
    @NamedQuery(name = "BaoNews.findByNewsContent", query = "SELECT b FROM BaoNews b WHERE b.newsContent = :newsContent"),
    @NamedQuery(name = "BaoNews.findByNewsDate", query = "SELECT b FROM BaoNews b WHERE b.newsDate = :newsDate"),
    @NamedQuery(name = "BaoNews.findByNewsKeywords", query = "SELECT b FROM BaoNews b WHERE b.newsKeywords = :newsKeywords"),
    @NamedQuery(name = "BaoNews.findByNewsState", query = "SELECT b FROM BaoNews b WHERE b.newsState = :newsState")})
public class BaoNews implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "news_id", nullable = false)
    private Integer newsId;
    @Basic(optional = false)
    @Column(name = "news_title", nullable = false, length = 255)
    private String newsTitle;
    @Basic(optional = false)
    @Column(name = "news_key", nullable = false, length = 255)
    private String newsKey;
    @Basic(optional = false)
    @Column(name = "news_language", nullable = false, length = 30)
    private String newsLanguage;
    @Basic(optional = false)
    @Column(name = "news_is_traduction", nullable = false)
    private boolean newsIsTraduction;
    @Basic(optional = false)
    @Column(name = "news_content", nullable = false, length = 2147483647)
    private String newsContent;
    @Basic(optional = false)
    @Column(name = "news_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date newsDate;
    @Column(name = "news_keywords", length = 2147483647)
    private String newsKeywords;
    @Basic(optional = false)
    @Column(name = "news_state", nullable = false)
    private short newsState;
    @ManyToMany(mappedBy = "baoNewsList", fetch = FetchType.LAZY)
    private List<BaoCategory> baoCategoryList;
    @OneToMany(mappedBy = "newsIdCallForPaper", fetch = FetchType.LAZY)
    private List<BaoVolumeOrIssue> baoVolumeOrIssueList;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "newsId", fetch = FetchType.LAZY)
    private List<BaoComment> baoCommentList;

    public BaoNews() {
    }

    public BaoNews(Integer newsId) {
        this.newsId = newsId;
    }

    public BaoNews(Integer newsId, String newsTitle, String newsKey, String newsLanguage, boolean newsIsTraduction, String newsContent, Date newsDate, short newsState) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newsKey = newsKey;
        this.newsLanguage = newsLanguage;
        this.newsIsTraduction = newsIsTraduction;
        this.newsContent = newsContent;
        this.newsDate = newsDate;
        this.newsState = newsState;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsKey() {
        return newsKey;
    }

    public void setNewsKey(String newsKey) {
        this.newsKey = newsKey;
    }

    public String getNewsLanguage() {
        return newsLanguage;
    }

    public void setNewsLanguage(String newsLanguage) {
        this.newsLanguage = newsLanguage;
    }

    public boolean getNewsIsTraduction() {
        return newsIsTraduction;
    }

    public void setNewsIsTraduction(boolean newsIsTraduction) {
        this.newsIsTraduction = newsIsTraduction;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public Date getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(Date newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsKeywords() {
        return newsKeywords;
    }

    public void setNewsKeywords(String newsKeywords) {
        this.newsKeywords = newsKeywords;
    }

    public short getNewsState() {
        return newsState;
    }

    public void setNewsState(short newsState) {
        this.newsState = newsState;
    }

    public List<BaoCategory> getBaoCategoryList() {
        return baoCategoryList;
    }

    public void setBaoCategoryList(List<BaoCategory> baoCategoryList) {
        this.baoCategoryList = baoCategoryList;
    }

    public List<BaoVolumeOrIssue> getBaoVolumeOrIssueList() {
        return baoVolumeOrIssueList;
    }

    public void setBaoVolumeOrIssueList(List<BaoVolumeOrIssue> baoVolumeOrIssueList) {
        this.baoVolumeOrIssueList = baoVolumeOrIssueList;
    }

    public BaoUser getUserId() {
        return userId;
    }

    public void setUserId(BaoUser userId) {
        this.userId = userId;
    }

    public List<BaoComment> getBaoCommentList() {
        return baoCommentList;
    }

    public void setBaoCommentList(List<BaoComment> baoCommentList) {
        this.baoCommentList = baoCommentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (newsId != null ? newsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoNews)) {
            return false;
        }
        BaoNews other = (BaoNews) object;
        return !((this.newsId == null && other.newsId != null) || (this.newsId != null && !this.newsId.equals(other.newsId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoNews[ newsId=" + newsId + " ]";
    }
}
