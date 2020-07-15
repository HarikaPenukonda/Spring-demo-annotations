package com.udemy.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeAnnotationApp {

	public static void main(String[] args) {
		
		// read the spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// get the bean from spring container
		Coach theCoach  = context.getBean("pingpongCoach", Coach.class);
		// call a method of a bean
		System.out.println(theCoach.getDailyWorkout());
		// close context
		context.close();
	}

}
