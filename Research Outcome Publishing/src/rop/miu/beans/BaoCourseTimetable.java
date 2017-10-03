package rop.miu.beans;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
*
* @author Doris-kholer NYABEYE
*/
@Entity
@Table(name = "bao_course_timetable")
public class BaoCourseTimetable implements Serializable {
	private static final long serialVersionUID = 1L;
	@EmbeddedId
	protected BaoCourseTimetablePK baoCourseTimetablePK;

	@JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private BaoCourse baoCourse;
	@JoinColumn(name = "timetable_id", referencedColumnName = "timetable_id", nullable = false, insertable = false, updatable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private BaoTimetable baoTimetable;

	public BaoCourseTimetable() {
	}

	public BaoCourseTimetable(BaoCourseTimetablePK baoCourseTimetablePK) {
		this.baoCourseTimetablePK = baoCourseTimetablePK;
	}

	public BaoCourseTimetable(long courseId, long timetableId) {
		this.baoCourseTimetablePK = new BaoCourseTimetablePK(courseId,
				timetableId);
	}

	public BaoCourseTimetablePK getBaoCourseTimetablePK() {
		return baoCourseTimetablePK;
	}

	public void setBaoCourseTimetablePK(
			BaoCourseTimetablePK baoCourseTimetablePK) {
		this.baoCourseTimetablePK = baoCourseTimetablePK;
	}

	public BaoCourse getBaoCourse() {
		return baoCourse;
	}

	public void setBaoCourse(BaoCourse baoCourse) {
		this.baoCourse = baoCourse;
	}

	public BaoTimetable getBaoTimetable() {
		return baoTimetable;
	}

	public void setBaoUser(BaoTimetable baoTimetable) {
		this.baoTimetable = baoTimetable;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (baoCourseTimetablePK != null ? baoCourseTimetablePK.hashCode()
				: 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof BaoCourseTimetable)) {
			return false;
		}
		BaoCourseTimetable other = (BaoCourseTimetable) object;
		return !((this.baoCourseTimetablePK == null && other.baoCourseTimetablePK != null) || (this.baoCourseTimetablePK != null && !this.baoCourseTimetablePK
				.equals(other.baoCourseTimetablePK)));
	}

	@Override
	public String toString() {
		return "rop.miu.beans.BaoTeacherCourse[ baoTeacherCoursePK="
				+ baoCourseTimetablePK + " ]";
	}
}
