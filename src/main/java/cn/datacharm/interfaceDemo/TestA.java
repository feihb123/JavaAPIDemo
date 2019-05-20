package cn.datacharm.interfaceDemo;

public  interface TestA{
    //接口中变量都是 public static final的
    int x = 1;

    default void show(){
        System.out.println("TestA-show()");
    }

    default void show2(){
        System.out.println("TestA-show2()");
    }
    static void show3(){
        System.out.println("TestA-show3()");
    }
}
