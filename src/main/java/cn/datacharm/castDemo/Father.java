package cn.datacharm.castDemo;


public class Father {
    String name;
    int age;
    String sex;
    public Father(){}
    public Father(String name, int age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }
    public void hello(){
        System.out.println("helloFa");
    }
    @Override
    public String toString() {
        return "Father{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
