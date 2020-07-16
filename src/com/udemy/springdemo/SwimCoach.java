package com.udemy.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach{
	
	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Practice 50 laps daily";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
//	@Autowired
//	@Qualifier("fileFortuneService")
//	private FortuneService fortuneService;
//	
//	public SwimCoach()
//	{
//		//System.out.println(" >> SwimCoach : inside no arg constructor");
//	}
//	
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

	

}
