package udemy.springHibernate.C5_AOP;

import java.util.ArrayList;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App19_AOP {

	/* user cases */
	// Logging, security, transaction
	// Audit logging
	// Exception handling
	// API management/tracking

	/* advantage */
	// one single class, reusable
	// business logic is clean without adding extra code.
	// resolve code tangling
	// resolve code scatter
	// configurable

	/* disadvantage */
	// too many aspects: logic hard to follow
	// minor performance impact

	/* terms */
	// Aspect: module of code for cross-cutting concerns
	// Advice: what action to taken, when it should apply
	// Join Point: when to apply code during application
	// PointCut: predicate expression for where advice should be applied
	// Weaving: connect aspects to target objects

	/* Advice types */
	// before advice: run before method
	// after finally advice
	// after returnining advice
	// after throwing advice
	// around advice

	/* 2 AOP framework */
	// Spring AOP: run-time weaving of aspects, built-in
	// AspectJ: rech support on join points, diff code-weaving

	// compare:
	// spring: simpler, only method level join points, run-time weaving only, only apply to beans created by spring app context
	// aspectJ: complex, faster,

	// following we will: create aspects, advice, pointcut, apply to project

	// Steps:
	// add jar of aspectJ
	// create target object "MyAccountDBO"
	// create config class "MySpringConfig"
	// create main app class "App19_AOP"
	// create an Aspect

	static public void main(String[] args) {
		try {
			// read config class
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MySpringConfig.class);

			// read bean
			MyAccountDAO dao = context.getBean("myAccountDAO", MyAccountDAO.class);
			MyMembershipDAO membership = context.getBean("myMembershipDAO", MyMembershipDAO.class);

			// call business method
			dao.addAccount();
			membership.addAccount();

			dao.delOtherAccount("accountABC");
			membership.delOther("otherName1");

			ArrayList<String> accounts = dao.getAllAccounts();

			// print out
			System.out.println("---- after GetAllCounts -----");
			for (String accountDAO : accounts) {
				System.out.println("Account found:" + accountDAO.toString());
			}
			
			dao.runLongJob();

			dao.getAllAccountsError();
			
			
			
			// close context
			context.close();
		}
		catch (Exception ex) {
			System.out.println("Main program exception!"+ex.getMessage());
			
		}
		
	}

}
