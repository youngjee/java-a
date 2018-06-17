package math;

public class MathExample {
	// 거리 구하기
	public static double calcul거리(int[] a, int[] b) {
		return Math.sqrt(Math.pow(Math.abs(b[0] - a[0]), 2)
				+ Math.pow(Math.abs(b[1] - a[1]), 2));
	}
}
