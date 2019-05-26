package cn.datacharm.castDemo;
class Animal{
	public void eat(){
		System.out.println("Anmal eat..");
	}

}
class Cat extends Animal{
	public void eat(){
		System.out.println("Cat eat..");
	}

}
class Dog extends Animal{
	public void eat(){
		System.out.println("Dog eat..");
	}
	public void run(){
		System.out.println("run");
	}
}
public class UpCast {

	public static void eat(Animal animal){
		animal.eat();
	}
	public static void main(String[] args) {
		Animal dog=new Dog();//自动向上转型
		dog.eat();
		//向上转型后不能使用子类中的方法 
		//dog.run();
		
		/**
		 * 向上转型优点
		1.减少重复代码，使代码变得简洁。
		2.提高系统扩展性。*/

		eat(new Cat());
		
		/*可以说狗都是动物，但不能说动物都是狗
		 *所以Animal不能向下转型成Dog
		Animal a1=new Animal();
	    Dog dog2=(Dog) a1;
	    dog2.eat();*/
		
	}

}
