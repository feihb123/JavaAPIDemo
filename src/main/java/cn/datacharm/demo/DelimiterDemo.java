package cn.datacharm.demo;

import java.util.Scanner;
/**
 * Scanner分隔符
 * @author 化十
 *
 */
public class DelimiterDemo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("a");
		while (sc.hasNext()) {
			System.out.println("hasNext()判断为true,我还有下一个：");
			System.out.println("下一个输出是："+sc.next());
		}
		sc.close();
	}

}
