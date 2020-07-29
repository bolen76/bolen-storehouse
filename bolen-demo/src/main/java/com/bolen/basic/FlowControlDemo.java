package com.bolen.basic;

public class FlowControlDemo {

	public static void main(String[] args) {

		LOCATION: test01();

		LL: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {
				if (j == 1) {
					break LL;
					// LL标签与循环之间不能有任何其它 语句，continue会跳出内层循环，从外层循环继续下一轮循环
					// 而break则会终结外层循环
				} else {
					System.out.println("i:" + i);
					System.out.println("j:" + j);
					System.out.println("A");
				}
			}
			System.out.println("i:" + i);
			System.out.println("B");
		}
		System.out.println("C");

	}

	private static void test01() {
		System.out.println("test01......");

	}
}
