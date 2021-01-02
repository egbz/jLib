package org.egbz.jLab.concurrent;

/**
 * @author egbz
 * @date 2021/1/2
 */
public class WaitNotify {
    volatile int a = 0;

    public static void main(String[] args) {
        Object object = new Object();
        WaitNotify waitNotify = new WaitNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println("线程1 获取到监视器锁");
                    try {
                        object.wait();
                        System.out.println("线程1 正常回复啦");
                    } catch (InterruptedException e) {
                        System.out.println("线程1 wait方法抛出了InterruptedException异常");
                    }
                }
            }
        }, "线程1");
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println("线程2 获取到监视器锁");
                    try {
                        object.wait();
                        System.out.println("线程2 正常恢复啦");
                    } catch (InterruptedException e) {
                        System.out.println("线程2 wait方法抛出InterruptedException异常");
                    }
                }
            }
        }, "线程2");
        thread2.start();

        // 这里让 thread1 thread2 先起来, 然后在起后面的 thread3
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println("线程3 拿到了监视器锁");
                    System.out.println("线程3 设置线程1终端");
                    thread1.interrupt();  // 1
                    waitNotify.a = 1;   // 禁止上线两行中断和notify代码重排
                    System.out.println("线程3 调用notify");
                    object.notify();      // 2
                    System.out.println("线程3 调用完notify后 休息一会");
                    try {
                        Thread.sleep(3000); // sleep不释放锁
                    } catch (InterruptedException e) {
                    }
                    System.out.println("线程3 结束同步代码块");
                }
            }
        }, "线程3").start();

    }
}
