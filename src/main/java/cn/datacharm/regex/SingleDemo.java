package cn.datacharm.regex;

public class SingleDemo {
	public static void main(String[] args) {
		//匹配单个字母
		System.out.println("匹配单个字母 "+"a".matches("a"));
		//匹配斜杠
		System.out.println("匹配斜杠 "+"\\".matches("\\\\"));
		//匹配范围
		System.out.println("匹配斜范围 "+"a".matches("[abc]"));
		System.out.println("匹配数字 "+"1".matches("[0-9]"));
		System.out.println("匹配字母 "+"A".matches("[a-zA-Z]"));
		
		//匹配不在范围  ^取反
		System.out.println("匹配不在范围 "+"x".matches("[^abc]"));
		
		//简化表达式   .表示任意一个字符
		System.out.println(".匹配任意字符 "+"x".matches("."));
		//匹配点  .
		System.out.println("匹配点. "+".".matches("\\."));
		System.out.println("d 简化匹配数字 "+"1".matches("\\d"));
		System.out.println("D 简化匹配不是数字 "+"1".matches("\\D"));
		//匹配空格或换行或制表符
		System.out.println("s 匹配空格或换行或制表符 "+"\n".matches("\\s"));
		System.out.println("S 匹配不是空格或换行或制表符 "+"\n".matches("\\S"));
		//字母数字下划线  /w 等价于 [a-zA-Z0-9_]  /W取反
		System.out.println("w 正则匹配 "+"x".matches("\\w"));
		//  ^正则开始  $正则结束  java用不到 jsp需要
		System.out.println("w 正则匹配 "+"x".matches("^\\w$"));
		
	}
}
