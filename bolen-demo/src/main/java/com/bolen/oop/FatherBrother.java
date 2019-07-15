package com.bolen.oop;

public class FatherBrother {
	
	public void test01(){
		Father father = new Father();
		
		String name = father.name;
		Integer age = father.age;
		Integer height = father.height;
		//Date date=father.birth;//同包下只有私有域不可见
	}
}
