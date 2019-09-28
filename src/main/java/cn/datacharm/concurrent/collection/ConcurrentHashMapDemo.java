package cn.datacharm.concurrent.collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * description:
 * ConcurrentHashMapDemo
 *
 * @author Herb
 * @date 2019/09/240
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentMap<String, String> map = new ConcurrentHashMap<>(16);
        map.putIfAbsent("name", "herb");
        map.putIfAbsent("age", "22");
        System.out.println(map.get("name"));
    }
}
