package rop.miu.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_additional_info", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_twitter_account"}),
    @UniqueConstraint(columnNames = {"user_facebook_account"}),
    @UniqueConstraint(columnNames = {"user_linkedin_account"})})
@NamedQueries({
    @NamedQuery(name = "BaoAdditionalInfo.findAll", query = "SELECT b FROM BaoAdditionalInfo b"),
    @NamedQuery(name = "BaoAdditionalInfo.findByAdditionalInfoId", query = "SELECT b FROM BaoAdditionalInfo b WHERE b.additionalInfoId = :additionalInfoId"),
    @NamedQuery(name = "BaoAdditionalInfo.findByUserDefaultLanguage", query = "SELECT b FROM BaoAdditionalInfo b WHERE b.userDefaultLanguage = :userDefaultLanguage"),
    @NamedQuery(name = "BaoAdditionalInfo.findByUserRegistrationDate", query = "SELECT b FROM BaoAdditionalInfo b WHERE b.userRegistrationDate = :userRegistrationDate"),
    @NamedQuery(name = "BaoAdditionalInfo.findByUserAvatar", query = "SELECT b FROM BaoAdditionalInfo b WHERE b.userAvatar = :userAvatar"),
    @NamedQuery(name = "BaoAdditionalInfo.findByUserAvatarType", query = "SELECT b FROM BaoAdditionalInfo b WHERE b.userAvatarType = :userAvatarType"),
    @NamedQuery(name = "BaoAdditionalInfo.findByUserCurrentWork", query = "SELECT b FROM BaoAdditionalInfo b WHERE b.userCurrentWork = :userCurrentWork"),
    @NamedQuery(name = "BaoAdditionalInfo.findByUserCurrentInstitution", query = "SELECT b FROM BaoAdditionalInfo b WHERE b.userCurrentInstitution = :userCurrentInstitution"),
    @NamedQuery(name = "BaoAdditionalInfo.findByUserPhoneNumber", query = "SELECT b FROM BaoAdditionalInfo b WHERE b.userPhoneNumber = :userPhoneNumber"),
    @NamedQuery(name = "BaoAdditionalInfo.findByUserFacebookAccount", query = "SELECT b FROM BaoAdditionalInfo b WHERE b.userFacebookAccount = :userFacebookAccount"),
    @NamedQuery(name = "BaoAdditionalInfo.findByUserTwitterAccount", query = "SELECT b FROM BaoAdditionalInfo b WHERE b.userTwitterAccount = :userTwitterAccount"),
    @NamedQuery(name = "BaoAdditionalInfo.findByUserLinkedinAccount", query = "SELECT b FROM BaoAdditionalInfo b WHERE b.userLinkedinAccount = :userLinkedinAccount"),
    @NamedQuery(name = "BaoAdditionalInfo.findByUserWebsiteUrl", query = "SELECT b FROM BaoAdditionalInfo b WHERE b.userWebsiteUrl = :userWebsiteUrl")})
public class BaoAdditionalInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "additional_info_id", nullable = false)
    private Integer additionalInfoId;
    @Column(name = "user_default_language", length = 30)
    private String userDefaultLanguage;
    @Basic(optional = false)
    @Column(name = "user_registration_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date userRegistrationDate;
    @Column(name = "user_avatar", length = 255)
    private String userAvatar;
    @Column(name = "user_avatar_type", length = 10)
    private String userAvatarType;
    @Column(name = "user_current_work", length = 200)
    private String userCurrentWork;
    @Column(name = "user_current_institution", length = 200)
    private String userCurrentInstitution;
    @Column(name = "user_phone_number", length = 30)
    private String userPhoneNumber;
    @Column(name = "user_facebook_account", length = 150)
    private String userFacebookAccount;
    @Column(name = "user_twitter_account", length = 150)
    private String userTwitterAccount;
    @Column(name = "user_linkedin_account", length = 150)
    private String userLinkedinAccount;
    @Column(name = "user_website_url", length = 150)
    private String userWebsiteUrl;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "additionalInfoId", fetch = FetchType.EAGER)
    private BaoUser baoUser;

    public BaoAdditionalInfo() {
    }

    public BaoAdditionalInfo(Integer additionalInfoId) {
        this.additionalInfoId = additionalInfoId;
    }

    public BaoAdditionalInfo(Integer additionalInfoId, Date userRegistrationDate) {
        this.additionalInfoId = additionalInfoId;
        this.userRegistrationDate = userRegistrationDate;
    }

    public Integer getAdditionalInfoId() {
        return additionalInfoId;
    }

    public void setAdditionalInfoId(Integer additionalInfoId) {
        this.additionalInfoId = additionalInfoId;
    }

    public String getUserDefaultLanguage() {
        return userDefaultLanguage;
    }

    public void setUserDefaultLanguage(String userDefaultLanguage) {
        this.userDefaultLanguage = userDefaultLanguage;
    }

    public Date getUserRegistrationDate() {
        return userRegistrationDate;
    }

    public void setUserRegistrationDate(Date userRegistrationDate) {
        this.userRegistrationDate = userRegistrationDate;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserAvatarType() {
        return userAvatarType;
    }

    public void setUserAvatarType(String userAvatarType) {
        this.userAvatarType = userAvatarType;
    }

    public String getUserCurrentWork() {
        return userCurrentWork;
    }

    public void setUserCurrentWork(String userCurrentWork) {
        this.userCurrentWork = userCurrentWork;
    }

    public String getUserCurrentInstitution() {
        return userCurrentInstitution;
    }

    public void setUserCurrentInstitution(String userCurrentInstitution) {
        this.userCurrentInstitution = userCurrentInstitution;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getUserFacebookAccount() {
        return userFacebookAccount;
    }

    public void setUserFacebookAccount(String userFacebookAccount) {
        this.userFacebookAccount = userFacebookAccount;
    }

    public String getUserTwitterAccount() {
        return userTwitterAccount;
    }

    public void setUserTwitterAccount(String userTwitterAccount) {
        this.userTwitterAccount = userTwitterAccount;
    }

    public String getUserLinkedinAccount() {
        return userLinkedinAccount;
    }

    public void setUserLinkedinAccount(String userLinkedinAccount) {
        this.userLinkedinAccount = userLinkedinAccount;
    }

    public String getUserWebsiteUrl() {
        return userWebsiteUrl;
    }

    public void setUserWebsiteUrl(String userWebsiteUrl) {
        this.userWebsiteUrl = userWebsiteUrl;
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
        hash += (additionalInfoId != null ? additionalInfoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoAdditionalInfo)) {
            return false;
        }
        BaoAdditionalInfo other = (BaoAdditionalInfo) object;
        return !((this.additionalInfoId == null && other.additionalInfoId != null) || (this.additionalInfoId != null && !this.additionalInfoId.equals(other.additionalInfoId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoAdditionalInfo[ additionalInfoId=" + additionalInfoId + " ]";
    }
}
