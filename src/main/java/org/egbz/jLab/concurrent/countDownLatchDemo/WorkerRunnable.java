package org.egbz.jLab.concurrent.countDownLatchDemo;

import java.util.concurrent.CountDownLatch;

/**
 * @author egbz
 * @date 2020/12/16
 */
public class WorkerRunnable implements Runnable {
    private final CountDownLatch doneSignal;
    private final int i;

    public WorkerRunnable(CountDownLatch doneSignal, int i) {
        this.doneSignal = doneSignal;
        this.i = i;
    }

    @Override
    public void run() {
        try {
            doWork(i);
            // 这个线程的任务完成了, 调用 countDown方法
            doneSignal.countDown();
        } catch (Exception ex) {
        } // return
    }

    void doWork(int x) {
        //...
    }
}
