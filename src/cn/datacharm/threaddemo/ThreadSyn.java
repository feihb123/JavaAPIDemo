package cn.datacharm.threaddemo;
class MyThread3 implements Runnable{
	private  int ticket=10;//票数
	@Override
	public void run() {
			for(int i=0;i<20;i++){
				sale();
			/*synchronized (this) {//同步
				if(ticket>0){
					try {
						Thread.sleep(200);//模拟延迟
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(
							Thread.currentThread().getName()+"剩余票数:"+ticket--);
				}
			}*/
		}
	}
	public synchronized void sale(){
		if(this.ticket>0){
			try {
				Thread.sleep(200);//模拟延迟
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(
					Thread.currentThread().getName()+"剩余票数:"+ticket--);
		}
	}
}
public class ThreadSyn {

	public static void main(String[] args) {
		MyThread3 thread=new MyThread3();
		Thread t1=new Thread(thread,"票贩子A卖票，");
		Thread t2=new Thread(thread,"票贩子B卖票，");
		Thread t3=new Thread(thread,"票贩子C卖票，");
		t1.start();
		t2.start();
		t3.start();

	}

}
