package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfig.class);
		context.start();
		
		HelloWorld helloWorld = context.getBean(HelloWorld.class);
		helloWorld.setMessage("This is a test");
		System.out.println(helloWorld.getMessage());
		
		context.stop();
		// TODO Auto-generated method stub

	}

}
