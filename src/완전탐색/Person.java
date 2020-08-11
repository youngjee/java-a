package 완전탐색;

import java.util.ArrayList;
import java.util.List;

public class Person {

	private String id;
	private List<Person> list = new ArrayList<Person>();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<Person> getList() {
		return list;
	}
	public void setList(List<Person> list) {
		this.list = list;
	}
	
}
