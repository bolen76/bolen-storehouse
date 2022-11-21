package bolen.test;

import java.math.BigInteger;

public class Main {

    public static void main(String[] args) {
        BigInteger b1 = new BigInteger("100");
        BigInteger b2 = new BigInteger("200");
        int i = b2.compareTo(b1);
        System.out.println(i);

        boolean a = Integer.MIN_VALUE - 1 == Integer.MAX_VALUE;
        System.out.println(a);

        BigInteger min_large_int = new BigInteger("2").shiftLeft(127).negate();
        BigInteger max_large_int = new BigInteger("2").shiftLeft(127).subtract(new BigInteger("1"));
    }
}
