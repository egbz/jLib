package org.egbz.jLab.design_patterns.structural.decorator;

/**
 * 定义柠檬 芒果等具体的调料, 他们属于装饰者
 * @author egbz
 * @date 2021/1/11
 */
public class Mango extends Condiment {
    Beverage beverage;
    public Mango(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 加芒果";
    }

    @Override
    public double cost() {
        return beverage.cost() + 3;
    }
}
