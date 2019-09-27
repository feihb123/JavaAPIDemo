package cn.datacharm.concurrent.lock;

import java.util.concurrent.Exchanger;

/**
 * description:
 *
 * @author Herb
 * @date 2019/09/22
 */
public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger<String> ex = new Exchanger<>();
        new Thread(new Producer(ex)).start();
        new Thread(new Consumer(ex)).start();

    }

    static class Producer implements Runnable {
        private Exchanger<String> exchanger;

        public Producer(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            String info = "Hello from producer";

            try {
                String msg = exchanger.exchange(info);
                System.out.println("Producer get :" + msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class Consumer implements Runnable {
        private Exchanger<String> exchanger;

        public Consumer(Exchanger<String> exchanger) {
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            String info = "Hello from Consumer";

            try {
                String msg = exchanger.exchange(info);
                System.out.println("Consumer get:" + msg);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
