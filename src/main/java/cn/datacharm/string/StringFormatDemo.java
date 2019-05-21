package cn.datacharm.string;

public class StringFormatDemo {
	public static void main(String[] args) {
		String name = "小纯洁";
		int age=20;
		double salary=9999.987;
		String str = String.format("姓名:%s 年龄:%d 工资:%4.2f",name,age,salary);
		System.out.println(str);
		
	}
}
