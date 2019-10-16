package com.daocloud.concurrent.thread;

/**
 * 创建线程的方式 runnable
 * @Author: dushiyu
 * @Date: 2019-09-09 11:30
 * @Version 1.0
 */
public class RunnableDemo implements Runnable {



    @Override
    public void run() {
        while (true) {
            System.out.println("线程运行中");
        }
    }

    public static void main(String[] args) {
        new Thread(new RunnableDemo()).run();
    }
}
