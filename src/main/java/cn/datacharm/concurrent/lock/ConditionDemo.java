package cn.datacharm.concurrent.lock;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * description:
 * 相比使用Object的wait()、notify()，使用Condition的await()、signal()这种方式实现线程间协作更加安全和高效。
 * 调用Condition的await()和signal()方法，都必须在lock保护之内。
 * @author Herb
 * @date 2019/09/25
 */
public class ConditionDemo {
    final Lock lock = new ReentrantLock();
    final Condition condition = lock.newCondition();

    public static void main(String[] args) {
        ConditionDemo test = new ConditionDemo();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();


        consumer.start();
        producer.start();
    }

    class Consumer extends Thread{

        @Override
        public void run() {
            consume();
        }

        private void consume() {

            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "我在等一个新信号");
                condition.await();
                System.out.println(Thread.currentThread().getName() + "拿到一个信号");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally{

                lock.unlock();
            }

        }
    }

    class Producer extends Thread{

        @Override
        public void run() {
            produce();
        }

        private void produce() {
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName() + "我拿到锁");
                condition.signalAll();
                System.out.println(Thread.currentThread().getName() + "我发出了一个信号：");
            } finally{
                lock.unlock();
            }
        }
    }

}
