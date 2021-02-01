package com.bolen.jvm;

public class ParallelCalcDemo {

	public static void main(String[] args) {
		int num = 1000000000;
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = i;
		}

		long start = System.currentTimeMillis();
		long singalCalc = singalCalc(arr);
		long end = System.currentTimeMillis();
		System.out.println("cost time:" + (end - start));
		System.out.println(singalCalc);

		long start1 = System.currentTimeMillis();
		long paraCalc = paraCalc(arr);
		long end1 = System.currentTimeMillis();
		System.out.println("cost time:" + (end1 - start1));
		System.out.println(paraCalc);
	}

	public static long singalCalc(int[] num) {
		long sum = 0;

		for (int i = 0; i < num.length; i++) {
			sum += num[i];
		}

		return sum;
	}

	public static long paraCalc(int[] num) {
		long l1 = 0;
		long l2 = 0;
		long l3 = 0;
		long l4 = 0;

		int i = 0;

		for (; i < num.length - 4; i += 4) {
			l1 += num[i];
			l2 += num[i + 1];
			l3 += num[i + 2];
			l4 += num[i + 3];
		}
		for (; i < num.length; i++) {
			l1 += num[i];
		}

		long sum = l1 + l2 + l3 + l4;

		return sum;
	}
}
