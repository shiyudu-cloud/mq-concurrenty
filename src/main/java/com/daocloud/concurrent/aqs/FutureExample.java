package com.daocloud.concurrent.aqs;

import java.util.concurrent.*;

/**
 * @Author: dushiyu
 * @Date: 2019-10-16 11:55
 * @Version 1.0
 */
public class FutureExample {

     static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("MyCallable线程运行中");
            Thread.sleep(5000);
            return "线程运行完成";
        }
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(new MyCallable());
        System.out.println(submit.get());
    }

}
