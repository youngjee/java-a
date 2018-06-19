package self.dfs;

import java.util.ArrayList;
import java.util.List;

//온 방향으로 숫자가 갈수있는 경우 모여있는 숫자가 몇개있는지 보기
public class FindNumberLoadWithAllWay {

	private int[][] road = {
			{1, 2, 3, 3, 3},
			{4, 2, 3, 3, 4},
			{2, 2, 2, 3, 4},
			{5, 5, 2, 9, 8},
			{6, 2, 2, 2, 7},
			{6, 3, 8, 2, 2},
			{7, 7, 8, 9, 2},
			{1, 2, 2, 2, 2},
			{1, 1, 3, 3, 2}
	}; //10*5
	
	public int[][] searchedRoad;
	private int height;
	private int width;
	
	public FindNumberLoadWithAllWay(int[][] road){
		this.road = road;
		height = road.length;
		width = road[0].length;
		this.searchedRoad = new int[height][width];
	}
	
	public int searchNumberLoad(int x, int y, int num){
		int result = 0;
		if(searchedRoad[x][y]==1){
			return result;
		}else if(searchedRoad[x][y]==0){
			if(road[x][y]==num){
				searchedRoad[x][y]=1;
				result = 1;
				if(x>0)
					result += searchNumberLoad(x-1, y, num);
				if(x<height-1)
					result += searchNumberLoad(x+1, y, num);
				if(y<width-1)
					result += searchNumberLoad(x, y+1, num);
				if(y>0)
					result += searchNumberLoad(x, y-1, num);
			}
			return result;
		}
		return 0;
	}
	
	public List<int[]> searchLoads(){
		List<int[]> result = new ArrayList<int[]>();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				int search = 0;
				if((search=searchNumberLoad(i, j, road[i][j]))>2){
					result.add(new int[]{road[i][j], search});
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[][] road = {
				{1, 2, 3, 3, 3},
				{4, 2, 3, 3, 4},
				{2, 2, 2, 3, 4},
				{5, 5, 2, 9, 8},
				{6, 2, 2, 2, 7},
				{6, 3, 8, 2, 2},
				{7, 7, 8, 9, 2},
				{1, 2, 2, 2, 2},
				{1, 1, 3, 3, 2}
		};
		
		FindNumberLoadWithAllWay fl=new FindNumberLoadWithAllWay(road);
		List<int[]> loads = fl.searchLoads();
		
		for(int[] load:loads) {
			System.out.println(load[0]+"의 길은 "+load[1]+"개");
		}
	}
}
