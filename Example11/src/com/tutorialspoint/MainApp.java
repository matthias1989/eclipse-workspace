package com.tutorialspoint;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
		
		System.out.println("Records creation");
		studentJDBCTemplate.create("Anthony", 18, 95, 2008);
		studentJDBCTemplate.create("Sarah", 17, 91, 2007);
		studentJDBCTemplate.create("Ben", 17, 78, 2008);
		studentJDBCTemplate.create("Ria", 18, 82, 2007);
		
		System.out.println("The next students are created");
		List<StudentMarks> studentMarksList = studentJDBCTemplate.listStudents();
		
		for(StudentMarks studentMarks : studentMarksList) {
			System.out.print("ID: "+studentMarks.getId());
			System.out.print("Name: "+studentMarks.getName());
			System.out.print(", age: "+studentMarks.getAge());
			System.out.print(", marks: "+ studentMarks.getMarks());
			System.out.println(", year: "+ studentMarks.getYear());
		}

	}

}
