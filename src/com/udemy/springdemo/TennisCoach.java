package com.udemy.springdemo;

import org.springframework.stereotype.Component;

@Component // @Component scans our classes, uses the default bean id - tennisCoach
public class TennisCoach implements Coach {
 
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

}
