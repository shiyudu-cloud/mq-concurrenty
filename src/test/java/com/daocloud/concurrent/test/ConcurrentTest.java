package com.daocloud.concurrent.test;


import com.daocloud.concurrent.annotation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 本测试使用Semaphore  和 CountDownLatch 和线程池 完成 测试工作
 * @Author: dushiyu
 * @Date: 2019-09-03 15:29
 * @Version 1.0
 */
@Slf4j
@NotThreadSafe
public class ConcurrentTest {
    /**请求数 5000*/
    private static final int CLIENT_TOTAL = 5000;
    /**并发数 200*/
    private static final int THREAD_TOTAL = 200;
    /**计数器*/
    private static int count = 0 ;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(THREAD_TOTAL);
        final CountDownLatch countDownLatch = new CountDownLatch(CLIENT_TOTAL);
        for (int i = 0; i< CLIENT_TOTAL ;i++){
            executorService.submit(new Thread(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                countDownLatch.countDown();
            }));
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("计数器=======>{}",count);
    }

    private static void add(){
        count++;
    }
}
