package self.dfs;

import java.util.ArrayList;
import java.util.List;

//자기보다 큰 방향으로만 number가 뻗어나갈 수 있는 경우 모여있는 수 구하기
public class FindNumberLoad {

	private int[][] road = {
			{1, 2, 3, 3, 3},
			{4, 2, 4, 3, 4},
			{5, 2, 2, 3, 4},
			{5, 5, 2, 9, 8},
			{6, 3, 2, 2, 7},
			{6, 3, 8, 2, 2},
			{7, 7, 8, 9, 2},
			{1, 2, 2, 9, 2},
			{1, 1, 3, 3, 2}
	}; //10*5
	
	public int[][] searchedRoad;
	private int height;
	private int width;
	
	public FindNumberLoad(int[][] road){
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
				if(x<height-1)
					result += searchNumberLoad(x+1, y, num);
				if(y<width-1)
					result += searchNumberLoad(x, y+1, num);
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
				{4, 2, 4, 3, 4},
				{5, 2, 2, 3, 4},
				{5, 5, 2, 9, 8},
				{6, 3, 2, 2, 7},
				{6, 3, 8, 2, 2},
				{7, 7, 8, 9, 2},
				{1, 2, 2, 9, 2},
				{1, 1, 3, 3, 2}
		};
		
		FindNumberLoad fl=new FindNumberLoad(road);
		List<int[]> loads = fl.searchLoads();
		
		for(int[] load:loads) {
			System.out.println(load[0]+"의 길은 "+load[1]+"개");
		}
	}
}
