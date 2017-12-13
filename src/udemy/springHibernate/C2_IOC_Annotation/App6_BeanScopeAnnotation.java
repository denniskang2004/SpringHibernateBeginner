
package udemy.springHibernate.C2_IOC_Annotation;

import javax.annotation.PostConstruct;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import udemy.springHibernate.C1_IOC_XMLConfig.ICoach;

public class App6_BeanScopeAnnotation {
	public static void main(String[] args) {
		/*
		 * Bean Scope: use @Scope to define singleton or prototype
		 * Bean Lifecycle: use @PostConstruct or @PreDestroy for custom init or destroy
		 * ATTN: @preDestroy only works for singleton bean
		 */
		
		
		// load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation-applicationContext.xml");

		// tennis coach is using Prototype scope
		ICoach coach = context.getBean("tennisCoach", ICoach.class);
		ICoach alphaCoach = context.getBean("tennisCoach", ICoach.class);

		boolean isSame = (coach == alphaCoach);
		System.out.println("Point to same object? " + isSame);
		System.out.println("Memory location of coach:" + coach.toString());
		System.out.println("Memory location of alphaCoach:" + alphaCoach.toString());

		// funny coach is using single scope
		ICoach coach2 = context.getBean("funnyCoach", ICoach.class);
		ICoach alphaCoach2 = context.getBean("funnyCoach", ICoach.class);

		boolean isSame2 = (coach2 == alphaCoach2);
		System.out.println("Point to same object? " + isSame2);
		System.out.println("Memory location of coach:" + coach2.toString());
		System.out.println("Memory location of alphaCoach:" + alphaCoach2.toString());
		
		
		// close container
		context.close();
	}
}
