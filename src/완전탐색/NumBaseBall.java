package 완전탐색;

import java.util.ArrayList;
import java.util.List;

public class NumBaseBall {
	
	public static void main(String[] args) {
		NumBaseBall nb = new NumBaseBall();
		int[][] baseball = {{123, 1, 1}, {356, 1, 0},{327, 2, 0}, {489, 0, 1}};
		System.out.println(nb.solution(baseball));
		
	}
	
	public int solution(int[][] baseball) {
		int answer = 0;
		
		int[] nums = new int[9];
		for(int i=1; i<=9; i++) {
			nums[i-1] = i;
		}
		//hashSet init
		permutation(nums, 0, nums.length, 3);
		
		for(int i=0; i<baseball.length; i++) {
			doBaseBall(Integer.toString(baseball[i][0]), baseball[i][1], baseball[i][2]);
		}
		answer = strList.size();
		
		return answer;
	}
	
	public void doBaseBall(String num, int strike, int ball) {
		for (int i = strList.size()-1; i>=0; i--) {
			boolean result = isCondition(strList.get(i), num, strike, ball);
			if(!result) {
				strList.remove(i);
			}
		}
	}
	
	public boolean isCondition(String num1, String num2, int strike, int ball) {
		int tempStrike = 0;
		int tempBall = 0;
		for(int i=0; i<num1.length(); i++) {
			int result = num2.indexOf(Character.toString(num1.charAt(i)));
			if(result==i) {
				tempStrike++;
			}else if(result!=-1){
				tempBall++;
			}
		}
		if(tempStrike==strike && tempBall==ball) {
			return true;
		}
		return false;
	}
	
	List<String> strList = new ArrayList<String>();
	
	void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
        	strList.add(getNum(arr, r));
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
    
 // 배열 출력
    String getNum(int[] arr, int r) {  
    	String num = "";
        for (int i = 0; i < r; i++)
        	num = num + arr[i];
        return num;
    }
    
}
