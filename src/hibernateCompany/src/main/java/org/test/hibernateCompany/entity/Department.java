package org.test.hibernateCompany.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department {
	
	@Id
	private Integer dNumber;
	
	@Column(name="Dname", length = 15, unique = true, nullable = false)
	private String dName;
	
	@Column(name="Mgr_ssn", length = 9, nullable = false)
	private Integer mgrSSN;
	
	@Column(name="Mgr_start_date")
	private Date mgrStartDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="dno")
	private List<Employee> employees;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="dnum")
	private List<Project> projects;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="dNumber")
	private List<DeptLocations> deptLocations;

	public Integer getdNumber() {
		return dNumber;
	}

	public void setdNumber(Integer dNumber) {
		this.dNumber = dNumber;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public Integer getMgrSSN() {
		return mgrSSN;
	}

	public void setMgrSSN(Integer mgrSSN) {
		this.mgrSSN = mgrSSN;
	}

	public Date getMgrStartDate() {
		return mgrStartDate;
	}

	public void setMgrStartDate(Date mgrStartDate) {
		this.mgrStartDate = mgrStartDate;
	}
	
	
	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<DeptLocations> getDeptLocations() {
		return deptLocations;
	}

	public void setDeptLocations(List<DeptLocations> deptLocations) {
		this.deptLocations = deptLocations;
	}

	public Department(Integer dNumber, String dName, Integer mgrSSN, Date mgrStartDate) {
		super();
		this.dNumber = dNumber;
		this.dName = dName;
		this.mgrSSN = mgrSSN;
		this.mgrStartDate = mgrStartDate;
		
	}

	public Department() {
		super();
	}

}
