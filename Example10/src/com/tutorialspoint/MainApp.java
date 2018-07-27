package com.tutorialspoint;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		StudentJDBCTemplate studentJDBCTemplate = (StudentJDBCTemplate) context.getBean("studentJDBCTemplate");
		
		System.out.println("----Remove old records----");
		List<Student> students = studentJDBCTemplate.listStudents();
		Set<Integer> studentIds = new HashSet<Integer>();
		for(Student student : students) {
			studentIds.add(student.getId());
		}
		studentJDBCTemplate.deleteList(studentIds);
		//studentJDBCTemplate.deleteAll();
		
		
		System.out.println("-------Records Creation------");
		studentJDBCTemplate.create("Edward",17);
		studentJDBCTemplate.create("Eva",16);
		studentJDBCTemplate.create("Marcel",18);
		
		System.out.println("-------LListing Multiple Records------");
		students = studentJDBCTemplate.listStudents();
		
		Map<String, Integer> studentMap = new HashMap<String,Integer>();
		for(Student student : students) {	
			System.out.print("ID : "+student.getId());
			System.out.print(", Name: "+student.getName());
			System.out.println(", Age : "+student.getAge());
			studentMap.put(student.getName(), student.getId());
		}
		
		Integer studentId = studentMap.get("Eva");
		System.out.println("----Updating Record with ID = " + studentId + "----");
		studentJDBCTemplate.update(studentId, 20);
		

		System.out.println("----Listing Record with ID = " + studentId + "----");
		Student student2 = studentJDBCTemplate.getStudent(studentId);
		System.out.print("ID: " + student2.getId());
		System.out.print(", Name: "+student2.getName());
		System.out.println(", Age : "+student2.getAge());
		
		
		
		/*students = studentJDBCTemplate.listStudents();
		
		for(Student student : students) {	
			System.out.print("ID : "+student.getId());
			System.out.print(", Name: "+student.getName());
			System.out.println(", Age : "+student.getAge());
		}*/

		
	}

}
