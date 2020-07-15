package com.udemy.springdemo;

import org.springframework.stereotype.Component;

@Component("thatsillycoach") // @Component scans our classes, registers with beanID - thatsillycoach
public class TennisCoach implements Coach {
 
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

}
