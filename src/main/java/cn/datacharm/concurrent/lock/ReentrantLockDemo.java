package cn.datacharm.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description:
 *
 * @author Herb
 * @date 2019/09/20
 */
public class ReentrantLockDemo {
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        //默认参数false 非公平锁
        Lock lock = new ReentrantLock();
        //公平锁
        //ReentrantLock lock = new ReentrantLock(true);


        Thread thread1 = new Thread(new Add(lock));
        Thread thread2 = new Thread(new Add(lock));
        thread1.start();
        thread2.start();
        //后续的处理，需要依赖thread线程的执行结果，可以在这里调用join方法等待t线程执行结束
        thread1.join();
        thread2.join();


        System.out.println(i);

    }

    static class Add implements Runnable {
        private Lock lock;

        public Add(Lock lock) {
            this.lock = lock;
        }


        @Override
        public void run() {
            //使用tryLock发现已有线程上锁直接返回false,可以设置等待时长
            //if (lock.tryLock()) {
                lock.lock();
                for (int j = 0; j < 10000; j++) {
                    i++;
                }
                lock.unlock();
            //}
        }
    }
}
