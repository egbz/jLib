package org.egbz.jLab.design_patterns.structural.bridge;

/**
 * @author egbz
 * @date 2021/1/11
 */
public abstract class Shap {
    protected DrawAPI drawAPI;

    protected Shap(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
