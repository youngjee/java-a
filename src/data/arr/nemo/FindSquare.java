package data.arr.nemo;

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
		
		System.out.println(1^1^3);
		//find(squareArr);
		
	}
	
	int[][] findSquare = new int[6][8];
	int[][] square;
	
	public void find(int[][] square){
		this.square = square;
		
		for (int i = 0; i < square.length; i++) {
			for (int j = 0; j < square[0].length; j++) {
				
			}
		}
	}
	
	public void selfFind(int x, int y, int width, int height) {
		if(x==5 || y==7)
			return;
		else{
			if(findSquare[x+1][y]==0){
				width++;
				selfFind(x+1, y, width, height);
			}
			if(findSquare[x][y+1]==0){
				height++;
				//selfFind
			}
			
		}
	}
}
