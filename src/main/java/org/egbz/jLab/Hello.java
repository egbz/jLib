package org.egbz.jLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author egbz
 * @date 2020/12/13
 */
public class Hello {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 2, 3, 3, 3, 4};
        for (int ele : a) {
            System.out.println(ele);
        }

        ArrayList<Integer> aList = new ArrayList<Integer>(Arrays.asList(a));

        System.out.println("hello world");
    }
}
