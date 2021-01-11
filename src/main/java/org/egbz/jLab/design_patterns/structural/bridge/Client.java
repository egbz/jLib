package org.egbz.jLab.design_patterns.structural.bridge;

/**
 * @author egbz
 * @date 2021/1/11
 */
public class Client {

    public static void main(String[] args) {
        Shap greenCircle = new Circle(10, new GreenPen());
        Shap redRectangle = new Rectangle(4, 8, new RedPen());
        greenCircle.draw();
        redRectangle.draw();
    }
}
