package edu.nyu.liangfang.codefactory;
import java.util.concurrent.Semaphore;

/*
Two thread, one calls functionFoo another calls functionBar
Print "FooBar" infinite times

void functionFoo() {
    while(1){          
            System.out.print("Foo");
    }
}

void functionBar() {
    while(1) {
            System.out.print("Bar");
    }
}
volatile cause busy waiting, but how to avoid busy waiting?
*/

// No busy waiting version - Semaphore
public class multithreadPrint {
	private Semaphore sem1 = new Semaphore(1);
	private Semaphore sem2 = new Semaphore(0);
	
	public void functionFoo() throws InterruptedException {
		while(true){   
			sem1.acquire();
			System.out.print("Foo");
			sem2.release();
		}
	}


	public void functionBar() throws InterruptedException {
		while(true) {
			sem2.acquire();
			System.out.println("Bar");
			sem1.release();
		}
	}
	
	
	public static void main(String[] args) {
		final multithreadPrint obj = new multithreadPrint();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					obj.functionFoo();
				} catch (InterruptedException e) {
					
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					obj.functionBar();
				} catch (InterruptedException e) {
					
				}
			}
		});
		
		t1.start();
		t2.start();
	}
}


// volatile - busy waiting version
/*
public class multithreadPrint {
	private volatile int flag = 1;
	
	public void functionFoo() throws InterruptedException {
		while(true){   
			if (flag == 1) {
				System.out.print("Foo");
				flag = 2;
			}
		}
	}


	public void functionBar() throws InterruptedException {
		while(true) {
			if (flag == 2) {
				System.out.println("Bar");
				flag = 1;
			}
		}
	}
	
	
	public static void main(String[] args) {
		final multithreadPrint obj = new multithreadPrint();
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					obj.functionFoo();
				} catch (InterruptedException e) {
					
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					obj.functionBar();
				} catch (InterruptedException e) {
					
				}
			}
		});
		
		t1.start();
		t2.start();
	}
}
*/

