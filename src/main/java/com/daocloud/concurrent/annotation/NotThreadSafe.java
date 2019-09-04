package com.daocloud.concurrent.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记为线程不安全的
 * @Author: dushiyu
 * @Date: 2019-09-03 14:40
 * @Version 1.0
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface NotThreadSafe {

    String value() default "";
}
