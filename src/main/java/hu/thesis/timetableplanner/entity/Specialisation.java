/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hu.thesis.timetableplanner.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Atesz
 */
@Entity
@Table(name = "Specialisation")
public class Specialisation extends BaseEntity<Long> implements Serializable {
    
    private static final long serialVersionUID = 1L;
   
    @Column(name = "name", nullable=false)
    private String name;
    
    @JoinColumn(name = "major", referencedColumnName = "ID") //nullable?
    @ManyToOne(fetch = FetchType.LAZY)
    private Major major;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "specialisations")
    private List<CourseOfSpecialisation> coursesOfSpecialization;

    public Specialisation() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public List<CourseOfSpecialisation> getMajoriranyTantargyaList() {
        return coursesOfSpecialization;
    }

    public void setMajoriranyTantargyaList(List<CourseOfSpecialisation> coursesOfSpecialization) {
        this.coursesOfSpecialization = coursesOfSpecialization;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Specialisation");
        sb.append("{name=").append(name);
        sb.append('}');
        return sb.toString();
    }
    
}
