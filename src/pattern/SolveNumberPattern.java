package pattern;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 1013. Contact
 * 전파의 기본 단위는 { 0 , 1 } 두 가지로 구성되어있으며, x+ (  ) 는 임의의 개수(최소 1개) x의 반복으로 이루어진 전파의 집합을 나타낸다.

(xyx)+ (  ) 는 괄호 내의 xyx의 반복으로 이루어진 전파의 집합을 뜻한다. 아래는 이해를 돕기 위한 예제이다.

1+ = { 1, 11, 111, 1111, 11111, … }
10+ = { 10, 100, 1000, 10000, 100000, … }
(01)+ = { 01, 0101, 010101, 01010101, 0101010101, … }
(1001)+ = { 1001, 10011001, 100110011001, … }
10+11 = { 1011, 10011, 100011, 1000011, 10000011, … }
(10+1)+ = { 101, 1001, 10001, 1011001, 1001101, 100011011000001, … }
반복을 의미하는 + 외에도 or 를 의미하는 | 기호가 있다. { x | y } 는 x 혹은 y 를 의미하는 것으로, { 0+ | 1+ } 는 { 0 , 1 , 00 , 11 , 000 , 111 , … } 의 집합을 의미한다. 아래는 두 기호를 복합적으로 사용한 예이다.

(100 | 11)+ = { 100 , 11 , 10011 , 11100 , 1110011100 , 100111111100100, … }
최근 김동혁 박사는 아레시보 전파망원경에서 star Vega(직녀성) 으로부터 수신한 전파 기록의 일부를 조사하여 그 전파들의 패턴을 분석하여 아래와 같이 기록하였다.

(100+1+ | 01)+
김동혁 박사는 다양한 전파 기록 중에서 위의 패턴을 지니는 전파를 가려내는 프로그램을 필요로 한다. 이를 수행할 수 있는 프로그램을 작성하라.
 */
public class SolveNumberPattern {
	public static void main(String[] args) {
		SolveNumberPattern pattern = new SolveNumberPattern();
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println(pattern.solve(scanner.nextLine()));

		}

	}

	private String pattern;

	public boolean solve(String str) {
		// Pattern p = Pattern.compile("(^([((10)0+1+)|01])+$)");
		Pattern p = Pattern.compile("((100+1+)|(01))+");

		Matcher m = p.matcher(str);

		return m.matches();
	}
}
/*
 * 
입력)
3
10010111
011000100110001
0110001011001

출력)
false
false
true
*/