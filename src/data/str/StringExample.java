package data.str;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StringExample {

	//char로 모두 채워진 String반환
	public static String fillChar(char c, int length) {
		char[] chars = new char[length];
		Arrays.fill(chars, c);
		return new String(chars);
	}
	
	//오름차순
	public static String sortStr(String str){
		char[] charArr = str.toCharArray();
		Arrays.sort(charArr);
		return new String(charArr);
	}
	
	//오름차순, 내림차순
	public static String sortStr(String str, boolean increase){
		List<String> list = Arrays.asList(str.split(""));
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int inc=increase?1:-1; //오름차순인경우 1, 내림차순인 경우 -1
				return o1.compareTo(o2)*inc;
			}
		});
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("*이 10개: "+fillChar('*', 10));
		System.out.println("AEXEFDEF->(오름차순)"+sortStr("AEXEFDEF"));
		System.out.println("AEXEFDEF->(내림차순)"+sortStr("AEXEFDEF", true));
		System.out.println("AEXEFDEF->(내림차순)"+sortStr("AEXEFDEF", false));
	}
}
