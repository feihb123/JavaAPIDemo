package cn.datacharm.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedDemo {
	public static void readNoBuf() throws Exception{
		File file=new File("G:"+File.separator+"hello.txt");
		InputStream in=new FileInputStream(file);
		//转换流
		InputStreamReader isr=new InputStreamReader(in);
		char c[]=new char[1024];
		int len=isr.read(c);
		System.out.println("字符："+new String(c,0,len));
		isr.close();
		in.close();
	}
	
	public static void readByBuf() throws Exception{
		File file=new File("G:"+File.separator+"hello.txt");
		InputStream in=new FileInputStream(file);
		//转换流
		InputStreamReader isr=new InputStreamReader(in);
		//创建字符缓冲区
		BufferedReader bfr=new BufferedReader(isr);
		
		String line;
		while((line=bfr.readLine())!=null){
			System.out.println(line);
			
		}
		bfr.close();
		isr.close();
		in.close();
		
		
	}
	
	
	public static void main(String[] args)throws Exception {
		//readNoBuf();
		readByBuf();
		
	}
}
