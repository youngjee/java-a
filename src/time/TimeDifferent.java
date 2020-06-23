package time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeDifferent {
	public static void main(String[] args) {
		TimeDifferent td = new TimeDifferent();
		System.out.println("9시와 11시는 "+td.timeDirrerent("09:00", "11:00")+"분 차이");
		System.out.println("현재시각은 "+td.getCurrentTime("YYYY년MM월dd일 HH:mm:ss"));
	}

	public long timeDirrerent(String time1, String time2) {
		
		// YYYY MM dd HH mm ss
		// yy/MM/dd HH:mm:ss
		SimpleDateFormat sdformat = new SimpleDateFormat("HH:mm");
		
		Date startDate;
		Date endDate;
		long diff = 0;
		try {
			startDate = sdformat.parse(time1);
			endDate = sdformat.parse(time2);
			//1000밀리초는 1초니까 1000으로 나누면 초
			//분으로 구할때는 1000*60 = 60000;
			//시로 구할때는 1000*60*60 = 3600000
			diff = (endDate.getTime() - startDate.getTime()) / 60000;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return diff;

	}
	
	public String getCurrentTime(String formatStr) {
		SimpleDateFormat format = new SimpleDateFormat (formatStr);
		
		Date time = new Date();
				
		return format.format(time);
	}
}
