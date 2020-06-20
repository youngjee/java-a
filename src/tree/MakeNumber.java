package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MakeNumber {
	public static void main(String[] args) {
		String[] input = {"GI, IFD", "FDA", "ABC", "CE", "EH"};
		ArrayList<String> list = new ArrayList<>(Arrays.asList(input));
		
		ArrayList<String> resultList = new ArrayList<String>();
		resultList.add(input[0]);
		for (int j = 0; j < resultList.size(); j++) {
			String result = resultList.get(j);
			for (int i = 1; i < list.size(); i++) {
				if(result.charAt(result.length()-1)==list.get(i).charAt(0)){
					result += list.get(i).substring(1);
					list.remove(i);
				}else if(result.charAt(0)==list.get(i).charAt(list.get(i).length()-1)){
					result = list.get(i).substring(0, list.get(i).length()-2)+result;
				}
			}
		}
		
	}
}
