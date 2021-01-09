package org.egbz.jLab.design_patterns.creational;

/**
 * 单例 嵌套类; 最经典
 * @author egbz
 * @date 2021/1/9
 */
public class Singleton {
    private Singleton() {}

    private static class Holder {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return Holder.instance;
    }
}
