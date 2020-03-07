package com.bolen.jdk8;

import java.math.BigInteger;
import java.util.stream.Stream;
public class StreamDemo {
	
	
	static Stream<BigInteger> primes(){
		return Stream.iterate(BigInteger.valueOf(2), BigInteger::nextProbablePrime);
	}
	
	public static void main(String[] args) {
		primes().parallel().map(p->BigInteger.valueOf(2).pow(p.intValueExact()).subtract(BigInteger.valueOf(1)))
		.filter(mersenne->mersenne.isProbablePrime(50))
		.limit(20).forEach(System.out::println);
		
	}
}
