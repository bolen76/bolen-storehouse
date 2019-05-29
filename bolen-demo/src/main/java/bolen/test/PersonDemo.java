package bolen.test;

public class PersonDemo {
	
	public static void main(String[] args) {
		/*TestPerson tpA=new TestPerson(30);
		TestPerson tpB=new TestPerson(25);
		
		tpA.setName("张周俊");
		String name = tpB.getName();
		System.out.println(name);
		
		tpB.setAge(100);
		
		int age = tpA.getAge();
		System.out.println(age);*/
		
		//PersonDemo.method();
		
		//String s="hello";
		//System.out.println(s.getClass());
		
		StringBuilder sb=new StringBuilder("java");
		
		StringBuilder  sb2=new StringBuilder("java");
		
		/*System.out.println(sb);
		System.out.println(sb2);
		System.out.println(sb==sb2);*/
		
		String s1="c++";
		String s2="c++";
		System.out.println(s1==s2);
		
		s1="php";
		
	}
	
	
	public static void method(){
		//function();
		String s1="hello";
		System.out.println(s1.getClass());
		//System.out.println("method.....");
	}
	
	public void function(){
		method();
		System.out.println("function");
	}
}
