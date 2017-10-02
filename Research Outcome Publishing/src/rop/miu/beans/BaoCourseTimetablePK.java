package rop.miu.beans;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Doris-kholer NYABEYE
 */
@Embeddable
public class BaoCourseTimetablePK implements Serializable {
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "course_id", nullable = false)
    private long courseId;
    @Basic(optional = false)
    @Column(name = "timetable_id", nullable = false)
    private long timetableId;

    public BaoCourseTimetablePK() {
    }

    public BaoCourseTimetablePK(long courseId, long timetableId) {
        this.timetableId = timetableId;
        this.courseId = courseId;
    }

  

    public long getTimetableId() {
		return timetableId;
	}

	public void setTimetableId(long timetableId) {
		this.timetableId = timetableId;
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
        hash += (int) timetableId;
        hash += (int) courseId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoCourseTimetablePK)) {
            return false;
        }
        BaoCourseTimetablePK other = (BaoCourseTimetablePK) object;
        if (this.timetableId != other.timetableId) {
            return false;
        }
        return this.courseId == other.courseId;
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoCourseTimetable[ timetableId=" + timetableId + ", courseId=" + courseId + " ]";
    }
}
