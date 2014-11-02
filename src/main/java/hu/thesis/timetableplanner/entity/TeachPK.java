/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hu.thesis.timetableplanner.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Atesz
 */
@Embeddable
public class TeachPK implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 2581084557186375596L;

	@Column(name = "course", nullable=false)
    private Long course;

    @Column(name = "lecturer", nullable=false)
    private Long lecturer;

    public TeachPK() {
    }

    public TeachPK(Long course, Long lecturer) {
        this.course = course;
        this.lecturer = lecturer;
    }

    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }

    public Long getLecturer() {
        return lecturer;
    }

    public void setLecturer(Long lecturer) {
        this.lecturer = lecturer;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeachPK)) {
            return false;
        }
        TeachPK other = (TeachPK) object;
        return this.course.equals(other.course) && this.lecturer.equals(other.lecturer);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.course != null ? this.course.hashCode() : 0);
        hash = 41 * hash + (this.lecturer != null ? this.lecturer.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("OktatPK");
        sb.append("{course=").append(course);
        sb.append(", lecturer='").append(lecturer).append('\'');
        sb.append('}');
        return sb.toString();
    }
    
}
