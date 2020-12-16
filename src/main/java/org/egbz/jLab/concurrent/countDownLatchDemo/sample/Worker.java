package org.egbz.jLab.concurrent.countDownLatchDemo.sample;

import java.util.concurrent.CountDownLatch;

/**
 * @author egbz
 * @date 2020/12/16
 */
public class Worker implements Runnable {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    public Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    @Override
    public void run() {
        try {
            // 为了让所有线程同时开始任务, 我们让所有线程先阻塞在这里
            // 等大家都准备好了, 再打开这个门栓
            startSignal.await();
            doWork();
            doneSignal.countDown();
        } catch (InterruptedException ex) {
        } // return
    }

    private void doWork() {
        // ...
    }
}
