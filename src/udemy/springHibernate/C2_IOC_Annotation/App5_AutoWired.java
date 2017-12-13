package udemy.springHibernate.C2_IOC_Annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import udemy.springHibernate.C1_IOC_XMLConfig.ICoach;

public class App5_AutoWired {

	public static void main(String[] args) {

		/*
		 * Autowiring: 3 types of injection: constructor, setter, field
		 * ATTN: use one type, consistent across the project
		 */
		// 3 steps of constructor injection with AutoWire
		// define dependency class/interface (IFunny/MyFunnyService)
		// create FunnyCoach constructor with a dependency(IFunny)
		// configure dependency injection in config: with @Autowired annotation for FunnyCoach constructor

		// get container
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation-applicationContext.xml");
		// get bean
		FunnyCoach coach = context.getBean("funnyCoach", FunnyCoach.class);
		// use bean
		System.out.println(coach.MakeFun());
		System.out.println(coach.MakeFundNew());//autoWired for field
		// 2steps for Setter injection
		// 1. define the setter function for FunnyCoach
		// 2. add "@Autowired" to setter function

		
		
		/*
		 * Autowire with Qualifiers (for multiple implementation for a given interface)
		 */
		
		// close container
		context.close();
	}

}
