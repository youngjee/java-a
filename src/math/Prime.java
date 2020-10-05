package math;

import java.util.ArrayList;
import java.util.List;

public class Prime {
	public static void main(String[] args) {
		new Prime().printPrim(100);
	}

	public void printPrim(int max) {
		for (int i = 2; i <= max; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}

	public boolean isPrime(int num) {
		int squr = (int) Math.ceil(Math.sqrt(num));
		for (int i = 2; i <= squr; i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}

	ArrayList<Boolean> primeList;

	List<Integer> oddNums = new ArrayList<Integer>();
	List<Integer> evenNums = new ArrayList<Integer>();
	boolean[] visited;

	// 에라토스테네스의 체
	public void primeList(int n) {
		// ArrayList로 구현

		// n <= 1 일 때 종료
		if (n <= 1)
			return;

		// n+1만큼 할당
		primeList = new ArrayList<Boolean>(n + 1);
		// 0번째와 1번째를 소수 아님으로 처리
		primeList.add(false);
		primeList.add(false);
		// 2~ n 까지 소수로 설정
		for (int i = 2; i <= n; i++)
			primeList.add(i, true);

		// 2 부터 ~ i*i <= n
		// 각각의 배수들을 지워간다.
		for (int i = 2; (i * i) <= n; i++) {
			if (primeList.get(i)) {
				for (int j = i * i; j <= n; j += i)
					primeList.set(j, false);
				// i*i 미만은 이미 처리되었으므로 j의 시작값은 i*i로 최적화할 수 있다.
			}
		}
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		for (int i = 0; i <= n; i++) {
			if (primeList.get(i) == true) {
				sb.append(i);
				sb.append(",");
			}
		}
		sb.setCharAt(sb.length() - 1, '}');

		System.out.println(sb.toString());

	}
}
