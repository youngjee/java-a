package pattern.doorlock;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoorLockRun {
	public static void main(String[] args) {
		String input ="9,8,8,6,7,9";
		System.out.println(valid(input));
	}
	
	public static boolean valid(String input){
		String[] inArr = input.split(",");
		String inStr = input.replace(",", "");
		
		String init = inArr[0];
		int samCnt = 1;
		int conCnt = 0;
		int patternCnt = 0;
		
		if(!Pattern.matches("\\d{6,15}", inStr)){
			System.out.println("길이오류");
			return false;
		}
		
		for (int i = 0; i < inArr.length; i++) {
			/*Matcher m = Pattern.compile(inArr[i]+"{3}").matcher(inStr);
			if(m.find()){
				return false;
			}*/
			
			if(i==0){
				init = inArr[0];
			}else{
				int ab = Math.abs(Integer.valueOf(init)-Integer.valueOf(inArr[i]));
				if(ab==0){
					samCnt++;
				}else if(ab==1){
					conCnt++;
				}else{
					samCnt = 0;
					conCnt = 0;
				}
				init = inArr[i];
				
				for (int j = 0; j < i; j++) {
					System.out.println(inStr.substring(j, i+1));
					Matcher mm = Pattern.compile("("+inStr.substring(j, i+1)+")"+"{2}").matcher(inStr);
					if(mm.find()){
						System.out.println("패턴중복!");
						return false;
					}
				}
			}
			
			if(samCnt>2 || conCnt>1){
				System.out.println("숫자중복이나 연속숫자중복");
				return false;
			}
		}
		return true;
	}
}
