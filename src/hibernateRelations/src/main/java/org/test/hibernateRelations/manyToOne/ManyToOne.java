package org.test.hibernateRelations.manyToOne;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.test.hibernateRelations.manyToOne.entity.Department;
import org.test.hibernateRelations.manyToOne.entity.Employee;
import org.test.hibernateRelations.manyToOne.entity.Project;
import org.test.hibernateRelations.oneToOne.entity.Student;

public class ManyToOne {

	static SessionFactory factory;

	public static void main(String[] args) throws ParseException {

		Transaction tx = null;

		try {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(org.test.hibernateRelations.manyToOne.entity.Department.class);
			cfg.addAnnotatedClass(org.test.hibernateRelations.manyToOne.entity.Employee.class);
			cfg.addAnnotatedClass(org.test.hibernateRelations.manyToOne.entity.Project.class);
		

			cfg.configure();

			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();
			
			//Many to one relation
			
			Project project1 = new Project("Communication", "Description of communication project");
			session.save(project1);
			
			Department dept1 = new Department("Telco", 9);
			dept1.setProject(project1);
			
			session.save(dept1);
			
			Date date = new Date(System.currentTimeMillis());
			
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date d = df.parse("2020-12-11"); //java.util.date
			Date sqlDate = new Date(d.getTime());
			
			Employee e1 = new Employee("Aleksandar Acev", 50000, date);
			
			e1.setDepartment(dept1);
			
			session.save(e1);
			
			Employee e2 = new Employee("Vlatko Doncev", 90000, date);
			
			e2.setDepartment(dept1);
			
			session.save(e2);
			
			
			findEmployeeData(2L, session);

			
			tx.commit();
			session.close();
			

		} catch (HibernateException e) {
			tx.rollback();
			System.out.println(e);

		}
	}

	private static void findEmployeeData(long employeeNumber, Session session) {
		
		String hql = "SELECT e FROM Employee e WHERE e.id=:empId";
		
		//String hqlJoin = "SELECT e d FROM Employee e Department d JOIN e.department d WHERE e.id=d.id"
		
		//find all employees working on same project
		//find all employees working in predefined department
		//find all employees working on same department
		
		Query query = session.createQuery(hql);
		List<Employee> result = query.setParameter("empId", employeeNumber).list();
		
		System.out.println("Ime i prezime: " + result.get(0).getName());
		
		Department dept = result.get(0).getDepartment();
		System.out.println("Dept name: " + dept.getDeptName());
		
		Project project = dept.getProject();
		System.out.println("Project name: " + project.getProjectname());
		
		
	}

}
