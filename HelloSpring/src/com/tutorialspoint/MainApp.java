package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
		objA.getMessage1();
		objA.getMessage2();
		
		HelloBelgium objB = (HelloBelgium) context.getBean("helloBelgium");
		objB.getMessage1();
		objB.getMessage2();
		objB.getMessage3();
		
		//context.registerShutdownHook();
		// TODO Auto-generated method stub

	}

}
