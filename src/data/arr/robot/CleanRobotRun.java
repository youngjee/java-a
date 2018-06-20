package data.arr.robot;

public class CleanRobotRun {
	//달팽이처럼 뱅글뱅글 돌면서 숫자를 출력하는 문제
	//5*5이고, 4,0부터 시작함.
	public static void main(String[] args) {
		int[][] room = {
				{5, 6, 7, 8, 9},
				{4, 19, 20, 21, 10},
				{3, 18, 25, 22, 11},
				{2, 17, 24, 23, 12},
				{1, 16, 15, 14, 13}
		};
		
		CleanRobot cr = new CleanRobot();
		cr.clearRoom(room);
	}
}
