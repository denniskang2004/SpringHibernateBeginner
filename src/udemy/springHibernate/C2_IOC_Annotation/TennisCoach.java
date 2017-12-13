package udemy.springHibernate.C2_IOC_Annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import udemy.springHibernate.C1_IOC_XMLConfig.ICoach;
import udemy.springHibernate.C1_IOC_XMLConfig.IFortuneService;

//Spring will register this bean with default bean name "tennisCoach. specifying id is optional
//Default bean id: same as class name except fist char is lower
@Component 
@Scope("prototype")
public class TennisCoach  implements ICoach{
	
	@Value("funncoach.email") // directly value
	private String email;
	
	@Value("${funnycoach.team}")
	private String team;
	
	@Override
	public String getDailyWorkout() {
		return "Process backstroke 20 times";
	}

	@Override
	public String getDailyFortuneService() {
		return "Tennis Coach got fortuen: 1000 balls";
	}

	public String getEmail() {
		return this.email;
	}
	
	public String getTeam() {
		return this.team;
	}
}
