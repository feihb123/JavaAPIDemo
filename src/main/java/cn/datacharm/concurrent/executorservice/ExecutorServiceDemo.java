package cn.datacharm.concurrent.executorservice;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * description:
 * 手动创建线程池
 * @author Herb
 * @date 2019/09/20
 */
public class ExecutorServiceDemo {

    @Test
    public void manual() {
        /**
         * 手动创建线程池
         */
        // 创建线程工厂
        ThreadFactory threadFactory = new ThreadFactoryBuilder()
                .setNameFormat("manual-pool-%d")
                .build();
        // 创建通用线程池
        /**
         * 参数含义：
         *      corePoolSize : 线程池中常驻的线程数量。核心线程数，默认情况下核心线程会一直存活，即使处于闲置状态也不会受存keepAliveTime限制。除非将allowCoreThreadTimeOut设置为true。
         *      maximumPoolSize : 线程池所能容纳的最大线程数。超过这个数的线程将被阻塞。当任务队列为没有设置大小的LinkedBlockingDeque时，这个值无效。
         *      keepAliveTime : 当线程数量多于 corePoolSize 时，空闲线程的存活时长，超过这个时间就会被回收
         *      unit : keepAliveTime 的时间单位
         *      workQueue : 存放待处理任务的队列，该队列只接收 Runnable 接口
         *      threadFactory : 线程创建工厂
         *      handler : 当线程池中的资源已经全部耗尽，添加新线程被拒绝时，会调用RejectedExecutionHandler的rejectedExecution方法，参考 ThreadPoolExecutor 类中的内部策略类
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 200, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024),
                threadFactory,
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 1000; i++) {
            threadPoolExecutor.execute(() ->{
                    System.out.println(Thread.currentThread().getName());
            });
        }
        threadPoolExecutor.shutdown();
    }

    public static void main(String[] args) {
        //corePoolSize 核心线程数
        //maximumPoolSize 最大线程数 （核心+临时）
        //keepAliveTime 临时线程使用后存活时间
        // unit 时间单位
        //workQueue 工作队列
        ExecutorService es = new ThreadPoolExecutor(
                5,
                10,
                5000,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(5),

                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("拒绝执行"+r);
                    }
                }
        );

        for (int i = 0; i < 100; i++) {
            es.execute(new ESRunnable());
        }


        es.shutdown();
    }

    static class ESRunnable implements Runnable {
        @Override
        public void run() {
            try {
                System.out.println("hello!");
                Thread.sleep(3000);
                System.out.println("finish!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
