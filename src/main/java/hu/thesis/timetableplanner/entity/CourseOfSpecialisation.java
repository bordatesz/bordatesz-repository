/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hu.thesis.timetableplanner.entity;

import java.io.Serializable;
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
 * @author Atesz
 */
@Entity
@Table(name = "Course_of_specialisation")
public class CourseOfSpecialisation implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected CourseOfSpecialisationPK courseOfSpecialisationPK;
    
    @Column(name = "block")
    private String block;
    
    @JoinColumn(name = "course", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Course courses;
    
    @JoinColumn(name = "specialisation", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Specialisation specialisations;

    public CourseOfSpecialisation() {
    }

    public CourseOfSpecialisation(CourseOfSpecialisationPK courseOfSpecialisationPK) {
        this.courseOfSpecialisationPK = courseOfSpecialisationPK;
    }

    public CourseOfSpecialisation(Long szakiranyID, Long tantargyID) {
        this.courseOfSpecialisationPK = new CourseOfSpecialisationPK(szakiranyID, tantargyID);
    }

    public CourseOfSpecialisationPK getSzakiranyTantargyaPK() {
        return courseOfSpecialisationPK;
    }

    public void setSzakiranyTantargyaPK(CourseOfSpecialisationPK courseOfSpecialisationPK) {
        this.courseOfSpecialisationPK = courseOfSpecialisationPK;
    }

    public String getBlokk() {
        return block;
    }

    public void setBlokk(String block) {
        this.block = block;
    }

    public Course getCourses() {
        return courses;
    }

    public void setCourses(Course courses) {
        this.courses = courses;
    }

    public Specialisation getSpecialisations() {
        return specialisations;
    }

    public void setSpecialisations(Specialisation specialisations) {
        this.specialisations = specialisations;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CourseOfSpecialisation)) {
            return false;
        }
        CourseOfSpecialisation other = (CourseOfSpecialisation) object;
        if ((this.courseOfSpecialisationPK == null && other.courseOfSpecialisationPK != null) || (this.courseOfSpecialisationPK != null && !this.courseOfSpecialisationPK.equals(other.courseOfSpecialisationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("CourseOfSpecialisation");
        sb.append("{course=").append(courseOfSpecialisationPK.getCourse());
        sb.append("{department=").append(courseOfSpecialisationPK.getSpecialisation());
        sb.append("{block=").append(block);
        sb.append('}');
        return sb.toString();
    }
    
}
