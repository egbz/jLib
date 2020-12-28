package org.egbz.jLab.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author egbz
 * @date 2020/12/28
 */
public class SemaphoreDemo implements Runnable {
    final Semaphore sema = new Semaphore(5);

    @Override
    public void run() {
        try {
            sema.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId() + " :done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sema.release();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SemaphoreDemo demo = new SemaphoreDemo();
        for (int i = 0; i < 20; ++i) {
            exec.submit(demo);
        }
        exec.shutdown();
    }
}
