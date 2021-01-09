package org.egbz.jLab.concurrent;

/**
 *  双重检查
 *  (volatile 提供了内存可见性和禁止指令重排;)
 *
 * @author egbz
 * @date 2021/1/9
 */
public class Singleton {
    private static volatile Singleton instance;
    private int value;

    private Singleton() {
        this.value = 42;
    }

    public static  Singleton getInstance() {
        if (instance == null) {
            synchronized(Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
