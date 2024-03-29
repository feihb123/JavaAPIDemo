package cn.datacharm.concurrent.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * description:
 *
 * @author Herb
 * @date 2019/09/22
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        new Thread(new Runner(cyclicBarrier), "1号运动员").start();
        new Thread(new Runner(cyclicBarrier), "2号运动员").start();
        new Thread(new Runner(cyclicBarrier), "3号运动员").start();
        new Thread(new Runner(cyclicBarrier), "4号运动员").start();
        new Thread(new Runner(cyclicBarrier), "5号运动员").start();
    }

    static class Runner implements Runnable {
        private CyclicBarrier cyclicBarrier;

        public Runner(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println(name + "到达！");
            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(name + "起跑！");
        }

    }
}
