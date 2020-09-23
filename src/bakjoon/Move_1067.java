package bakjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Move_1067 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = 0;
		List<Integer> xx = new ArrayList<Integer>();
		List<Integer> yy = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			if(i==0) {
				n = Integer.valueOf(scanner.nextLine());
			}else if(i==1) {
				String[] nums = scanner.nextLine().split(" ");
				for (int j = 0; j < nums.length; j++) {
					xx.add(Integer.valueOf(nums[j]));
				}
			}else {
				String[] nums = scanner.nextLine().split(" ");
				for (int j = 0; j < nums.length; j++) {
					yy.add(Integer.valueOf(nums[j]));
				}
			}
		}
		System.out.println(new Move_1067().maxRotate(xx, yy));
		
	}
	
	public int maxRotate(List<Integer> xx, List<Integer> yy) {

		int max = 0;
		for (int i = 0; i < yy.size(); i++) {
			Collections.rotate(yy, i);
			
			int total= 0;
			for (int j = 0; j < yy.size(); j++) {
				total += xx.get(j)*yy.get(j);
			}
			
			if(i==0) {
				max = total;
			}else {
				if(max<total) {
					max = total;
				}
			}
		}
		return max;
	}
}
