package org.egbz.jLab.daily.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author egbz
 * @date 2021/1/20
 */
public class ReflectDemo {
    // 反射 获取 设置字段值
    void fieldDemo() throws NoSuchFieldException, IllegalAccessException {
        Person p = new Person("Violet");
        Object obj = p;
        Class cls = obj.getClass();
        Field field = cls.getDeclaredField("name");

        //获取字段值
        field.setAccessible(true);
        Object value = field.get(obj);
        System.out.println(value);

        // 设置字段值
        field.set(p, "薇尔莉特");
        System.out.println(p.getName());
    }

    // 反射调用方法
    void methodDemo() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 以这段代码为例
//        String s = "hello world";
//        String sub = s.substring(6);

        String s = "hello world";
        Method method = String.class.getMethod("substring", int.class);
        String sub = (String) method.invoke(s, 6);
        System.out.println(sub);
    }

    public static void main(String[] args) throws Exception {
        ReflectDemo demo = new ReflectDemo();
        demo.fieldDemo();
//        demo.methodDemo();
    }
}
