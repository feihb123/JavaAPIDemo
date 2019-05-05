package com.datacharm.demo;
class MessageDemo{
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
class MessageConsumer{
	public void print(){
		System.out.println(Thread.currentThread().getName()+"="+Util.get().getMessage());
	}
}
class Util{
	private static ThreadLocal<MessageDemo> threadLocal=new ThreadLocal<>();
	public static void set(MessageDemo msg) {
		threadLocal.set(msg);
	}
	public static MessageDemo get() {
		return threadLocal.get();
	}
}

public class ThreadLocalDemo {
	public static void main(String[] args) {
		
		new Thread(()->{
			MessageDemo msg=new MessageDemo();
			msg.setMessage("AAAAAAA");
			Util.set(msg);
			new MessageConsumer().print();
		},"用户A").start();
		new Thread(()->{
			MessageDemo msg=new MessageDemo();
			msg.setMessage("BBBBBBB");
			Util.set(msg);
			new MessageConsumer().print();
		},"用户B").start();
	}
}
