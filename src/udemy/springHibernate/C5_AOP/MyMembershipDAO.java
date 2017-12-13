package udemy.springHibernate.C5_AOP;

import org.springframework.stereotype.Component;

@Component
public class MyMembershipDAO {
	public void addAccount() {
		System.out.println(getClass() + ": Doing my DB work: add an membership.");
		
	}
	
	public void delOther(String otherName) {
		System.out.println(getClass() + ": Doing my DB work: delete an Other membership.");
		
	}
}
