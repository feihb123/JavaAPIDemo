package cn.datacharm.collectionandmap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 线程安全的list
 * @author datacharm.cn
 */
public class SecurityList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        //Collections下synchronizedList转换为线程安全
        List<Integer> list2= Collections.synchronizedList(list);
    }
}
