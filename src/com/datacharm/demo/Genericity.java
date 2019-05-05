package com.datacharm.demo;
class message<T>{//泛型类
	private T msg;

	public T getMsg() {
		return msg;
	}

	public void setMsg(T msg) {
		this.msg = msg;
	}
	
}
class point <T extends Number>{//T只能为number或其子类
	private T x,y;

	public T getX() {
		return x;
	}

	public void setX(T x) {
		this.x = x;
	}

	public T getY() {
		return y;
	}

	public void setY(T y) {
		this.y = y;
	}
}
interface IMessage<T>{//泛型接口
	public void print(T t);
}
class MessageImp<T> implements IMessage<T>{

	@Override
	public void print(T t) {
		System.out.println(t);
	}
	
}
class MessageImp2 implements IMessage<String>{

	@Override
	public void print(String t) {
		System.out.println(t);
	}
	
}
public class Genericity {
	
	public static void main(String[] args) {
		point<Integer> p=new point<Integer>();
		p.setX(10);
		p.setY(20);
		int x=p.getX();
		int y=p.getY();
		System.out.println(x+" "+y);
		
		message<Integer> msg=new message<Integer>();
		msg.setMsg(99);
		fun(msg);
		message<String> msg2=new message<String>();
		msg2.setMsg("帅的鸭批");
		fun2(msg2);
		
		
		IMessage<String> iMessage=new MessageImp<String>();
		iMessage.print("我帅的鸭批");
		MessageImp2 iMessage2=new MessageImp2();
		iMessage2.print("我帅的鸭批2");
		
		Integer[] data=geneFun(1,2,3,4);
		for(int temp :data){
			System.out.print(temp+" ");
		}
	}
	
	
	public static void fun(message<?> msg){//加通配符后无法给msg赋值
		System.out.println(msg.getMsg());
	}
	public static void fun2(message<?super String> msg){//泛型只能用String 或其父类Object
		System.out.println(msg.getMsg());
	}
	
	public static <T> T[] geneFun(T...args){//不建议使用
		return args;
	}

}
