package self.dfs;

import java.util.ArrayList;
import java.util.List;

public class FindSquare {

	public static void main(String[] args) {
		int[][] squareArr = {
				{ 1, 1, 1, 0, 0, 0, 1, 1},
				{ 1, 1, 1, 0, 0, 0, 0, 0},
				{ 1, 1, 1, 0, 0, 0, 0, 1},
				{ 0, 0, 0, 0, 1, 1, 0, 1},
				{ 1, 1, 1, 0, 0, 0, 0, 1},
				{ 1, 1, 1, 0, 0, 0, 0, 1}
		};
		
		
		FindSquare fs = new FindSquare();
		fs.printArr(squareArr);
		fs.find(squareArr);
		
	}
	
	int[][] findSquare = new int[6][8];
	boolean[][] isVisited;
	int[][] square;
	
	public void printArr(int[][] squre) {
		for (int i = 0; i < squre.length; i++) {
			for (int j = 0; j < squre[0].length; j++) {
				System.out.print(squre[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void find(int[][] square){
		this.square = square;
		isVisited = new boolean[square.length][square[0].length];
		int cnt = 0;
		List<Integer> squreNum = new ArrayList<Integer>();
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square[0].length; j++) {
				int result = selfFind(i, j, square.length, square[0].length);
				if(result>0) {
					cnt++;
					squreNum.add(result);
				}
			}
		}
		System.out.println("사각형수는: "+cnt);
		System.out.println(squreNum);
	}
	
	public int selfFind(int x, int y, int height, int width) {
		int result = 0;
		if(x<0 || y<0 || x>height-1 || y>width-1) {
			return result;
		}else if(square[x][y]!=1||isVisited[x][y]) {
			return result;
		}else {
			if(x==6||y==6)
				System.out.println("error?");
			isVisited[x][y]=true;
			result++;
			if(x<height) {
				result += selfFind(x+1, y, height, width);
			}
			if(y<width) {
				result += selfFind(x, y+1, height, width);
			}
			return result;
		}
	}
}
