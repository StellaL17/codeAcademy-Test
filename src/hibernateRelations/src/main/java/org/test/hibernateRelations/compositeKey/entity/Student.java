package org.test.hibernateRelations.compositeKey.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="student_compositekey")
public class Student {
	
	//primary key: id index
	
	//private Long id;
	
	//private String index; ==> ke ima nova klasa studentId koja ke gi sodrzi vo nea
	
	@EmbeddedId
	private StudentId studentId;
	
	@Column(name="name")
	private String name;

	public StudentId getStudentId() {
		return studentId;
	}

	public void setStudentId(StudentId studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(StudentId studentId, String name) {
		super();
		this.studentId = studentId;
		this.name = name;
	}

	public Student() {
		super();
	}
	
	
	
	

}
