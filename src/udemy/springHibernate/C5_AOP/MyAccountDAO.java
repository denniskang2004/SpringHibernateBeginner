package udemy.springHibernate.C5_AOP;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

@Component
public class MyAccountDAO {

	public void addAccount() {
		System.out.println(getClass() + ": Doing my DB work: add an account.");
		
	}
	
	
	public void delOtherAccount(String accountName) {
		System.out.println(getClass() + ": Doing my DB work: delete OTHER account.");
		
	}
	
	public ArrayList<String> getAllAccounts(){
		ArrayList<String> accountList = new ArrayList<>();
		
		accountList.add("accountAA");
		accountList.add("accountBB");
		accountList.add("accountCC");
		return accountList;
	}
	
	
	public void runLongJob() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("RunLongJob done!");
	}
	public ArrayList<String>getAllAccountsError(){
		throw new RuntimeException("error from getAllAccountsError");
	}
	@Override
	public String toString() {
		return "";
	}
}
