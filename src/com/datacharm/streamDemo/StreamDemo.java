package com.datacharm.streamDemo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
/**
 * 输入输出流指相对内存而言的流向
 * 字节流，字符流(字节流+字符集)，转换流（字节流<->字符流）
 */
public class StreamDemo {

	public static void main(String[] args) throws Exception{
		File file=new File("G:"+File.separator+"hello.txt");
		if(!file.getParentFile().exists()){
			file.mkdirs();
		}if(!file.exists()){
			file.createNewFile();
		}
		
		//输出字节流
		OutputStream output=new FileOutputStream(file,true);
		//不覆盖前面内容
		//OutputStream output=new FileOutputStream(file,true);
		String msg="huabb.xyz";
		//output.write(msg.getBytes(),0,9);
		byte b[]=msg.getBytes();
		output.write(b, 0, 9);
		output.close();
		
		//输入字节流
		InputStream input=new FileInputStream(file);
		byte data[]=new byte[1024];//定义一个数组，用来存放读入的数据
		int len=input.read(data);//-1代表读到了文件末尾
		System.out.println("读取内容【"+new String(data,0,len)+"】");
		input.close();
		
		//输出字符流
		String s="世界和平";
		Writer writer=new FileWriter(file);
		writer.write(s);
		//writer.flush();//强制清空缓冲内容，全部输出
		writer.close();
		
		//输入字符流
		Reader reader=new FileReader(file);
		char data2[]=new char[1024];
		int len2=reader.read(data2);
		System.out.println("读取中文内容【"+new String(data2,0,len2)+"】");
		reader.close();
		

		charStream();
	
	}
	
	public static void byteStream() throws Exception{
		byte container[]=new byte[1024];
		//字节流数据拷贝
		File counterpart=new File("G:"+File.separator+"hello.txt");
		InputStream copy=new FileInputStream(counterpart);
		
		File location=new File("G:"+File.separator+"counter.txt");
		OutputStream out=new FileOutputStream(location);
		 /*copy.read(container);
		   if(counterpart.exists()){//只能操作一个数组长度！
			out.write(container);
		}*/
		int x=0;
		while((x=copy.read(container))!=-1){
			out.write(container,0,x);
		}
		copy.close();//*****
		out.close();//*****
	}
	
	public static void charStream() throws Exception{
		//字符流数据拷贝
		File counterpart=new File("G:"+File.separator+"hello.txt");
		File location=new File("G:"+File.separator+"counter.txt");
		Reader read=new FileReader(counterpart);
		Writer writer=new FileWriter(location);
		//使用字符流通常和缓冲字符流一起使用
		BufferedReader in=new BufferedReader(read);
		//使用字符缓冲输出流实现文件写操作
		BufferedWriter out=new BufferedWriter(writer);
		String line=in.readLine();
		if(line!=null){
			out.write(line);
/*			//添加换行符
			line=in.readLine();
			//新行
			out.newLine();*/
		}
		out.close();
		in.close();
		read.close();
		writer.close();
	}
	
	
}
