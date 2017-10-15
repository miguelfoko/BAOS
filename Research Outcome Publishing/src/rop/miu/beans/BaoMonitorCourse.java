package rop.miu.beans;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "bao_monitor_course")
@NamedQueries({
    @NamedQuery(name = "BaoMonitorCourse.findAll", query = "SELECT b FROM BaoMonitorCourse b"),
    @NamedQuery(name = "BaoMonitorCourse.findByUserId", query = "SELECT b FROM BaoMonitorCourse b WHERE b.baoMonitorCoursePK.userId = :userId"),
    @NamedQuery(name = "BaoMonitorCourse.findByCourseId", query = "SELECT b FROM BaoMonitorCourse b WHERE b.baoMonitorCoursePK.courseId = :courseId"),
    @NamedQuery(name = "BaoMonitorCourse.findByMonitorCourseDate", query = "SELECT b FROM BaoMonitorCourse b WHERE b.monitorCourseDate = :monitorCourseDate")})
public class BaoMonitorCourse implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BaoMonitorCoursePK baoMonitorCoursePK;
    @Column(name = "monitor_course_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date monitorCourseDate;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoCourse baoCourse;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser baoUser;

    public BaoMonitorCourse() {
    }

    public BaoMonitorCourse(BaoMonitorCoursePK baoMonitorCoursePK) {
        this.baoMonitorCoursePK = baoMonitorCoursePK;
    }

    public BaoMonitorCourse(long userId, long courseId) {
        this.baoMonitorCoursePK = new BaoMonitorCoursePK(userId, courseId);
    }

    public BaoMonitorCoursePK getBaoMonitorCoursePK() {
        return baoMonitorCoursePK;
    }

    public void setBaoMonitorCoursePK(BaoMonitorCoursePK baoMonitorCoursePK) {
        this.baoMonitorCoursePK = baoMonitorCoursePK;
    }

    public Date getMonitorCourseDate() {
        return monitorCourseDate;
    }

    public void setMonitorCourseDate(Date monitorCourseDate) {
        this.monitorCourseDate = monitorCourseDate;
    }

    public BaoCourse getBaoCourse() {
        return baoCourse;
    }

    public void setBaoCourse(BaoCourse baoCourse) {
        this.baoCourse = baoCourse;
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
        hash += (baoMonitorCoursePK != null ? baoMonitorCoursePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoMonitorCourse)) {
            return false;
        }
        BaoMonitorCourse other = (BaoMonitorCourse) object;
        return !((this.baoMonitorCoursePK == null && other.baoMonitorCoursePK != null) || (this.baoMonitorCoursePK != null && !this.baoMonitorCoursePK.equals(other.baoMonitorCoursePK)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoMonitorCourse[ baoMonitorCoursePK=" + baoMonitorCoursePK + " ]";
    }
    
}
