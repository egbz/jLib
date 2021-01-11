package org.egbz.jLab.design_patterns.structural.bridge;

/**
 * @author egbz
 * @date 2021/1/11
 */
public class Circle extends Shap {
    private int radius;

    public Circle(int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.draw(radius, 0, 0);
    }
}
