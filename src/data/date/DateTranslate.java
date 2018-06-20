package data.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTranslate {
	public static void main(String[] args) {
		strToDate();
	}
	
	public static void currentMills() {
		long start = System.currentTimeMillis();
		System.out.println("start:"+start);
		//내용
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//끝 시간
		long end = System.currentTimeMillis();
		System.out.println("end:"+end);
		//시작 시간과 끝 시간의 차이
		long time = (long) ((end - start) / 1000.0);

		//결과 출력(000초)
		System.out.println(time + "초");
	}
	
	public static void strToDate(){
		String startTime = "2017-05-15 15:30:27";
		String endTime = "2017-05-16 1:00:00";
		
		try {
			Date startDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime);
			Date endDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime);
			
			long gap = (endDate.getTime()-startDate.getTime())/1000; //초단위
			long hourGap = gap/60/60;
			long reminder = ((long)(gap/60))%60;
			long minuteGap = reminder;
			long secondGap = gap%60;
			
			System.out.println("두 시간 차이는: "+hourGap+"시간 "+minuteGap+"분 "+secondGap+"초");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
