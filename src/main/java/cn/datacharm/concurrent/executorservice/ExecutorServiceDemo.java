package cn.datacharm.concurrent.executorservice;

import java.util.concurrent.*;

/**
 * description:
 * 手动创建线程池
 * @author Herb
 * @date 2019/09/20
 */
public class ExecutorServiceDemo {
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
