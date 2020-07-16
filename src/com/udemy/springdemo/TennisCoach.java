package com.udemy.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/* Spring will scan for a component that implements FortuneService interface */

@Component // @Component scans our classes, uses the default bean id - tennisCoach
//@Scope("prototype") // Bean scope, where new object is created for each request(prototype), bydefault it is singleton
public class TennisCoach implements Coach {
	
	//@Autowired // field injection, inject a FortuneService implementation directly into the class
	//@Qualifier("randomFortuneService") // @Qualifier annotation is used to resolve the autowiring conflict, when there are multiple beans of same type. 
	private FortuneService fortuneService;
	
	// define a default constructor
	public TennisCoach()
	{
		System.out.println(" >> TennisCoach: inside the no-arg constructor ");
	}
	// 1. create a constructor for injection
	// 2. Configure the dependency injection with @Autowired annotation
	
	/*public void setFortuneService(FortuneService fortuneService) {
		System.out.println(" >> TennisCoach: inside the setFortuneService method ");
		this.fortuneService = fortuneService;
	}*/
	
	@PostConstruct
	public void doMyStartupStuff()
	{
		System.out.println(" >>TennisCoach: inside the doMyStartupStuff method ");
	}
	
	// define destroy method
	@PreDestroy
	public void doMyCleanupStuff()
	{
		System.out.println(" >>TennisCoach: inside the doMyCleanupStuff method ");
	}

	
	// Inject dependencies by calling any method on your class 
//	@Autowired
//	public void doSomeStuff(FortuneService fortuneService) {
//		System.out.println(" >> TennisCoach: inside the doSomeStuff method ");
//		this.fortuneService = fortuneService;
//	}
	
	
	// Using @Qualifier with Constructor
	@Autowired
	public TennisCoach(@Qualifier("randomFortuneService")FortuneService fortuneService) {
		System.out.println(" >>TennisCoach: inside constructor using @autowired and @qualifier ");
		this.fortuneService = fortuneService;
	} 
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	// define init method
	
}
