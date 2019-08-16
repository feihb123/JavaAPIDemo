package cn.datacharm.reflex;

import java.util.Date;

public class ReflexDemo {
	/**
	 * 获取class的三种方式
	 * 1.对象.getClass()
	 * 2.类名.class
	 * 3.Class.forName("路径名")
	 */

	public static void main(String[] args) throws Exception {
		Class<?> cls=new Date().getClass();
		System.out.println(cls);
		
		Class<?> cls2=Date.class;
		System.out.println(cls2.getName());
		
		Class<?> cls3=Class.forName("java.util.Date");
		System.out.println(cls3.getName());

		//反射实例化对象
		Object obj=cls.newInstance();
		System.out.println(obj);
		
		//工厂模式
		iFruit fruit=Factory.getInstance("Apple");
		fruit.eat();
		
		//改进后工厂模式
		iFruit advance=FactoryAdvance.getInstance("Apple");
		advance.eat();
		iMessage advance2=FactoryAdvance.getInstance("Message");
		advance2.print();
		
	}
}


interface iFruit{
	public void eat();
}
interface iMessage{
	public void print();
}

class Message implements iMessage{
	@Override
	public void print() {
		System.out.println("打印消息");
	}
}
class Apple implements iFruit{

	@Override
	public void eat() {
		System.out.println("Eat Apple");
	}
	
}

class Factory{
	public static iFruit getInstance(String className){
		iFruit fruit=null;
		try {
			fruit=(iFruit) Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fruit;		
	}
	
}
class FactoryAdvance{
	@SuppressWarnings("unchecked")
	public static <T> T getInstance(String className){
		T obj=null;
		try {
			obj=(T) Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return obj;		
	}
	
}