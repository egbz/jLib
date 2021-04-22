package org.egbz.jLab.concurrent.thread.blocking;

/**
 *  synchronized  Object wait()  notify()机制
 *  如果 notify()先于wait()发生, wait()无法正常被唤醒
 *
 * @author egbz
 * @date 2021/4/22
 */
public class ObjectWaitDemo {
    static Object objLock = new Object();

    /**
     * 正常顺序  obj.wait() 先于 obj.notify()
     */
    private static void normalOrder() {
        new Thread(() -> {

//            // sleep一段时间 让 threadB 的 notify先于wait发生
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            synchronized (objLock) {
                System.out.println(Thread.currentThread().getName() + "  ---------  come in");
                try {
                    objLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "---------  awake");
        }, "thread A").start();

        new Thread(() -> {
            synchronized (objLock) {
                objLock.notify();
                System.out.println(Thread.currentThread().getName() + "---------  notify");
            }
        }, "thread B").start();
    }

    public static void main(String[] args) {
        normalOrder();

    }
}
