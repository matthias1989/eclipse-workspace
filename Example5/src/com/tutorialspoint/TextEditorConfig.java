package com.tutorialspoint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class TextEditorConfig {
	@Bean
	public TextEditor textEditor() {
		return new TextEditor(spellingCheck());
	}
	
	@Bean(initMethod = "init", destroyMethod = "cleanup")
	@Scope("prototype")
	public SpellingCheck spellingCheck() {
		return new SpellingCheck();
	}
}
