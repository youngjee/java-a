package data.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class ListUtil {

	public void printList(List<String> list, boolean enter) {
		
		if(enter) {
			for(String str:list){
				System.out.println(str);
			}
		}else{
			StringBuffer sb = new StringBuffer();
			for(String str:list){
				sb.append(str+" ");
			}
			sb.append("\n");
			System.out.println(sb.toString());
		}
		
	}
	
}
