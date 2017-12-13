package udemy.springHibernate.C2_IOC_Annotation;

import org.springframework.stereotype.Component;

@Component
public class OtherFunnyService implements IFunny{

	@Override
	public String getFunny() {
		return "Another funny story";
	}

}
