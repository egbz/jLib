package org.egbz.jLab.jvm.memory;

/**
 * 新生代Minor GC
 * vm args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -Xlog:gc* -XX:SurvivorRatio=8
 *
 * @author egbz
 * @date 2021/4/4
 */
public class MinorGCTest {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];    // 出现一次 Minor GC
    }

}
