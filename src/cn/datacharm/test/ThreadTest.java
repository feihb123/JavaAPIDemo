package cn.datacharm.test;

public class ThreadTest {

	public static void main(String[] args) {
		Runnable r = new Runnable() {
		public void run() {
		System.out.println("11111");
		}
		}; new Thread(r).start();
		}

}
