package cn.datacharm.threaddemo;

class MyThread extends Thread{//单继承局限
	String title;
	public  MyThread(String title) {
		this.title=title;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println(title+"----"+i);
		}
	}
}

class MyThread2 implements Runnable{
	String title;
	public  MyThread2(String title) {
		this.title=title;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			System.out.println(title+"----"+i);
		}
	}
}



public class ThreadDemo {
	public static void main(String[] args) {
		//继承实现多线程
		/*MyThread thread1=new MyThread("线程A");
		MyThread thread2=new MyThread("线程B");
		MyThread thread3=new MyThread("线程C");
		//thread1.run();//错误的线程启动方法
		thread1.start();
		thread2.start();
		thread3.start();*/
		
		//Runnable接口实现多继承
		/*MyThread2 thread1=new MyThread2("线程A");
		MyThread2 thread2=new MyThread2("线程B");
		MyThread2 thread3=new MyThread2("线程C");
		new Thread(thread1).start();
		new Thread(thread2).start();
		new Thread(thread3).start();*/
		
		//匿名内部类实现多线程
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10;i++){
					System.out.println("x----"+i);
				}
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<10;i++){
					System.out.println("y----"+i);
				}
			}
		}).start();
	
		//lambda写法
		new Thread(()->System.out.println("z----")).start();
		
		
		
	}	
}
