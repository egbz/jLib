package org.egbz.jLab.concurrent.countDownLatchDemo.sample;

import java.util.concurrent.CountDownLatch;

/**
 * sample from Doug Lea
 *
 * @author egbz
 * @date 2020/12/16
 */
public class Driver { // ...
    final int N = 100;
    void main() throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);

        for (int i = 0; i < N; ++i) // create and start threads
            new Thread(new Worker(startSignal, doneSignal)).start();

        // 这边插入一些代码, 确保上面的每个线程先启动起来, 才执行下面的代码.
        doSomethingElse();          // don't let run yet
        // 因为startSignal的初始化参数是1, 所以这里只要调用一次, 那么所有的 await 方法都可以通过
        startSignal.countDown();      //let all thread proceed
        doSomethingElse();
        // 等待所有任务结束
        doneSignal.await();          // wait for all to finish
    }

    private void doSomethingElse() {
    }
}
