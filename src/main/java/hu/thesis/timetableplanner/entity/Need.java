/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hu.thesis.timetableplanner.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Atesz
 */
@Entity
@Table(name = "Need")
public class Need implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected NeedPK needPK;
    
    @Column(name = "accepted")
    private Boolean accepted;
    
    @Column(name = "recording", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date recording;
    
    @JoinColumn(name = "department", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Department departments;
    
    @JoinColumn(name = "course", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Course courses;

    public Need() {
    }

    public Need(NeedPK needPK) {
        this.needPK = needPK;
    }

    public Need(NeedPK needPK, Date recording) {
        this.needPK = needPK;
        this.recording = recording;
    }

    public Need(Long course, Long department) {
        this.needPK = new NeedPK(course, department);
    }

    public NeedPK getNeedekPK() {
        return needPK;
    }

    public void setNeedekPK(NeedPK needPK) {
        this.needPK = needPK;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public Date getRecording() {
        return recording;
    }

    public void setRecording(Date recording) {
        this.recording = recording;
    }

    public Department getDepartments() {
        return departments;
    }

    public void setDepartments(Department departments) {
        this.departments = departments;
    }

    public Course getCourses() {
        return courses;
    }

    public void setCourses(Course courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Need");
        sb.append("{course=").append(needPK.getCourse());
        sb.append("{department=").append(needPK.getDepartment());
        sb.append("{accepted=").append(accepted);
        sb.append("{recording=").append(recording);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Need)) {
            return false;
        }
        Need other = (Need) object;
        if ((this.needPK == null && other.needPK != null) || (this.needPK != null && !this.needPK.equals(other.needPK))) {
            return false;
        }
        return true;
    }

    
}
