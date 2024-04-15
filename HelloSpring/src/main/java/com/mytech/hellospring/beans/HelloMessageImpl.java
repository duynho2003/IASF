package com.mytech.hellospring.beans;

public class HelloMessageImpl implements HelloMessage{

	@Override
	public String greetUser() {
		System.out.println("Welcome Spring Framework...");
		return "Nice Framework for Dev";
	}

}
