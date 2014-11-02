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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "Course")
public class Course extends BaseEntity<Long> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Column(name = "name", length=256, nullable=false)
    private String name;

    @Column(name = "type", nullable=false)
    private String type;

    @Column(name = "credit", nullable=false)
    private int credit;
    
    @Column(name = "hours_per_week")
    private Integer hoursPerWeek;
    
    @Column(name = "period")
    private Integer period;
    
    @Column(name = "curricula")
    private Integer curricula;
    
    @ManyToMany(mappedBy = "courses")
    private List<Major> majors;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courses")
    private List<Need> needs;
    
    @JoinColumn(name = "responsible", referencedColumnName = "ID")
    @ManyToOne
    private Lecturer responsible;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Teach> teach;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courses")
    private List<CourseOfSpecialisation> coursesOfSpecialisation;

    public Course() {
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public Integer getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(Integer hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public Integer getCurricula() {
        return curricula;
    }

    public void setCurricula(Integer curricula) {
        this.curricula = curricula;
    }

    public List<Major> getMajors() {
        return majors;
    }

    public void setMajors(List<Major> majors) {
        this.majors = majors;
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

    public List<Teach> getTeach() {
        return teach;
    }

    public void setTeach(List<Teach> teach) {
        this.teach = teach;
    }

    public List<CourseOfSpecialisation> getCoursesOfSpecialisation() {
        return coursesOfSpecialisation;
    }

    public void setCoursesOfSpecialisation(List<CourseOfSpecialisation> coursesOfSpecialisation) {
        this.coursesOfSpecialisation = coursesOfSpecialisation;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Course");
        sb.append("{name=").append(name);
        sb.append(", type='").append(type).append('\'');
        sb.append(", credit='").append(credit).append('\'');
        sb.append(", hoursPerWeek='").append(hoursPerWeek).append('\'');
        sb.append(", period='").append(period).append('\'');
        sb.append(", curricula='").append(curricula).append('\'');
        sb.append('}');
        return sb.toString();
    }
    
}
