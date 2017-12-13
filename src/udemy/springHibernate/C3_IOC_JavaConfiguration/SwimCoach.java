package udemy.springHibernate.C3_IOC_JavaConfiguration;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import org.springframework.beans.factory.annotation.Value;

import udemy.springHibernate.C1_IOC_XMLConfig.ICoach;
import udemy.springHibernate.C1_IOC_XMLConfig.IFortuneService;

public class SwimCoach implements ICoach{
	private IFortuneService theFortuneService;
	
	@Value("${foo.email}") 
	private String email;
	public SwimCoach(IFortuneService fservice) {
		this.theFortuneService = fservice;
	}
	@Override
	public String getDailyWorkout() {
		return "Swim 3 miles";
	}

	@Override
	public String getDailyFortuneService() {
		return theFortuneService.GetFortune();
	}
	public String getEmail() {
		return this.email;
	}
	
}
