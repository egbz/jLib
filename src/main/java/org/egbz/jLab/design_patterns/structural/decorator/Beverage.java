package org.egbz.jLab.design_patterns.structural.decorator;

/**
 * 饮料抽象基类
 * @author egbz
 * @date 2021/1/11
 */
public abstract class Beverage {
    // 返回描述
    public abstract String getDescription();
    // 返回价格
    public abstract double cost();
}
