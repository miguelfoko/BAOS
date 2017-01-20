package rop.miu.beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
@Table(name = "bao_student_course")
@NamedQueries({
    @NamedQuery(name = "BaoStudentCourse.findAll", query = "SELECT b FROM BaoStudentCourse b"),
    @NamedQuery(name = "BaoStudentCourse.findByUserId", query = "SELECT b FROM BaoStudentCourse b WHERE b.baoStudentCoursePK.userId = :userId"),
    @NamedQuery(name = "BaoStudentCourse.findByCourseId", query = "SELECT b FROM BaoStudentCourse b WHERE b.baoStudentCoursePK.courseId = :courseId"),
    @NamedQuery(name = "BaoStudentCourse.findBySubscriptionDate", query = "SELECT b FROM BaoStudentCourse b WHERE b.subscriptionDate = :subscriptionDate")})
public class BaoStudentCourse implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BaoStudentCoursePK baoStudentCoursePK;
    @Basic(optional = false)
    @Column(name = "subscription_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date subscriptionDate;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoCourse baoCourse;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser baoUser;

    public BaoStudentCourse() {
    }

    public BaoStudentCourse(BaoStudentCoursePK baoStudentCoursePK) {
        this.baoStudentCoursePK = baoStudentCoursePK;
    }

    public BaoStudentCourse(BaoStudentCoursePK baoStudentCoursePK, Date subscriptionDate) {
        this.baoStudentCoursePK = baoStudentCoursePK;
        this.subscriptionDate = subscriptionDate;
    }

    public BaoStudentCourse(long userId, long courseId) {
        this.baoStudentCoursePK = new BaoStudentCoursePK(userId, courseId);
    }

    public BaoStudentCoursePK getBaoStudentCoursePK() {
        return baoStudentCoursePK;
    }

    public void setBaoStudentCoursePK(BaoStudentCoursePK baoStudentCoursePK) {
        this.baoStudentCoursePK = baoStudentCoursePK;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
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
        hash += (baoStudentCoursePK != null ? baoStudentCoursePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoStudentCourse)) {
            return false;
        }
        BaoStudentCourse other = (BaoStudentCourse) object;
        return !((this.baoStudentCoursePK == null && other.baoStudentCoursePK != null) || (this.baoStudentCoursePK != null && !this.baoStudentCoursePK.equals(other.baoStudentCoursePK)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoStudentCourse[ baoStudentCoursePK=" + baoStudentCoursePK + " ]";
    }
}
