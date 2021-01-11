package org.egbz.jLab.design_patterns.structural.decorator;

/**
 * 三个基础饮料实现类 红茶 绿茶 咖啡
 * @author egbz
 * @date 2021/1/11
 */
public class Coffee extends Beverage {
    @Override
    public String getDescription() {
        return "咖啡";
    }

    @Override
    public double cost() {
        return 9;
    }
}
