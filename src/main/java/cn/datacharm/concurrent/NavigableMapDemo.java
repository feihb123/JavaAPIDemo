package cn.datacharm.concurrent;

import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * description:
 *
 * @author Herb
 * @date 2019/09/20
 */
public class NavigableMapDemo {
    public static void main(String[] args) {
        ConcurrentNavigableMap<String, Integer> map = new ConcurrentSkipListMap<>();
        map.put("g",1);
        map.put("b",2);
        map.put("c",3);
        map.put("d",4);
        map.put("a",5);
        System.out.println(map);

        //截取子映射  从头开始截取到指定位置
        System.out.println(map.headMap("c"));
        //从指定位置到末尾
        System.out.println(map.tailMap("c"));
        //选择两端截取
        System.out.println(map.subMap("a","d"));

    }
}
