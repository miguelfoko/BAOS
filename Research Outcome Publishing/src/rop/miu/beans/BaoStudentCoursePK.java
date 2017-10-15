package rop.miu.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Ndadji Maxime
 */
@Embeddable
public class BaoStudentCoursePK implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "user_id", nullable = false)
    private long userId;
    @Basic(optional = false)
    @Column(name = "course_id", nullable = false)
    private long courseId;

    public BaoStudentCoursePK() {
    }

    public BaoStudentCoursePK(long userId, long courseId) {
        this.userId = userId;
        this.courseId = courseId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userId;
        hash += (int) courseId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoStudentCoursePK)) {
            return false;
        }
        BaoStudentCoursePK other = (BaoStudentCoursePK) object;
        if (this.userId != other.userId) {
            return false;
        }
        return this.courseId == other.courseId;
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoStudentCoursePK[ userId=" + userId + ", courseId=" + courseId + " ]";
    }
}
