package org.egbz.jLab.design_patterns.creational;

/**
 * 懒加载 双重检测 (注意 volatile)
 * @author egbz
 * @date 2021/1/9
 */
public class Singleton1 {
    private Singleton1() {}

    private static volatile Singleton1 instance = null;

    public static Singleton1 getInstance() {
        if (instance == null) {
            synchronized(Singleton1.class) {
                if (instance == null) {
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }
}
