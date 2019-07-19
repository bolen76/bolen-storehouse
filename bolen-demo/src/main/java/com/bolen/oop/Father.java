package com.bolen.oop;

import java.util.Date;

public class Father
//extends Person
{
	public String name="father";
	Integer age;
	protected Integer height;
	private Date birth;
	
	public void methodA(){
		System.out.println("father AAA......");
	}
	
	/*public Father(String name){
		
	}*/
	public void methodB(){
		System.out.println("father BBB......");
		this.methodA();
		System.out.println(this.name);
		//方法有重写机制，而成员变量是没有的。
	}
	
	
	
	public static void sMethod(){
		
		System.out.println("father......sMethod");
	}
}
