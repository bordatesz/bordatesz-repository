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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Atesz
 */
@Entity
@Table(name = "Lecturer")
public class Lecturer extends BaseEntity<Long> implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Column(name = "name", length=64, nullable=false)
    private String name;
    
    @Column(name = "password", length=20, nullable=false)
    private String password;
    
    @Column(name = "required_hours")
    private Integer requiredHours;
    
    @Column(name = "active")
    private Boolean active;
    
    @Column(name = "room_number")
    private String roomNumber;
    
    @Column(name = "phone_number", length=64)
    private String phoneNumber;
    
    @Column(name = "email")
    private String email;
    
    @JoinTable(name = "Occupied", joinColumns = {
        @JoinColumn(name = "lecturer", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "occupation", referencedColumnName = "ID")})
    @ManyToMany
    private List<Occupation> occupations;
    
    @OneToMany(mappedBy = "responsible")
    private List<Course> courses;
        
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lecturer")
    private List<Teach> teach;
    
    @JoinColumn(name = "department", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private Department department;

    public Lecturer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRequiredHours() {
        return requiredHours;
    }

    public void setRequiredHours(Integer requiredHours) {
        this.requiredHours = requiredHours;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Occupation> getOccupations() {
        return occupations;
    }

    public void setOccupations(List<Occupation> occupations) {
        this.occupations = occupations;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Teach> getTeach() {
        return teach;
    }

    public void setTeach(List<Teach> teach) {
        this.teach = teach;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Lecturer");
        sb.append("{name=").append(name);
        sb.append(", password='").append(password).append('\'');
        sb.append(", required_hours='").append(requiredHours).append('\'');
        sb.append(", active='").append(active).append('\'');
        sb.append(", room_number='").append(roomNumber).append('\'');
        sb.append(", phone_number='").append(phoneNumber).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
    
}
