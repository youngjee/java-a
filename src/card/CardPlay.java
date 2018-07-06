package card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardPlay {
	
	public String getCard(String[] cards) {
		ArrayList<String> cardList = new ArrayList<String>(Arrays.asList(cards));
		String first = cardList.get(0);
		if(!isNum(first)){
			cardList.remove(0);
			first = cardList.get(0);
		}
		String last = cardList.get(cardList.size()-1);
		if(!isNum(last)){
			cardList.remove(cardList.size()-1);
			last = cardList.get(cardList.size()-1);
		}
		
		return Integer.valueOf(first)>Integer.valueOf(last)?first:last;
	}
	
	private ArrayList<String> firstList = new ArrayList<String>();
	private ArrayList<String> twoList = new ArrayList<String>();
	
	public int[] twoPersonTotal(String[] cards){
		getCard(new ArrayList<String>(Arrays.asList(cards)), true);
		int[] total = new int[2];
		System.out.println("---first--");
		print(firstList);
		System.out.println("----two---");
		print(twoList);
		
		
		total[0] = calculTotal(firstList);
		total[1] = calculTotal(twoList);
		return total;
		
	}
	
	public void print(ArrayList<String> list) {
		for (String s:list){
			System.out.println(s);
		}
	}
	public int calculTotal(ArrayList<String> list) {
		int total = 0;
		for(String num:list){
			total += Integer.valueOf(num);
		}
		return total;
	}
	
	public void getCard(ArrayList<String> cardList, boolean isFirst) {
		if(cardList.size()==1){
			String last = cardList.get(0);
			if(!isNum(last)){
				return;
			}else{
				if(isFirst){
					firstList.add(last);
				}else{
					twoList.add(last);
				}
			}
			return;
		}else if(cardList.size()==0){
			return;
		}else{
			String first = cardList.get(0);
			if(!isNum(first)){
				cardList.remove(0);
				first = cardList.get(0);
			}
			String last = cardList.get(cardList.size()-1);
			if(!isNum(last)){
				cardList.remove(cardList.size()-1);
				last = cardList.get(cardList.size()-1);
			}
			
			String result;
			if(Integer.valueOf(first)>Integer.valueOf(last)){
				result = first;
				cardList.remove(0);
			}else{
				result = last;
				cardList.remove(cardList.size()-1);
			}
			
			if(isFirst){
				firstList.add(result);
				getCard(cardList, false);
			}else{
				twoList.add(result);
				getCard(cardList, true);
			}
			
			
		}
		
		
	}
	
	public boolean isNum(String str){
		Matcher m = Pattern.compile("\\d+").matcher(str);
		return m.matches();
	}
}
