package com.daocloud.concurrent.atomic;


import com.daocloud.concurrent.annotation.NotThreadSafe;
import com.daocloud.concurrent.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 本测试使用Semaphore  和 CountDownLatch 和线程池 完成 测试工作
 * @Author: dushiyu
 * @Date: 2019-09-03 15:29
 * @Version 1.0
 */
@Slf4j
@ThreadSafe
public class ConcurrentAtomicIntegerTest {
    /**请求数 5000*/
    private static final int CLIENT_TOTAL = 5000;
    /**并发数 200*/
    private static final int THREAD_TOTAL = 200;
    /**计数器*/
    private static AtomicInteger atomicInteger = new AtomicInteger(0);


    /**
     * AtomicInteger 底层实现是 cas 原理 全称为 CompareAndSwap 主要是 nitive 方法 通过 do while 循环 比较 内存值 当前值 要设置的值，
     * 如果内存值 == 当前值 将内存的值设置为 要设置的值
     * @param args
     * @throws InterruptedException
     */
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
        log.info("计数器=======>{}",atomicInteger);
    }

    private static void add(){
        atomicInteger.incrementAndGet();
    }
}
