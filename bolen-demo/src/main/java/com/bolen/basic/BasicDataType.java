package com.bolen.basic;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class BasicDataType {

	public static void main(String[] args) throws UnsupportedEncodingException {
		char a = '中';
		byte a1=(byte) a;
		byte a2=(byte) (a>>>8);
		String str = String.valueOf(a);
		byte[] bytes = str.getBytes("utf-16");
		byte[] bys=new byte[2];
		bys[0]=a2;
		bys[1]=a1;
		System.out.println(new String(bys,"iso8859-1"));
		System.out.println(str);
		System.out.println(Arrays.asList(bytes));
	}
}
