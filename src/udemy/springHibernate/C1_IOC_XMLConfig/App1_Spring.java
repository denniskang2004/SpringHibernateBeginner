package udemy.springHibernate.C1_IOC_XMLConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//TODO install cleanly the Tomcat and Spring instead of using STS
public class App1_Spring {

	public static void main(String[] args) {
		/*
		 * use spring IOC: make it configurable
		 */

		// spring containers 2 function: create/manage objects, inject object
		// dependencies

		// configure spring containers 3 ways
		// 1. XML/legacy way 2. Java annotation 3. Java source code

		// Kang note: Spring IOC development process 3 steps:
		// 1. configure spring beans (copy/config the applicationContext.xml)
		// 2. create spring container (a.k.a ApplicationContext)
		// 3. retrieve bean from spring container
		// 4. close container/context

		// load spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// retrieve bean from spring container
		ICoach baseballCoach = context.getBean("baseballCoach", ICoach.class);

		// call methods on bean
		System.out.println(baseballCoach.getDailyWorkout());

		/*
		 * IOC: Construtor Injections
		 */

		// 1. Define dependency interface and classes
		// 2. create constructor in class for injection
		// 3.Configure dependency injection in Spring config (constructor-arg)

		ICoach trackCoach = context.getBean("trackCoach", ICoach.class);// get constructor injection also
		System.out.println(trackCoach.getDailyWorkout());
		System.out.println(trackCoach.getDailyFortuneService());

		/*
		 * 
		 * IOC: Setter injection
		 */
		// 1. create setter method
		// 2. Confgiure dependency in spring config (property, name, ref)

		CricketCoach cricketCoach = context.getBean("cricketCoach", CricketCoach.class);// do setter injection also
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortuneService());

		/*
		 * IOC: Inject literal values (such as String values)
		 */
		// 1. create setter method
		// 2. Confgiure dependency in spring config (property, name, value)
		System.out.println("Email:" + cricketCoach.getEmailAddress());
		System.out.println("Team:" + cricketCoach.getTeam());
		
		/*
		 * IOC: Inject values from Properties file
		 */
		// 1. Create Properties file. i.e. text file named: sport.properties
		// 2. Load Property File in spring config. 
		// 3. Reference value from Properties File (value=${xxx})
		System.out.println("Email:" + cricketCoach.getPropEmail());
		System.out.println("Team:" + cricketCoach.getPropTeam());
		
		/*
		 * IOC: Exercise: define a new implementation of IFortuneService, then inject to TrackCoach
		 */
		
		
		// close context
		context.close();
	}

}
