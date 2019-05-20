package cn.datacharm.interfaceDemo;

public interface TestB {
    //同时实现的两个接口具有同名默认方法，会报错
   /* default void show(){
        System.out.println("TestB-show()");
    }

    default void show2(){
        System.out.println("TestB-show2()");
    }*/

    default void show3(){
        System.out.println("TestB-show3()");
    }

    default void show4(){
        System.out.println("TestB-show4()");
    }

}
