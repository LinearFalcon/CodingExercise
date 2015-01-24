package edu.nyu.liangfang.codefactory;
import java.util.concurrent.Semaphore;


public class semaphore_cc150_ch16_16_5 {
	Semaphore s1 = new Semaphore(1);
	Semaphore s2 = new Semaphore(0);
	Semaphore s3 = new Semaphore(0);
	
	public void first() throws InterruptedException {
//		while (true) {
			s1.acquire();
			System.out.println("first");
			s2.release();
//		}
	}
	
	public void second() throws InterruptedException {
//		while (true) {
			s2.acquire();
			System.out.println("second");
			s3.release();
//		}
	}
	
	public void third() throws InterruptedException {
//		while (true) {
			s3.acquire();
			System.out.println("third");
			s1.release();
//		}
	}
	
	public static void main(String[] args) {
		final semaphore_cc150_ch16_16_5 o = new semaphore_cc150_ch16_16_5();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					o.first();
				} catch (InterruptedException e) {
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					o.second();
				} catch (InterruptedException e) {
				}
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			public void run() {
				try {
					o.third();
				} catch (InterruptedException e) {
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
	}
}
