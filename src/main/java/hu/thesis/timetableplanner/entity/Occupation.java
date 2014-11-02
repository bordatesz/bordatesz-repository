/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hu.thesis.timetableplanner.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Atesz
 */
@Entity
@Table(name = "Occupation")
public class Occupation extends BaseEntity<Long> implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Column(name = "name", nullable=false)
    private String name;
    
    @Column(name = "date_time")
    private String dateTime;
    
    @ManyToMany(mappedBy = "occupations")
    private List<Lecturer> lecturers;

    public Occupation() {
    }

    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public List<Lecturer> getLecturers() {
        return lecturers;
    }

    public void setOktatokList(List<Lecturer> lecturers) {
        this.lecturers = lecturers;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Occupation");
        sb.append("{name=").append(name);
        sb.append(", dateTime='").append(dateTime).append('\'');
        sb.append('}');
        return sb.toString();
    }
    
}
