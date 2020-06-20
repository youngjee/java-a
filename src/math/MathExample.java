package math;

import java.util.Arrays;

public class MathExample {
	
	//최소값
	public static int min(int[] arr){
		int min = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i]<min)
				min = arr[i];
		}
		return min;
	}
	// 거리 구하기
	public static double calcul거리(int[] a, int[] b) {
		return Math.sqrt(Math.pow(Math.abs(b[0] - a[0]), 2)
				+ Math.pow(Math.abs(b[1] - a[1]), 2));
	}
	
	//반올림 구하기
	public static long 반올림(double num){
		return Math.round(num);
	}
	
	//올림
	public static double 올림(double num){
		return Math.ceil(num);
	}
	
	//버림
	public static double 버림(double num){
		return Math.floor(num);
	}
	
	//소수점 n째 자리에서 반올림
	public static double 소수점반올림(double num, int n){
		double result = Math.round(num*Math.pow(10, n))/Math.pow(10, n);
		return result;
	}
	
	//최대공약수 구하기
	public static int gcd(int a, int b) {
	    if (b == 0){
	        return a;
	    }
	    return gcd(b, a % b);
	}
	
	//최소공배수 구하기
	public static int lcm(int a, int b) {
		return a*b/gcd(a,b);
	}
	
	//여러숫자의 최대공약수 구하기
	public static int gcdArr(int[] arr) {
		if(arr.length==1){
			return arr[0];
		}else if(arr.length==2){
			return gcd(arr[0],arr[1]);
		}
		else{
			int result = gcd(arr[arr.length-2], arr[arr.length-1]);
			int[] copiedArr = Arrays.copyOf(arr, arr.length-2);
			return gcd(gcdArr(copiedArr), result);
		}
	}
	
	//여러숫자의 최소공배수 구하기
	public static int lcmArr(int[] arr) {
		if(arr.length==1){
			return arr[0];
		}else if(arr.length==2){
			return lcm(arr[0],arr[1]);
		}
		else{
			int result = lcm(arr[arr.length-2], arr[arr.length-1]);
			int[] copiedArr = Arrays.copyOf(arr, arr.length-2);
			return lcm(lcmArr(copiedArr), result);
		}
	}
	
	public static void main(String[] args) {
		//최대공약수
		System.out.println("최대공약수: "+gcd(6, 8));
		System.out.println("최소공배수: "+lcm(6, 8));
		
		//6, 9, 15
		System.out.println("3자리 최대공약수: "+ gcdArr(new int[]{6, 18, 3}));
		System.out.println("3자리 최소공배수: "+ lcmArr(new int[]{6, 18, 3}));
		
		System.out.println(소수점반올림(10.2462343, 3));
	}
}
