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
@Table(name = "bao_email_bug_report")
@NamedQueries({
    @NamedQuery(name = "BaoEmailBugReport.findAll", query = "SELECT b FROM BaoEmailBugReport b"),
    @NamedQuery(name = "BaoEmailBugReport.findByBugReportId", query = "SELECT b FROM BaoEmailBugReport b WHERE b.bugReportId = :bugReportId"),
    @NamedQuery(name = "BaoEmailBugReport.findByBugReportTitle", query = "SELECT b FROM BaoEmailBugReport b WHERE b.bugReportTitle = :bugReportTitle"),
    @NamedQuery(name = "BaoEmailBugReport.findByBugReportContent", query = "SELECT b FROM BaoEmailBugReport b WHERE b.bugReportContent = :bugReportContent"),
    @NamedQuery(name = "BaoEmailBugReport.findByBugReportDate", query = "SELECT b FROM BaoEmailBugReport b WHERE b.bugReportDate = :bugReportDate"),
    @NamedQuery(name = "BaoEmailBugReport.findByBugReportState", query = "SELECT b FROM BaoEmailBugReport b WHERE b.bugReportState = :bugReportState")})
public class BaoEmailBugReport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bug_report_id", nullable = false)
    private Integer bugReportId;
    @Basic(optional = false)
    @Column(name = "bug_report_title", nullable = false, length = 255)
    private String bugReportTitle;
    @Basic(optional = false)
    @Column(name = "bug_report_content", nullable = false, length = 2147483647)
    private String bugReportContent;
    @Basic(optional = false)
    @Column(name = "bug_report_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date bugReportDate;
    @Basic(optional = false)
    @Column(name = "bug_report_state", nullable = false)
    private short bugReportState;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser userId;

    public BaoEmailBugReport() {
    }

    public BaoEmailBugReport(Integer bugReportId) {
        this.bugReportId = bugReportId;
    }

    public BaoEmailBugReport(Integer bugReportId, String bugReportTitle, String bugReportContent, Date bugReportDate, short bugReportState) {
        this.bugReportId = bugReportId;
        this.bugReportTitle = bugReportTitle;
        this.bugReportContent = bugReportContent;
        this.bugReportDate = bugReportDate;
        this.bugReportState = bugReportState;
    }

    public Integer getBugReportId() {
        return bugReportId;
    }

    public void setBugReportId(Integer bugReportId) {
        this.bugReportId = bugReportId;
    }

    public String getBugReportTitle() {
        return bugReportTitle;
    }

    public void setBugReportTitle(String bugReportTitle) {
        this.bugReportTitle = bugReportTitle;
    }

    public String getBugReportContent() {
        return bugReportContent;
    }

    public void setBugReportContent(String bugReportContent) {
        this.bugReportContent = bugReportContent;
    }

    public Date getBugReportDate() {
        return bugReportDate;
    }

    public void setBugReportDate(Date bugReportDate) {
        this.bugReportDate = bugReportDate;
    }

    public short getBugReportState() {
        return bugReportState;
    }

    public void setBugReportState(short bugReportState) {
        this.bugReportState = bugReportState;
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
        hash += (bugReportId != null ? bugReportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoEmailBugReport)) {
            return false;
        }
        BaoEmailBugReport other = (BaoEmailBugReport) object;
        return !((this.bugReportId == null && other.bugReportId != null) || (this.bugReportId != null && !this.bugReportId.equals(other.bugReportId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoEmailBugReport[ bugReportId=" + bugReportId + " ]";
    }
}
