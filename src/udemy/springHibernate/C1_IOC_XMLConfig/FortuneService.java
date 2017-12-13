package udemy.springHibernate.C1_IOC_XMLConfig;

public class FortuneService implements IFortuneService {
	@Override
	public String GetFortune() {
		return "Today is your lucky day!";
	}
}
