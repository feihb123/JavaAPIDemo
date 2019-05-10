package com.datacharm.regexDemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Capture {
    public static void main(String[] args) {

        String line = "[\"1234\"]";
        System.out.println(line);
        String pattern = "(\\D*)?(\\d+)(.*)";
        // 创建 Pattern 对象
        Pattern r = Pattern.compile(pattern);
        // 创建 matcher 对象
        Matcher m = r.matcher(line);
        if (m.find( )) {
            System.out.println("Found value: " + m.group(0) );
            System.out.println("Found value: " + m.group(1) );
            System.out.println("Found value: " + m.group(2) );
            System.out.println("Found value: " + m.group(3) );
        } else {
            System.out.println("NO MATCH");
        }
    }
}
