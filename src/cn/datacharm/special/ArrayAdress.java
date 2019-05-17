package cn.datacharm.special;

import java.util.Scanner;

public class ArrayAdress {
	static Scanner sc=new Scanner(System.in);
	//如果两个不同的Scanner变量 不能直接用空格截断数据！
	public static void main(String[] args) {
		
		int n;

		while(sc.hasNext()){
			n=sc.nextInt();
			if(n==0)break;
			int a[]=new int[n];
			func(n,a);
			
		}
		sc.close();
	}
	public static void func(int n,int a[]){
		
		
		for(int i=0;i<a.length;i++){
			a[i]=sc.nextInt();
		}
		//int b[]=a;  a地址传给B！！b随时改变！
		int b[]=new int[n];
		for(int i=0;i<a.length;i++){
			b[i]=a[i];
			}
		
		for(int i=0;i<a.length;i++){
			if(a[i]<0){
				a[i]=-a[i];
			}
		}
		sort(a);

		for(int i=0;i<a.length;i++){
		      a[i]=search(a[i],b);
		}
		int x = 0;
		for(int i=0;i<a.length-1;i++){
			System.out.print(a[i]+" ");
			x=i;
			}
		System.out.println(a[x+1]);
		
	}
	public static int search(int a,int b[]){
		for(int i=0;i<b.length;i++){
		
			if((a+b[i])==0){
				return -a;
			}
		}
		return a;
	}
	
	public static void sort(int a[]){
		for(int i=0;i<a.length-1;i++)
			for(int j=0;j<a.length-1-i;j++){
				int temp;
				if(a[j]<a[j+1]){
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}

	}
		

}
