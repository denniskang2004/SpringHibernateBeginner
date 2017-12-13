package udemy.springHibernate.C3_IOC_JavaConfiguration;

import java.awt.ImageCapabilities;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import udemy.springHibernate.C1_IOC_XMLConfig.ICoach;
import udemy.springHibernate.C2_IOC_Annotation.FunnyCoach;

public class App8_JavaConfigurationNoScan {
	public static void main(String[] args) {


		/*
		 * Java No Scan: Add Bean to config using Java
		 * 
		 */
		// 4 steps
		// 1. Define method to expose bean (in SwimConfig class)
		// 2. Inject bean dependencies
		// 3. Read java spring config class
		// 4. Retrieve bean from spring container
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SwimConfig.class);
		SwimCoach coach = context.getBean("swimCoach",SwimCoach.class);
		
		System.out.println(coach.getDailyFortuneService());
		System.out.println(coach.getDailyWorkout());
		
		/*
		 * Define properties file using java config
		 */
		//1. create properties file
		//2. Load properties file in Spring config ( use @PropertySource to SwimConfig class)
		//3. Reference values from properties file
		System.out.println("Email of Swim:"+coach.getEmail());
		
		
		context.close();
	}
}
