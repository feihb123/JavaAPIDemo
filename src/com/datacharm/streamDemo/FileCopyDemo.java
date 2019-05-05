package com.datacharm.streamDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 专门负责文件拷贝类
 * 1、判断源文件是否存在
 * 2、判断父路径是否存在，不在则创建
 * 3、进行文件拷贝
 * @author 化十
 *
 */
class CopyUtil{
	 private CopyUtil(){
		 
	 }
	 /**
	  * 判断源文件是否存在
	  * @param 文件路径
	  * @return 存在返回ture
	  */
	 public static boolean fileExists(String path){
		 return new File(path).exists();
	 }
	
	 /**
	  * 根据输入的路径判断其父路径是否存在 不存在则创建
	  * @param 路径
	  */
	 public static void createParentDir(String path){
		 File file=new File(path);
		 if(!file.getParentFile().exists()){
			 file.getParentFile().mkdirs();
		 }
	 }
	 /**
	  * 
	  * @param 原路径
	  * @param 目标路径
	  * @return 完成返回ture
	  */
	 public static boolean copy(String scrPath,String desPath){
		 boolean flag=false;
		 File inFile=new File(scrPath);
		 File outFile=new File(desPath);
		 InputStream input=null;
		 OutputStream output=null;
		 try {
			input =new FileInputStream(inFile);
			output =new FileOutputStream(outFile);
			try {
				copyHandle(input, output);
				flag=true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			flag=false;
		}finally {
			try {
				input.close();
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		 
		 return flag;
	 
	 }
	 public  static void copyHandle(InputStream input,OutputStream output) throws IOException{
		  //inputStream 有读取单个字节方法 int read() 同outputStream void write(data)
		 long start = System.currentTimeMillis();
		 int temp = 0 ;
		 byte data[] =new byte[2048];

		 //temp = input.read(data) 表示将数据读到数组之中，返回数据读取个数
		 //(temp = input.read()) != -1 判断保存在temp中的个数是否为-1,不是则有内容
		 while ((temp = input.read(data)) != -1){
			output.write(data,0,temp); 
		 }
		 long end = System.currentTimeMillis();
		 System.out.println("花费时间:"+ (end - start));
	 }
}
public class FileCopyDemo {
	public static void main(String[] args) {
		if(args.length!=2){
			System.out.println("错误执行方式");
			System.exit(1);
		}
		if(CopyUtil.fileExists(args[0])){//判断源文件路径是否存在
			CopyUtil.createParentDir(args[1]);
			System.out.println(CopyUtil.copy(args[0],args[1]) ? "文件复制成功":"文件复制失败");
		}else{
			System.out.println("文件不存在，操作失败");
		}
	}
}
