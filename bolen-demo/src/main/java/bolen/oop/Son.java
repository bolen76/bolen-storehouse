package bolen.oop;

public class Son extends Father implements Uncle{
	public String name="java";	
	
	@Override
	public void methodA() {
		System.out.println("son AAA......");
		//String name = this.name;
	//	this.name="haha";
		//System.out.println(name);
	}
}
