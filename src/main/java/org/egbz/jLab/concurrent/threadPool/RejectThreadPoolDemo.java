package org.egbz.jLab.concurrent.threadPool;

import java.util.concurrent.*;

/**
 * 自定义线程池的拒绝策略, 在抛弃任务的时候打印信息.
 *
 * @author egbz
 * @date 2021/5/11
 */
public class RejectThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () ->{
            System.out.println(System.currentTimeMillis() + "  |  " + Thread.currentThread().getId());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ExecutorService es = new ThreadPoolExecutor(5, 5,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(10),
                Executors.defaultThreadFactory(),
                (r, executor) -> System.out.println(r.toString() + "--------is discard")
                );

        for (int i = 0; i < 1000000; i++) {
            es.submit(task);
            Thread.sleep(10);
        }
    }

}
