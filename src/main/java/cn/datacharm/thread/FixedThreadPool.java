package cn.datacharm.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author datacharm.cn
 */
public class FixedThreadPool {
    public static void main(String[] args) {
        //创建一个可重用固定个数的线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    //打印正在执行的缓存线程信息
                    System.out.println(Thread.currentThread().getName()+"正在被执行");
                    try {
                        Thread.sleep(2000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            });
        }
    }
}
