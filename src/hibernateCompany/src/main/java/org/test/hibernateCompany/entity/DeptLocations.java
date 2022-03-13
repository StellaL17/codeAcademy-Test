package org.test.hibernateCompany.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="dept_locations")
public class DeptLocations {
	
	@EmbeddedId
	private DLocation dLocations;

	public DLocation getdLocations() {
		return dLocations;
	}

	public void setdLocations(DLocation dLocations) {
		this.dLocations = dLocations;
	}

	public DeptLocations(DLocation dLocations) {
		super();
		this.dLocations = dLocations;
	}

	public DeptLocations() {
		super();
	}

}
