package com.daocloud.concurrent.single;

import com.daocloud.concurrent.annotation.NotThreadSafe;
import org.springframework.util.ObjectUtils;

/**
 *
 * 懒汉式
 * 单例模式是第一次使用的情况下初始化
 * @Author: dushiyu
 * @Date: 2019-09-06 15:53
 * @Version 1.0
 */
@NotThreadSafe
public class SingletonDemo1 {

    private SingletonDemo1(){}
    private static SingletonDemo1 singletonDemo1;
    public SingletonDemo1 getInstance(){
        //多线程会出现问题 两个线程都在判断的时候
        if(ObjectUtils.isEmpty(singletonDemo1)){
            singletonDemo1 = new SingletonDemo1();
        }
        //
        return singletonDemo1;
    }
}
