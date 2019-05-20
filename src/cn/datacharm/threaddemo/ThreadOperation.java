package cn.datacharm.threaddemo;


class TestThread implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(
					Thread.currentThread().getName()+"x="+i);
		}
		
	}
	
}
public class ThreadOperation {

	
	public static void main(String[] args) {
		TestThread thread=new TestThread();
		Thread t1=new Thread(thread,"线程A");
		Thread t2=new Thread(thread,"线程B");
		Thread t3=new Thread(thread,"线程C");
		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);
		t1.start();
		t2.start();
		t3.start();
		
	}

}
