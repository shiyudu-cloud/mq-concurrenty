package com.daocloud.concurrent.single;

import com.daocloud.concurrent.annotation.NotThreadSafe;
import com.daocloud.concurrent.annotation.ThreadSafe;
import org.springframework.util.ObjectUtils;

/**
 *
 * 饿汉式
 * @Author: dushiyu
 * @Date: 2019-09-06 15:53
 * @Version 1.0
 */
@ThreadSafe
public class SingletonDemo2 {

    private SingletonDemo2(){}
    private static SingletonDemo2 singletonDemo1 = new SingletonDemo2();

    public SingletonDemo2 getInstance(){
       return singletonDemo1;
    }
}
