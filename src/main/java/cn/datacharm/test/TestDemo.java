package cn.datacharm.test;

import org.junit.Test;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * 测试类
 * @author Herb
 * @date 2019/09/22
 */
public class TestDemo {

    @Test
    public void test() {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("aaaa");


        for(int i = 0; i< arrayList.size();i++){
            String item = (String)arrayList.get(i);
            System.out.println("泛型测试item = " + item);
        }
    }
}
