package cn.datacharm.concurrent.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * description:
 * LinkedBlockingQueueDemo
 *
 * @author Herb
 * @date 2019/09/23
 */
public class LinkedBlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<>();
        queue.add(1);
        queue.offer(2);
        queue.put(3);

        for (Integer integer : queue) {
            System.out.println(integer);
        }

    }
}
