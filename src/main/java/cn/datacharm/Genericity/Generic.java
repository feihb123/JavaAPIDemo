package cn.datacharm.Genericity;

/**
 * 泛型类
 * @author datacharm.cn
 */
public class Generic<T> {


    public void show_1(T t){
        System.out.println(t.toString());
    }

    /**
     *在泛型类中声明了一个泛型方法，使用泛型T，注意这个T是一种全新的类型，
     *可以与泛型类中声明的T不是同一种类型。
     */
    public <T> void show_2(T t){
        System.out.println(t.toString());
    }

    /**在泛型类中声明了一个泛型方法，使用泛型E，这种泛型E可以为任意类型。
     * 可以类型与T相同，也可以不同。
     * 由于泛型方法在声明的时候会声明泛型<E>，
     * 因此即使在泛型类中并未声明泛型，编译器也能够正确识别泛型方法中识别的泛型。
     */

    public <E> void show_3(E t){
        System.out.println(t.toString());
    }

    public static void main(String[] args) {
        //泛型类
        Generic<Banana> demo = new Generic();
        //声明泛型类后 show_1 用到此类型所以不能使用
        //demo.show_1(new Apple("苹果","red"));
        demo.show_1(new Banana("香蕉","yellow"));
        demo.show_2(new Apple("苹果","red"));
        demo.show_3(new Apple("苹果","red"));
    }



}
