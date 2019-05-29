package bolen.exception;

import org.junit.Test;

import bolen.pojo.Person;

public class ExceptionDemo {

	@Test
	public void test01() {
		int a_method = a_method();
		System.out.println("a_method:"+a_method);
		int b_method = b_method();
		System.out.println("b_method:"+b_method);
		Person c_method = c_method();
		System.out.println("c_method:"+c_method.getName());
		Person d_method = d_method();
		System.out.println("d_method:"+d_method.getName());
		
	}

	public static int a_method() {

		int i = 10;
		try {

			return i;
		} finally {
			i = 100;
			return i;
		}
	}

	public static int b_method() {
		int i = 10;
		try {

			return i;
		} finally {
			return 200;
		}
	}
	
	public static Person c_method(){
		
		Person p=new Person("bolen");
		
		
		try{
			return p;
		}finally{
			p.setName("zhangzhoujun");
		}
		
	}
	
	
	public static Person d_method(){
		Person p=new Person("bolen");
		try{
			return p;
		}
		finally{
			p=new Person("java");
			return p;
		}
	}
	
}
