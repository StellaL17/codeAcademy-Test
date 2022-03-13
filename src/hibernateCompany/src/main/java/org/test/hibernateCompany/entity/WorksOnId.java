package org.test.hibernateCompany.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class WorksOnId implements Serializable {
	
	private Integer essn;
	
	private Integer pno;

	public Integer getEssn() {
		return essn;
	}


	public void setEssn(Integer essn) {
		this.essn = essn;
	}


	public Integer getPno() {
		return pno;
	}


	public void setPno(Integer pno) {
		this.pno = pno;
	}


	public WorksOnId(Integer essn, Integer pno) {
		super();
		this.essn = essn;
		this.pno = pno;
	}


	public WorksOnId() {
		super();
	}
}
