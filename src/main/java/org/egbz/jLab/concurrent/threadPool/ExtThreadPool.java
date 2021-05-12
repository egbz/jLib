package org.egbz.jLab.concurrent.threadPool;

import java.util.concurrent.*;

/**
 * 线程池扩展
 * 实现 ThreadPoolExecutor 的 beforeExecute() afterExecute() terminated() 方法
 *
 * @author egbz
 * @date 2021/5/12
 */
public class ExtThreadPool {

    private static class MyTask implements Runnable {
        public String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("[正在执行]   " + Thread.currentThread().getId() +"    task name: " + name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>()) {
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("[before]   " + ((MyTask) r).name);
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("[after]   " + ((MyTask) r).name);
            }

            @Override
            protected void terminated() {
                System.out.println("[terminated]");
            }
        };

        for (int i = 0; i < 5; i++) {
            MyTask task = new MyTask("TASK-" + i);
            es.execute(task);
        }
        es.shutdown();
    }
}
