package cn.datacharm.concurrent.lock;

import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.CountDownLatch;

/**
 * description:
 * 闭锁 若不使用CountDownLatch，不能正确计算所有线程结束所用时间
 * @author Herb
 * @date 2019/09/25
 */
public class CountDownLatchDemo {
    public static void main(String[] args){
        final CountDownLatch latch = new CountDownLatch(5);
        LatchDemo latchDemo = new LatchDemo(latch);
        long begin = System.currentTimeMillis();
        for (int i = 0; i <5 ; i++) {
            new Thread(latchDemo).start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("耗费时间："+(end-begin));

    }

    static class LatchDemo implements  Runnable {
        private CountDownLatch latch;

        public LatchDemo(CountDownLatch latch) {
            this.latch = latch;
        }

        public LatchDemo() {
            super();
        }

        @Override
        public void run() {
            //当前对象唯一，使用当前对象加锁，避免多线程问题
            synchronized (this) {
                try {
                    for (int i = 0; i < 50000; i++) {
                        if (i % 2 == 0) {
                            System.out.println(i);
                        }
                    }
                } finally {
                    //保证肯定执行
                    latch.countDown();
                }
            }
        }
    }
}
