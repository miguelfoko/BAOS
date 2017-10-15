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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "bao_user", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"additional_info_id"}),
    @UniqueConstraint(columnNames = {"user_login"}),
    @UniqueConstraint(columnNames = {"user_email"})})
@NamedQueries({
    @NamedQuery(name = "BaoUser.findAll", query = "SELECT b FROM BaoUser b"),
    @NamedQuery(name = "BaoUser.findByUserId", query = "SELECT b FROM BaoUser b WHERE b.userId = :userId"),
    @NamedQuery(name = "BaoUser.findByUserLogin", query = "SELECT b FROM BaoUser b WHERE b.userLogin = :userLogin"),
    @NamedQuery(name = "BaoUser.findByUserEmail", query = "SELECT b FROM BaoUser b WHERE b.userEmail = :userEmail"),
    @NamedQuery(name = "BaoUser.findByUserPassword", query = "SELECT b FROM BaoUser b WHERE b.userPassword = :userPassword"),
    @NamedQuery(name = "BaoUser.findByUserName", query = "SELECT b FROM BaoUser b WHERE b.userName = :userName"),
    @NamedQuery(name = "BaoUser.findByUserSurname", query = "SELECT b FROM BaoUser b WHERE b.userSurname = :userSurname"),
    @NamedQuery(name = "BaoUser.findByUserBirthday", query = "SELECT b FROM BaoUser b WHERE b.userBirthday = :userBirthday"),
    @NamedQuery(name = "BaoUser.findByUserBiography", query = "SELECT b FROM BaoUser b WHERE b.userBiography = :userBiography"),
    @NamedQuery(name = "BaoUser.findByUserAccountState", query = "SELECT b FROM BaoUser b WHERE b.userAccountState = :userAccountState")})
