package org.egbz.jLab.concurrent;

/**
 * @author egbz
 * @date 2021/1/2
 */
public class FinalFieldExample {
    final int x;
    int y;
    static FinalFieldExample f;

    public FinalFieldExample() {
        x = 3;
        y = 4;
    }

    static void writer() {
        f = new FinalFieldExample();
    }

    static void reader() {
        if (f != null) {
            int i = f.x;
            int j = f.y;
            System.out.println("i: " + i);
            System.out.println("j: " + j);
        }
    }

    public static void main(String[] args) {
       Runnable r1 = () -> {writer();};
       Runnable r2 = () -> {reader();};

       Thread t1 = new Thread(r1);
       t1.start();
       try {
           t1.join();
       } catch (InterruptedException e) {
           //
       }
       new Thread(r2).start();



    }

}
