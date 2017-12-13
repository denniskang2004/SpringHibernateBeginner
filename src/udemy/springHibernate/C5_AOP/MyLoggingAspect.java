package udemy.springHibernate.C5_AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import udemy.springHibernate.C4_Hibernate.intro;
/*
  * Terms: */
//Aspect: a class that define a crosscutting module
//Advice: fund in aspect class that define actions for certain rule


@Aspect
@Component
@Order(2) // second to fire
public class MyLoggingAspect {

	@Before("execution(public void addAccount())") // pointcut expression: match any addAccount
	public void beforeAddAccountAdvice() {

		System.out.println("\n=====>>>> Executing Logging advice on addAccount()");

	}

	@Before("execution(public void del*(..))") // pointcut expression: match any add...
	public void beforeAnyAddAdvice() {

		System.out.println("\n=====>>>> Executing Logging advice on Delete anything()");

	}

	@Before("execution(public void del*(..))") // pointcut expression: match any add...
	public void beforeLoggingAnyAddAdvice(JoinPoint theJoinPoint) {

		MethodSignature signature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("@@@Del Method sigature:" + signature);
		Object[] args = theJoinPoint.getArgs();
		for (Object arg : args) {
			System.out.println("***Argument:" + arg.toString());
		}
		System.out.println("\n=====>>>> Executing Logging advice on Delete anything()");

	}

}
