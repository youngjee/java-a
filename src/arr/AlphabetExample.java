package arr;

import java.util.Arrays;

public class AlphabetExample {

	//알파벳 개수=26개
	private char[] lower;
	private char[] upper;
	
	private String[] lowerStr;
	private String[] upperStr;
	
	//a:97
	//z:122
	//A:65
	//Z:90
	

	public void setLower() {
		lower = new char['z'-'a'+1];
		for (int i = 0; i<lower.length; i++) {
			lower[i] = (char)('a'+i);
		}
	}
	
	public void setUpper() {
		upper = new char['Z'-'A'+1];
		for (int i = 0; i<upper.length; i++) {
			upper[i] = (char)('A'+i);
		}
	}
	

	public void setLowerStr() {
		//lower = new char['z'-'a'+1];
		lowerStr = new String['z'-'a'+1];
		for (int i = 0; i < lowerStr.length; i++) {
			lowerStr[i] = String.valueOf((char)('a'+i));
		}
	}

	public void setUpperStr() {
		upperStr = new String['Z'-'A'+1];
		for (int i = 0; i < upperStr.length; i++) {
			upperStr[i] = String.valueOf((char)('A'+i));
		}
	}
	
	//배열 rotate
	public char[] rotateArr(char[] arr, int rotateNum){
		char[] result = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int rotatedInx = i+rotateNum;
			if(rotatedInx>=arr.length){
				rotatedInx = rotatedInx-arr.length;
			}else if(rotatedInx<0){
				rotatedInx = arr.length+rotatedInx;
			}
			
			result[rotatedInx] = arr[i];
		}
		return result;
	}
	
	//배열 reverse
	public char[] reverseArr(char[] arr) {
		char[] result = Arrays.copyOf(arr, arr.length);
		for (int i = 0; i < result.length; i++) {
			result[i] = arr[result.length-i-1];
		}
		return result;
	}

	
	public static void main(String[] args) {
		//알파벳 개수
		//System.out.println((int)('z'-'a'+1));
		
		/*
		System.out.println("a:"+(int)'a');
		System.out.println("z:"+(int)'z');
		System.out.println("A:"+(int)'A');
		System.out.println("Z:"+(int)'Z');
		*/
		AlphabetExample ae = new AlphabetExample();
		ae.setLower();
		ae.setUpper();
		
		ae.setLowerStr();
		ae.setUpperStr();
		
		char[] lowers = ae.getLower();
		char[] uppers = ae.getUpper();
		
		//print배열
		System.out.println("char배열: "+Arrays.toString(lowers));
		System.out.println("char배열: "+Arrays.toString(uppers));
		
		System.out.println("String배열: "+Arrays.toString(ae.getLowerStr()));
		System.out.println("String배열: "+Arrays.toString(ae.getUpperStr()));
		
		//rotate
		System.out.println("rotate:"+Arrays.toString(ae.rotateArr(lowers, 2)));
		
		//reverse
		System.out.println("reverse:"+Arrays.toString(ae.reverseArr(lowers)));
		
		
	}

	public char[] getLower() {
		return lower;
	}

	public char[] getUpper() {
		return upper;
	}

	public String[] getUpperStr() {
		return upperStr;
	}
	

	public String[] getLowerStr() {
		return lowerStr;
	}

}
