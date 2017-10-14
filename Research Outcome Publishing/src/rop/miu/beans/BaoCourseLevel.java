package rop.miu.beans;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Ndadji Maxime
 */
@Entity
@Table(name = "bao_course_level")
public class BaoCourseLevel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "course_level_id", nullable = false)
    private Integer courseLevelId;
    @Basic(optional = false)
    @Column(name = "course_level_max_price", nullable = false)
    private Double courseLevelMaxPrice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseLevelId", fetch = FetchType.LAZY)
    private List<BaoCourse> baoCourseList;

    public BaoCourseLevel() {
    }

	public BaoCourseLevel(Integer courseLevelId) {
		super();
		this.courseLevelId = courseLevelId;
	}

	public BaoCourseLevel(Integer courseLevelId, Double courseLevelMaxPrice) {
		super();
		this.courseLevelId = courseLevelId;
		this.courseLevelMaxPrice = courseLevelMaxPrice;
	}

	public Integer getCourseLevelId() {
		return courseLevelId;
	}

	public void setCourseLevelId(Integer courseLevelId) {
		this.courseLevelId = courseLevelId;
	}

	public Double getCourseLevelMaxPrice() {
		return courseLevelMaxPrice;
	}

	public void setCourseLevelMaxPrice(Double courseLevelMaxPrice) {
		this.courseLevelMaxPrice = courseLevelMaxPrice;
	}

	public List<BaoCourse> getBaoCourseList() {
		return baoCourseList;
	}

	public void setBaoCourseList(List<BaoCourse> baoCourseList) {
		this.baoCourseList = baoCourseList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((courseLevelId == null) ? 0 : courseLevelId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaoCourseLevel other = (BaoCourseLevel) obj;
		if (courseLevelId == null) {
			if (other.courseLevelId != null)
				return false;
		} else if (!courseLevelId.equals(other.courseLevelId))
			return false;
		return true;
	}
}
