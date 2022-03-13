package org.test.hibernateRelations.oneToOne;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.test.hibernateRelations.oneToOne.entity.Address;
import org.test.hibernateRelations.oneToOne.entity.Student;

public class OneToOne {
	
	static SessionFactory factory;
	
	public static void main(String[] args) {
		
		Transaction tx = null;
		
		try {
			Configuration cfg = new Configuration();
			cfg.addAnnotatedClass(org.test.hibernateRelations.oneToOne.entity.Student.class);
			cfg.addAnnotatedClass(org.test.hibernateRelations.oneToOne.entity.Address.class);
			
			cfg.configure();
			
			factory = cfg.configure().buildSessionFactory();
			Session session = factory.openSession();
			
			//tx = session.beginTransaction();
			
			//One to one mapping of entities
			
//			Student student1 = new Student("Vlatko", "Donchev");
//			Address address1 = new Address("Partizanska", "50", "Skopje");
//			
//			student1.setAddress(address1);
//			address1.setStudent(student1);
//			
//			session.persist(student1);
			
			String hql = "SELECT s FROM Student s WHERE s.id=:stid";
			
			Query query = session.createQuery(hql);
			List<Student> res = query.setParameter("stid", 1L).list();
			System.out.println(res.get(0).getName());
			
			Address a = res.get(0).getAddress();
			System.out.println(a.getCity());
			
			List<Student> res1 = session.createQuery("SELECT s FROM Student AS s").list();
					
			
			tx.commit();
			
			session.close();
			
		} catch (HibernateException e) {
			tx.rollback();
			System.out.println(e);
			
		}
		
	}

}
