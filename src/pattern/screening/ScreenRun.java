package pattern.screening;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class ScreenRun {
	public static void main(String[] args) {
		String a = "ABCDE";
		String b = "CDEG";
		
		System.out.println(screen(a, b));
		System.out.println(totalStr(a, b));
		
		String[] strArr = {"GI", "IFD", "FDA", "ABC", "CE", "EH"};
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(strArr));
		System.out.println(findAlpha(list, list.get(0)));
	}
	
	public static String findAlpha(ArrayList<String> list, String result){
		if(list.size()==0){
			return result;
		}
			
		ArrayList<String> newList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			String temp = totalStr(result, list.get(i));
			if(temp!=null){
				result = temp;
			}else{
				newList.add(list.get(i));
			}
		}
		return findAlpha(newList, result);
	}
	
	public static String screen(String a, String b){
		for (int i = 0; i < a.length(); i++) {
			String sub = a.substring(i);
			if(b.startsWith(sub)) {
				return sub;
			}
		}
		
		for(int i=0; i<b.length(); i++) {
			String sub = b.substring(i);
			if(a.startsWith(sub)) {
				return sub;
			}
		}
		return null;

	}
	
	public static String totalStr(String a, String b){
//		char[] aArr = a.toCharArray();
//		char[] bArr = b.toCharArray();
//		
//		String result = "";
//		
//		for (int i = 0; i < bArr.length; i++) {
//			for (int j = 0; j < aArr.length; j++) {
//				if(bArr[i]==aArr[j]){
//					String matchingStr="";
//					for (int k = j; k < aArr.length; k++) {
//						if(aArr[k]!=bArr[k-j]){
//							break;
//						}else{
//							matchingStr+=aArr[k];
//						}
//						
//						if(k==aArr.length-1){
//							result = a.substring(0, j);
//							result += b;
//							return result;
//						}
//					}
//				}
//			}
//		}
		for (int i = 0; i < a.length(); i++) {
			String sub = a.substring(i);
			if(b.startsWith(sub)) {
				return a.substring(0, i)+sub+b.substring(sub.length());
			}
		}
		
		for(int i=0; i<b.length(); i++) {
			String sub = b.substring(i);
			if(a.startsWith(sub)) {
				return b.substring(0, i)+sub+a.substring(sub.length());
			}
		}
		return null;
	}
}
