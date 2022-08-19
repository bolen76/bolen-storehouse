package com.bolen.string;

import org.junit.Test;

public class StringDemo {

    @Test
    public void test01() {
        String s1 = "";
        String s2 = "   ";
        String s3 = null;
        String s4 = " hello";
        System.out.println(s1.isEmpty());
        System.out.println(s2.isEmpty());

        System.out.println(s4.isEmpty());
        System.out.println(s2.trim().isEmpty());
        System.out.println(s3.isEmpty());

        StringBuffer sb = new StringBuffer();
        sb.append("");
    }

    @Test
    public void test02() {
        String str = "ab123ab123aab";
        String replace = str.replace("ab", "xx");
        System.out.println(str);
        System.out.println(replace);

        String replaceAll = str.replaceAll("ab", "xx");
        System.out.println(str);
        System.out.println(replaceAll);

    }
}	
