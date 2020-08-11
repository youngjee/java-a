package time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeUtil {

	public static void main(String[] args) {
		
	}
	//현재시간
	public String getCurrent(String format) {
		//format = "yyyy-MM-dd HH:mm:ss";
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));

	}
	//현재시간
	public LocalDateTime getCurrentLocalDateTime() {
		return LocalDateTime.now();
	}
	
	//LocalDateTime -> String
	public String LocalDateTimeToString(LocalDateTime time, String format) {
		String formattedTime = time.format(DateTimeFormatter.ofPattern(format));
		return formattedTime;
	}
	
	//String->LocalDateTime
	public LocalDateTime StringToLocalDateTime(String time, String format) {
		return LocalDateTime.parse(time, DateTimeFormatter.ofPattern(format));
	}
	
	//date사이 몇일 차이나는지
	public long getBetweenDays(LocalDate startDate, LocalDate endDate) {
		
//		Period period = Period.between(startDate, endDate);
//		period.getYears(); //몇년
//		period.getMonths(); //몇달
//		period.getDays(); //31일차이나면 31일 리턴되는게 아니라 1개월 1일로 반환됨. 조심.
		return ChronoUnit.DAYS.between(startDate, endDate);
		
	}
	
	//LocalTime사이 몇초인지
	public long getBetweenTime(LocalTime startTime, LocalTime endTime) {
		Duration duration = Duration.between(startTime, endTime);
		return duration.getSeconds();
		//분이면 
		//return duration.getSeconds()/
	}
	
}
