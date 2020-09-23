package bakjoon;

public class NoSquare {
	public static void main(String[] args) {
		System.out.println(new NoSquare().noSqure(1, 10));
	}

	public int noSqure(int min, int max) {

		//제곱수 구하기
		int squre = 0;
		
		long maxSqure = Math.round(Math.sqrt(max));
		
		for (int i = 2; i <= maxSqure; i++) {
			int pow = (int)Math.pow(i, 2);
			int gop = 0;
			
			if(min==0) {
				gop = 1;
			}else {
				gop = min%pow==0?min/pow:min/pow+1;
			}
			
			while(pow*gop<=max) {
				squre++;
				gop++;
			}
		}
		
		//전체-제곱수갯수
		return (max-min)+1-squre;
	}
}
