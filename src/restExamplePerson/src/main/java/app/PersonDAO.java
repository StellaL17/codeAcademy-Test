package app;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class PersonDAO {

//	static SessionFactory factory;
	static Transaction tx = null;

	public static Session initDB() {

		String hibernatePropsFilePath = "C:\\Users\\stela\\OneDrive\\Desktop\\CodeAcademy\\restExamplePerson\\src\\main\\resources\\hibernate.cfg.xml";
		File hibernatePropsFile = new File(hibernatePropsFilePath);

		Configuration cfg = new Configuration();

		cfg.configure(hibernatePropsFile);

		cfg.addAnnotatedClass(app.Person.class);
		cfg.addAnnotatedClass(app.UserProfile.class);

		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties());

		ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();

		SessionFactory sessionFactory = cfg.buildSessionFactory(serviceRegistry);

//		factory = cfg.configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		return session;
	}

	public static String insertpersonInDB(Person person) {

		try {

			Session s = initDB();
			tx = s.beginTransaction();

			s.save(person);

			tx.commit();

			s.close();
			return "Person with id: " + person.getId() + "has been created";

		} catch (HibernateException e) {
			tx.rollback();
			System.out.println(e);

		}
		return null;
	}

	public static List<Person> getAllFromDB() {
		List<Person> result = new ArrayList<Person>();

		try {
			Session s = initDB();
			tx = s.beginTransaction();

			result = s.createQuery("SELECT p FROM Person AS p").list();

			tx.commit();
			s.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}

		return result;
	}

	public static Person findPersonByIdDB(Integer id) {
		List<Person> result = new ArrayList<Person>();

		try {
			Session s = initDB();
			tx = s.beginTransaction();

//				result = s.createQuery("SELECT p FROM Person AS p").list();
			result = s.createNativeQuery("SELECT * FROM Person WHERE id=" + id + ";", Person.class).list();

			tx.commit();
			s.close();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}

		return result.get(0);
	}

	public static Person findPersonByUsernamePassword(String username, String password) {

		List<Person> result = new ArrayList<Person>();

		try {

			Session s = initDB();
			tx = s.beginTransaction();

			String query = "SELECT p FROM Person p WHERE p.username=:username AND p.password=:password";

			Query q = s.createQuery(query);
			q.setParameter("username", username);
			q.setParameter("password", password);

			result = q.list();

			if (result.isEmpty()) {
				return null;
			}

//			result = s.createQuery("SELECT p FROM Person p WHERE p.username=:username AND p.password=:password ;").list();

			tx.commit();
			s.close();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}

		return result.get(0);
	}

	public static void main(String[] args) {
		initDB();
	}

	public static String updateLoginStatus(Person p) {

		try {

			Session s = initDB();

			tx = s.beginTransaction();

			p.setLoginStatus(true);
			p.setLoginTime(new Date(System.currentTimeMillis()));

			s.update(p);

			tx.commit();
			s.close();

		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}

		return "";

	}

	public static Person checkIfUserIsLoggedIn(String username) {
		List<Person> result = new ArrayList<Person>();

		try {

			Session s = initDB();
			tx = s.beginTransaction();

			String query = "SELECT p From Person p WHERE p.username=:username AND p.loginStatus=true";

			Query q = s.createQuery(query);
			q.setParameter("username", username);

			result = q.list();

			if (result.isEmpty()) {

				return null;
			}

			tx.commit();
			s.close();

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		
		return result.get(0);
	}

	public static void changeStatus(Person p) {
		
		try {
			
			Session s = initDB();
			tx = s.beginTransaction();

			p.setLoginStatus(false);
			p.setLoginTime(new Date(System.currentTimeMillis()));

			s.update(p);

			tx.commit();
			s.close();
			
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		}
		
	}

	public static Person findPersonByUsername(String username) {
		List<Person> result = new ArrayList<Person>();

		try {

			Session s = initDB();
			tx = s.beginTransaction();

			String query = "SELECT p From Person p WHERE p.username=:username";

			Query q = s.createQuery(query);
			q.setParameter("username", username);

			result = q.list();
			
			if(result.isEmpty()) {
				return null;
			}

//			result = ("SELECT p From Person p WHERE p.username=:username AND p.password=:password ;").list();

			tx.commit();
			s.close();

		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
			tx.rollback();
		}

		return result.get(0);

	}

}
