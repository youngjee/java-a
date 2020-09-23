package bakjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Prime {

	public static void main(String[] args) {
//		int[] nums = {1, 4, 7, 10, 11, 12};
//		new Prime().printWithPrime(nums);
		new Prime().primeList(20);
		int[] nums = {1, 4, 7, 10, 11, 12};
		new Prime().printWithPrime(nums);
	}

	ArrayList<Boolean> primeList;

	List<Integer> oddNums = new ArrayList<Integer>();
	List<Integer> evenNums = new ArrayList<Integer>();
	boolean[] visited;

	public void printWithPrime(int[] nums) {

		/*
		 * List<ArrayList<int[]>> picked = new ArrayList<ArrayList<int[]>>();
		 * firstPrime(nums, numList, picked);
		 */

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0) {
				evenNums.add(nums[i]);
			} else {
				evenNums.add(nums[i]);
			}
		}

		visited = new boolean[evenNums.size()];
		Arrays.fill(visited, false);

		for (int i = 0; i < evenNums.size(); i++) {

		}
	}

	public void firstPrime(int[] nums, List<Integer> numList, List<ArrayList<int[]>> picked) {
		if (numList.size() == 0) {
			return;
		} else {
			int target = numList.get(0);
			for (int i = 1; i < numList.size(); i++) {
				if (isPrime(target + numList.get(i))) {
					int[] primeSet = { target, numList.get(i) };

					if (target == nums[0]) {
						ArrayList<int[]> newList = new ArrayList<int[]>();

						newList.add(primeSet);
						picked.add(newList);
					} else {
						picked.get(picked.size() - 1).add(primeSet);
					}

					System.out.println(target + "," + numList.get(i));
					List<Integer> extraList = new ArrayList<Integer>(numList);
					extraList.remove(i);
					extraList.remove(0);

					firstPrime(nums, extraList, picked);

				}
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
