package cn.datacharm.concurrent.queue;

import java.util.concurrent.Callable;
import java.util.concurrent.SynchronousQueue;

/**
 * description:
 * SynchronousQueueDemo
 *
 * @author Herb
 * @date 2019/09/23
 */
public class SynchronousQueueDemo {
    public static void main(String[] args) {
        /**
         * SynchronousQueue容量为1，会直接将任务交给消费者，必须等队列中的添加元素被消费后才能继续添加新的元素。
         * 如果该队列已有一个元素，则试图向队列中新添一个新元素的线程将会阻塞，直到另一个线程将该元素从队列中抽走。
         * 如果该队列为空，则试图从队列中抽取一个元素的线程将会阻塞，直到另一个线程向队列中添加了一个新的元素
         */
        SynchronousQueue<String> queue = new SynchronousQueue<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    queue.put("str1");
                    queue.put("str2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(queue.take());
                    System.out.println(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
