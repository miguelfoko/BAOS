package rop.miu.beans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_category", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"category_name"})})
@NamedQueries({
    @NamedQuery(name = "BaoCategory.findAll", query = "SELECT b FROM BaoCategory b"),
    @NamedQuery(name = "BaoCategory.findByCategoryId", query = "SELECT b FROM BaoCategory b WHERE b.categoryId = :categoryId"),
    @NamedQuery(name = "BaoCategory.findByCategoryName", query = "SELECT b FROM BaoCategory b WHERE b.categoryName = :categoryName"),
    @NamedQuery(name = "BaoCategory.findByCategoryDesc", query = "SELECT b FROM BaoCategory b WHERE b.categoryDesc = :categoryDesc"),
    @NamedQuery(name = "BaoCategory.findByCategoryState", query = "SELECT b FROM BaoCategory b WHERE b.categoryState = :categoryState")})
public class BaoCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "category_id", nullable = false)
    private Integer categoryId;
    @Basic(optional = false)
    @Column(name = "category_name", nullable = false, length = 255)
    private String categoryName;
    @Column(name = "category_desc", length = 2147483647)
    private String categoryDesc;
    @Basic(optional = false)
    @Column(name = "category_state", nullable = false)
    private short categoryState;
    @JoinTable(name = "bao_news_category", joinColumns = {
        @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "news_id", referencedColumnName = "news_id", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<BaoNews> baoNewsList;
    @OneToMany(mappedBy = "categoryIdParent", fetch = FetchType.LAZY)
    private List<BaoCategory> baoCategoryList;
    @JoinColumn(name = "category_id_parent", referencedColumnName = "category_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private BaoCategory categoryIdParent;

    public BaoCategory() {
    }

    public BaoCategory(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public BaoCategory(Integer categoryId, String categoryName, short categoryState) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryState = categoryState;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    public short getCategoryState() {
        return categoryState;
    }

    public void setCategoryState(short categoryState) {
        this.categoryState = categoryState;
    }

    public List<BaoNews> getBaoNewsList() {
        return baoNewsList;
    }

    public void setBaoNewsList(List<BaoNews> baoNewsList) {
        this.baoNewsList = baoNewsList;
    }

    public List<BaoCategory> getBaoCategoryList() {
        return baoCategoryList;
    }

    public void setBaoCategoryList(List<BaoCategory> baoCategoryList) {
        this.baoCategoryList = baoCategoryList;
    }

    public BaoCategory getCategoryIdParent() {
        return categoryIdParent;
    }

    public void setCategoryIdParent(BaoCategory categoryIdParent) {
        this.categoryIdParent = categoryIdParent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoCategory)) {
            return false;
        }
        BaoCategory other = (BaoCategory) object;
        return !((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoCategory[ categoryId=" + categoryId + " ]";
    } 
}
