package cn.datacharm.demo;

public class VariablePara {

	public static int add(int ... x){
		int sum=0;
		for(int i=0;i<x.length;i++){
			sum+=x[i];
		}
		return sum;
		
	}
	public static void main(String[] args) {
		System.out.println(add(1,2,3));
		System.out.println(add(new int[]{1,2,3}));
	}

}
