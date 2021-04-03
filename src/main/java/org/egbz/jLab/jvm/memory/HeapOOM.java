package org.egbz.jLab.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * Java堆内存溢出异常测试
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author egbz
 * @date 2021/4/3
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        for(;;) {
            list.add(new OOMObject());
        }
    }
}
