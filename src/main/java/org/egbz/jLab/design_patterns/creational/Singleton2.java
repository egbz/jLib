package org.egbz.jLab.design_patterns.creational;

/**
 * @author egbz
 * @date 2021/1/9
 */
public class Singleton2 {
    private Singleton2() {}

    private static Singleton2 instance = new Singleton2();

    public static Singleton2 getInstance() {
        return instance;
    }
}
