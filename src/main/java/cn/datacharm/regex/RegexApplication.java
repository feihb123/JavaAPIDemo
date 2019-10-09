package cn.datacharm.regex;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * description:正则表达式使用
 */
public class RegexApplication {
    @Test
    public void split() {
        String test = "my name  is   herb";
        //根据空格拆分字符串，“ +”：匹配一个或多个空格。
        String[] split = test.split(" +");
        for (String s : split) {
            System.out.println(s);
        }
        System.out.println("--------------------");
        String test2 = "my name is zhangsan,welcome to beijing";
        //根据空格或逗号拆分字符串，“[ ,]”：匹配一个空格或一个逗号
        String[] split2 = test2.split("[ ,]");
        for (String s : split2) {
            System.out.println(s);
        }
    }

    @Test
    public void getString() {
        //获取字符串中的java、Java、JAVA
        String test = "java 是世界上最好的语言，Java天下第一，我爱JAVA";
        String reg = "[jJ]ava|JAVA";
        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(test);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    @Test
    public void convert() {
        //给一个连字符串例如：get-element-by-id转化成驼峰形式。
        String str = "get-element-by-id";
        String regex = "-[a-z]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String oldStr = matcher.group();
            char letter = (char)(oldStr.charAt(1) - 32) ;
            String newStr = String.valueOf(letter);
            str = str.replace(oldStr, newStr);
        }
        System.out.println(str);
    }



}
