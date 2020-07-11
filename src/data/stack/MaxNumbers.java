package data.stack;

import java.util.Stack;


//어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하기
public class MaxNumbers {
	public static void main(String[] args) {
		String number = "4177252841";
		int k = 5;
		MaxNumbers mn = new MaxNumbers();
		System.out.println(mn.solution(number, k));
	}
	public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }
}
