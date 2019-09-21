package cn.datacharm.concurrent.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * description:
 *
 * @author Herb
 * @date 2019/09/19
 */
public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        //阻塞式队列长度是固定的
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

        /**
         * bockingQueue 方法以四种形式出现，对于不能立即满足但可能在将来某一时刻可以满足的操作，
         * 这四种形式的处理方式不同：
         * 第一种是抛出一个异常，
         * 第二种是返回一个特殊值（null 或 false，具体取决于操作），
         * 第三种是在操作可以成功前，无限期地阻塞当前线程，
         * 第四种是在放弃前只在给定的最大时间限制内阻塞。下表中总结了这些方法：
         */
        //      抛出异常     特殊值	     阻塞	       超时
        //插入	 add(e)	   offer(e)	   put(e)	offer(e, time, unit)
        //移除	remove()	poll()     take()	poll(time, unit)
        //检查	element()	peek()	   不可用	不可用
        queue.add("xjj1");
        queue.add("xjj2");
        queue.add("xjj3");
        queue.offer("xbb",5, TimeUnit.MILLISECONDS);
        queue.put("cbb");
        System.out.println(queue);


        System.out.println(queue.remove());
        System.out.println(queue.poll());
        System.out.println(queue.poll(5,TimeUnit.SECONDS));
        System.out.println(queue.take());


    }
}
