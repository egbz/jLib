package org.egbz.jLab.concurrent.thread.blocking;

import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport.park()   unpark() 是基于许可的机制
 * 无论 park  unpark 哪个先调用, park线程都可以被正常唤醒
 *
 * @author egbz
 * @date 2021/4/22
 */
public class LockSupportDemo {
    public static void main(String[] args) {

        Thread threadA = new Thread(() -> {

            // 让 unpark 先于 park 发生
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + "---------  come in");
            LockSupport.park();
            System.out.println("\n" + Thread.currentThread().getName() + "---------  awake");
        }, "thread A");
        threadA.start();



        new Thread(() -> {

//            // 让 park 先于 unpark 发生
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            LockSupport.unpark(threadA);
            System.out.println(Thread.currentThread().getName() + "---------   unpark");
        }, "thread B").start();
    }
}
