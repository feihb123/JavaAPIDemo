package cn.datacharm.concurrent.lock;


/**
 * description:
 *
 * @author Herb
 * @date 2019/09/25
 */
public class WaitAndNotifyDemo {
    public static void main(String[] args) {
        Object obj = new Object();
        new Thread(new Consumer(obj)).start();
        new Thread(new Restaurant(obj)).start();

    }

    static class Consumer implements  Runnable{
        final Object object;

        public Consumer(Object object) {
            this.object = object;
        }

        public void come() throws InterruptedException {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":来到餐馆，落座~");
                object.wait();
                System.out.println(System.currentTimeMillis() + ":开始用餐~");
            }
        }

        @Override
        public void run() {
            try {
                come();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Restaurant implements  Runnable{
        final Object object;

        public Restaurant(Object object) {
            this.object = object;
        }

        public void serving() throws InterruptedException {
            synchronized (object) {
                System.out.println("上菜！");
                object.notify();
            }
        }

        @Override
        public void run() {
            try {
                serving();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
