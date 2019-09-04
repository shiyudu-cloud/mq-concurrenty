package com.daocloud.concurrent.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记为推荐使用方式
 * @Author: dushiyu
 * @Date: 2019-09-03 14:36
 * @Version 1.0
 * @Target
 * @Retention 注解存在的范围 source 表明 在编译的时候会忽略 ，我们在只是使用时候会标记下
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Recommend {

    String value() default "";
}
