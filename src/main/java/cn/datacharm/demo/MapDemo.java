package cn.datacharm.demo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

class User{
	String name;
	public User(String name){
		this.name=name;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}

public class MapDemo {

	public static void main(String[] args) {
		Map<Integer, Integer> m=new TreeMap<>();
		m.put(1, 1);
		m.put(1, 6);
		m.put(1, 3);
		System.out.println(m.get(2));
		
		
		Map<Integer, String> map=new HashMap<>();
		map.put(1, "hello");
		map.put(2, "world");
		map.put(3, "hhhcj");
		
		map.replace(3, "hhhhb");
		System.out.println(map.get(3));
		//1.把Map集合转化为Set集合
		Set<Map.Entry<Integer, String>> set=map.entrySet();
		//2.实例化Iterator接口
		Iterator<Map.Entry<Integer, String>> iter =set.iterator();
		//3.迭代输出，取出每一个Map.Entry对象
		while(iter.hasNext()){
			Map.Entry<Integer, String> me=iter.next();
			System.out.println(me.getKey()+"="+me.getValue());
		}
		
		//对象以及数组传递依靠的是地址传递！！********
		Map<Integer, User> users=new HashMap<>();
		users.put(1, new User("xxxxx"));
		User user=users.get(1);
		user.setName("yyyyy");
		System.out.println(users.get(1).name);
		
		
		
		//HashMap高性能，线程不安全 （异步）HashTable线程安全（同步），低性能
		//ConcurrentHashMap高性能，线程安全
		Map<Integer, String> concurrentmap=new ConcurrentHashMap<>();
		concurrentmap.put(1, "hello");
		concurrentmap.put(2, "world");
		concurrentmap.put(3, "hhhcj");
		System.out.println(concurrentmap);
		
		
		
		
	}

}
