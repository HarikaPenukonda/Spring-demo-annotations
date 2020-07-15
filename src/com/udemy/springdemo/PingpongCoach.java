package com.udemy.springdemo;

import org.springframework.stereotype.Component;

@Component
public class PingpongCoach implements Coach {
	
	public PingpongCoach()
	{
		//System.out.println(" PingPongCoach: inside default constructor ");
	}

	@Override
	public String getDailyWorkout() {
		return "Practice your pingpong drop shot";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
