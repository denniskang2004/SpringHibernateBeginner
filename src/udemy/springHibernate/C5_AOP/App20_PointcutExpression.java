package udemy.springHibernate.C5_AOP;

public class App20_PointcutExpression {
	/*
	 * Examples of pointcut expression
	 */
	// Excution(modifier-pattern? return-type? declare-type? method-name throw-pattern?)

	// example: match only AccountDAO's addAccount
	// @Before("execution(public void udemy.springHibernate.C5_AOP.addAccount())")

	// example: match only anyclass's addAccount
	// @Before("execution(public void addAccount())")

	// example: match only method starting with "add"
	// @Before("execution(public void add*())")

	// any modifier and any return type
	// @Before("execution(* * add*())")

	// for parameters
	// (): match with no-arg
	// (*): match method with one arg of any type
	// (..): match a method with 0 or more arg with any type

	// example:
	// @Before("execution(* udemy.springHibernate.C5_AOP.*.*(..))")
	// match: any return type, in C5_AOP package, any class , any method, any args

	// param type
	// @Before("execution(* * add*(udemy.springHibernate.C5_AOP.MyAccountDAO))")

}
