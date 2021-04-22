package org.egbz.jLab.concurrent.thread.blocking;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition await() signal() 机制
 * 如果 signal 先于 await发生, await的线程无法被正常唤醒
 *
 * @author egbz
 * @date 2021/4/22
 */
public class ConditionAwaitDemo {
    static ReentrantLock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    private static void test() {
        new Thread(() -> {

            // sleep 一段时间, 让 threadB的 signal 先于 await 发生
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "---------  come in");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
            System.out.println(Thread.currentThread().getName() + "---------  awake");

        }, "thread A").start();

        new Thread(() -> {
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "---------  signal");
            } finally {
                lock.unlock();
            }
        }, "thread B").start();
    }

    public static void main(String[] args) {
        test();
    }
}
