package util;

import java.util.ArrayList;

public class findPrime {
	public static void main(String[] args) {
		findPrime fp = new findPrime();
		fp.getPrime(new ArrayList<Integer>(), 11);
	}
	
	public void getPrime(ArrayList<Integer> prime, int num) {
		prime.add(2);
		for(int i=2; i<num; i++) {
			for (int j = 0; prime.size() > j; j++) {

				if (i % prime.get(j) == 0) break; // 소수가 아닌 경우 pass
				if (j + 1 == prime.size()) // 소수일 때
					prime.add(i);
			}
		}
		
		for(Integer result:prime) {
			System.out.println(result);
		}
	}
	
	public boolean isPrime(int n) {
		if (n == 0 || n == 1)
			return false;
		for (int i = 3; i <= (int) Math.sqrt(n); i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
