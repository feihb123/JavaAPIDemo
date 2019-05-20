package cn.datacharm.streamDemo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class SystemInDemo {
	public static void main(String[] args) throws IOException {
		InputStream input = System.in;
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte data[] = new byte[10];
		System.out.print("请输入信息:");
		int temp=0;
		while((temp=input.read(data))!=-1){
			out.write(data,0,temp);

			if(temp<data.length){
				break;
			}
		}
		System.out.println("输入内容："+new String(out.toByteArray()));
		out.close();
		input.close();
	}
}
