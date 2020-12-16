package org.egbz.jLab.concurrent.countDownLatchDemo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author egbz
 * @date 2020/12/16
 */
public class Driver2 { //...
    final int N = 100;

    void main() throws InterruptedException {
        CountDownLatch doneSignal = new CountDownLatch(N);
        Executor e = Executors.newFixedThreadPool(8);

        // 创建 N 个任务, 提交给线程池来执行
        for (int i = 0; i < N; ++i)
            e.execute(new WorkerRunnable(doneSignal, i));

        // 等待所有的任务完成, 这个方法才返回
        doneSignal.await();
    }
}
