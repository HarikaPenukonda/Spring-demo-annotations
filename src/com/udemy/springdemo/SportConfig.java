package com.udemy.springdemo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // Spring @Configuration annotation allows us to use annotations for dependency injection
@ComponentScan("com.udemy.springdemo") 
/*we use the @ComponentScan annotation along with @Configuration annotation to specify the packages that we want to be scanned.
 *@ComponentScan without arguments tells Spring to scan the current package and all of its sub-packages.*/ 
public class SportConfig {

}
