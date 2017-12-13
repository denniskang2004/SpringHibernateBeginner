package udemy.springHibernate.C2_IOC_Annotation;

import org.springframework.stereotype.Component;

@Component
public class MyFunnyService implements IFunny {

	@Override
	public String getFunny() {
		return "This is my funny story";
	}

}
