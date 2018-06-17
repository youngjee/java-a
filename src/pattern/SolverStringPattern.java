package pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*문자열에서3개문자로구성된“GOL”과“LOL” 
 * 문자열을몇번포함하고있는지찾는프로그램을작성한다.
 * 
 */
public class SolverStringPattern {
	
	//문자 찾기-> String함수에 contain과 동일
	public void findStr1(String pStr, String inputStr) {
		Pattern p = Pattern.compile(pStr);
		Matcher m = p.matcher(inputStr);
		
	}
	
	//겹치는 부분도 찾기
	public static void findStr2() {
		Pattern p = Pattern.compile("(LOL)|(GOL)");
		String input = "LGOLOLOLGOLOL";
		Matcher m = p.matcher(input);
		
		//LOL과 GoL갯수를 각각 따로 계산하기위해
		int lolCnt = 0;
		int golCnt = 0;
		
		//전체갯수
		int cnt = 0;
		while(m.find()){
			System.out.println("start: "+m.start()+" end: "+m.end());
			//System.out.println(m.groupCount());
			
			if(m.group().equals("LOL"))
				lolCnt++;
			else if(m.group().equals("GOL"))
				golCnt++;
			
			cnt++;
			//input값에서 겹치는 부분도 찾기위해서 찾는범위를 조절
			m.region(m.start()+1,input.length());
		}
		System.out.println(cnt);
		System.out.println("lol갯수: "+lolCnt+" gol갯수: "+golCnt);
	}

	public static void main(String[] args) {
		findStr2();
	}
}
