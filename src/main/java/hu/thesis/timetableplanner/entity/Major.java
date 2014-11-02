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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Atesz
 */
@Entity
@Table(name = "Major")
public class Major extends BaseEntity<Long> implements Serializable {
    
    private static final long serialVersionUID = 1L;
  
    @Column(name = "name", length=64, nullable=false)
    private String name;
    
    @JoinTable(name = "Course_of_major", joinColumns = {
        @JoinColumn(name = "major", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "course", referencedColumnName = "ID")})
    @ManyToMany
    private List<Course> courses;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "major")
    private List<Specialisation> sepcialisations;
    
    @JoinColumn(name = "majorResponsible", referencedColumnName = "ID", nullable=false)
    @OneToOne(fetch = FetchType.LAZY)
    private Lecturer majorResponsible;

    public Major() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Specialisation> getSpecialisations() {
        return sepcialisations;
    }

    public void setSpecialisations(List<Specialisation> sepcialisations) {
        this.sepcialisations = sepcialisations;
    }

    public Lecturer getMajorResponsible() {
        return majorResponsible;
    }

    public void setMajorResponsible(Lecturer majorResponsible) {
        this.majorResponsible = majorResponsible;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Major");
        sb.append("{name=").append(name);
        sb.append('}');
        return sb.toString();
    }
    
}
