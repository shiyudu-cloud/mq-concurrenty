package com.daocloud.concurrent.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * 创建线程的方式 callable
 * @Author: dushiyu
 * @Date: 2019-09-09 11:30
 * @Version 1.0
 */
public class CallableDemo implements Callable<Integer> {




    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<Integer> task = new FutureTask<>(callableDemo);

        new Thread(task).start();

        System.out.println(task.get());
        System.out.println("我是主线程");
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("紧张计算中");
        Thread.sleep(3000);
        return 1;
    }
}
