package com.daocloud.concurrent.single;

import com.daocloud.concurrent.annotation.ThreadSafe;
import org.springframework.util.ObjectUtils;

/**
 *
 * 枚举模式-实现单例模式
 * @Author: dushiyu
 * @Date: 2019-09-06 15:53
 * @Version 1.0
 */
@ThreadSafe
public class SingletonEnumDemo3 {

    private SingletonEnumDemo3(){}

    private  static SingletonEnumDemo3 singletonDemo3;

    public SingletonEnumDemo3 getInstance(){
        return singleton.INSTANCE.getInstance();
    }

    private enum singleton{
        INSTANCE;

        private SingletonEnumDemo3 singletonEnumDemo3;
        //枚举 这个东西 JVM初始化的时候 构造函数只会初始化一次
        singleton(){
            singletonEnumDemo3 = new SingletonEnumDemo3();

        }

        public SingletonEnumDemo3 getInstance(){
            return singletonEnumDemo3;
        }
    }
}
