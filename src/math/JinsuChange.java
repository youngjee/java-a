package math;

public class JinsuChange {
	public static void main(String[] args) {
		
		//10진수에서 n진수로 변환
		int i = 127;
		 
		String binaryString = Integer.toBinaryString(i); //2진수
		String octalString = Integer.toOctalString(i);   //8진수
		String hexString = Integer.toHexString(i);       //16진수
		 
		System.out.println(binaryString); //1111111
		System.out.println(octalString);  //177
		System.out.println(hexString);    //7f
		 
		//n진수에서 10진수로 변환
		int binaryToDecimal = Integer.parseInt(binaryString, 2);
		int binaryToOctal = Integer.parseInt(octalString, 8);
		int binaryToHex = Integer.parseInt(hexString, 16);
		 
		System.out.println(binaryToDecimal); //127
		System.out.println(binaryToOctal);   //127
		System.out.println(binaryToHex);     //127
	}
	
}
