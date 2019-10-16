package com.daocloud.concurrent.single;

import com.daocloud.concurrent.annotation.ThreadSafe;
import org.springframework.util.ObjectUtils;

/**
 *
 * 双重检查机制
 * @Author: dushiyu
 * @Date: 2019-09-06 15:53
 * @Version 1.0
 */
@ThreadSafe
public class SingletonDemo3 {

    private SingletonDemo3(){}
    private volatile static SingletonDemo3 singletonDemo3;

    public SingletonDemo3 getInstance(){
       if(ObjectUtils.isEmpty(singletonDemo3)){
            synchronized (this){
                if(ObjectUtils.isEmpty(singletonDemo3)){
                    //1.分配对象内存空间
                    //2.初始化对象
                    //3.设置instance 指向分配的内存
                    singletonDemo3 = new SingletonDemo3();
                }
            }
       }
       return singletonDemo3;
    }
}
