package data.arr.소용돌이;

public class 소용돌이출력 {
	
	private int[][] block;
	private int size;
	public static void main(String[] args) {
		int size = 7;
		
		소용돌이출력 pb = new 소용돌이출력();
		
		int[][] block = pb.buildBlock(size);
		
		for (int i = 0; i < 7; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < 7; j++) {
				sb.append(String.format(" %-2d", block[i][j]));
			}
			System.out.println(sb.toString()+"\n");
		}
	}
	
	public int[][] buildBlock(int size){
		this.block = new int[size][size];
		this.size = size;
		putBlock(size-1, size-1, size*size+1, 0);
		
		return block;
	}
	
	public void putBlock(int x, int y, int n, int cnt){

		if(n==1)
			return;
		if(block[x][y]==0)
		{
			n--;
			block[x][y] = n;
		}
		
		switch(cnt%4){
		case 0:
			if(y==0 || block[x][y-1]!=0){
				putBlock(x-1, y, n, cnt+1);
			}else{
				putBlock(x, y-1, n, cnt);
			}
			break;
		case 1:
			if(x==0 || block[x-1][y]!=0){
				putBlock(x, y+1, n, cnt+1);
			}else{
				putBlock(x-1, y, n, cnt);
			}
			break;
		case 2:
			if(y==size-1 || block[x][y+1]!=0){
				putBlock(x+1, y, n, cnt+1);
			}else{
				putBlock(x, y+1, n, cnt);
			}
			
			break;
		case 3:
			if(x==size-1 || block[x+1][y]!=0){
				putBlock(x, y-1, n, cnt+1);
			}else{
				putBlock(x+1, y, n, cnt);
			}
			
			break;
		}
/*		
		if(y>0&&block[x][y-1]==0){
			putBlock(x, y-1, n);
		}
		if(x>0&&block[x-1][y]==0){
			putBlock(x-1, y, n);
		}
		if(y<size-1&&block[x][y+1]==0){
			putBlock(x, y+1, n);
		}
		if(x<size-1&&block[x+1][y]==0){
			putBlock(x+1, y, n);
		}
			*/
	}
}
