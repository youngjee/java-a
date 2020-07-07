package pattern;

public class CharCount {
	public static void main(String[] args) {
		String str = "aaaabbccccdeee";
		
		char c = str.charAt(0);
		int cCnt = 1;
		for (int i = 1; i < str.length(); i++) {
			if(c==str.charAt(i)) {
				cCnt++;
				if(i==str.length()-1) {
					System.out.print(String.valueOf(c)+String.valueOf(cCnt));
				}
			}else {
				if(cCnt>1) {
					System.out.print(String.valueOf(c)+String.valueOf(cCnt));
				}
				c = str.charAt(i);
				cCnt = 1;
			}
			
		}
	}
}
