package org.egbz.jLab.design_patterns.behavioral.observer;

/**
 *
 * 实际生产过程中, 观察者模式往往用消息中间件来实现.
 * 如果要实现单机观察者模式, 可以使用 Guava 中的 EventBus, 它有同步实现也有异步实现
 *
 * 观察者模式有很多变种, 但最核心的部分是
 * 一定有一个地方存放了所有的观察者, 然后在事件发生的时候, 遍历观察者, 调用它们的回调函数
 * @author egbz
 * @date 2021/1/11
 */
public class Client {
    public static void main(String[] args) {
        // 先定义一个主题
        Subject subject1 = new Subject();
        // 定义观察者
        new BinaryObserver(subject1);
        new HexObserver(subject1);

        // 模拟数据变更, 这个时候 观察者们的 update 方法将会被调用
        subject1.setState(11);
    }
}
