package data.arr.robot;

import java.util.ArrayList;

public class CleanRobot {

	private int[][] room;
	private int[][] visited;
	
	private ArrayList<Integer> visitedList = new ArrayList<Integer>();

	public void clearRoom(int[][] room) {
		this.room = room;
		this.visited = new int[room.length][room.length];
		selfCleaning(4,0);
		for (int i = 0; i < visitedList.size(); i++) {
			System.out.println(visitedList.get(i)+" ");
		}
	}
	
	public void selfCleaning(int x, int y){
		if(visited[x][y]==0){
			visitedList.add(room[x][y]);
			visited[x][y] = 1;
		}else{
			return;
		}
		
		selfCleaning(x-1, y);
		selfCleaning(x, y+1);
		selfCleaning(x+1, y);
		selfCleaning(x, y-1);
	}

	public void cleaning(int x, int y, int direction) {
		if(visited[x][y]==1){
			return;
		}
		switch (direction % 4) {
			case 0:
				visitedList.add(room[x][y]);
				visited[x][y] = 1;
				if(x>0 && visited[x-1][y]!=1){
					cleaning(x-1, y, direction);
				}else{
					cleaning(x, y+1, direction+1);
				}
				break;
			case 1:
				visitedList.add(room[x][y]);
				visited[x][y] = 1;
				if(y<4 && visited[x][y+1]!=1){
					cleaning(x, y+1, direction);
				}else{
					cleaning(x+1, y, direction+1);
				}
				break;
			case 2:
				visitedList.add(room[x][y]);
				visited[x][y] = 1;
				if(x<4 && visited[x+1][y]!=1){
					cleaning(x+1, y, direction);
				}else{
					cleaning(x, y-1, direction+1);
				}
				break;
			case 3:
				visitedList.add(room[x][y]);
				visited[x][y] = 1;
				if(y>0 && visited[x][y-1]!=1){
					cleaning(x, y-1, direction);
				}else{
					cleaning(x-1, y, direction+1);
				}
				break;
			default:
				break;
		}
	}
}
