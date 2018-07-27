package com.tutorialspoint;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TextEditorConfig.class);
		TextEditor textEditor = context.getBean(TextEditor.class);
		textEditor.startSpellCheck();
		context.registerShutdownHook();
		
	}

}
