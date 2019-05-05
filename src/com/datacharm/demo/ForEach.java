package com.datacharm.demo;
//增强型for循环
public class ForEach {

	public static void main(String[] args) {
		int[] data=new int[]{1,2,3,4,5};
		//for
		for(int i=0;i<data.length;i++){
			System.out.print(data[i]+" ");
		}
		System.out.println();
		//增强型for
		for(int x:data){
			System.out.print(x+" ");
		}
	}

}
