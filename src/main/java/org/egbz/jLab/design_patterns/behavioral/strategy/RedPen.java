package org.egbz.jLab.design_patterns.behavioral.strategy;

/**
 * 然后我们定义具体的几个策略类
 * @author egbz
 * @date 2021/1/11
 */
public class RedPen implements Strategy {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("use red pen, radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
