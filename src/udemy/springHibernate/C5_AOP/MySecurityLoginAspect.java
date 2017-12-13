package udemy.springHibernate.C5_AOP;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1) // first to run
public class MySecurityLoginAspect {
	@Before("execution(public void addAccount())") //pointcut expression: match any addAccount
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>>> Executing Security advice on addAccount()");
		
	}
	
	@Before("execution(public void del*())") //pointcut expression: match any add...
	public void beforeAnyAddAdvice() {
		
		System.out.println("\n=====>>>> Executing Security advice on Delete anything()");
		
	}
}
