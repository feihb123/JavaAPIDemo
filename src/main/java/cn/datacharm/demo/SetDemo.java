package cn.datacharm.demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class SetDemo {

	public static void main(String[] args) {
		    Set<String> all=new HashSet<String>();
		    all.add("Acc");
		    all.add("Zaa");		
		    all.add("Brr");
		    all.add("Mxx");
		    all.add("Dxx");
		    /*for(String s:all){
		    	System.out.println();
		    }*/
		    Iterator<String> iter=all.iterator();
		    while(iter.hasNext()){
		    	 String s=iter.next();
		    	 System.out.println(s);
		    }
		    
	}

}
