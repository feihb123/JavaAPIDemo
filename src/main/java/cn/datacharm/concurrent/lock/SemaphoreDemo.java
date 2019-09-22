package cn.datacharm.concurrent.lock;

import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * description:
 *
 * @author Herb
 * @date 2019/09/22
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            new Thread(new Table(semaphore)).start();
        }
    }

    static class Table implements Runnable {
        private Semaphore semaphore;

        public Table(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("吃饭中，占用一张桌子!");
                Thread.sleep((long)(Math.random() * 10000));

                System.out.println("吃完饭，空出一张桌子~");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
