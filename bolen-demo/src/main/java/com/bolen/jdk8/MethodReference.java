package com.bolen.jdk8;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;

public interface MethodReference {

	int apply(int a, int b);

	public static void main(String[] args) {
		MethodReference mr=MethodBeRefer::add;
		int apply = mr.apply(10, 11);
		System.out.println(apply);
		
		MethodReference mr2=new MethodBeRefer()::minus;
		int apply2 = mr2.apply(100, 98);
		System.out.println(apply2);
		
		Function<MethodBeRefer, Integer> mr3= MethodBeRefer::inc;
		int apply3 = mr3.apply(new MethodBeRefer());
		System.out.println(apply3);
		
		
		//StringBuilder::append;
		
		
		Optional<String> op=Optional.empty();
		
		boolean present = op.isPresent();
		System.out.println(present);
		
		op=Optional.of("hello");
		boolean present2 = op.isPresent();
		System.out.println(present2);
		
		
		ArrayList<String> al=new ArrayList<>();
		
		al.add(null);
		al.add(1, null);
	}
}
