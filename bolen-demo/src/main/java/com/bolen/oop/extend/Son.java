package com.bolen.oop.extend;

import org.junit.Test;

import com.bolen.oop.Father;
import com.bolen.oop.Uncle;

public class Son extends Father implements Uncle{
	public String name="java";	
	
	@Override
	public void methodA() {
		System.out.println("son AAA......");
		//String name = this.name;
	//	this.name="haha";
		System.out.println(super.name);
		System.out.println(this.name);
	}
	
	public void methodB(){
		System.out.println("son BBB......");
		super.methodB();
	}
	
	public void test01(){
		String name =this.name;
		Integer height=this.height;
		Father father = new Father();
		
		
		String fatherName=father.name;
		//Integer fatherHeight=father.height; // protected域不可见
	}
	
	@Test
	public void test02(){
		Son son = new Son();
		son.methodB();
	}
	
	
	public static void sMethod(){
		System.out.println("son......sMethod");
	}
	
	
	public static void main(String[] args) {
		Father fa=new Son();
		fa.sMethod();
		
		Son so=new Son();
		so.sMethod();
	}
}
