package cn.datacharm.string;

/**
 * String不是基本数据类型
 * String是final修饰的，最主要为了线程安全，也利于实现字符串常量池和保证HashCode不可变性
 */
public class StringDemo {

	public static void main(String[] args) {
		String s1="你好";
		String s2="你好";
		//new 在程序中表示开启一个空间
		String s3=new String("你好");
		//== 判断两个实例的地址值是否相同，即是否是同一对象
		//判断字符串内容是否相同，需要使用equals()
		//if(s1.equals("你好")     //若s1未初始化会报空指针异常
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s2==s3);


		String s = "123*** \t\n";
		//trim去掉 unicode <= 32的字符 即unicode小于' '
		System.out.println(s.trim());
	}

}
