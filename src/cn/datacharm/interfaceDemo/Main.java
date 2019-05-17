package cn.datacharm.interfaceDemo;


public class Main implements TestA,TestB{

    public static void main(String[] args) {
        Main main = new Main();
        main.show();
        main.show2();
        //静态方法需要用 接口.方法名 调用
        TestA.show3();
        //接口.变量名 获取接口中静态常量
        System.out.println(TestA.x);

        main.show3();

    }
}
