package cn.datacharm.demo;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
class Person{
	private String name;
	private Integer age;//和int区别Integer有空
	public Person(String name,Integer age){
		this.name=name;
		this.age=age;
	}
	@Override
	public String toString() {
		return "person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age == null) {
			if (other.age != null)
				return false;
		} else if (!age.equals(other.age))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
public class ListDemo {

	public static void main(String[] args) {
	    List<Person> all=new ArrayList<>();
	    all.add(new Person("a",11));
	    all.add(new Person("b",22));		
	    all.add(new Person("c",31));
	    System.out.println(all.get(1));
	    //list.set(index,Object);
	    //list.remove(index);按下标删
	    //list.remove(Object);按内容删
	    for(Person s:all){
	    	System.out.println(s);
	    }
	   
	    //需要生成hashCode（）和equals()不然结果为false
	    System.out.println(all.contains(new Person("b",22)));
		
	    Vector<String> vec =new Vector<String>();
	    vec.add("Acc");
	    vec.add("Zaa");		
	    vec.add("Brr");
	    vec.add("Mxx");
	    vec.add("Dxx");
	    Enumeration<String> enu=vec.elements();
	    while( enu.hasMoreElements()){
	    	 String s=enu.nextElement();
	    	 System.out.println(s);
	    }
		
		
		
	}
}
