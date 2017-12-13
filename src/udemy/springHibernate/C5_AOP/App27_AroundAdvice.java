package udemy.springHibernate.C5_AOP;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class App27_AroundAdvice {

	// @Around will be called before and after of a function
	// use case: log/profile the function performance/time
	// use case: swallow, handle , stop exception
	
	@Around("execution(public * runLongJob())")
	public Object trackingAdvice(ProceedingJoinPoint thePrcdJoinPoint) throws Throwable {
		System.out.println("AroundTrackingService signature:"+thePrcdJoinPoint.getSignature());	
		
		long begin = System.currentTimeMillis();
		
		Object result = thePrcdJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		System.out.println("Duration:"+ (end-begin));
		
		return result;
	}
	
	@Around("execution(public * runLongJobError())")
	public Object swallowExceptionAdvice(ProceedingJoinPoint thePrcdJoinPoint) throws Throwable {
		System.out.println("AroundTrackingService signature:"+thePrcdJoinPoint.getSignature());	
		
		long begin = System.currentTimeMillis();
		
		try {
			Object result = thePrcdJoinPoint.proceed();	
		}
		catch(Exception ex) {
			System.out.println("!!! Error was handled by swallowExceptionAdvice:"+ex.getMessage());
		}
		
		
		long end = System.currentTimeMillis();
		
		System.out.println("Duration:"+ (end-begin));
		
		return null;
	}
	
	
	
}
