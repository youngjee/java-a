package string;

import java.util.Arrays;

public class StringExample {

	//char로 모두 채워진 String반환
	public String fillChar(char c, int length) {
		char[] chars = new char[length];
		Arrays.fill(chars, c);
		return new String(chars);
	}
}
