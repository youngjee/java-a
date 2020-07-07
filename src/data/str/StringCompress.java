package data.str;

//압축할 문자열  s가 매개변수로 주어질 때 1개 이상 단위로 문자열을 압축하여 표현한 문자열 중 가장 짧은 것의 길이를 return
public class StringCompress {
	public static void main(String[] args) {
		String s = "aaaaaababbbbccbdbd";
		StringCompress se = new StringCompress();
		System.out.println(se.solution(s));
	}
	public int solution(String s) {
		int min = 0;
		
		for (int i = 1; i < s.length()/2; i++) {
			StringBuffer sb = new StringBuffer();
			String part = s.substring(0, i);
			int partCnt = 1;
			for (int j = i; j < s.length(); j=j+i) {
				if(j+i>s.length()) {
					if(partCnt==1) {
						sb.append(part);
					}else {
						sb.append(part+partCnt);
					}
					sb.append(s.substring(j));
				}else {
					boolean isLast = false;
					
					if(j+i==s.length()) {
						isLast = true;
					}
					if(part.equals(s.substring(j, j+i))){
						partCnt++;
						if(isLast) {
							//print
							sb.append(part+partCnt);
						}
					}else {
						if(partCnt==1) {
							sb.append(part);
						}else {
							sb.append(part+partCnt);
						}
								
						part = s.substring(j, j+i);
						partCnt = 1;
						
						if(isLast) {
							//print
							sb.append(part);
						}
					}
				}
				
			}
			System.out.println(sb.toString());
			if(i==1) {
				min = sb.length();
			}else if(min>sb.length()) {
				min = sb.length();
			}
			
		}
		return min;
	}
}
