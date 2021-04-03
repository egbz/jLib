package org.egbz.jLab.jvm.memory;

/**
 * String.intern() 返回引用的测试
 * @author egbz
 * @date 2021/4/3
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
