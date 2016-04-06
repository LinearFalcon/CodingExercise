package edu.nyu.liangfang.codefactory;

import java.util.concurrent.Semaphore;

/*
 * Linkedin: 实现两个函数: H() and O(), 这两个函数会被多线程调用。如果满足当前2个线程调用H(),
 * 和1个线程调用O()，让以上3个线程返回，产生一个水分子(可能是HHO,HOH,OHH)。
 * 调用H()的当前线程不能大于2，调用O()的当前线程不能大于1。
 */

public class H2O {
    Object mutex = new Object();
    int h_count = 0;
    int o_count = 0;
    Semaphore hSemaphore = new Semaphore(2);    // 保证只有不多于2个thread在call H()，多于2个的put to sleep
    Semaphore oSemaphore = new Semaphore(1);    // 保证只有不多于1个thread在call O()，多于1个的put to sleep

    public void H() throws InterruptedException {
        hSemaphore.acquire();
        System.out.println("H");

        synchronized (mutex) {
            h_count++;

            if (h_count == 2 && o_count == 1) {
                h_count = 0;
                o_count = 0;
                hSemaphore.release(2);
                oSemaphore.release();
                mutex.notifyAll();
            } else {
                mutex.wait();                // wait must be used with synchronized, here make sure this thread wait here
            }                                // until "H2O" is met, means two threads call H() and one thread calls O()
        }
    }

    public void O() throws InterruptedException {
        oSemaphore.acquire();
        System.out.println("O");

        synchronized (mutex) {
            o_count++;

            if (h_count == 2 && o_count == 1) {
                h_count = 0;
                o_count = 0;
                hSemaphore.release(2);
                oSemaphore.release();
                mutex.notifyAll();
            } else {
                mutex.wait();
            }
        }
    }

    // test
    public static void main(String[] args) {
        final H2O o = new H2O();

        Thread h1 = new Thread(new Runnable() {
            public void run() {
                try {
                    o.H();
                } catch (InterruptedException e) {
                }
            }
        });
        Thread h2 = new Thread(new Runnable() {
            public void run() {
                try {
                    o.H();
                } catch (InterruptedException e) {
                }
            }
        });
        Thread o1 = new Thread(new Runnable() {
            public void run() {
                try {
                    o.O();
                } catch (InterruptedException e) {
                }
            }
        });
        Thread o2 = new Thread(new Runnable() {
            public void run() {
                try {
                    o.O();
                } catch (InterruptedException e) {
                }
            }
        });

        o1.start();
        o2.start();
        h1.start();
        h2.start();
    }

}
