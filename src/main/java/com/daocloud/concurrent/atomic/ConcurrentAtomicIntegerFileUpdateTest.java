package com.daocloud.concurrent.atomic;


import com.daocloud.concurrent.annotation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * 本测试使用Semaphore  和 CountDownLatch 和线程池 完成 测试工作
 * @Author: dushiyu
 * @Date: 2019-09-03 15:29
 * @Version 1.0
 */
@Slf4j
@ThreadSafe
public class ConcurrentAtomicIntegerFileUpdateTest {
    /**
     * 用来修改 一个类中的 某个值 这个值 必须是 volidate 修饰 但是不能有 static
     *
     */
    private static AtomicIntegerFieldUpdater<ConcurrentAtomicIntegerFileUpdateTest> atomicReference = AtomicIntegerFieldUpdater.newUpdater(ConcurrentAtomicIntegerFileUpdateTest.class,"count");

    private volatile int count ;

    private static ConcurrentAtomicIntegerFileUpdateTest concurrentAtomicIntegerFileUpdateTest = new ConcurrentAtomicIntegerFileUpdateTest();

    public static void main(String[] args) throws InterruptedException {
        atomicReference.compareAndSet(concurrentAtomicIntegerFileUpdateTest,0,100);
        System.out.println(atomicReference.get(concurrentAtomicIntegerFileUpdateTest));
    }

}
