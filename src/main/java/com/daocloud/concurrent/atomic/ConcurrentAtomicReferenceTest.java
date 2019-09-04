package com.daocloud.concurrent.atomic;


import com.daocloud.concurrent.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 本测试使用Semaphore  和 CountDownLatch 和线程池 完成 测试工作
 * @Author: dushiyu
 * @Date: 2019-09-03 15:29
 * @Version 1.0
 */
@Slf4j
@ThreadSafe
public class ConcurrentAtomicReferenceTest {
    /**
     *
     * @param args
     * @throws InterruptedException
     */

    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(0);

    public static void main(String[] args) throws InterruptedException {
        atomicReference.compareAndSet(0,2);
        atomicReference.compareAndSet(1,3);
        atomicReference.compareAndSet(2,4);
        atomicReference.compareAndSet(3,6);
        System.out.println(atomicReference.get());
    }

}
