package udemy.springHibernate.C5_AOP;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class App25_AfterReturnning {
	
	// @AfterReturning (pointcut="", returning="myresult")
	// Use case: post-process the value returned
	// ATTN: access returned value, use "myresult", match advice function's signature!!!
	@AfterReturning(pointcut="execution(public * getAll*())", returning="myResult")
	public void afterReturnFindAccountAdvice(JoinPoint theJoinPoint, ArrayList<String> myResult) {
		for(String accountDAO:myResult) {
			System.out.println("Account found:"+accountDAO.toString());
		}
		
		// Modifying data (post-processing data)
		myResult.add("!!!New Item from afterReturnFindAccountAdvice");
		
	}
	
	
}
