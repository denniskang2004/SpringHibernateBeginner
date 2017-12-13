package udemy.springHibernate.C5_AOP;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration //spring config class
@EnableAspectJAutoProxy // for aspect AOP
@ComponentScan ("udemy.springHibernate.C5_AOP") // where to scan
public class MySpringConfig {

}
