package cn.datacharm.concurrent.executorservice;

import cn.datacharm.concurrent.CallableDemo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * description:
 *
 * @author Herb
 * @date 2019/09/20
 */
public class ScheduleExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledExecutorService se = Executors.newScheduledThreadPool(5);
        //延时执行
        se.schedule(new CallableDemo(), 1, TimeUnit.SECONDS);

        //定期执行 上一次开始计算下一次启动时间
        //如果两次线程执行时间大于间隔时间，则以线程执行时间为准
        se.scheduleAtFixedRate(new Run(), 0,5, TimeUnit.SECONDS);

        //定期执行 上一次结束计算下一次启动时间
        se.scheduleWithFixedDelay(new Run(), 0,5, TimeUnit.SECONDS);

    }

    static class Run implements Runnable {
        @Override
        public void run() {
            System.out.println("run!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end!");

        }
    }
}
