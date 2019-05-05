package com.datacharm.castDemo;

public class Son extends Father {
    int id;

    public Son(int id) {
        this.id = id;
    }

    public void hello(){
         super.hello();
    }

    public void hello1(){
    	System.out.println("helloSon");
    }

    @Override
    public String toString() {
        return "Son{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }

    public Son(String name, int age, String sex, int id) {
        super(name, age, sex);
        this.id = id;
    }

    public static  void main(String args[]){

    Father f=new Father("xxx",30,"f");
    Son s=new Son("yyyy",10,"f",2);

    if(s instanceof Father){  // 若s是 Father实例  向上转型
    	 Father fa = (Father)s;
    	 System.out.println(fa.name);//fa.id无法访问  转型后子类特有会暂时无法访问
    	 System.out.println(fa.toString());//父类方法被重写的调用子类方法
    }
    
    Father father=new Son("aaa",20,"男",1);
    System.out.println(father.toString());
    ((Son)father).hello1();
    father.hello();

    }
}

