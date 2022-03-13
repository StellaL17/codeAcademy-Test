package app;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ProfileDAO {

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

	public static String createProfile(UserProfile profile) {

		try {

			Session s = initDB();
			tx = s.beginTransaction();

			s.save(profile);

			tx.commit();

			s.close();
			return "User profile with id: " + profile.getId() + "has been created";

		} catch (HibernateException e) {
			tx.rollback();
			System.out.println(e);

		}
		return null;
	}

	public static UserProfile getProfileByUserId(Integer id, String username) {

		List<UserProfile> result = new ArrayList<>();

		try {

			Session s = initDB();
			tx = s.beginTransaction();

			// SELECT u FROM person AS p RIGHT OUTER JOIN user_profile AS u ON p.id =
			// u.personid WHERE p.username='jdimitar';
//			result = s.createNativeQuery("SELECT * FROM public.user_profile WHERE user_profile.personId=" + personId + ";", UserProfile.class).list();

			result = s.createNativeQuery("SELECT * FROM public.person RIGHT OUTER JOIN public.user_profile ON public.person.id = public.user_profile.personid WHERE public.person.username='" + username + "';", UserProfile.class).list();
			
			tx.commit();
			s.close();

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}

		return result.get(0);
	}

	public static void updateUserProfile(UserProfile userProfile) {

		try {

			Session s = initDB();
			tx = s.beginTransaction();

			s.update(userProfile);

			tx.commit();
			s.close();

		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
	}

	public static List<UserProfile> getAllProfiles() {
		List<UserProfile> res = new ArrayList<UserProfile>();
		
		try {
			
			Session s = initDB();
			tx = s.beginTransaction();
			
			res = s.createNativeQuery("SELECT * FROM public.user_profile;", UserProfile.class).list();
			
			tx.commit();
			s.close();
			
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			tx.rollback();
		}
		
		return res;
	}

}
