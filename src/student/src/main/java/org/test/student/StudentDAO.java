package org.test.student;

import java.util.List;
import java.util.Set;

public interface StudentDAO {
	
	public String createStudentTable();
	public String createStudent(Student student);
	public Set getAllStudents();
	
	public Integer countStudents();
	public Student getStudentById(String index);
	
	public Student getStudentsById(String index);
	public List<Student> getStudentsByMajor(String major);
	public List<StudentInfo> getStudentsInfo();
	
	public String countStudent();
	
	
	

}
