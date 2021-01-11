package org.egbz.jLab.design_patterns.behavioral.strategy;

/**
 * 策略模式与桥梁模式非常相似. 只是桥梁模式多了一层抽象.
 * 桥梁模式的耦合更低, 结构更复杂
 * @author egbz
 * @date 2021/1/11
 */
public class Client {
    public static void main(String[] args) {
        // 使用绿色的笔来画
        Context context = new Context(new BluePen());
        context.executeDraw(10, 0, 0);
    }
}
