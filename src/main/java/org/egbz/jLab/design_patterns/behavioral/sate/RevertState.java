package org.egbz.jLab.design_patterns.behavioral.sate;

/**
 * 定义补库存状态
 * @author egbz
 * @date 2021/1/11
 */
public class RevertState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("给此商品补库存");
        context.setState(this);

        // ... 执行加库存的具体操作

    }

    @Override
    public String toString() {
        return "Revert State";
    }
}
