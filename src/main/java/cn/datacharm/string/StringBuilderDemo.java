package cn.datacharm.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * StringBuilder字符串可变，单线程使用，线程不安全
 * @author datacharm.cn
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("Begin-");
        stringBuilder.append("1-");
        stringBuilder.append("2-");
        stringBuilder.append("3");
        System.out.println(stringBuilder);


    }
}
