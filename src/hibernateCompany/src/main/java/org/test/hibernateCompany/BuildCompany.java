package org.test.hibernateCompany;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.test.hibernateCompany.entity.DLocation;
import org.test.hibernateCompany.entity.Department;
import org.test.hibernateCompany.entity.Dependent;
import org.test.hibernateCompany.entity.DependentId;
import org.test.hibernateCompany.entity.DeptLocations;
import org.test.hibernateCompany.entity.Employee;
import org.test.hibernateCompany.entity.Project;

public class BuildCompany {
	
	static SessionFactory factory;
	
	public static void main(String[] args) {
		
		Transaction tx = null;
		
		try {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(org.test.hibernateCompany.entity.Department.class);
			cfg.addAnnotatedClass(org.test.hibernateCompany.entity.Employee.class);
			cfg.addAnnotatedClass(org.test.hibernateCompany.entity.Project.class);
			cfg.addAnnotatedClass(org.test.hibernateCompany.entity.DeptLocations.class);
			cfg.addAnnotatedClass(org.test.hibernateCompany.entity.Dependent.class);
			cfg.addAnnotatedClass(org.test.hibernateCompany.entity.WorksOn.class);
			
			cfg.configure();
			
			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();
			tx = session.beginTransaction();
			
			Date date = new Date(System.currentTimeMillis());
			
			Department department1 = new Department(5, "Research", 333445555, date);
			
			Employee emp1 = new Employee(123456789, "John", 'B', "Smith", date, "731 Fondren, Houston, TX", 'M', 30000, 33344555);
			Employee emp2 = new Employee(333445555, "Franklin", 'T', "Wong", date, "638 Vos, Houston, TX", 'M', 40000, 888665555);
			
			List<Employee> res = new ArrayList<Employee>();
			res.add(emp1);
			res.add(emp2);
			
			department1.setEmployees(res);
			
			Project pr1 = new Project(1,"ProductX", "Bellaire");
			Project pr2 = new Project(3,"ProductZ", "Houston");
			
			List<Project> proRes = new ArrayList<Project>();
			proRes.add(pr1);
			proRes.add(pr2);
			
			department1.setProjects(proRes);
			
			DLocation dLoc1 = new DLocation(5, "Bellaire");
			DLocation dLoc2 = new DLocation(5, "Houston");
			
			DeptLocations deptLoc1 = new DeptLocations(dLoc1);
			DeptLocations deptLoc2 = new DeptLocations(dLoc2);
			
			List <DeptLocations> deptLocRes = new ArrayList<DeptLocations>();
			
			deptLocRes.add(deptLoc1);
			deptLocRes.add(deptLoc2);
			
			department1.setDeptLocations(deptLocRes);		
			session.persist(department1);
			
			Department department2 = new Department(4, "Administration", 987654321, date);
			
			Employee emp3 = new Employee(999887777, "Alicia", 'J', "Zelaya", date, "3321 Castle, Spring, TX", 'F', 25000, 987654321);
			Employee emp4 = new Employee(987654321, "Jennifer", 'S', "Wallance", date, "291 Berry, Bellaire, TX", 'F', 43000, 888665555);
			
			List<Employee> res1 = new ArrayList<Employee>();
			res1.add(emp3);
			res1.add(emp4);
			
			department2.setEmployees(res1);
			
			Project pr3 = new Project(10,"Computerization", "Stafford");
			Project pr4 = new Project(30,"Newbenefits", "Stafford");
			
			List<Project> proRes1 = new ArrayList<Project>();
			proRes1.add(pr3);
			proRes1.add(pr4);
			
			department2.setProjects(proRes1);
			
			DLocation dLoc3 = new DLocation(4, "Stafford");
			
			DeptLocations deptLoc3 = new DeptLocations(dLoc3);
			
			List <DeptLocations> deptLocRes1 = new ArrayList<DeptLocations>();
			
			deptLocRes1.add(deptLoc3);
			
			department2.setDeptLocations(deptLocRes1);		
			session.persist(department2);
			
			
//			DependentId deptId = new DependentId(333445555, "Alice");            //333445555, "Alice");	
//			Dependent dept = new Dependent(deptId, 'F', date, "Daughter");
//			
//			session.save(dept);
//			
//			DependentId deptId1 = new DependentId(333445555, "Theodore");
//			Dependent dept1 = new Dependent(deptId1, 'M', date, "Son");
//			
//			session.save(dept1);
			
//			Employee empRelations = new Employee(333445555, "Franklin", 'T', "Wong", date, "638 Vos, Houston, TX", 'M', 40000, 888665555);
//			session.save(empRelations);
			
//			dept.setEmployee(emp2);
//			dept1.setEmployee(emp2);
		
			
			tx.commit();
			session.close();
			
			
		} catch (HibernateException e) {
			System.out.println(e);
		}
	}

}
