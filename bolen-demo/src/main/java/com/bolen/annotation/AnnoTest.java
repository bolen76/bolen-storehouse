package com.bolen.annotation;

import java.lang.reflect.Method;

class AnnoTest{
	
	@MyAnno(value="he",age=33)
	public void test()	{
		
	}
	
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		Method declaredMethod = AnnoTest.class.getDeclaredMethod("test");
		
		MyAnno[] myAnnos = declaredMethod.getDeclaredAnnotationsByType(MyAnno.class);
		for(MyAnno an:myAnnos){
			String value = an.value();
			int age = an.age();
			
			System.out.println(value);
			
			System.out.println(age);
		}
	}
}
