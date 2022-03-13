package org.test.student;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );
        
        
        AddressDAO addressDAO = new AddressDAOImpl();
//        addressDAO.createAddressTable();
        
        StudentDAO studentDAO = new StudentDAOImpl();
//        System.out.println(studentDAO.createStudentTable());
        
        
        Address add = new Address(3, "Juzen Bulevar", "30", "Skopje");      
//        addressDAO.createAddress(add);
        
        Student st1 = new Student("352/2009", "Stela", "Lazarevska", add.getId(), "Computer science");       
//        studentDAO.createStudent(st1);
              
//        System.out.println(studentDAO.getAllStudents());
        
//        StudentDAO stdDAO = new StudentDAOImpl();  
//          System.out.println("Ima vkupno " + stdDAO.countStudents() + " studenti");
//        
//        Student student = new Student();
//        student = studentDAO.getStudentById("3");
//        System.out.println(student.getIndex());
        
        
        studentDAO.getAllStudents();
        
        Student s = studentDAO.getStudentsById("350/2009");
        Address a = addressDAO.getAddressById(s.getAddressId());
        
        System.out.println("Student info:" + s.getIndex() + " , " + s.getName() + "Address info: " 
        		+ a.getCity() + ", " + a.getStreet() + ", " + a.getNumber());
        
        List<Student> studentsWithSameMajor = studentDAO.getStudentsByMajor("Computer science");
        
        for (Student student : studentsWithSameMajor) {
        	System.out.println(student);
			
		}
        
        List<StudentInfo> studentsInfo = studentDAO.getStudentsInfo();
        
        for (StudentInfo studentInfo : studentsInfo) {
        	System.out.println(studentsInfo);
			
		}
        
        System.out.println(studentDAO.countStudent());
        
       
    }
}
