package cn.datacharm.streamDemo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MemoryDemo {
	public static void main(String[] args) throws IOException {
		String msg="hello world!";
		
		InputStream input = new ByteArrayInputStream(msg.getBytes());
		OutputStream output = new ByteArrayOutputStream();
		int temp=0;
		while((temp=input.read()) != -1){
			output.write(Character.toUpperCase(temp));
		}
		System.out.println(output);
		input.close();
		output.close();
		
	}
}
