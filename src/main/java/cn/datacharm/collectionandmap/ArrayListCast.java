package cn.datacharm.collectionandmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * list和array的转换
 * @author datacharm.cn
 */
public class ArrayListCast {
    public static void main(String[] args) {
        //1.array转list
        String[] array = {"string1","string2","string3"};
        //Arrays.asList产生一个Arrays内置的类 其中数组用final表示！
        List<String> list = Arrays.asList(array);
        // list.add("string4");  所以不能往其中添加元素
        for(String s:list){
            System.out.println(s);
        }
        System.out.println("-------------");

        //2.list转array
        List<String> list2 = new ArrayList<>();
        list2.add("t1");
        list2.add("t2");
        list2.add("t3");
        //toArray中不指定参数 只能转换为Object类型
        String[] strings = list2.toArray(new String[list2.size()]);

        for (String v:strings) {
            System.out.println(v);
        }

    }
}
