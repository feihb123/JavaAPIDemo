package cn.datacharm.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description:
 *
 * @author Herb
 * @date 2019/09/20
 */
public class LockDemo {
    //TODO
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {

        Lock lock = new ReentrantLock();
        new Thread(new Add(lock)).start();
        new Thread(new Add(lock)).start();


        Thread.sleep(1000);

        System.out.println(i);

    }

    static class Add implements Runnable {
        private Lock lock;

        public Add(Lock lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            for (int j = 0; j < 10000; j++) {
                i++;
            }
        }
    }
}
