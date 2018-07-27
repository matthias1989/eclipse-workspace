package com.tutorialspoint;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventHandlerConfig {

	@Bean
	public CStartEventHandler cStartEventHandler() {
		return new CStartEventHandler();
	}
	
	@Bean
	public CStopEventHandler cStopEventHandler() {
		return new CStopEventHandler();
	}
}
