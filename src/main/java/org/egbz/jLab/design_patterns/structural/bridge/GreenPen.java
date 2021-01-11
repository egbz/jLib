package org.egbz.jLab.design_patterns.structural.bridge;

/**
 * @author egbz
 * @date 2021/1/11
 */
public class GreenPen implements DrawAPI {
    @Override
    public void draw(int radius, int x, int y) {
        System.out.println("use green pen, radius:" + radius + ", x:" + x + ", y:" + y);

    }
}
