package cn.datacharm.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 * @author datacharm.cn
 */
public class CachedThreadPool {
    public static void main(String[] args) {
        //通过Executors创建可缓存线程池 （不推荐） newCachedThreadPool可能创建过多线程甚至OOM
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            try {
                //sleep可明显看到使用的是线程池里面以前的线程，没有创建新的线程
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    //打印正在执行的缓存线程信息
                    System.out.println(Thread.currentThread().getName()+"正在被执行");
                }
            });
        }
    }
}
