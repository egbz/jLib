package org.egbz.jLab.design_patterns.structural.facade;

/**
 * @author egbz
 * @date 2021/1/11
 */
public class Client {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
