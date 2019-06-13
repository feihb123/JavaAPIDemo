package cn.datacharm.Genericity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author datacharm.cn
 */
public class GenericityTest {
    public static void main(String[] args) throws Exception {
        //泛型方法
        Object obj = genericMethod(Class.forName("cn.datacharm.Genericity.Apple"));

        //测试上边界<? extends Number>  即？只能是Number或其子类
        //<?> 即 <? extends Object>

        showValue(new Generic<Integer>());
        showValue(new Generic<Double>());
        //Generic<>  <>中只能是Number或其子类，所以String不行
        //showValue(new Generic<String>());

        //测试下边界 <? super Apple>  即？只能是Apple或其父类
        showFruit(new Generic<Apple>());
        showFruit(new Generic<Fruit>());
        showFruit(new Generic<Object>());
        //Generic<>  <>中只能是Number或其子类，所以String不行
        //showFruit(new Generic<Banana>());

        //list采用通配符?的读写
        List<? extends Fruit> fruits = new ArrayList<>();
        /*
        结果是编译都不通过。
        因为<? extends Fruit>只是告诉编译器集合中元素的类型上限，
        但它具体是什么类型编译器是不知道的，
        fruits可以指向ArrayList<Fruit>，
        也可以指向ArrayList<Apple>、ArrayList<Banana>，
        也就是说它的类型是不确定的，既然是不确定的，
        为了类型安全，编译器只能阻止添加元素了。
        举个例子，当你添加一个Apple时，但fruits此时指向ArrayList<Banana>，
        显然类型就不兼容了。当然null除外，因为它可以表示任何类型。
         */
        //fruits.add(new Apple());
        //fruits.add(new Fruit());
        //读取可以
        Fruit fruit = fruits.get(0);


        List<? super Fruit> fruits1 = new ArrayList<Fruit>();
        List<? super Fruit> fruits2 = new ArrayList<Object>();
        //可以添加Fruit及其子类
        fruits1.add(new Apple());
        fruits1.add(new Banana());
        fruits1.add(new Fruit());
        //fruits1.add(new Object());

        //获取的元素为Object类型，需要强制转换
        Fruit fruit1 = (Fruit) fruits1.get(0);


        /*
         * PECS法则：生产者（Producer）使用extends，消费者（Consumer）使用super
         * 1、生产者
         * 如果你需要一个提供E类型元素的集合，使用泛型通配符<? extends E>。
         * 它好比一个生产者，可以提供数据。
         * 2、消费者
         * 如果你需要一个只能装入E类型元素的集合，使用泛型通配符<? super E>。
         * 它好比一个消费者，可以消费你提供的数据。
         * 3、既是生产者也是消费者
         * 既要存储又要读取，那就别使用泛型通配符。
         */
    }

    /**
     * 泛型方法的基本介绍
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     *     1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *     2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *     3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *     4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public static <T> T genericMethod(Class<T> tClass)throws InstantiationException ,
            IllegalAccessException{
        T instance = tClass.newInstance();
        return instance;
    }

    public static void showValue(Generic<? extends Number> obj){
        System.out.println(obj.toString());

    }

    public static void showFruit(Generic<? super Apple> obj){
        System.out.println(obj.toString());
    }
}
