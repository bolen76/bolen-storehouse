package com.bolen.jdk8;

public interface InterA {
	
	 static String name="static name";
	default String method(){
		
		return "InterA--------method"+this.name;
	};
	
	static String sm(){
		return "sm method";
	}
	//不能重写Object中的方法
	/*default boolean equals(Object o){
		return true;
	}*/
	
	/*static boolean equals(Object o){
		return true;
	}*/
	
	double aa=1.74_567;
	int i=123_45;
	int j=1;
	
	public static void main(String[] args) {
		int k=i+j;
		System.out.println(k);
		
		InterA interA = new InterA(){
			
		public	String method(){
				return "hello";
			}
		
		
		};
		
		String method = interA.method();
		System.out.println(method);
	}
}
