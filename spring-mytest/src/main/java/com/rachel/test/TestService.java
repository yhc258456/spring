package com.rachel.test;

import org.springframework.stereotype.Component;

@Component
public class TestService {

	private String name="------my name is rachel!-------";

	public String getMyName(){
		return name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
