package org.test.hibernateCompany.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name="works_on")
public class WorksOn {
	
	@EmbeddedId
	private WorksOnId worksOnId;
	
	@Column(nullable = false)
	private double hours;
	
	@ManyToOne
	@MapsId("essn")
	private Employee employee;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@MapsId("pno")
	private Project project;
	

	public WorksOnId getWorksOnId() {
		return worksOnId;
	}

	public void setWorksOnId(WorksOnId worksOnId) {
		this.worksOnId = worksOnId;
	}

	public double getHours() {
		return hours;
	}

	public void setHours(double hours) {
		this.hours = hours;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public WorksOn(WorksOnId worksOnId, double hours) {
		super();
		this.worksOnId = worksOnId;
		this.hours = hours;
	}

	public WorksOn() {
		super();
	}
	

}
