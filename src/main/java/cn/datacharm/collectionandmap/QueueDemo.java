package cn.datacharm.collectionandmap;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * description:
 * 队列使用
 *
 * @author Herb
 * @date 2019/10/20
 */
public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        Integer remove = queue.remove();
        System.out.println("remove:" + remove);
        System.out.println(queue.peek());
        System.out.println("isEmpty:"+queue.isEmpty());
    }
}
