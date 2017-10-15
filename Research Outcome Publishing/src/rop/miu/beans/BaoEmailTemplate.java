package rop.miu.beans;

import java.io.Serializable;
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
@Table(name = "bao_email_template")
@NamedQueries({
    @NamedQuery(name = "BaoEmailTemplate.findAll", query = "SELECT b FROM BaoEmailTemplate b"),
    @NamedQuery(name = "BaoEmailTemplate.findByEmailTemplateId", query = "SELECT b FROM BaoEmailTemplate b WHERE b.emailTemplateId = :emailTemplateId"),
    @NamedQuery(name = "BaoEmailTemplate.findByEmailTemplateName", query = "SELECT b FROM BaoEmailTemplate b WHERE b.emailTemplateName = :emailTemplateName"),
    @NamedQuery(name = "BaoEmailTemplate.findByEmailTemplateContent", query = "SELECT b FROM BaoEmailTemplate b WHERE b.emailTemplateContent = :emailTemplateContent"),
    @NamedQuery(name = "BaoEmailTemplate.findByEmailTemplateCreationDate", query = "SELECT b FROM BaoEmailTemplate b WHERE b.emailTemplateCreationDate = :emailTemplateCreationDate"),
    @NamedQuery(name = "BaoEmailTemplate.findByEmailTemplateState", query = "SELECT b FROM BaoEmailTemplate b WHERE b.emailTemplateState = :emailTemplateState")})
public class BaoEmailTemplate implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "email_template_id", nullable = false)
    private Integer emailTemplateId;
    @Basic(optional = false)
    @Column(name = "email_template_name", nullable = false, length = 255)
    private String emailTemplateName;
    @Basic(optional = false)
    @Column(name = "email_template_content", nullable = false, length = 2147483647)
    private String emailTemplateContent;
    @Basic(optional = false)
    @Column(name = "email_template_creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date emailTemplateCreationDate;
    @Basic(optional = false)
    @Column(name = "email_template_state", nullable = false)
    private short emailTemplateState;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private BaoUser userId;
    @OneToMany(mappedBy = "emailTemplateId", fetch = FetchType.LAZY)
    private List<BaoProgrammedEmail> baoProgrammedEmailList;

    public BaoEmailTemplate() {
    }

    public BaoEmailTemplate(Integer emailTemplateId) {
        this.emailTemplateId = emailTemplateId;
    }

    public BaoEmailTemplate(Integer emailTemplateId, String emailTemplateName, String emailTemplateContent, Date emailTemplateCreationDate, short emailTemplateState) {
        this.emailTemplateId = emailTemplateId;
        this.emailTemplateName = emailTemplateName;
        this.emailTemplateContent = emailTemplateContent;
        this.emailTemplateCreationDate = emailTemplateCreationDate;
        this.emailTemplateState = emailTemplateState;
    }

    public Integer getEmailTemplateId() {
        return emailTemplateId;
    }

    public void setEmailTemplateId(Integer emailTemplateId) {
        this.emailTemplateId = emailTemplateId;
    }

    public String getEmailTemplateName() {
        return emailTemplateName;
    }

    public void setEmailTemplateName(String emailTemplateName) {
        this.emailTemplateName = emailTemplateName;
    }

    public String getEmailTemplateContent() {
        return emailTemplateContent;
    }

    public void setEmailTemplateContent(String emailTemplateContent) {
        this.emailTemplateContent = emailTemplateContent;
    }

    public Date getEmailTemplateCreationDate() {
        return emailTemplateCreationDate;
    }

    public void setEmailTemplateCreationDate(Date emailTemplateCreationDate) {
        this.emailTemplateCreationDate = emailTemplateCreationDate;
    }

    public short getEmailTemplateState() {
        return emailTemplateState;
    }

    public void setEmailTemplateState(short emailTemplateState) {
        this.emailTemplateState = emailTemplateState;
    }

    public BaoUser getUserId() {
        return userId;
    }

    public void setUserId(BaoUser userId) {
        this.userId = userId;
    }

    public List<BaoProgrammedEmail> getBaoProgrammedEmailList() {
        return baoProgrammedEmailList;
    }

    public void setBaoProgrammedEmailList(List<BaoProgrammedEmail> baoProgrammedEmailList) {
        this.baoProgrammedEmailList = baoProgrammedEmailList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (emailTemplateId != null ? emailTemplateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BaoEmailTemplate)) {
            return false;
        }
        BaoEmailTemplate other = (BaoEmailTemplate) object;
        if ((this.emailTemplateId == null && other.emailTemplateId != null) || (this.emailTemplateId != null && !this.emailTemplateId.equals(other.emailTemplateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoEmailTemplate[ emailTemplateId=" + emailTemplateId + " ]";
    }
    
}
