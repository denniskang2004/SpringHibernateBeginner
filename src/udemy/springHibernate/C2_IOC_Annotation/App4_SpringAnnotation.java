package udemy.springHibernate.C2_IOC_Annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import udemy.springHibernate.C1_IOC_XMLConfig.ICoach;

public class App4_SpringAnnotation {

	public static void main(String[] args) {
		
		/*
		 * Annotation basics
		 */
		// Steps for annotation spring
		// 1. Enable component scanning in spring config file (context:component-scan base-package="")
		// 2. Add @Component annotation to java classes (@Component("aaaa");
		// 3. Retrieve beans from Spring container (context.getBean("aaaa",className.class))
		
		
		// process of spring
		
		// get spring container 
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation-applicationContext.xml");
		
		// get bean
		TennisCoach coach = context.getBean("tennisCoach",TennisCoach.class);
		
		// use bean
		System.out.println("Tennis Coach:"+coach.getDailyWorkout());
		System.out.println("Tennis coach email:"+coach.getEmail()); // use @Value("xxx") to get values injection
		System.out.println("Tennis coach team:"+coach.getTeam()); // use @Value("${xxx}") to properties file injection
		
		// close container
		context.close();
	}

}
