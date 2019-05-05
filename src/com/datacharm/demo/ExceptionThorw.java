package com.datacharm.demo;


public class ExceptionThorw {
	
	public static int fun(int x,int y)throws Exception{
		int t=0;
		System.out.println("开始计算");
		try{
		t=x/y;
		}catch(Exception e){
			throw e;
		}
		finally//不加fianlly捕捉异常后中断
		{
			System.out.println("结束计算");
		}
		return t;
	}

	public static void main(String[] args){
		try {
			System.out.println(fun(10, 0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		int i=0;
		if(i==0)
			try {
				throw new Exception("i是0！");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	}

}
