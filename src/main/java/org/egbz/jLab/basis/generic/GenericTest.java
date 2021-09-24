package org.egbz.jLab.basis.generic;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author egbz
 * @date 2021/8/13
 */
public class GenericTest {

    static void test1() throws Exception{
        List<Integer> list = new ArrayList<>();
        list.add(12);

//        list.add("aa");

        // java 伪泛型, 反射可以绕过
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        add.invoke(list, "aa");

        System.out.println(list);
    }

    static void test2() {
        List arrayList = new ArrayList();
        arrayList.add("aaaa");
        arrayList.add(100);

        for(int i = 0; i< arrayList.size(); i++){
            String item = (String)arrayList.get(i);

            // class java.lang.Integer cannot be cast to class java.lang.String
            System.out.println("泛型测试，item = " + item);
        }
    }

    static void test3() {
        ArrayList list = new ArrayList();
        list.add("hello");
        String first = (String) list.get(0);
        System.out.println(first);
    }

    public static void main(String[] args) throws Exception{
        test3();


    }
}
