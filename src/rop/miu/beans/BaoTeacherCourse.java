package rop.miu.beans;

import java.io.Serializable;
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

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_teacher_course")
@NamedQueries({
    @NamedQuery(name = "BaoTeacherCourse.findAll", query = "SELECT b FROM BaoTeacherCourse b"),
    @NamedQuery(name = "BaoTeacherCourse.findByUserId", query = "SELECT b FROM BaoTeacherCourse b WHERE b.baoTeacherCoursePK.userId = :userId"),
    @NamedQuery(name = "BaoTeacherCourse.findByCourseId", query = "SELECT b FROM BaoTeacherCourse b WHERE b.baoTeacherCoursePK.courseId = :courseId"),
    @NamedQuery(name = "BaoTeacherCourse.findByIsCreator", query = "SELECT b FROM BaoTeacherCourse b WHERE b.isCreator = :isCreator")})
public class BaoTeacherCourse implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BaoTeacherCoursePK baoTeacherCoursePK;
    @Basic(optional = false)
    @Column(name = "is_creator", nullable = false)
    private boolean isCreator;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoCourse baoCourse;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private BaoUser baoUser;

    public BaoTeacherCourse() {
    }

    public BaoTeacherCourse(BaoTeacherCoursePK baoTeacherCoursePK) {
        this.baoTeacherCoursePK = baoTeacherCoursePK;
    }

    public BaoTeacherCourse(BaoTeacherCoursePK baoTeacherCoursePK, boolean isCreator) {
        this.baoTeacherCoursePK = baoTeacherCoursePK;
        this.isCreator = isCreator;
    }

    public BaoTeacherCourse(long userId, long courseId) {
        this.baoTeacherCoursePK = new BaoTeacherCoursePK(userId, courseId);
    }

    public BaoTeacherCoursePK getBaoTeacherCoursePK() {
        return baoTeacherCoursePK;
    }

    public void setBaoTeacherCoursePK(BaoTeacherCoursePK baoTeacherCoursePK) {
        this.baoTeacherCoursePK = baoTeacherCoursePK;
    }

    public boolean getIsCreator() {
        return isCreator;
    }

    public void setIsCreator(boolean isCreator) {
        this.isCreator = isCreator;
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
        hash += (baoTeacherCoursePK != null ? baoTeacherCoursePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoTeacherCourse)) {
            return false;
        }
        BaoTeacherCourse other = (BaoTeacherCourse) object;
        return !((this.baoTeacherCoursePK == null && other.baoTeacherCoursePK != null) || (this.baoTeacherCoursePK != null && !this.baoTeacherCoursePK.equals(other.baoTeacherCoursePK)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoTeacherCourse[ baoTeacherCoursePK=" + baoTeacherCoursePK + " ]";
    }
}
