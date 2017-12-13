package udemy.springHibernate.C4_Hibernate;
/* Concepts*/

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App13_OneToOneMapping_biDirectional {

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
			
			InstructorDetail instructorDetail =session.get(InstructorDetail.class, 6);
			System.out.println("found detail: "+instructorDetail.toString());
			System.out.println("get referred instructor : "+instructorDetail.getInstructor().toString());
			
			// removed associated reference, break bi-directional link
			instructorDetail.getInstructor().setInstructorDetailId(null); // remove foreign key reference
			
			// delete the instructorDetail which triggers the cascading
			session.delete(instructorDetail);
			
			// commit
			session.getTransaction().commit();
			System.out.println("done!");
			

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
