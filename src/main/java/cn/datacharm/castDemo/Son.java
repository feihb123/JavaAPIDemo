package cn.datacharm.castDemo;

public class Son extends Father {
    int id;

    public Son(int id) {
        this.id = id;
    }

    @Override
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
        System.out.println(f.toString());
        Son s=new Son("yyyy",10,"f",2);
        System.out.println(s.toString());

        // 若s是 Father实例  向上转型
        if(s instanceof Father){
             Father fa = s;
            //fa.id无法访问  转型后子类特有会暂时无法访问
             System.out.println(fa.name);
            //父类方法被子类重写后,调用的是子类方法
             System.out.println(fa.toString());
        }

        //向上转型
        Father father=new Son("aaa",20,"男",1);
        System.out.println(father.toString());
        father.hello();
        //father.hello1();  向上转型后Father没有hello1()的方法
        //若要使用hello1()需要向下转型 （强制）
        Son son = new Son("aaa",20,"男",1);
        if(son instanceof Father){
            son = (Son) father;
        }
        son.hello1();

    }
}