public class BaoUser implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "user_login", nullable = false, length = 30)
    private String userLogin;
    @Basic(optional = false)
    @Column(name = "user_email", nullable = false, length = 100)
    private String userEmail;
    @Basic(optional = false)
    @Column(name = "user_password", nullable = false, length = 250)
    private String userPassword;
    @Basic(optional = false)
    @Column(name = "user_name", nullable = false, length = 150)
    private String userName;
    @Column(name = "user_surname", length = 150)
    private String userSurname;
    @Column(name = "user_birthday")
    @Temporal(TemporalType.DATE)
    private Date userBirthday;
    @Column(name = "user_biography", length = 2147483647)
    private String userBiography;
    @Basic(optional = false)
    @Column(name = "user_account_state", nullable = false)
    private short userAccountState;
    @ManyToMany(mappedBy = "baoUserList", fetch = FetchType.LAZY)
    private List<BaoGroup> baoGroupList;
    @ManyToMany(mappedBy = "baoUserList", fetch = FetchType.LAZY)
    private List<BaoMailingList> baoMailingListList;
    @OneToMany(mappedBy = "userIdAutomaticEditor", fetch = FetchType.LAZY)
    private List<BaoAutomaticReviewCondition> baoAutomaticReviewConditionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baoUser", fetch = FetchType.LAZY)
    private List<BaoMonitorCourse> baoMonitorCourseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIdAssociatedAccount", fetch = FetchType.LAZY)
    private List<BaoPartner> baoPartnerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<BaoNotification> baoNotificationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baoUser", fetch = FetchType.LAZY)
    private List<BaoPaperAuthor> baoPaperAuthorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baoUser", fetch = FetchType.LAZY)
    private List<BaoTeacherCourse> baoTeacherCourseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<BaoSuggestion> baoSuggestionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<BaoIntervention> baoInterventionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIdPaperOwner", fetch = FetchType.LAZY)
    private List<BaoPaper> baoPaperList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIdEditor", fetch = FetchType.LAZY)
    private List<BaoPaper> baoPaperList1;
    @JoinColumn(name = "additional_info_id", referencedColumnName = "additional_info_id", nullable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private BaoAdditionalInfo additionalInfoId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baoUser", fetch = FetchType.LAZY)
    private List<BaoPaperExcludedReviewer> baoExcludedReviewerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baoUser", fetch = FetchType.LAZY)
    private List<BaoPartnerUser> baoPartnerUserList;
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<BaoAccessCoupon> baoAccessCouponList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<BaoNews> baoNewsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<BaoEmailBugReport> baoEmailBugReportList;
    @OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
    private List<BaoEmailTemplate> baoEmailTemplateList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baoUser", fetch = FetchType.LAZY)
    private List<BaoStudentCourse> baoStudentCourseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baoUser", fetch = FetchType.LAZY)
    private List<BaoPaperReview> baoPaperReviewList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<BaoProgrammedEmail> baoProgrammedEmailList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<BaoComment> baoCommentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<BaoExamSheet> baoExamSheetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIdReviewerOrEditor", fetch = FetchType.LAZY)
    private List<BaoReviewOrEditionContract> baoReviewOrEditionContractList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIdContractCreator", fetch = FetchType.LAZY)
    private List<BaoReviewOrEditionContract> baoReviewOrEditionContractList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<BaoPartnershipContract> baoPartnershipContractList;

    public BaoUser() {
    }

    public BaoUser(Integer userId) {
        this.userId = userId;
    }

    public BaoUser(Integer userId, String userLogin, String userEmail, String userPassword, String userName, short userAccountState) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userAccountState = userAccountState;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserBiography() {
        return userBiography;
    }

    public void setUserBiography(String userBiography) {
        this.userBiography = userBiography;
    }

    public short getUserAccountState() {
        return userAccountState;
    }

    public void setUserAccountState(short userAccountState) {
        this.userAccountState = userAccountState;
    }

    public List<BaoGroup> getBaoGroupList() {
        return baoGroupList;
    }

    public void setBaoGroupList(List<BaoGroup> baoGroupList) {
        this.baoGroupList = baoGroupList;
    }

    public List<BaoMailingList> getBaoMailingListList() {
        return baoMailingListList;
    }

    public void setBaoMailingListList(List<BaoMailingList> baoMailingListList) {
        this.baoMailingListList = baoMailingListList;
    }

    public List<BaoAutomaticReviewCondition> getBaoAutomaticReviewConditionList() {
        return baoAutomaticReviewConditionList;
    }

    public void setBaoAutomaticReviewConditionList(List<BaoAutomaticReviewCondition> baoAutomaticReviewConditionList) {
        this.baoAutomaticReviewConditionList = baoAutomaticReviewConditionList;
    }

    public List<BaoMonitorCourse> getBaoMonitorCourseList() {
        return baoMonitorCourseList;
    }

    public void setBaoMonitorCourseList(List<BaoMonitorCourse> baoMonitorCourseList) {
        this.baoMonitorCourseList = baoMonitorCourseList;
    }

    public List<BaoPartner> getBaoPartnerList() {
        return baoPartnerList;
    }

    public void setBaoPartnerList(List<BaoPartner> baoPartnerList) {
        this.baoPartnerList = baoPartnerList;
    }

    public List<BaoNotification> getBaoNotificationList() {
        return baoNotificationList;
    }

    public void setBaoNotificationList(List<BaoNotification> baoNotificationList) {
        this.baoNotificationList = baoNotificationList;
    }

    public List<BaoPaperAuthor> getBaoPaperAuthorList() {
        return baoPaperAuthorList;
    }

    public void setBaoPaperAuthorList(List<BaoPaperAuthor> baoPaperAuthorList) {
        this.baoPaperAuthorList = baoPaperAuthorList;
    }

    public List<BaoTeacherCourse> getBaoTeacherCourseList() {
        return baoTeacherCourseList;
    }

    public void setBaoTeacherCourseList(List<BaoTeacherCourse> baoTeacherCourseList) {
        this.baoTeacherCourseList = baoTeacherCourseList;
    }

    public List<BaoSuggestion> getBaoSuggestionList() {
        return baoSuggestionList;
    }

    public void setBaoSuggestionList(List<BaoSuggestion> baoSuggestionList) {
        this.baoSuggestionList = baoSuggestionList;
    }

    public List<BaoIntervention> getBaoInterventionList() {
        return baoInterventionList;
    }

    public void setBaoInterventionList(List<BaoIntervention> baoInterventionList) {
        this.baoInterventionList = baoInterventionList;
    }

    public List<BaoPaper> getBaoPaperList() {
        return baoPaperList;
    }

    public void setBaoPaperList(List<BaoPaper> baoPaperList) {
        this.baoPaperList = baoPaperList;
    }

    public List<BaoPaper> getBaoPaperList1() {
        return baoPaperList1;
    }

    public void setBaoPaperList1(List<BaoPaper> baoPaperList1) {
        this.baoPaperList1 = baoPaperList1;
    }

    public BaoAdditionalInfo getAdditionalInfoId() {
        return additionalInfoId;
    }

    public void setAdditionalInfoId(BaoAdditionalInfo additionalInfoId) {
        this.additionalInfoId = additionalInfoId;
    }

    public List<BaoPaperExcludedReviewer> getBaoExcludedReviewerList() {
        return baoExcludedReviewerList;
    }

    public void setBaoExcludedReviewerList(List<BaoPaperExcludedReviewer> baoExcludedReviewerList) {
        this.baoExcludedReviewerList = baoExcludedReviewerList;
    }

    public List<BaoPartnerUser> getBaoPartnerUserList() {
        return baoPartnerUserList;
    }

    public void setBaoPartnerUserList(List<BaoPartnerUser> baoPartnerUserList) {
        this.baoPartnerUserList = baoPartnerUserList;
    }

    public List<BaoAccessCoupon> getBaoAccessCouponList() {
        return baoAccessCouponList;
    }

    public void setBaoAccessCouponList(List<BaoAccessCoupon> baoAccessCouponList) {
        this.baoAccessCouponList = baoAccessCouponList;
    }

    public List<BaoNews> getBaoNewsList() {
        return baoNewsList;
    }

    public void setBaoNewsList(List<BaoNews> baoNewsList) {
        this.baoNewsList = baoNewsList;
    }

    public List<BaoEmailBugReport> getBaoEmailBugReportList() {
        return baoEmailBugReportList;
    }

    public void setBaoEmailBugReportList(List<BaoEmailBugReport> baoEmailBugReportList) {
        this.baoEmailBugReportList = baoEmailBugReportList;
    }

    public List<BaoEmailTemplate> getBaoEmailTemplateList() {
        return baoEmailTemplateList;
    }

    public void setBaoEmailTemplateList(List<BaoEmailTemplate> baoEmailTemplateList) {
        this.baoEmailTemplateList = baoEmailTemplateList;
    }

    public List<BaoStudentCourse> getBaoStudentCourseList() {
        return baoStudentCourseList;
    }

    public void setBaoStudentCourseList(List<BaoStudentCourse> baoStudentCourseList) {
        this.baoStudentCourseList = baoStudentCourseList;
    }

    public List<BaoPaperReview> getBaoPaperReviewList() {
        return baoPaperReviewList;
    }

    public void setBaoPaperReviewList(List<BaoPaperReview> baoPaperReviewList) {
        this.baoPaperReviewList = baoPaperReviewList;
    }

    public List<BaoProgrammedEmail> getBaoProgrammedEmailList() {
        return baoProgrammedEmailList;
    }

    public void setBaoProgrammedEmailList(List<BaoProgrammedEmail> baoProgrammedEmailList) {
        this.baoProgrammedEmailList = baoProgrammedEmailList;
    }

    public List<BaoComment> getBaoCommentList() {
        return baoCommentList;
    }

    public void setBaoCommentList(List<BaoComment> baoCommentList) {
        this.baoCommentList = baoCommentList;
    }

    public List<BaoExamSheet> getBaoExamSheetList() {
        return baoExamSheetList;
    }

    public void setBaoExamSheetList(List<BaoExamSheet> baoExamSheetList) {
        this.baoExamSheetList = baoExamSheetList;
    }

    public List<BaoReviewOrEditionContract> getBaoReviewOrEditionContractList() {
        return baoReviewOrEditionContractList;
    }

    public void setBaoReviewOrEditionContractList(List<BaoReviewOrEditionContract> baoReviewOrEditionContractList) {
        this.baoReviewOrEditionContractList = baoReviewOrEditionContractList;
    }

    public List<BaoReviewOrEditionContract> getBaoReviewOrEditionContractList1() {
        return baoReviewOrEditionContractList1;
    }

    public void setBaoReviewOrEditionContractList1(List<BaoReviewOrEditionContract> baoReviewOrEditionContractList1) {
        this.baoReviewOrEditionContractList1 = baoReviewOrEditionContractList1;
    }

    public List<BaoPartnershipContract> getBaoPartnershipContractList() {
        return baoPartnershipContractList;
    }

    public void setBaoPartnershipContractList(List<BaoPartnershipContract> baoPartnershipContractList) {
        this.baoPartnershipContractList = baoPartnershipContractList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoUser)) {
            return false;
        }
        BaoUser other = (BaoUser) object;
        return !((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoUser[ userId=" + userId + " ]";
    }
}
