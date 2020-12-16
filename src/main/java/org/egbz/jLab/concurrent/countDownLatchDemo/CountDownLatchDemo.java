package org.egbz.jLab.concurrent.countDownLatchDemo;

import java.util.concurrent.CountDownLatch;

/**
 * @author egbz
 * @date 2020/12/16
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(2);

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ignore) {
            }
            // 休息 5s 后(模拟线程工作了 5s), 调用 countDown()
            latch.countDown();
        }, "t1");

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException ignore) {
            }
            // 休息 10s 后(模拟线程工作了 5s), 调用countDown()
            latch.countDown();
        }, "t2");

        t1.start();
        t2.start();

        Thread t3 = new Thread(() -> {
            try {
                // 阻塞 等待 state 减为0
                latch.await();
                System.out.println("线程 t3 从 await 中返回了");
            } catch (InterruptedException e) {
                System.out.println("线程 t3 await 被中断");
                Thread.currentThread().interrupt();
            }
        }, "t3");

        Thread t4 = new Thread(() -> {
            try {
                latch.await();
                System.out.println("线程 t4 从 await 中返回了");
            } catch (InterruptedException e) {
                System.out.println("线程 t4 await 被中断");
                Thread.currentThread().interrupt();
            }
        }, "t3");

        t3.start();
        t4.start();
    }
}
