package org.egbz.jLab.jvm.engine;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

/**
 * 使用MethodHandle, 子类 调用 祖类方法
 * p.s. <深入理解JVM>第二版 p258 此处有误
 *
 * @author egbz
 * @date 2021/4/13
 */
public class MethodInvokeTest {

    class GrandFather {
        void thinking() {
            System.out.println("i am grandfater");
        }
    }

    class Father extends GrandFather {
        @Override
        void thinking() {
            System.out.println("i am father");
        }
    }

    class Son extends Father {
        @Override
        void thinking() {

            try {
                MethodType mt = MethodType.methodType(void.class);
                Field IMPL_LOOKUP = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                IMPL_LOOKUP.setAccessible(true);
                MethodHandles.Lookup lkp = (MethodHandles.Lookup) IMPL_LOOKUP.get(null);
                MethodHandle mh = lkp.findSpecial(GrandFather.class, "thinking", mt, GrandFather.class);
                mh.invoke(this);
            } catch (Throwable e) {
            }
        }
    }

    public static void main(String[] args) {
        (new MethodInvokeTest().new Son()).thinking();
    }


}
