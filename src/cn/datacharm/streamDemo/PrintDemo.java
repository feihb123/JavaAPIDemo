package cn.datacharm.streamDemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;


public class PrintDemo {

	public static void main(String[] args) throws Exception {
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File("G:"+File.separator+"1.txt")));
		pw.print("姓名:");
		pw.println("fhb");
		pw.println(1+10);
		pw.println(1.0+10.1);
		pw.close();
		
	}

}
