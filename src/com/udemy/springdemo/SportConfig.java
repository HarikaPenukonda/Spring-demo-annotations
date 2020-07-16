package com.udemy.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration // Spring @Configuration annotation allows us to use annotations for dependency injection
//@ComponentScan("com.udemy.springdemo") 
/*we use the @ComponentScan annotation along with @Configuration annotation to specify the packages that we want to be scanned.
 *@ComponentScan without arguments tells Spring to scan the current package and all of its sub-packages.*/ 
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	// define bean for our sad fortune service
	@Bean
	public FortuneService sadFortuneService()
	{
		return new SadFortuneService();
	}
	// define bean for our swim coach and inject dependency
	@Bean
	public Coach swimCoach() // will use bean id (swimCoach) in main class when we get the bean from spring container, line 
	{
		
		return new SwimCoach(sadFortuneService()); // inject bean dependencies
		/* we are calling the bean method on line 15 and it will give us a reference to the 
		 * actual bean and Spring will intercept and gives us a reference to the object accordingly */
	}
}
