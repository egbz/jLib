package org.egbz.jLab.design_patterns.structural.bridge;

/**
 * @author egbz
 * @date 2021/1/11
 */
public class Rectangle extends Shap {
    private int x;
    private int y;

    public Rectangle(int x, int y, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        drawAPI.draw(0, x, y);
    }
}
