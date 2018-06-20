package data.arr.rotateCar;

public class CarRotation {

	public int[] getCarPosition(int a, int b, int x, int y, boolean right, int minuite, int n){
		int[] result = new int[2];
		for (int i = 0; i < minuite; i++) {
			if((x==a)&&((b<=y)&&(y<b+n-1))){
				if(right){
					y = y+1;
				}else{
					y = y-1;
				}
				
				
			}else if((y==b+n-1)&&((a<=x)&&(x<a+n-1))){
				if(right){
					x = x+1;
				}else{
					x = x-1;
				}
				
			}else if((x==a+n-1)&&((b<y)&&(y<=b+n-1))){
				if(right){
					y = y-1;
				}else{
					y = y+1;
				}
				
			}else if((y==b)&&((a<x)&&(x<=a+n-1))){
				if(right){
					x = x-1;
				}else{
					x = x+1;
				}
				
			}
			System.out.println("[" + x+","+y+"]");
		}
		result[0] = x;
		result[1] = y;
		
		return result;
	}
}

