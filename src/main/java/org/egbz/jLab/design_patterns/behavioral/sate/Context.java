package org.egbz.jLab.design_patterns.behavioral.sate;

/**
 * @author egbz
 * @date 2021/1/11
 */
public class Context {
    private String name;
    private State state;

    public Context(String name) {
        this.name = name;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }
}
