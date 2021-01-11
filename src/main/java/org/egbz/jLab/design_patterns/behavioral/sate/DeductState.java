package org.egbz.jLab.design_patterns.behavioral.sate;

/**
 * 定义减库存的状态
 * @author egbz
 * @date 2021/1/11
 */
public class DeductState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("商品卖出, 准备减库存");
        context.setState(this);

        // ... 执行减库存的具体操作
    }

    @Override
    public String toString() {
        return "Deduct State";
    }
}
