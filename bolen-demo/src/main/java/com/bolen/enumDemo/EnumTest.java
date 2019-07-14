package com.bolen.enumDemo;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Set;

import org.junit.Test;

public class EnumTest {
	
	@Test
	public void test01(){
		Week valueOf = Week.Monday;
		
		System.out.println(Week.Wednesday.ordinal());
		//Week.Monday=Week.Tuesday;
		Week.Monday.getName();
		Week.Monday.setSeq(100);
		int seq = Week.Monday.getSeq();
		System.out.println(seq);
		
	}
	
	
	public void test02(){
		EnumSet<Week> of = EnumSet.of(Week.Monday,Week.Tuesday,Week.Wednesday);
		EnumMap enumMap = new EnumMap<>(Week.class);
	}
}
