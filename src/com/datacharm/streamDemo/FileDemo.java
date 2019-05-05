package com.datacharm.streamDemo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileDemo {
	public static void main(String[] args) throws IOException {
		//在多级目录中添加删除文件
		File file=new File("D:"+File.separator+"hello"+File.separator+"hello"
				+File.separator+"hello.txt");
		System.out.println(file.getParentFile());
		/*if(!file.getParentFile().exists()){
			file.getParentFile().mkdirs();
		}
		if(file.exists()){
			file.delete();
		}else{
			file.createNewFile();
		}*/
		//文件操作
		File file2=new File("D:"+File.separator+"s.jpg");

		if(file2.exists()&&file2.isFile()){
			System.out.println("文件大小："+file2.length()/1024+"KB");
			System.out.println("最后一次修改日期："+new SimpleDateFormat("yyyy-MM-dd").format(file2.lastModified()));
		}
		
		//列出D：目录中文件
		File d=new File("D:"+File.separator);
		
		/*if(d.exists()&&d.isDirectory()){
			 File[] result=d.listFiles();
			 for(int i=0;i<result.length;i++){
				 System.out.println(result[i]);
			 }
		}*/
		
		//递归实现子目录全输出
		//listDir(d);
		
	}
	public static void listDir(File file){
		if(file.isDirectory()){
			File[] res=file.listFiles();
			if(res!=null){
			for(int i=0;i<res.length;i++){
				listDir(res[i]);
			}
		  }
		}
		System.out.println(file);
	}

}
