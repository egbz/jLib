package org.egbz.jLab.design_patterns.behavioral.sate;

/**
 * @author egbz
 * @date 2021/1/11
 */
public class Client {
    public static void main(String[] args) {
        // 我们需要操作的是 iphone X
        Context context = new Context("iphone X");

        // 补库存
        State revertState = new RevertState();
        revertState.doAction(context);

        // 减库存
        State deductState = new DeductState();
        deductState.doAction(context);

        // 获取当前的状态
        context.getState().toString();
    }
}
