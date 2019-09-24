package cn.datacharm.concurrent.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * description:
 *
 * @author Herb
 * @date 2019/09/20
 */
public class ForkJoinPoolDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        long begin = System.currentTimeMillis();
        ForkJoinTask<Long> submit = pool.submit(new Sum(1, 100000000000L));
        System.out.println(submit.get());
        pool.shutdown();

        long end = System.currentTimeMillis();
        System.out.println("使用时间：" + (end - begin));
    }


    static class Sum extends RecursiveTask<Long> {

        private long start;
        private long end;

        public Sum(long start, long end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Long compute() {
            if (end - start <= 10000) {
                long sum = 0;
                for (long i = start; i <= end; i++) {
                    sum += i;
                }
                return sum;
            } else {
                long mid = (start + end) / 2;
                Sum left = new Sum(start, mid);
                Sum right = new Sum(mid + 1, end);
                left.fork();
                right.fork();
                return left.join() + right.join();
            }
        }
    }


}