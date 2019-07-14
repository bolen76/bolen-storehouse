package com.bolen.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class ParameterDemo {
	
	@Test
	public void test01(){
		ConcurrentHashMap<Integer, String> productInfo = new ConcurrentHashMap<>();
		System.out.println(productInfo instanceof Map<?,?> );
	}
	
	public void test02(){
		List<?> list=new ArrayList<>();
		list.add(null);
	//	list.add("hello");
		System.out.println(list instanceof List<?>);
		//System.out.println(list instanceof List<String>);
	}
	
	
	public static <T> T[] pickTwo(T a, T b,T c){
		return toArray(a,b);
		
	}
	
	public static <T> T[] toArray(T... args){
		return args;
	}
	
	public static void test(List<String>... args){
		List[] list=new ArrayList[2];
		//List<String>[] list2=new ArrayList<String>[2];
		
	}
	
	public static void main(String[] args) {
		
		Object[] pickTwo = pickTwo("hello", "world", "java");
		
		
		Object[] arr=new Object[2];
		arr[0]="hello";
		String[] str=new String[2];
		
		//arr=str;
		
		str=(String[]) arr;
		String[] st=(String[]) pickTwo;
	}
}	
