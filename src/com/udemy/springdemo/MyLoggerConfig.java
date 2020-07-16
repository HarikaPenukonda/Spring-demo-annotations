package com.udemy.springdemo;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/* This class will set the parent logger level for the application context. It will also set the logging level for console handler. 
 * It sets the logger level to FINE. For more detailed logging info, you can set the logging level to level to FINEST. 
 * This class will set the parent logger level for the application context. It will also set the logging level for console handler. 
 * The logging levels are loaded from the configuration file using the @PropertySource annotation. The fields are injected using the @Value annotation. 
 * This class also has a @PostConstruct method to handle the actual configuration.*/

@Configuration
@PropertySource("classpath:mylogger.properties")
public class MyLoggerConfig {
	
	@Value("${root.logger.level}")
	private String rootLoggerLevel;
	
	@Value("${printed.logger.level}")
	private String printedLoggerLevel;
	
	@PostConstruct
	public void initLogger() {
		
		//parse levels
		Level rootLevel = Level.parse(rootLoggerLevel);
		Level printedLevel = Level.parse(printedLoggerLevel);	
		
		// get logger for app context
		Logger applicationContextLogger = Logger.getLogger(AnnotationConfigApplicationContext.class.getName());
		
		// get parent logger
		Logger loggerParent = applicationContextLogger.getParent();
		
		// set root logging level
		loggerParent.setLevel(rootLevel);
		
		// set up console handler
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(printedLevel);
		consoleHandler.setFormatter(new SimpleFormatter());
	
		// add handler to the logger
		loggerParent.addHandler(consoleHandler);
	
	}

}
