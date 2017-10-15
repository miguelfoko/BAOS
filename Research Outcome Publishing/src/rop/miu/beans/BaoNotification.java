package rop.miu.beans;

import java.io.Serializable;
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
@Table(name = "bao_notification")
@NamedQueries({
    @NamedQuery(name = "BaoNotification.findAll", query = "SELECT b FROM BaoNotification b"),
    @NamedQuery(name = "BaoNotification.findByNotificationId", query = "SELECT b FROM BaoNotification b WHERE b.notificationId = :notificationId"),
    @NamedQuery(name = "BaoNotification.findByNotificationTitle", query = "SELECT b FROM BaoNotification b WHERE b.notificationTitle = :notificationTitle"),
    @NamedQuery(name = "BaoNotification.findByNotificationMessage", query = "SELECT b FROM BaoNotification b WHERE b.notificationMessage = :notificationMessage"),
    @NamedQuery(name = "BaoNotification.findByNotificationDate", query = "SELECT b FROM BaoNotification b WHERE b.notificationDate = :notificationDate"),
    @NamedQuery(name = "BaoNotification.findByNotificationType", query = "SELECT b FROM BaoNotification b WHERE b.notificationType = :notificationType"),
    @NamedQuery(name = "BaoNotification.findByNotificationLink", query = "SELECT b FROM BaoNotification b WHERE b.notificationLink = :notificationLink"),
    @NamedQuery(name = "BaoNotification.findByNotificationReceptionDate", query = "SELECT b FROM BaoNotification b WHERE b.notificationReceptionDate = :notificationReceptionDate"),
    @NamedQuery(name = "BaoNotification.findByNotificationState", query = "SELECT b FROM BaoNotification b WHERE b.notificationState = :notificationState")})
public class BaoNotification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "notification_id", nullable = false)
    private Integer notificationId;
    @Basic(optional = false)
    @Column(name = "notification_title", nullable = false, length = 100)
    private String notificationTitle;
    @Basic(optional = false)
    @Column(name = "notification_message", nullable = false, length = 2147483647)
    private String notificationMessage;
    @Basic(optional = false)
    @Column(name = "notification_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date notificationDate;
    @Basic(optional = false)
    @Column(name = "notification_type", nullable = false, length = 12)
    private String notificationType;
    @Column(name = "notification_link", length = 255)
    private String notificationLink;
    @Column(name = "notification_reception_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date notificationReceptionDate;
    @Basic(optional = false)
    @Column(name = "notification_state", nullable = false)
    private short notificationState;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser userId;

    public BaoNotification() {
    }

    public BaoNotification(Integer notificationId) {
        this.notificationId = notificationId;
    }

    public BaoNotification(Integer notificationId, String notificationTitle, String notificationMessage, Date notificationDate, String notificationType, short notificationState) {
        this.notificationId = notificationId;
        this.notificationTitle = notificationTitle;
        this.notificationMessage = notificationMessage;
        this.notificationDate = notificationDate;
        this.notificationType = notificationType;
        this.notificationState = notificationState;
    }

    public Integer getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    public String getNotificationTitle() {
        return notificationTitle;
    }

    public void setNotificationTitle(String notificationTitle) {
        this.notificationTitle = notificationTitle;
    }

    public String getNotificationMessage() {
        return notificationMessage;
    }

    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }

    public Date getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(Date notificationDate) {
        this.notificationDate = notificationDate;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public String getNotificationLink() {
        return notificationLink;
    }

    public void setNotificationLink(String notificationLink) {
        this.notificationLink = notificationLink;
    }

    public Date getNotificationReceptionDate() {
        return notificationReceptionDate;
    }

    public void setNotificationReceptionDate(Date notificationReceptionDate) {
        this.notificationReceptionDate = notificationReceptionDate;
    }

    public short getNotificationState() {
        return notificationState;
    }

    public void setNotificationState(short notificationState) {
        this.notificationState = notificationState;
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
        hash += (notificationId != null ? notificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoNotification)) {
            return false;
        }
        BaoNotification other = (BaoNotification) object;
        return !((this.notificationId == null && other.notificationId != null) || (this.notificationId != null && !this.notificationId.equals(other.notificationId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoNotification[ notificationId=" + notificationId + " ]";
    }
}
