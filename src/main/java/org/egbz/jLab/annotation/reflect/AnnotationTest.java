package org.egbz.jLab.annotation.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 *
 *  Annotation在反射函数中的使用示例
 * @author egbz
 * @date 2021/5/8
 */
public class AnnotationTest {
    public static void iteratorAnnotation(Method method) {
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            String[] values = myAnnotation.value();
            for (String str: values) {
                System.out.println(str);
            }
        }
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation :annotations) {
            System.out.println(annotation);
        }
    }

    public static void main(String[] args) throws Exception{
        Person person = new Person();
        Class<Person> c = Person.class;
        Method mSomebody = c.getMethod("somebody", String.class, int.class);
        mSomebody.invoke(person, new Object[]{"lili", 18});
        iteratorAnnotation(mSomebody);

        Method mEmpty = c.getMethod("empty", new Class[]{});
        mEmpty.invoke(person, new Object[]{});
        iteratorAnnotation(mEmpty);

    }
}
