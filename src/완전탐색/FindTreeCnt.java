package 완전탐색;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTreeCnt {
	public static void main(String[] args) {
		Person person = new Person();
		person.setId("01");
		
		List<Person> list = new ArrayList<Person>();
		Person person2 = new Person();
		person2.setId("02");
		Person person4 = new Person();
		person4.setId("04");
		
		list.add(person2);
		list.add(person4);
		
		person.setList(list);
		
		List<Person> list2 = new ArrayList<Person>();
		Person person3 = new Person();
		person3.setId("03");
		list2.add(person3);
		list2.add(new Person());
		person2.setList(list2);
		
		FindTreeCnt fc = new FindTreeCnt();
		
		System.out.println(fc.cntChild(person));
		System.out.println(fc.cntChild(person2));
		
		fc.print();
		
		
	}
	
	Map<String, Integer> cntMap = new HashMap<String, Integer>();
	
	public void print() {
		System.out.println(cntMap.get("01"));
	}
	public int cntChild(Person person) {
		
		if(person.getList().size()==0) {
			return 1;
		}else {
			int cnt = 1;
			for (int i = 0; i < person.getList().size(); i++) {
				cnt += cntChild(person.getList().get(i));
			}
			return cnt;
		}
	}
}
