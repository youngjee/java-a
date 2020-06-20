package self.dfs;

import java.util.ArrayList;
import java.util.List;

public class FindSameNumber {

	public static void main(String[] args) {
		int[][] nums = { {3, 2, 5, 5},
						 {3, 4, 7, 8},
						 {1, 4, 5, 5},
						 {0, 7, 7, 9}};
		
		FindSameNumber mz = new FindSameNumber();
		
		int[][] result = mz.solution(nums);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j]+ " ");
			}
			System.out.println();
		}
	}
	
	public int[][] solution(int[][] nums){
		//방문했는지 여부 false로
//		for (int i = 0; i < isSearch.length; i++) {
//			for (int j = 0; j < isSearch.length; j++) {
//				isSearch[i][j] = false;
//			}
//		}
		
		//한 숫자씩 같은것 있는지 찾기
		//nums는 주어진 숫자배열
		//searchNums는 동일한 숫자만 넣는 배열
		//currentNums는 동일한 숫자 있는 배열정보 list에 저장
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				List<int[]> currentNums = new ArrayList<int[]>();
				dfs(i, j, nums[i][j], currentNums);
				if(currentNums.size()>1) {
					for (int k = 0; k < currentNums.size(); k++) {
						searchNums[currentNums.get(k)[0]][currentNums.get(k)[1]] = nums[currentNums.get(k)[0]][currentNums.get(k)[1]];
					}

					System.out.println("("+i+","+j+"): 같은갯수 "+currentNums.size());
				}
				
				
			}
		}
		System.out.println();
		printArr(searchNums);
		return searchNums;
	}
	
	int[][] nums = { {3, 2, 5, 5},
			 {3, 4, 7, 8},
			 {1, 4, 5, 5},
			 {0, 7, 7, 9}};
	
	boolean[][] isSearch = new boolean[nums.length][nums.length];
	int[][] searchNums = new int[nums.length][nums.length];
	
	public void dfs(int x, int y, int num, List<int[]> currentNums){
		if(isSearch[x][y]){
			return ;
		}else if(!isSearch[x][y]){
			if(nums[x][y]==num){
				int[] current = {x,y};
				currentNums.add(current);
				isSearch[x][y]=true;
				if(x<nums.length-1)
					dfs(x+1, y, num, currentNums);
				if(y<nums.length-1)
					dfs(x, y+1, num, currentNums);
			}
			return;
		}
		return;
	}
	
	public void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
