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
public class NeedPK implements Serializable {

    @Column(name = "course", nullable=false)
    private Long course;

    @Column(name = "department", nullable=false)
    private Long department;

    public NeedPK() {
    }

    public NeedPK(Long course, Long department) {
        this.course = course;
        this.department = department;
    }

    public Long getCourse() {
        return course;
    }

    public void setCourse(Long course) {
        this.course = course;
    }

    public Long getDepartment() {
        return department;
    }

    public void setDepartment(Long department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NeedPK)) {
            return false;
        }
        NeedPK other = (NeedPK) object;
        return this.course.equals(other.course) && this.department.equals(other.department);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (this.course != null ? this.course.hashCode() : 0);
        hash = 61 * hash + (this.department != null ? this.department.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("NeedPK");
        sb.append("{course=").append(course);
        sb.append(", department='").append(department).append('\'');
        sb.append('}');
        return sb.toString();
    }
    
}
