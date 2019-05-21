package cn.datacharm.regex;

import java.text.SimpleDateFormat;
import java.util.Arrays;


public class StringDemo {
	public static void main(String[] args) throws Exception {
		//提取出字母
		String str="saf]asf[aslf[aSA.SG[AS;]GAS[P";
		String regex="[^a-zA-Z]";
		System.out.println(str.replaceAll(regex, ""));
		//字符串拆分
		String str2="a1b22c333d4444e55555f";
		String regex2="\\d+";
		System.out.println(Arrays.toString(str2.split(regex2)));
		//验证某一个字符串是否是数字，是将其变为double
		String num="114415.12414";
		String regexNum="\\d+(\\.\\d+)?";
		if(num.matches(regexNum)){
			double d=Double.parseDouble(num);
			System.out.println(d);
		}
		//验证一个字符串是否是日期或日期时间 是 变为Date型
		String date="2019-01-25 11:22:33";
		String dateRegex="\\d{4}-\\d{2}-\\d{2}";
		if(date.matches(dateRegex)){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			System.out.println(sdf.parse(date));
		}else if(date.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")){
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			System.out.println(sdf.parse(date));
		}
		//验证电话是否正确
		/*
		 51283346  01051283346 (010)-51283346
		 */
		String tel="(010)-51283346";
		String telRegex="((\\(\\d{3,4}\\)-)?||(\\d{3,4}))?\\d{7,8}";
		System.out.println(tel.matches(telRegex));
		//验证email
		String email="feihb123@foxmail.com";
		String emailRegex="\\w+@\\w+\\.\\w+";
		System.out.println(email.matches(emailRegex));
		//验证  feihb-java.a@ huabb.xyz   后缀 .com .cn .xyz .net .edu
		String e="feihb-java.a@huabb.xyz";
		String eRegex="[a-zA-Z][a-zA-Z\\-_\\.0-9]{5,14}@[a-zA-Z\\-_\\.0-9]+\\.(com|cn|xyz|net|edu)";
		System.out.println(e.matches(eRegex));
	}
}
