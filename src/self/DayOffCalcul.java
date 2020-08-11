package self;

public class DayOffCalcul {

	public static void main(String[] args) {
		boolean[] days = {false, true, true, true, false, true, true, true, false, false, true};
		DayOffCalcul dc = new DayOffCalcul();
		System.out.println(dc.daysOff(days, 10));
	}
	
	public int daysOff(boolean[] days, int day) {
		boolean[] visited = new boolean[days.length];
		return selfDays(days, day, visited);
	}
	
	public int selfDays(boolean[] days, int day, boolean[] visited) {
		if(days[day]==false||visited[day]) {
			visited[day] = true;
			return 0;
		}else {
			int cnt = 1;
			visited[day] = true;
			if(day>0)
				cnt+=selfDays(days, day-1, visited);
			if(day<days.length-1)
				cnt+=selfDays(days, day+1, visited);
			return cnt;
		}
	}
}
