package org.egbz.jLab.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Condition 用在 生产者-消费者 场景
 * 这是一个 Doung Lea 给出的例子
 *
 * @author egbz
 * @date 2020/12/15
 */
public class BoundedBuffer {
    final ReentrantLock lock = new ReentrantLock();
    // condition 依赖于 lock 来产生
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[100];
    int putptr, takeptr, count;

    // 生产
    public void put (Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length) {
                // 队列已满, 等待, 直到 not full 才能继续生产
                notFull.await();
            }
            items[putptr] = x;
            if (++putptr == items.length) {
                putptr = 0;
            }
            count++;
            // 生产成功, 队列已经 not empty 了, 发个通知出去
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    // 消费
    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0) {
                // 队列为空, 等待, 直到队列 not empty, 才能继续消费
                notEmpty.await();
            }
            Object x = items[takeptr];
            if (++takeptr == items.length) {
                takeptr = 0;
            }
            count--;
            // 被我消费掉一个, 队列 not full 了, 发个通知出去
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }
}
