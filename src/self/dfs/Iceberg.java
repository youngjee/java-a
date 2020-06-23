package self.dfs;

import java.util.ArrayList;
import java.util.List;

public class Iceberg {

	/**
	 * 현재 빙산 지도에서 내부 물을 구분하는 기능
	 * 
	 * @param icebergMap
	 *            빙산 지도 데이터
	 * @return int[][] "내부 물"을 9로 변경한 빙산 지도 데이터
	 */
	public int[][] convertInnerWater(int[][] icebergMap) {

		globalIceberg = icebergMap.clone();
		resultIceberg = icebergMap.clone();
		searchRoad = new boolean[globalIceberg.length][globalIceberg[0].length];
		h = globalIceberg.length;
		w = globalIceberg[0].length;
		
		for (int i = 0; i < globalIceberg.length; i++) {
			for (int j = 0; j < globalIceberg[0].length; j++) {
				if(globalIceberg[i][j] == 0&&!searchRoad[i][j]) {
					List<int[]> currentNums = new ArrayList<int[]>();
					int result = 0;
					if(searchIceBurg(i, j, currentNums)) {
						for (int[] current: currentNums) {
							resultIceberg[current[0]][current[1]] = 9;
							result++;
						}
						System.out.println("내부물크기: ("+i+","+j+")"+result);
					}
					
				}
			}
		}
		
		return resultIceberg;
	}
	int[][] globalIceberg;
	int[][] resultIceberg;
	boolean[][] searchRoad;
	
	int w;
	int h;
	
	
	public boolean searchIceBurg(int x, int y, List<int[]> currentNums){
		//target이 끝에가면 false로
		if(x<0 || x>h-1 || y<0 || y>w-1) {
			return false;
		}
		//아니면 찾기
		else{
			if(globalIceberg[x][y]==0 ){
				if(searchRoad[x][y]==false) {
					int[] current = {x,y};
					currentNums.add(current);
					searchRoad[x][y]=true;
					
					if(!searchIceBurg(x+1, y, currentNums)||!searchIceBurg(x, y+1, currentNums)
						||!searchIceBurg(x-1, y, currentNums)||!searchIceBurg(x, y-1, currentNums)) {
						return false;
					}
				}
			}
			return true;
		}
	}


	/**
	 * 몇 년 후 빙산이 모두 사라지는지 구하는 기능
	 * 
	 * @param icebergMap
	 *            빙산 지도 데이터
	 * @return int 빙산이 모두 사라지는 년 수
	 */
	public int getCollapseYear(int[][] icebergMap) {

		int collYear = 0;
		
		List<int[]> iceList = new ArrayList<int[]>();
		for (int i = 0; i < icebergMap.length; i++) {
			for (int j = 0; j < icebergMap[0].length; j++) {
				if(icebergMap[i][j]==4) {
					int[] oneIce = {i, j};
					iceList.add(oneIce);
				}
			}
		}
		
		while(true) {
			List<int[]> removeList = new ArrayList<int[]>();
			collapse(iceList, iceList.size()-1, removeList);
			
			for(int[] remove:removeList) {
				globalIceberg[remove[0]][remove[1]] = 0;
			}
			
			//print
			IcebergRun.printInnerWaterMap( globalIceberg );
			
			if(iceList.size()==0) {
				break;
			}else {
				collYear++;
			}
		}

		return collYear;
	}
	
	public void collapse(List<int[]> iceList, int n, List<int[]> removeList) {
		if(n<0) {
			return;
		}else {
			int[] place = iceList.get(n);
			int i=place[0];
			int j=place[1];
			globalIceberg[i][j]-=getAround(i, j);
			
			if(globalIceberg[i][j] <=0) {
				removeList.add(iceList.remove(n));
			}
			collapse(iceList, n-1, removeList);
		}
	}
	
	//주변에 0이 몇개있는지 구하는함수
	public int getAround(int i, int j) {
		int cnt = 0;
		if(i<=0) {
			if(globalIceberg[i+1][j]==0) {
				cnt++;
			}
		}else if(i>=h-1) {
			if(globalIceberg[i-1][j]==0) {
				cnt++;
			}
		}else {
			if(globalIceberg[i+1][j]==0) {
				cnt++;
			}
			if(globalIceberg[i-1][j]==0) {
				cnt++;
			}
		}
		
		if(j<=0) {
			if(globalIceberg[i][j+1]==0) {
				cnt++;
			}
		}else if(j>=w-1) {
			if(globalIceberg[i][j-1]==0) {
				cnt++;
			}
		}else {
			if(globalIceberg[i][j+1]==0) {
				cnt++;
			}
			if(globalIceberg[i][j-1]==0) {
				cnt++;
			}
		}
		return cnt;
	}


}