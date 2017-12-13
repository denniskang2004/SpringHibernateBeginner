package udemy.springHibernate.C4_Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App11_PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		// use session
		try {
			// create student object to save
			System.out.println("Create new student obj");
			Student tempStu1 = new Student("Paul", "Wall", "wall@gmail.com");
			Student tempStu2 = new Student("Dennis", "Kang", "kang@gmail.com");
			Student tempStu3 = new Student("Mary", "Jobs", "jobs@gmail.com");

			// start transaction
			session.beginTransaction();

			// save student object
			System.out.println("Saving Students...");
			session.save(tempStu1);
			session.save(tempStu2);
			session.save(tempStu3);

			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done");
			
			// How to change incremental values
			// mysql: Alter Table hb_student_tracker.student auto_increment = 3000;
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}

	}
}
