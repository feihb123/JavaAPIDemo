package cn.datacharm.demo;

public class StringDemo {

	public static void main(String[] args) {
		String s1="你好";
		String s2="你好";
		//new 在程序中表示开启一个空间
		String s3=new String("你好");
		//==判断两个实例的地址值是否相同
		//判断字符串内容是否相同，需要使用equals()
		//if(s1.equals("你好")     //若s1未初始化会报空指针异常
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s2==s3);
	}

}
