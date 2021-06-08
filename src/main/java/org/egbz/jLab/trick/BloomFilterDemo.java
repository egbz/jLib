package org.egbz.jLab.trick;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author egbz
 * @date 2021/5/30
 */
public class BloomFilterDemo {
    public static void main(String[] args) {
        int total = 1000000;
        BloomFilter<CharSequence> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), total);

        // 初始化1000000条数据到过滤器中
        for (int i = 0; i < total; i++) {
            bf.put("" + i);
        }
        // 判断值是否存在过滤器中
        int count = 0;
        for (int i = 0; i < total + 10000; i++) {
            if (bf.mightContain("" + i)) {
                count++;
            }
        }

        System.out.println("matched: " + count);
    }
}
