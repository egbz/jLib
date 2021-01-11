package org.egbz.jLab.design_patterns.behavioral.observer;

/**
 * @author egbz
 * @date 2021/1/11
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
