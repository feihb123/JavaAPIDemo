package com.datacharm.regexDemo;

public class ManyDemo {
	public static void main(String[] args) {
		//  ? 匹配 0次或一次
		System.out.println("? 匹配0次或1次 "+"a".matches("\\w?"));
		System.out.println("? 匹配0次或1次 "+"".matches("\\w?"));
		
		//  + 匹配 1次或多次
		System.out.println("+ 匹配1次或多次 "+"aaa".matches("\\w+"));
		//  * 匹配 0次 1次或多次
		System.out.println("* 匹配 0次 1次或多次 "+"aaa".matches("\\w*"));
		// {n}匹配出现正好出现n次
		System.out.println(" {n}匹配出现正好出现n次 "+"123456".matches("\\d{6}"));
		System.out.println(" {n}匹配出现正好出现n次 "+"aaa".matches("\\w{18}"));
		// {n,}匹配出现n次或超过n次
		System.out.println(" {n,}匹配出现n次或超过n次 "+"12345678".matches("\\d{6,}"));
		// {n,m}匹配出现n次到m次之间
		System.out.println(" {n,m}匹配出现n次到m次之间 "+"12345678".matches("\\d{6,9}"));
		
		//逻辑符号
		System.out.println(" 正则逻辑符号 "+"1".matches("\\w|\\d"));
		
	}
}
