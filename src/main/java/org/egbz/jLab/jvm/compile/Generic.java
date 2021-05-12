package org.egbz.jLab.jvm.compile;

import java.util.HashMap;
import java.util.Map;

/**
 * 查看反编译后的 Generic.class 很容易发现, 泛型被擦除了.
 *
 * @author egbz
 * @date 2021/5/12
 */
public class Generic {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("hello", "你好");
        map.put("how are you", "吃了没");
        System.out.println(map.get("hello"));
        System.out.println(map.get("how are you"));
    }
}
