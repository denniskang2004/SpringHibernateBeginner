package udemy.springHibernate.C4_Hibernate;
/* Concepts*/

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App14_ExceptionHandling {

	static public void main(String[] args) {
		// create session factory
		// include the entity class into the factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		// use session
		try {
			session.beginTransaction();

			// get instructorDetail
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 555);
			System.out.println("found detail: " + instructorDetail.toString());
			System.out.println("get referred instructor : " + instructorDetail.getInstructor().toString());

			// commit
			session.getTransaction().commit();
			System.out.println("done!");

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close(); // handle the leaking issue
			factory.close(); // clean the connection pool 
		}
	}
}
