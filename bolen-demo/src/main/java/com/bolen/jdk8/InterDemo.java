package com.bolen.jdk8;

public class InterDemo implements InterA,InterB{
	
	public static String sm(){
		return "impl sm";
	}
	
	public static void main(String[] args) {
		InterA ia=new 	InterDemo();
		InterA.sm();
		
		InterDemo iad=new 	InterDemo();
		iad.sm();
	}
}
