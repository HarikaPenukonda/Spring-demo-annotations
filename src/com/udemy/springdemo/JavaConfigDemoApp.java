package com.udemy.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read the spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		// get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		// call a method of a bean
		System.out.println(theCoach.getDailyWorkout());
		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		// close context
		context.close();

	}

}
