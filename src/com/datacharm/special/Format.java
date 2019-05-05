package com.datacharm.special;

import java.text.DecimalFormat;

public class Format {

	public static void main(String[] args) {
		double x=3.55556;
		double y=Math.PI;
		
	 DecimalFormat df=new DecimalFormat("#.0000000");
	 System.out.println(df.format(x));
	 
	 System.out.println(String.format("%.2f",y));
	 
	 
	 double n=Math.round(x*100);
	 double m=n/100;
	 double t=0.555555;
	 System.out.println(m);
	 System.out.println(Math.PI*Math.pow(10, 7));
	 System.out.println(String.format("%.3f", t));
	 

	}

}
