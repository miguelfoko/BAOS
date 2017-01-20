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
import javax.persistence.ManyToMany;
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
@Table(name = "bao_programmed_email")
@NamedQueries({
    @NamedQuery(name = "BaoProgrammedEmail.findAll", query = "SELECT b FROM BaoProgrammedEmail b"),
    @NamedQuery(name = "BaoProgrammedEmail.findByProgrammedEmailId", query = "SELECT b FROM BaoProgrammedEmail b WHERE b.programmedEmailId = :programmedEmailId"),
    @NamedQuery(name = "BaoProgrammedEmail.findByProgrammedEmailTitle", query = "SELECT b FROM BaoProgrammedEmail b WHERE b.programmedEmailTitle = :programmedEmailTitle"),
    @NamedQuery(name = "BaoProgrammedEmail.findByProgrammedEmailDate", query = "SELECT b FROM BaoProgrammedEmail b WHERE b.programmedEmailDate = :programmedEmailDate"),
    @NamedQuery(name = "BaoProgrammedEmail.findByProgrammedEmailSubject", query = "SELECT b FROM BaoProgrammedEmail b WHERE b.programmedEmailSubject = :programmedEmailSubject"),
    @NamedQuery(name = "BaoProgrammedEmail.findByProgrammedEmailContent", query = "SELECT b FROM BaoProgrammedEmail b WHERE b.programmedEmailContent = :programmedEmailContent"),
    @NamedQuery(name = "BaoProgrammedEmail.findByProgrammedEmailAttachments", query = "SELECT b FROM BaoProgrammedEmail b WHERE b.programmedEmailAttachments = :programmedEmailAttachments"),
    @NamedQuery(name = "BaoProgrammedEmail.findByProgrammedEmailSendTime", query = "SELECT b FROM BaoProgrammedEmail b WHERE b.programmedEmailSendTime = :programmedEmailSendTime"),
    @NamedQuery(name = "BaoProgrammedEmail.findByProgrammedEmailIsSendOnlyToUser", query = "SELECT b FROM BaoProgrammedEmail b WHERE b.programmedEmailIsSendOnlyToUser = :programmedEmailIsSendOnlyToUser"),
    @NamedQuery(name = "BaoProgrammedEmail.findByProgrammedEmailState", query = "SELECT b FROM BaoProgrammedEmail b WHERE b.programmedEmailState = :programmedEmailState")})
public class BaoProgrammedEmail implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "programmed_email_id", nullable = false)
    private Integer programmedEmailId;
    @Basic(optional = false)
    @Column(name = "programmed_email_title", nullable = false, length = 255)
    private String programmedEmailTitle;
    @Basic(optional = false)
    @Column(name = "programmed_email_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date programmedEmailDate;
    @Basic(optional = false)
    @Column(name = "programmed_email_subject", nullable = false, length = 255)
    private String programmedEmailSubject;
    @Column(name = "programmed_email_content", length = 2147483647)
    private String programmedEmailContent;
    @Column(name = "programmed_email_attachments", length = 2147483647)
    private String programmedEmailAttachments;
    @Basic(optional = false)
    @Column(name = "programmed_email_send_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date programmedEmailSendTime;
    @Basic(optional = false)
    @Column(name = "programmed_email_is_send_only_to_user", nullable = false)
    private boolean programmedEmailIsSendOnlyToUser;
    @Basic(optional = false)
    @Column(name = "programmed_email_state", nullable = false)
    private short programmedEmailState;
    @ManyToMany(mappedBy = "baoProgrammedEmailList", fetch = FetchType.LAZY)
    private List<BaoMailingList> baoMailingListList;
    @JoinColumn(name = "email_template_id", referencedColumnName = "email_template_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private BaoEmailTemplate emailTemplateId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser userId;

    public BaoProgrammedEmail() {
    }

    public BaoProgrammedEmail(Integer programmedEmailId) {
        this.programmedEmailId = programmedEmailId;
    }

    public BaoProgrammedEmail(Integer programmedEmailId, String programmedEmailTitle, Date programmedEmailDate, String programmedEmailSubject, Date programmedEmailSendTime, boolean programmedEmailIsSendOnlyToUser, short programmedEmailState) {
        this.programmedEmailId = programmedEmailId;
        this.programmedEmailTitle = programmedEmailTitle;
        this.programmedEmailDate = programmedEmailDate;
        this.programmedEmailSubject = programmedEmailSubject;
        this.programmedEmailSendTime = programmedEmailSendTime;
        this.programmedEmailIsSendOnlyToUser = programmedEmailIsSendOnlyToUser;
        this.programmedEmailState = programmedEmailState;
    }

    public Integer getProgrammedEmailId() {
        return programmedEmailId;
    }

    public void setProgrammedEmailId(Integer programmedEmailId) {
        this.programmedEmailId = programmedEmailId;
    }

    public String getProgrammedEmailTitle() {
        return programmedEmailTitle;
    }

    public void setProgrammedEmailTitle(String programmedEmailTitle) {
        this.programmedEmailTitle = programmedEmailTitle;
    }

    public Date getProgrammedEmailDate() {
        return programmedEmailDate;
    }

    public void setProgrammedEmailDate(Date programmedEmailDate) {
        this.programmedEmailDate = programmedEmailDate;
    }

    public String getProgrammedEmailSubject() {
        return programmedEmailSubject;
    }

    public void setProgrammedEmailSubject(String programmedEmailSubject) {
        this.programmedEmailSubject = programmedEmailSubject;
    }

    public String getProgrammedEmailContent() {
        return programmedEmailContent;
    }

    public void setProgrammedEmailContent(String programmedEmailContent) {
        this.programmedEmailContent = programmedEmailContent;
    }

    public String getProgrammedEmailAttachments() {
        return programmedEmailAttachments;
    }

    public void setProgrammedEmailAttachments(String programmedEmailAttachments) {
        this.programmedEmailAttachments = programmedEmailAttachments;
    }

    public Date getProgrammedEmailSendTime() {
        return programmedEmailSendTime;
    }

    public void setProgrammedEmailSendTime(Date programmedEmailSendTime) {
        this.programmedEmailSendTime = programmedEmailSendTime;
    }

    public boolean getProgrammedEmailIsSendOnlyToUser() {
        return programmedEmailIsSendOnlyToUser;
    }

    public void setProgrammedEmailIsSendOnlyToUser(boolean programmedEmailIsSendOnlyToUser) {
        this.programmedEmailIsSendOnlyToUser = programmedEmailIsSendOnlyToUser;
    }

    public short getProgrammedEmailState() {
        return programmedEmailState;
    }

    public void setProgrammedEmailState(short programmedEmailState) {
        this.programmedEmailState = programmedEmailState;
    }

    public List<BaoMailingList> getBaoMailingListList() {
        return baoMailingListList;
    }

    public void setBaoMailingListList(List<BaoMailingList> baoMailingListList) {
        this.baoMailingListList = baoMailingListList;
    }

    public BaoEmailTemplate getEmailTemplateId() {
        return emailTemplateId;
    }

    public void setEmailTemplateId(BaoEmailTemplate emailTemplateId) {
        this.emailTemplateId = emailTemplateId;
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
        hash += (programmedEmailId != null ? programmedEmailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoProgrammedEmail)) {
            return false;
        }
        BaoProgrammedEmail other = (BaoProgrammedEmail) object;
        return !((this.programmedEmailId == null && other.programmedEmailId != null) || (this.programmedEmailId != null && !this.programmedEmailId.equals(other.programmedEmailId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoProgrammedEmail[ programmedEmailId=" + programmedEmailId + " ]";
    }
}
