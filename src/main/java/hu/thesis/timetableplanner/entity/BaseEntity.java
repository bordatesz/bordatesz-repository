package hu.thesis.timetableplanner.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity<ID> implements Entity<ID> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private ID id;
	
	public ID getId() {
		return id;
	}
	
	public void setId(ID id) {
		this.id = id;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if( obj != null && this.getClass().isInstance(obj) ) {
			@SuppressWarnings("unchecked")
			BaseEntity<ID> other = (BaseEntity<ID>) obj;
			return this.id != null ? this.id.equals(other.id) : other.id == null;
		}
		
		return false;
	}
}
