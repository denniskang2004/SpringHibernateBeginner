package udemy.springHibernate.C1_IOC_XMLConfig;

public class TrackCoach implements ICoach {
	IFortuneService fService;
	public TrackCoach() {
		
	}
	@Override
	public String getDailyWorkout() {
		return "run 5 miles";
	}

	public TrackCoach(IFortuneService fortuneService) {
		System.out.println("TrackCoach constructor called");
		this.fService = fortuneService;
	}

	@Override
	public String getDailyFortuneService() {
		// user fortune service
		return "TrackCoach:" +fService.GetFortune();
	}
	// custom init function
	public void myStartup() {
		System.out.println("TrackCoach myStartup called");
	}
	// custom destroy function
	public void myCleanup1() {
		System.out.println("TrackCoach myCleanup called");
		
	}
}
