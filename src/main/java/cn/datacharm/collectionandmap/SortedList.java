package cn.datacharm.collectionandmap;


import java.util.*;

/**
 * @author datacharm.cn
 */
public class SortedList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(5);
        list.add(1);
        //默认排序方法
        Collections.sort(list);
        for(Integer value:list){
            System.out.println(value);
        }
        System.out.println("--------------");
        //自定义比较 -重写
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2){
                    return -1;
                }else if(o1 < o2){
                    return 1;
                }else{
                    return 0;
                }
            }
        });

        for(Integer value:list){
            System.out.println(value);
        }

    }
}
