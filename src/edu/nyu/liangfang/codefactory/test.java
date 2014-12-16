package edu.nyu.liangfang.codefactory;

public class test {
	void fun1() {
		System.out.println("fun1");
	}
	
	void fun2() {
		fun1();
	}
}

class subTest extends test {
	void fun1() {
		System.out.println("fun11");
	}
}
