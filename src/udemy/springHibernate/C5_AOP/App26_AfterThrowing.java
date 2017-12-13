package udemy.springHibernate.C5_AOP;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class App26_AfterThrowing {

	@AfterThrowing(pointcut="execution(public * getAllAccountsError())", throwing="myEx")
	public void afterReturnFindAccountAdvice(JoinPoint theJoinPoint, Throwable myEx) {
		System.out.println("Caught exception in afterReturnFindAccountAdvice! @AfterThrowing: "+myEx.getMessage());	
	}
	
	// @After will run no matter exception or not, like finally. No access to exception
	@After("execution(public * getAllAccountsError())")
	public void afterAdvice(JoinPoint theJoinPoint) {
		System.out.println("@After running! ");	
	}
}
