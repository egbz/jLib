package org.egbz.jLab.design_patterns.structural.bridge;

/**
 * @author egbz
 * @date 2021/1/11
 */
public class RedPen implements DrawAPI {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("use red pen, radius:" + radius + ", x:" + x + ", y:" + y);
    }
}
