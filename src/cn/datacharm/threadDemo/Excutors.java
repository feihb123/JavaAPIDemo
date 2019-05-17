package cn.datacharm.threadDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Excutors {

	public static void main(String[] args) throws Exception {
		//无限大小线程池
		//ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		//单个线程池
		//ExecutorService newCachedThreadPool = Executors.newSingleThreadExecutor();
		//固定大小线程池
		ExecutorService newCachedThreadPool = Executors.newFixedThreadPool(3);

		for(int i=0;i<10;i++){
			//Thread.sleep(200);
			int index=i;
			newCachedThreadPool.submit(()->{
				System.out.println(Thread.currentThread().getName()+"、x="+index);
			});		
		}
		newCachedThreadPool.shutdown();
		
		//定时调度线程池
	     ScheduledExecutorService newScheduledThreadPool = 
	    		 Executors.newScheduledThreadPool(1);
	    for(int i=0;i<10;i++){
			//Thread.sleep(200);
			int index=i;
			newScheduledThreadPool.scheduleAtFixedRate(new Runnable() {	
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()
							+"、x="+index);
				}
				}, 3, 2, TimeUnit.SECONDS);
		}
	   
	}
	
}
