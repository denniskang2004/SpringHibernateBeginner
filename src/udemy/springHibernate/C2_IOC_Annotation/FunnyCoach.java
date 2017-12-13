package udemy.springHibernate.C2_IOC_Annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import udemy.springHibernate.C1_IOC_XMLConfig.ICoach;

@Component
@Scope("singleton")
public class FunnyCoach implements ICoach {
	private IFunny funnyService;
	
	@Autowired // no need to setter to inject!
	@Qualifier("otherFunnyService")// to differentiate diff impl for IFunny
	private IFunny funnyNewService;
	
	
	public IFunny getFunnyService() {
		return funnyService;
	}
	
	@Autowired // any mothod
	@Qualifier("myFunnyService")// to differentiate diff impl for IFunny
	public void doCrazyStuff(IFunny funnyService) {
		System.out.println("doCrazyStuff of funny coach");
		this.funnyService = funnyService;
	}

	@Autowired // setter
	@Qualifier("myFunnyService")// to differentiate diff impl for IFunny
	public void setFunnyService(IFunny funnyService) {
		System.out.println("Setter of funny coach");
		this.funnyService = funnyService;
	}

	@Autowired // constructor // 
	public FunnyCoach(@Qualifier("myFunnyService") IFunny fService) { // special syntax for constructor
		System.out.println("constructor of funny coach");
		funnyService = fService;
	}

	public String MakeFun() {
		return "Fun:" + funnyService.getFunny();
		
	}
	public String MakeFundNew() {
		return "Other Fun:" + funnyNewService.getFunny();
	}

	@Override
	public String getDailyWorkout() {
		return "Laugh 2 times a day";
	}

	@Override
	public String getDailyFortuneService() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@PostConstruct // custom init
	public void myStartup() {
		System.out.println("FunnyCoach: myStartup");
	}
	
	@PreDestroy // custom destroy
	public void myCleanup() {
		System.out.println("FunnyCoach: myCleanup");
	}
}
