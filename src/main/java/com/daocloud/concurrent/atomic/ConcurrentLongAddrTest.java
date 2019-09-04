package com.daocloud.concurrent.atomic;


import com.daocloud.concurrent.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * 本测试使用Semaphore  和 CountDownLatch 和线程池 完成 测试工作
 * @Author: dushiyu
 * @Date: 2019-09-03 15:29
 * @Version 1.0
 */
@Slf4j
@ThreadSafe
public class ConcurrentLongAddrTest {
    /**请求数 5000*/
    private static final int CLIENT_TOTAL = 5000;
    /**并发数 200*/
    private static final int THREAD_TOTAL = 200;
    /**计数器*/
    private static LongAdder longAdder = new LongAdder();


    /**
     * LongAddr 实现原理 ： 核心是将热点数据分离，将内部value 分离称数组 通过
     * AtomicLong 在 死循环内做修改 如果在并发较低的情况下 成功率会很高 但是在并发高的情况下 就会很低，在大量修改失败时候就多次 循环 性能会被影响
     * 对于普通的 Long 和Double 进行读操作或者写操作 jvm 会将64位 的变成两个32 位的操作 。
     *
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
        log.info("计数器=======>{}",longAdder);
    }

    private static void add(){
        longAdder.increment();
    }
}
