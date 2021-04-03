package org.egbz.jLab.jvm.memory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 本机直接内存溢出测试 (使用unsafe分配本机内存)
 * The experiment failed
 *
 * @author egbz
 * @date 2021/4/3
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        for (;;) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
