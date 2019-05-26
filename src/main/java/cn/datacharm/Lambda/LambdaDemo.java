package cn.datacharm.Lambda;
@FunctionalInterface
interface IDemo{
	public void print();
}
interface IMath{
	public int add(int x,int y);
}
public class LambdaDemo {
	public static void main(String[] args) {
		IDemo message=()->{
			System.out.println("Hello World!");
			System.out.println("Hello World Again!");		
		};
		message.print();
		IMath math=(int x,int y)->x+y;
		System.out.println(math.add(1, 2));
	}
}
