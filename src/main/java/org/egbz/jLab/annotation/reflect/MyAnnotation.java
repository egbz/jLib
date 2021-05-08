package org.egbz.jLab.annotation.reflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Annotation 在反射函数中的使用示例
 *
 * @author egbz
 * @date 2021/5/8
 */
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String[] value() default "unknown";
}
