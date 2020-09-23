package stream;

import java.util.Collections;
import java.util.List;

public class StreamEx {
	public static void main(String[] args) {
		//Collections함수
		List<Integer> numbers = List.of(4, 0, 5, 2, 7, 1, 8, 6, 9, 3);
		int max = numbers.isEmpty() ? -1 : Collections.max(numbers);
		System.out.println("Max: " + max); // Max: 9
		
		int min = numbers.isEmpty() ? -1 : Collections.min(numbers);
		System.out.println("Min: " + min); // Min: 0
		
		//Stream 사용
		max = numbers.stream().max(Integer::compare).orElse(-1);
		System.out.println("Max: " + max); // Max: 9
		
		min = numbers.stream().min(Integer::compare).orElse(-1);
		System.out.println("Min: " + min); // Min: 0
	}
}
