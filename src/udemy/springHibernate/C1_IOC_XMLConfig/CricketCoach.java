package udemy.springHibernate.C1_IOC_XMLConfig;

public class CricketCoach implements ICoach{
	private IFortuneService fortuneService;
	private String emailAddress;
	private String team;
	
	// property from Properties File
	private String propEmail;
	private String propTeam;
	
	public String getPropEmail() {
		return propEmail;
	}
	public void setPropEmail(String propEmail) {
		this.propEmail = propEmail;
	}
	public String getPropTeam() {
		return propTeam;
	}
	public void setPropTeam(String propTeam) {
		this.propTeam = propTeam;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside the setter function - setEmailAddress");
		this.emailAddress = emailAddress;
	}
	
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		System.out.println("CricketCoach: inside the setter function - setTeam");
		this.team = team;
	}
	public CricketCoach() {
		System.out.println("CricketCoach: inside the no-arg constructor");
	}
	@Override
	public String getDailyWorkout() {
		return "Servie 100 balls";
	}

	@Override
	public String getDailyFortuneService() {
		return "TennisCoach:" + fortuneService.GetFortune();
	}

	public IFortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(IFortuneService fortuneService) {
		System.out.println("CricketCoach: inside the setter function - setFortuneService");
		this.fortuneService = fortuneService;
	}
	
	

}
