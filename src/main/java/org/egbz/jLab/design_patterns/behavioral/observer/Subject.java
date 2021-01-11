package org.egbz.jLab.design_patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 首先 需要定义主题.
 * 每个主题需要持有观察者列表的引用 用于在数据变更的时候通知各个观察者
 *
 * @author egbz
 * @date 2021/1/11
 */
public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        // 数据已变更, 通知观察者们
        notifyAllObservers();
    }

    // 注册观察者
    public void attach(Observer observer) {
        observers.add(observer);
    }

    // 通知观察者们
    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
