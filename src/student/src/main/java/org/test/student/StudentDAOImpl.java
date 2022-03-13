package org.test.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public String createStudentTable() {
		Connection conn = JDBCCOnfig.getConnection();
		String result = "";
		
		try {
			Statement stmt = conn.createStatement();
			String query = "CREATE TABLE public.student ("
					+ "index VARCHAR(10) NOT NULL,"
					+ "name VARCHAR(20),"
					+ "surname VARCHAR(30),"
					+ "addressId INTEGER,"
					+ "major VARCHAR(50),"
					+ "PRIMARY KEY(index),"
					+ "FOREIGN KEY(addressId) REFERENCES public.address(id)"
					+ ");";
			
			Boolean status = stmt.execute(query);
			if (status) {
				result = "Table succesfully created";
			}else {
				result = "Table is not created";
			}		
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return result;
	}

	@Override
	public String createStudent(Student student) {
		Connection conn = JDBCCOnfig.getConnection();
		String res = "";
		try {
			String query = "INSERT INTO public.student("
					+ "	index, name, surname, addressid, major)"
					+ "	VALUES (?, ?, ?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, student.getIndex());
			ps.setString(2, student.getName());
			ps.setString(3, student.getSurname());
			ps.setInt(4, student.getAddressId());
			ps.setString(5, student.getMajor());
			
			ps.execute();
			
			res = "Student has been inserted";
		} catch (Exception e) {
			res = "Student has NOT been inserted";
			System.out.println(e);
		}
		
		return res;
	}

	@Override
	public Integer countStudents() {
		
		Connection conn = JDBCCOnfig.getConnection();
		Integer count = 0;
		
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT COUNT(*) FROM public.student";
			ResultSet rs = stmt.executeQuery(query);
			
			if (rs.next());
				count = rs.getInt(1);
				
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return count;
	}

	@Override
	public Student getStudentById(String index) {
		
		Student student = new Student();
		Connection conn = JDBCCOnfig.getConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query =  "SELECT * FROM public.student WHERE index = " + index + ";";
			ResultSet rs = stmt.executeQuery(query);
			
			if (rs.next()) {
				student = extractStudentFromResultSet(rs);
			}
				
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return student;
	}

	private Student extractStudentFromResultSet(ResultSet rs) throws SQLException {
		
		Student student = new Student();

		student.setIndex(rs.getString("index"));
		student.setName(rs.getString("name"));
		student.setSurname(rs.getString("surname"));
		student.setAddressId(rs.getInt("addressId"));
		student.setMajor(rs.getString("major"));

		return student;
	}

	@Override
	public Set getAllStudents() {
		
		Connection conn = JDBCCOnfig.getConnection();
		Set students = new HashSet();
		
		try {
			
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM public.student;";
			ResultSet rs = stmt.executeQuery(query);
			
			
			while (rs.next()) {
				Student student = new Student();
				
				student.setIndex(rs.getString("index"));
				student.setName(rs.getString("name"));
				student.setSurname(rs.getString("surname"));
				student.setAddressId(rs.getInt("addressId"));
				student.setMajor(rs.getString("major"));
				
				students.add(student);
			}
			return students;
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return students;

	}

	@Override
	public Student getStudentsById(String index) {
		
		Connection conn = JDBCCOnfig.getConnection();
		Student st = new Student();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM public.student WHERE index = " + index + "; ";
			
			ResultSet rs = stmt.executeQuery(query);
			
			if (rs.next()) {
				st.setIndex(rs.getString("index"));
				st.setName(rs.getString("name"));
				st.setSurname(rs.getString("surname"));
				st.setAddressId(rs.getInt("addressId"));
				st.setMajor(rs.getString("major"));
			
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return st;
	}

	@Override
	public List<Student> getStudentsByMajor(String major) {
		
		Connection conn = JDBCCOnfig.getConnection();
		List<Student> result = new ArrayList<>();
		
		try {
			String query = "SELECT * FROM public.student WHERE major = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, major);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Student s = new Student();
				
				s.setIndex(rs.getString("index"));
				s.setName(rs.getString("name"));
				s.setSurname(rs.getString("surname"));
				s.setAddressId(rs.getInt("addressId"));
				s.setMajor(rs.getString("major"));
				
				result.add(s);
			}
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return result;
	}

	@Override
	public List<StudentInfo> getStudentsInfo() {
		
		AddressDAO addDao = new AddressDAOImpl();
		
		List<StudentInfo> result = new ArrayList<>();
		
		Set<Student> allStudents = getAllStudents();
		
		for (Student student : allStudents) {
			StudentInfo sInfo = new StudentInfo();
			
			sInfo.setName(student.getName());
			sInfo.setSurname(student.getSurname());
			
			Address a = addDao.getAddressById(student.getAddressId());
			
			sInfo.setStreet(a.getStreet());
			sInfo.setNumber(a.getNumber());
			sInfo.setCity(a.getCity());
			
			result.add(sInfo);
			
		}
		
		return result;
	}

	@Override
	public String countStudent() {
		
		String i = "";
		Connection conn = JDBCCOnfig.getConnection();
		
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT COUNT(*) FROM public.student;";
			
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				i = rs.getString(1);
				System.out.println("Ima vkupno: " + rs.getString(1) + " studenti");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return i;
	}

}
