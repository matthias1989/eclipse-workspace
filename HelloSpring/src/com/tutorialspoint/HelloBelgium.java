package com.tutorialspoint;

public class HelloBelgium {
	private String message1;
	private String message2;
	private String message3;
	private String message4;
	
	public void setMessage1(String message) {
		this.message1 = message;
	}
	
	public void setMessage2(String message) {
		this.message2 = message;
	}
	
	public void setMessage3(String message) {
		this.message3 = message;
	}
	
	public void setMessage4(String message) {
		this.message4 = message;
	}
	
	public void getMessage1() {
		System.out.println("Belgium Message1 : " + this.message1);
	}
	
	public void getMessage2() {
		System.out.println("Belgium Message2 : " + this.message2);
	}
	
	public void getMessage3() {
		System.out.println("Belgium Message3 : " + this.message3);
	}
	
	public void getMessage4() {
		System.out.println("Belgium Message4 : " + this.message4);
	}


}
