package cn.datacharm.demo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

class Mytask extends TimerTask{

	@Override
	public void run() {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.sss").format(new Date()));
		
	}
	
}
public class TimerDemo {

	public static void main(String[] args) {
		Timer timer=new Timer();
		timer.schedule(new Mytask(), 1000,2000);

	}

}
