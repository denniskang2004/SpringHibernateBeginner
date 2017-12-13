package udemy.springHibernate.C1_IOC_XMLConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App2_BeanScope {

	public static void main(String[]args) {
		// load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");

		// retrieve bean
		ICoach coach = context.getBean("myCoach",ICoach.class);
		ICoach alphaCoach = context.getBean("myCoach",ICoach.class);
		
		/*
		 * Bean Scope: means: lifecycle, how shared, how many instances created
		 */
		// default: is singleton: all reference to same bean object (Stateless bean)
		// prototype: everytime of "getBean" will get new object (Stated bean)
		// 2 types for regular app: Singleton and Prototype
		// 3 types for WebApp only: ...
		
		// check if above 2 are same 
		// case1: use default without change
		// case2: bean config: scope="prototype"
		boolean isSame = (coach == alphaCoach);
		System.out.println("Point to same object? "+ isSame);
		System.out.println("Memory location of coach:"+coach.toString());
		System.out.println("Memory location of alphaCoach:"+alphaCoach.toString());
		
		
		
		
		// close
		context.close();
	}
}
