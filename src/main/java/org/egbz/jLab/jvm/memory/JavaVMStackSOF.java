package org.egbz.jLab.jvm.memory;

/**
 * 虚拟机栈和本地方法栈OOM测试
 * VM Args: -Xss256k
 *
 * @author egbz
 * @date 2021/4/3
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }
    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + oom.stackLength);
            throw e;
        }
    }
}
