package bolen.enumDemo;

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
}
