/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hu.thesis.timetableplanner.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Atesz
 */
@Embeddable
public class CourseOfSpecialisationPK implements Serializable {

    @Column(name = "specialisation", nullable=false)
    private Long specialisation;

    @Column(name = "course", nullable=false)
    private Long course;

    public CourseOfSpecialisationPK() {
    }

    public CourseOfSpecialisationPK(Long specialisation, Long course) {
        this.specialisation = specialisation;
        this.course = course;
    }

    public Long getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(Long specialisation) {
        this.specialisation = specialisation;
    }

    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseOfSpecialisationPK)) {
            return false;
        }
        CourseOfSpecialisationPK other = (CourseOfSpecialisationPK) object;
        return this.specialisation.equals(other.specialisation) && this.course.equals(other.course);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (this.specialisation != null ? this.specialisation.hashCode() : 0);
        hash = 43 * hash + (this.course != null ? this.course.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CourseOfSpecialisationPK");
        sb.append("{course=").append(course);
        sb.append(", specialisation='").append(specialisation).append('\'');
        sb.append('}');
        return sb.toString();
    }
    
}
