package udemy.springHibernate.C3_IOC_JavaConfiguration;

import udemy.springHibernate.C1_IOC_XMLConfig.IFortuneService;

public class SwimFortuneService implements IFortuneService {

	@Override
	public String GetFortune() {
		return "swim $5m fortune";
	}

}
