package udemy.springHibernate.C3_IOC_JavaConfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import udemy.springHibernate.C1_IOC_XMLConfig.ICoach;
import udemy.springHibernate.C2_IOC_Annotation.FunnyCoach;

public class App7_JavaConfigurationScan {

	public static void main(String[] args) {

		/*
		 * Java configure Spring
		 */
		// 1. create java class and annotated with @Configuration, i.e. SportConfig class
		// 2. add component scan support: @ComponentScan
		// 3. read spring java config class
		// 4. retrieve bean from spring container

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		FunnyCoach coach = context.getBean("funnyCoach", FunnyCoach.class);
		// use bean
		System.out.println(coach.MakeFun());
		System.out.println(coach.MakeFundNew());//autoWired for field
		
		/*
		 * Add Bean to config using Java
		 * 
		 */
		// 4 steps
		// 1. Define method to expose bean
		// 2. Inject bean dependencies
		// 3. Read java spring config class
		// 4. Retrieve bean from spring container
		
		
		context.close();
		
	}

}
