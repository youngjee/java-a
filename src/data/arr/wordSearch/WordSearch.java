package data.arr.wordSearch;

import java.util.ArrayList;
import java.util.List;

public class WordSearch {
	
	private String[][] matrix;
	
	/**
	 * 해당 단어가 격자 내에  존재 하는 경우 시작좌표를 반환하는 메소드 (구현)
	 * 
	 * @param matrix 알파벳 대문자가 포함된 격자
	 * @param word 격자 내에서 찾을 단어
	 * @return 입력 받은 단어가 격자 내에 존재할 경우 시작좌표
	 */
	public String [] findWordCount(String [][] matrix, String word) {
		this.matrix = matrix;
		List<String> result = new ArrayList<String>();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if(word.split("")[0].equals(matrix[i][j])){
					if(findGaro(word, i, j)){
						result.add(getPoint(i, j));
					}
					
					if(findSero(word, i, j)){
						result.add(getPoint(i, j));
					}
					
					if(findDagag(word, i, j)){
						result.add(getPoint(i, j));
					}
				}
				
			}
		}
		if(result.size()>0){
			String[] real = new String[result.size()];
			result.toArray(real);
			return real;
		}else{
			return null;
		}
		
	}
	
	public String getPoint(int i, int j) {
		StringBuffer sb = new StringBuffer();
		sb.append((char)('a'+i));
		sb.append(j);
		return sb.toString();
	}
	
	public boolean findGaro(String word, int i, int j){
		if(j+word.length()<=10){
			StringBuffer sb = new StringBuffer();
			for (int k = j; k < j+word.length(); k++) {
				sb.append(matrix[i][k]);
			}
			if(word.equals(sb.toString())){
				return true;
			}
		}
		return false;
	}
	
	public boolean findSero(String word, int i, int j){
		if(i+word.length()<=10){
			StringBuffer sb = new StringBuffer();
			for (int k = i; k < i+word.length(); k++) {
				sb.append(matrix[k][j]);
			}
			if(word.equals(sb.toString())){
				return true;
			}
		}
		return false;
	}
	
	public boolean findDagag(String word, int i, int j){
		if(i+word.length()<=10 && j+word.length()<=10){
			StringBuffer sb = new StringBuffer();
			for (int k = 0; k < word.length(); k++) {
				sb.append(matrix[i+k][j+k]);
			}
			if(word.equals(sb.toString())){
				return true;
			}
		}
		return false;
	}

}
