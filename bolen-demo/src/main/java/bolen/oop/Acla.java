package bolen.oop;

public abstract class Acla extends Employee{
	
	//public abstract void methodA();
	
	public   void methodB(){};
	
	
	public void methodC(){
		Acla acla = new Acla(){
			//匿名内部类
		} ;
	}
}
