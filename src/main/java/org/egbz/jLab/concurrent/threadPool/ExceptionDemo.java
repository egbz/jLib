package org.egbz.jLab.concurrent.threadPool;

import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * execute 提交任务, 出异常会打印异常信息, 然后继续执行其他的线程.
 * submit  提交任务, 出异常 不打印异常信息, 然后继续执行其他线程.
 *
 * [具体原因]
 * execute 提交的任务, 会被封装成一个Runnable任务, 然后封装成Worker, 调用runWorker()时又调用了最初的Runnable任务.
 * 并且try-catch捕获了异常, 并直接抛出去, 所以我们在execute中看到了异常信息
 *
 * submit是将任务封装成一个FutureTask, 然后封装成Worker, 调用runWorker()方法时, 最终调用的是FutureTask的run方法.
 * FutureTask的run方法吞掉了异常而没有抛出. 所以在Worker的runWorker里无法捕获到异常.
 *
 *
 * Future future = pools.submit(..)
 * future.get();
 * 可以拿到异常信息
 *
 *
 *
 * @author egbz
 * @date 2021/5/12
 */
public class ExceptionDemo {

    private static class DivTask implements Runnable {
        int a, b;

        public DivTask(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public void run() {
            double re = a/b;
            System.out.println(re);
        }
    }

    public static void main(String[] args) {
        ThreadPoolExecutor pool = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
                0L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());

        for (int i = 0; i < 5; i++) {
            // submit()  线程内异常不抛出 然后继续执行其他线程
//            pool.submit(new DivTask(100, i));

            // submit()  可以用这种方法使其打印异常
            try {
                Future re = pool.submit(new DivTask(100, i));
                re.get();
            } catch (Exception e) {
                e.printStackTrace();
            }


            // execute() 线程内异常抛出 然后继续执行其他线程
//            pool.execute(new DivTask(100, i));
        }
    }
}
