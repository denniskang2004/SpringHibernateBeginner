package udemy.springHibernate.C5_AOP;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class App21_PointcutExpressionDeclaration {

	// pointcut declaration
	// create it
	// apply to Advises
	
	@Pointcut("execution(public void del*())") 
	public void forDaoPackage(){} // declare pointcut "forDaoPackage"
	
	@Before("forDaoPackage") //apply pointcut 
	public void beforeAnyAddAdvice() {
		System.out.println("\n=====>>>> Executing @Before advice on Delete anything()");
	}
	
}
