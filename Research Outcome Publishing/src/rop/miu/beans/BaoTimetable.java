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
import javax.persistence.ManyToMany;
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
@Table(name = "bao_timetable")
@NamedQueries({
    @NamedQuery(name = "BaoTimetable.findAll", query = "SELECT b FROM BaoTimetable b"),
    @NamedQuery(name = "BaoTimetable.findByTimetableId", query = "SELECT b FROM BaoTimetable b WHERE b.timetableId = :timetableId"),
    @NamedQuery(name = "BaoTimetable.findByTimetableName", query = "SELECT b FROM BaoTimetable b WHERE b.timetableName = :timetableName"),
    @NamedQuery(name = "BaoTimetable.findByTimetableDay", query = "SELECT b FROM BaoTimetable b WHERE b.timetableDay = :timetableDay"),
    @NamedQuery(name = "BaoTimetable.findByTimetableStartTime", query = "SELECT b FROM BaoTimetable b WHERE b.timetableStartTime = :timetableStartTime"),
    @NamedQuery(name = "BaoTimetable.findByTimetableEndTime", query = "SELECT b FROM BaoTimetable b WHERE b.timetableEndTime = :timetableEndTime"),
    @NamedQuery(name = "BaoTimetable.findByTimetableState", query = "SELECT b FROM BaoTimetable b WHERE b.timetableState = :timetableState")})
public class BaoTimetable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "timetable_id", nullable = false)
    private Integer timetableId;
    @Basic(optional = false)
    @Column(name = "timetable_name", nullable = false, length = 100)
    private String timetableName;
    @Basic(optional = false)
    @Column(name = "timetable_day", nullable = false, length = 10)
    private String timetableDay;
    @Basic(optional = false)
    @Column(name = "timetable_start_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date timetableStartTime;
    @Basic(optional = false)
    @Column(name = "timetable_end_time", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date timetableEndTime;
    @Basic(optional = false)
    @Column(name = "timetable_state", nullable = false)
    private short timetableState;
    @ManyToMany(mappedBy = "baoTimetableList", fetch = FetchType.LAZY)
    private List<BaoCourse> baoCourseList;

    public BaoTimetable() {
    }

    public BaoTimetable(Integer timetableId) {
        this.timetableId = timetableId;
    }

    public BaoTimetable(Integer timetableId, String timetableName, String timetableDay, Date timetableStartTime, Date timetableEndTime, short timetableState) {
        this.timetableId = timetableId;
        this.timetableName = timetableName;
        this.timetableDay = timetableDay;
        this.timetableStartTime = timetableStartTime;
        this.timetableEndTime = timetableEndTime;
        this.timetableState = timetableState;
    }

    public Integer getTimetableId() {
        return timetableId;
    }

    public void setTimetableId(Integer timetableId) {
        this.timetableId = timetableId;
    }

    public String getTimetableName() {
        return timetableName;
    }

    public void setTimetableName(String timetableName) {
        this.timetableName = timetableName;
    }

    public String getTimetableDay() {
        return timetableDay;
    }

    public void setTimetableDay(String timetableDay) {
        this.timetableDay = timetableDay;
    }

    public Date getTimetableStartTime() {
        return timetableStartTime;
    }

    public void setTimetableStartTime(Date timetableStartTime) {
        this.timetableStartTime = timetableStartTime;
    }

    public Date getTimetableEndTime() {
        return timetableEndTime;
    }

    public void setTimetableEndTime(Date timetableEndTime) {
        this.timetableEndTime = timetableEndTime;
    }

    public short getTimetableState() {
        return timetableState;
    }

    public void setTimetableState(short timetableState) {
        this.timetableState = timetableState;
    }

    public List<BaoCourse> getBaoCourseList() {
        return baoCourseList;
    }

    public void setBaoCourseList(List<BaoCourse> baoCourseList) {
        this.baoCourseList = baoCourseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timetableId != null ? timetableId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof BaoTimetable)) {
            return false;
        }
        BaoTimetable other = (BaoTimetable) object;
        return !((this.timetableId == null && other.timetableId != null) || (this.timetableId != null && !this.timetableId.equals(other.timetableId)));
    }

    @Override
    public String toString() {
        return "rop.miu.beans.BaoTimetable[ timetableId=" + timetableId + " ]";
    }
}
