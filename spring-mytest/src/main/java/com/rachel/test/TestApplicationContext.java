package com.rachel.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestApplicationContext {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		TestService testService = ac.getBean(TestService.class);
		System.out.println(testService.getMyName());
	}
}
