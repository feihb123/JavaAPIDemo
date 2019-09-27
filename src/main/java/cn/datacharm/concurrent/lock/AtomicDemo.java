package cn.datacharm.concurrent.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * description:
 *
 * @author Herb
 * @date 2019/09/22
 */
public class AtomicDemo {


    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count = new AtomicInteger(0);
        Thread thread = new Thread(new Add(count));
        Thread thread1 = new Thread(new Add(count));
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(count);
    }

    static class Add implements Runnable {
        private  AtomicInteger count;

        public Add( AtomicInteger count) {
            this.count = count;
        }

        @Override
        public void run() {
            for (int j = 0; j < 10000; j++) {
                count.incrementAndGet();
            }

        }
    }
}
