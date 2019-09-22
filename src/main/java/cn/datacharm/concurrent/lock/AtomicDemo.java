package cn.datacharm.concurrent.lock;

import java.util.concurrent.CountDownLatch;

/**
 * description:
 *
 * @author Herb
 * @date 2019/09/22
 */
public class AtomicDemo {
    //TODO
    static int i = 0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new Add(countDownLatch)).start();
        new Thread(new Add(countDownLatch)).start();
        countDownLatch.await();
        System.out.println(i);
    }

    static class Add implements Runnable {
        private CountDownLatch countDownLatch;

        public Add(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            for (int j = 0; j < 10000; j++) {
                AtomicDemo.i ++;
            }
            countDownLatch.countDown();
        }
    }
}
