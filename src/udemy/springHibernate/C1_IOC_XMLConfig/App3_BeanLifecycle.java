package udemy.springHibernate.C1_IOC_XMLConfig;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App3_BeanLifecycle {

	public static void main(String[]args) {
		// load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifecycle-applicationContext.xml");

		// retrieve bean
		ICoach coach = context.getBean("myLifeCoach",ICoach.class);
		
		
		/*
		 * Bean lifeCycle:
		 * 
		 * Container started 
		 * -> Bean instantiated 
		 * -> Dependency injected 
		 * -> Spring internal process
		 * -> Your custom Init Method*
		 * ...(use beans)
		 * -> Container is shut down
		 * -> Your custom Destry Method* 
		 * -> STOP
		 */
		// ATTN: 
		// 1. custom init called always
		// 2. custom destroy called only for singleton bean! not for prototype
		// Steps
		// 1. define custom methods for Init and Destry (must: public void)
		// 2. configure these method name in Spring Config File
		
		
		System.out.println("GetFortune:"+coach.getDailyFortuneService());
		// close
		context.close();
	}
}
