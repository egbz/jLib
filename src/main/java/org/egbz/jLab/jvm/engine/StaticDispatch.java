package org.egbz.jLab.jvm.engine;

/**
 * 方法静态分派演示
 * p.s. 重载 是通过参数的静态类型确定的
 * @author egbz
 * @date 2021/4/13
 */
public class StaticDispatch {
    static abstract class Human {}

    static class Man extends Human {}

    static class Woman extends Human {}

    public void sayHello (Human guy) {
        System.out.println("hello guys");
    }

    public void sayHello(Man guy) {
        System.out.println("hello gentleman");
    }

    public void sayHello(Woman guy) {
        System.out.println("hello lady");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.sayHello(man);
        staticDispatch.sayHello(woman);
    }

}
