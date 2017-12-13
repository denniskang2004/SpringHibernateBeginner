package udemy.springHibernate.C3_IOC_JavaConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import udemy.springHibernate.C1_IOC_XMLConfig.ICoach;
import udemy.springHibernate.C1_IOC_XMLConfig.IFortuneService;

@Configuration
@PropertySource("classpath:sport.properties")
public class SwimConfig {

	// define bean for swim fortune service
	@Bean // "swimFortuneService" is the bean id
	public IFortuneService swimFortuneService() {
		return new SwimFortuneService();
	}

	// define bean for swim coach and inject dependency
	@Bean
	public ICoach swimCoach() {
		return new SwimCoach(swimFortuneService());
	}
}
