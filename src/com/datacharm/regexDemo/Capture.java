package com.datacharm.regexDemo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Capture {
    public static void main(String[] args) {
        String pro = "[\"1\"]";
        System.out.println(pro);
        String pattern = "\\*?(\\d+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(pro);
        System.out.println(m.group(0));
    }
}
