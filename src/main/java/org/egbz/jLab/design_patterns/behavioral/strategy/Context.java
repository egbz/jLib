package org.egbz.jLab.design_patterns.behavioral.strategy;

/**
 * 使用策略的类
 * @author egbz
 * @date 2021/1/11
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void executeDraw(int radius, int x, int y) {
        strategy.draw(radius, x, y);
    }
}
