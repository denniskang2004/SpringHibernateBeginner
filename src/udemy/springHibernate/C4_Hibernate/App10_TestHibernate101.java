package udemy.springHibernate.C4_Hibernate;

import java.util.ArrayList;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import antlr.collections.List;

public class App10_TestHibernate101 {
	// Three steps:

	// 1. add Hibernate config file (Udemy downloaded source: "hibertnate.cfg.xml")

	// 2. annotation(legacy:xml) to java class (Entity class, which is mapped to DB)
	// - map class to table: use @Entity, @Table(name="studnet")
	// - map fields to table columns: use @Id, @Column(name="id")
	// - create no-arg/all-field constructor and toString

	// 3. develop code to do CRUD actions of java class
	// - create SessionFactory: read hibernate config, to create session objects, singleton
	// - create Session: wraps JDBC, object used to CRUD, short-lived
	// - use session to do db actions CRUD
	// - close sessionFactory

	static public void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		// use session
		try {
			// create student object to save
			System.out.println("Create new student obj");
			Student tempStu = new Student("Paul", "Wall", "wall@gmail.com");

			// start transaction
			session.beginTransaction();

			// save student object
			System.out.println("Saving Student...");
			session.save(tempStu);
			
			// commit transaction
			session.getTransaction().commit();
			

			/*get sutduent from db*/
			Session sessionNew = factory.getCurrentSession();
			sessionNew.beginTransaction();
			Student stuGot = sessionNew.get(Student.class, 123);//123 is primary key
			sessionNew.getTransaction().commit();
			
			/*query objects :using HQL */
			// avoid sql injection
			// https://software-security.sans.org/developer-how-to/fix-sql-injection-in-java-hibernate
			Session sessionNew2 = factory.getCurrentSession();
			sessionNew2.beginTransaction();
			java.util.List<Student> list = sessionNew2.createQuery("from Student s where "+ " s.email LIKE '%.com' ").getResultList();
			System.out.println("got sutdent: "+ list.get(0).toString());
			java.util.List<Student> list2 = sessionNew2.createQuery("from Student s where "+ " s.lastName = 'Kang' or s.lastName = 'Jobs' ").getResultList();
			System.out.println("got sutdent: "+ list.get(0).toString());
			sessionNew2.getTransaction().commit();
			
			/* add tracing for query --> download log4j and properties log4j.logger.org.hibernate=TRACE */
			
			/* update hibernate DB */
			// get object, set value, commit transaction
			// batch update: 
			session = factory.getCurrentSession();
			session.createQuery("update Student set email = 'newemail'").executeUpdate();
			
			/* delete */			 
			session.delete(stuGot);
			session.getTransaction().commit();
			//delete batch
			session.createQuery("delete from Student ...").executeUpdate();
			
			System.out.println("Done");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

		}

		// close factory
	}
}
