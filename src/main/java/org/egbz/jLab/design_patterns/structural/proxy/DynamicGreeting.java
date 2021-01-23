package org.egbz.jLab.design_patterns.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 *
 * 在运行期动态创建一个 interface 实例的方法如下:
 * 1. 定义一个 InvocationHandler 实例, 它负责实现接口的方法调用
 * 2. 通过 Proxy.newProxyInstance() 创建interface 实例, 它需要3个参数:
 *      1) 使用的 ClassLoader, 通常就是接口类的 ClassLoader
 *      2) 需要实现的接口数组, 至少需要传入一个接口进去
 *      3) 用来处理接口方法调用的 InvocationHandler 实例
 * 3. 将返回的 Object 强制转型为接口
 *
 * @author egbz
 * @date 2021/1/23
 */
public class DynamicGreeting {
    public static void main(String[] args) {

//        InvocationHandler handler = new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println(method);
//                if (method.getName().equals("morning")) {
//                    System.out.println("good morning " + args[0]);
//                }
//                return null;
//            }
//        };


        InvocationHandler handler = (proxy, method, params) -> {
          System.out.println(method);
          if (method.getName().equals("morning")) {
              System.out.println("good morning, " + params[0]);
          }
          return null;
        };


        // 传入 ClassLoader
        // 传入要实现的接口
        // 传入处理调用方法的 InvocationHandler
        Greeting greeting = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[] {Greeting.class},
                handler);
        greeting.morning("薇尔莉特");
    }
}
