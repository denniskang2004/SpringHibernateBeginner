package udemy.springHibernate.C1_IOC_XMLConfig;

public class FortuneServiceRandom implements IFortuneService {

	@Override
	public String GetFortune() {
		return "You got fortune worth " + Math.random()*1000 + " US dollars";
	}

}
