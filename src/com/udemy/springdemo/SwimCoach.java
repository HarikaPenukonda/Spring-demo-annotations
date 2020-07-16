package com.udemy.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach{
	
	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;
	
	public SwimCoach()
	{
		//System.out.println(" >> SwimCoach : inside no arg constructor");
	}
	
	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice 50 laps daily";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
