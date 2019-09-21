package cn.datacharm.concurrent.executorservice;

import cn.datacharm.concurrent.CallableDemo;

import java.util.concurrent.*;

/**
 * description:
 *
 * @author Herb
 * @date 2019/09/20
 */
public class ExecutorServiceDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //没有核心线程全是临时线程  临时线程最大数量Integer.MAX_VALUE
        //大池子小队列 适用于短任务高并发
        ExecutorService es = Executors.newCachedThreadPool();

        //没有临时线程全是核心线程
        //小池子大队列  适用于 长任务场景
        ExecutorService es2 = Executors.newFixedThreadPool(5);

        Future<String> future = es.submit(new CallableDemo());
        es.shutdown();
        System.out.println(future.get());
    }
}
