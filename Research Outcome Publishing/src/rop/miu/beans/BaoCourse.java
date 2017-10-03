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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_course")
@NamedQueries({
    @NamedQuery(name = "BaoCourse.findAll", query = "SELECT b FROM BaoCourse b"),
    @NamedQuery(name = "BaoCourse.findByCourseId", query = "SELECT b FROM BaoCourse b WHERE b.courseId = :courseId"),
    @NamedQuery(name = "BaoCourse.findByCourseName", query = "SELECT b FROM BaoCourse b WHERE b.courseName = :courseName"),
    @NamedQuery(name = "BaoCourse.findByCourseStartTime", query = "SELECT b FROM BaoCourse b WHERE b.courseStartTime = :courseStartTime"),
    @NamedQuery(name = "BaoCourse.findByCourseLength", query = "SELECT b FROM BaoCourse b WHERE b.courseLength = :courseLength"),
    @NamedQuery(name = "BaoCourse.findByCourseLengthUnit", query = "SELECT b FROM BaoCourse b WHERE b.courseLengthUnit = :courseLengthUnit"),
    @NamedQuery(name = "BaoCourse.findByCourseCreationDate", query = "SELECT b FROM BaoCourse b WHERE b.courseCreationDate = :courseCreationDate"),
    @NamedQuery(name = "BaoCourse.findByCourseDesc", query = "SELECT b FROM BaoCourse b WHERE b.courseDesc = :courseDesc"),
    @NamedQuery(name = "BaoCourse.findByCourseState", query = "SELECT b FROM BaoCourse b WHERE b.courseState = :courseState")})
public class BaoCourse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "course_id", nullable = false)
    private Integer courseId;
    @Basic(optional = false)
    @Column(name = "course_name", nullable = false, length = 255)
    private String courseName;
    @Column(name = "course_logo", length = 255)
    private String courseLogo;
    @Basic(optional = false)
    @Column(name = "course_start_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date courseStartTime;
    @Basic(optional = false)
    @Column(name = "course_length", nullable = false)
    private int courseLength;
    @Basic(optional = false)
    @Column(name = "course_length_unit", nullable = false, length = 10)
    private String courseLengthUnit;
    @Basic(optional = false)
    @Column(name = "course_creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date courseCreationDate;
    @Column(name = "course_desc", length = 2147483647)
    private String courseDesc;
    @Basic(optional = false)
    @Column(name = "course_state", nullable = false)
    private short courseState;
    @JoinTable(name = "bao_course_timetable", joinColumns = {
        @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "timetable_id", referencedColumnName = "timetable_id", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private List<BaoTimetable> baoTimetableList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baoCourse", fetch = FetchType.LAZY)
    private List<BaoMonitorCourse> baoMonitorCourseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baoCourse", fetch = FetchType.LAZY)
    private List<BaoTeacherCourse> baoTeacherCourseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId", fetch = FetchType.LAZY)
    private List<BaoExamination> baoExaminationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId", fetch = FetchType.LAZY)
    private List<BaoLesson> baoLessonList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "baoCourse", fetch = FetchType.LAZY)
    private List<BaoStudentCourse> baoStudentCourseList;

    public BaoCourse() {
    }

    public BaoCourse(Integer courseId) {
        this.courseId = courseId;
    }

    public BaoCourse(Integer courseId, String courseName, Date courseStartTime, int courseLength, String courseLengthUnit, Date courseCreationDate, short courseState) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseStartTime = courseStartTime;
        this.courseLength = courseLength;
        this.courseLengthUnit = courseLengthUnit;
        this.courseCreationDate = courseCreationDate;
        this.courseState = courseState;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getCourseStartTime() {
        return courseStartTime;
    }

    public void setCourseStartTime(Date courseStartTime) {
        this.courseStartTime = courseStartTime;
    }

    public int getCourseLength() {
        return courseLength;
    }

    public void setCourseLength(int courseLength) {
        this.courseLength = courseLength;
    }

    public String getCourseLengthUnit() {
        return courseLengthUnit;
    }

    public void setCourseLengthUnit(String courseLengthUnit) {
        this.courseLengthUnit = courseLengthUnit;
    }

    public Date getCourseCreationDate() {
        return courseCreationDate;
    }

    public void setCourseCreationDate(Date courseCreationDate) {
        this.courseCreationDate = courseCreationDate;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public short getCourseState() {
        return courseState;
    }

    public void setCourseState(short courseState) {
        this.courseState = courseState;
    }

    public String getCourseLogo() {
		return courseLogo;
	}

	public void setCourseLogo(String courseLogo) {
		this.courseLogo = courseLogo;
	}

	public List<BaoTimetable> getBaoTimetableList() {
        return baoTimetableList;
    }

    public void setBaoTimetableList(List<BaoTimetable> baoTimetableList) {
        this.baoTimetableList = baoTimetableList;
    }

    public List<BaoMonitorCourse> getBaoMonitorCourseList() {
        return baoMonitorCourseList;
    }

    public void setBaoMonitorCourseList(List<BaoMonitorCourse> baoMonitorCourseList) {
        this.baoMonitorCourseList = baoMonitorCourseList;
    }

    public List<BaoTeacherCourse> getBaoTeacherCourseList() {
        return baoTeacherCourseList;
    }

    public void setBaoTeacherCourseList(List<BaoTeacherCourse> baoTeacherCourseList) {
        this.baoTeacherCourseList = baoTeacherCourseList;
    }

    public List<BaoExamination> getBaoExaminationList() {
        return baoExaminationList;
    }

    public void setBaoExaminationList(List<BaoExamination> baoExaminationList) {
        this.baoExaminationList = baoExaminationList;
    }

    public List<BaoLesson> getBaoLessonList() {
        return baoLessonList;
    }

    public void setBaoLessonList(List<BaoLesson> baoLessonList) {
        this.baoLessonList = baoLessonList;
    }

    public List<BaoStudentCourse> getBaoStudentCourseList() {
        return baoStudentCourseList;
    }

    public void setBaoStudentCourseList(List<BaoStudentCourse> baoStudentCourseList) {
        this.baoStudentCourseList = baoStudentCourseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseId != null ? courseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BaoCourse)) {
            return false;
        }
        BaoCourse other = (BaoCourse) object;
        if ((this.courseId == null && other.courseId != null) || (this.courseId != null && !this.courseId.equals(other.courseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoCourse[ courseId=" + courseId + " ]";
    }
    
}
