package org.egbz.jLab.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 *
 * 一个关于重排序的实验
 * p.s. 如果不发生重排序 这个结果 (x ==0 && y == 0) 是不可能出现的
 * @author egbz
 * @date 2021/1/9
 */
public class Test {
    private static int x = 0, y = 0;
    private static int a = 0, b =0;

    public static void main(String[] args) throws InterruptedException{

        int i = 0;
        for(;;) {
            i++;
            x = 0; y = 0;
            a = 0; b = 0;
            CountDownLatch latch = new CountDownLatch(1);

            Thread one = new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                }
                a = 1;
                x = b;
            });

            Thread other = new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                }
                b = 1;
                y = a;
            });
            one.start();other.start();
            latch.countDown();
            one.join();other.join();

            String result = "第" + i + "次 (" + x + "," + y + "）";
            if(x == 0 && y == 0) {
                System.err.println(result);
                break;
            } else {
                System.out.println(result);
            }
        }

    }
}
