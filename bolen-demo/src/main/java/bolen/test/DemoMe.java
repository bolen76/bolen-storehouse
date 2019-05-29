package bolen.test;

import bolen.pojo.Person;

public class DemoMe {
	
	public static void main(String[] args) {
		/*int a=10;
		int b=100;
		
		method(a,b);
		
		System.out.println("a:"+a);
		System.out.println("b:"+b);*/
		
		/*String a="hello";
		String b="world";
		
		method(a, b);
		System.out.println("a:"+a);
		System.out.println("b:"+b);*/
		
		Person a=new Person(10);
		Person b=new Person(100);
		
		method(a, b);
		
		System.out.println("a:"+a.getAge());
		System.out.println("b:"+b.getAge());
		
	}
	
	
	
	public static void method(int a,int b){
		
		int temp=a;
		a=b;
		b=temp;
	}
	
	public static void method(String a,String b){
		String temp=a;
		a=b;
		b=temp;
	}
	
	public static void method(StringBuilder a,StringBuilder b){
		StringBuilder temp=a;
		a=b;
		b=temp;
	}
	
	
	public static void method(Person a,Person b){
		Person temp=a;
		a=b;
		b=temp;
		
		a.setAge(a.getAge()+1);
		b.setAge(b.getAge()+2);
	}
}
