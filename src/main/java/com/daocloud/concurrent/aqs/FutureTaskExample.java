package com.daocloud.concurrent.aqs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: dushiyu
 * @Date: 2019-10-16 13:30
 * @Version 1.0
 */
public class FutureTaskExample {


    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("MyCallable线程运行中");
            Thread.sleep(5000);
            return "线程运行完成";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> stringFutureTask = new FutureTask<>(new MyCallable());
        new Thread(stringFutureTask).start();
        String s = stringFutureTask.get();
        System.out.println(s);
    }
}
