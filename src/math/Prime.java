package math;

public class Prime {
	public static void main(String[] args) {
		new Prime().printPrim(100);
	}
	
	public void printPrim(int max) {
		for (int i = 2; i <=max; i++) {
			if(isPrime(i)) {
				System.out.println(i);
			}
		}
	}
	
	public boolean isPrime(int num) {
		int squr = (int)Math.ceil(Math.sqrt(num));
		for(int i=2; i<=squr; i++) {
			if(num%i == 0) {
				return false;
			}
		}
		
		return true;
	}
}
