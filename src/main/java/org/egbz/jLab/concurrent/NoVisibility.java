package org.egbz.jLab.concurrent;

/**
 * 因为可见性问题 如果ready不是 volatile 则程序可能无法结束
 * @author egbz
 * @date 2021/4/4
 */
public class NoVisibility {
    private static volatile boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready);
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        Thread.sleep(1000);
        number = 42;
        ready = true;
        Thread.sleep(1000);

    }
}
