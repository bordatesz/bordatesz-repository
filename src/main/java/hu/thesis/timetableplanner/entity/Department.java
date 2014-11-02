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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Atesz
 */
@Entity
@Table(name = "Department")
public class Department extends BaseEntity<Long> implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Column(name = "name", length=256, nullable=false)
    private String name;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departments")
    private List<Need> needs;
    
    @JoinColumn(name = "responsible", referencedColumnName = "ID", nullable=false)
    @OneToOne(fetch = FetchType.LAZY)
    private Lecturer responsible;
    
    @OneToMany(mappedBy = "department")
    private List<Lecturer> lecturers;    

    public Department() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Need> getNeeds() {
        return needs;
    }

    public void setNeeds(List<Need> needs) {
        this.needs = needs;
    }

    public Lecturer getResponsible() {
        return responsible;
    }

    public void setResponsible(Lecturer responsible) {
        this.responsible = responsible;
    }

    public List<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setLecturers(List<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Department");
        sb.append("{name=").append(name);
        sb.append('}');
        return sb.toString();
    }
    
}
