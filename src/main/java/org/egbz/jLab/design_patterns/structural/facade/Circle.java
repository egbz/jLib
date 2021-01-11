package org.egbz.jLab.design_patterns.structural.facade;

/**
 * @author egbz
 * @date 2021/1/11
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}
