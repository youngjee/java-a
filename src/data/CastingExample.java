package data;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CastingExample {

	//배열 to List
	public List<String> arrayToList(String[] strArr){
		return Arrays.asList(strArr);
	}
	
	//List to 배열
	public String[] listToArray(List<String> list){
		String[] strArr = new String[list.size()];
		list.toArray(strArr);
		return strArr;
	}
	
	public static void main(String[] args) {
		String[] strArr = {"abc", "bcd", "cdf"};
		CastingExample ce = new CastingExample();
		System.out.println(ce.arrayToList(strArr));
		System.out.println(Arrays.toString(ce.listToArray(ce.arrayToList(strArr))));

	}
}
