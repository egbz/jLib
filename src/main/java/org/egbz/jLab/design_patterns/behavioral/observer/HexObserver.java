package org.egbz.jLab.design_patterns.behavioral.observer;

import java.util.Locale;

/**
 * @author egbz
 * @date 2021/1/11
 */
public class HexObserver extends Observer {
    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        String result = Integer.toHexString(subject.getState()).toUpperCase();
        System.out.println("订阅的数据发生变化，新的数据处理为十六进制值为: " + result);

    }
}
