package udemy.springHibernate.C1_IOC_XMLConfig;

public class BaseballCoach implements ICoach{
	
	public BaseballCoach() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String getDailyWorkout() {
		return "spend 30 min on batting practice";
		
	}
	
	public BaseballCoach(IFortuneService fservice) {
		fservice.GetFortune();
	}

	@Override
	public String getDailyFortuneService() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
