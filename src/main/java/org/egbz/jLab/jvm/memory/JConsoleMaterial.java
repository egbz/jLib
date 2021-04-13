package org.egbz.jLab.jvm.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * JConsole 监视代码
 *
 * @author egbz
 * @date 2021/4/4
 */
public class JConsoleMaterial {

    /**
     * 内存占位符, 一个OOMObject大约占64k
     */
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            // 稍作延迟, 令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
    }
}
