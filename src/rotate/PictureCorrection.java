package rotate;

public class PictureCorrection {
	static final int  MAX_SIZE =  128; // 최대 사진 크기.
	
	/**
	 * 2차원 사진  배열을 좌우 반전 시킨다.
	 *
	 * @param[in] photoAry	2차원 사진 배열
	 * @param[in] height	사진 배열의 행 개수
	 * @param[in] width		사진 배열의 열 개수
	 * @return 				좌우 반전된 2차원 사진 배열
	 */
	public static char[][] reversalPhoto(char photoAry[][], int height, int width) {
		char[][] retAry;
		retAry=new char[MAX_SIZE][MAX_SIZE]; // 사진을 좌우 반전시킨 2차원 배열. 
		int i,k;
	    for ( i=0; i<height; i++) {
	    	for ( k=0; k<width; k++) {
	            retAry[i][width-k-1] = photoAry[i][k];
	        }
	    }
	    return retAry; // 좌우 반전된 2차원 배열. 
	}

	/**
	 * 2차원 사진  배열을 2배 확대 시킨다.
	 *
	 * @param[in] photoAry	2차원 사진 배열
	 * @param[in] height	사진 배열의 행 개수
	 * @param[in] width		사진 배열의 열 개수
	 * @return				2배 확대된 2차원 사진 배열
	 */
	public static char[][] zoomScale(char photoAry[][], int height, int width) {
		
		char[][] retAry=new char[height*2][width*2];  
		int i,k;	
		
		for ( i=0; i<height; i++) {
	    	for ( k=0; k<width; k++) {
				retAry[2*i][2*k] = photoAry[i][k];
				retAry[2*i+1][2*k] = photoAry[i][k];
				retAry[2*i][2*k+1] = photoAry[i][k];
				retAry[2*i+1][2*k+1] = photoAry[i][k];
			}
		}
	    
	    return retAry; 
	}

	/**
	 * 2차원 사진 배열을 왼쪽으로 90도 회전시킨다.
	 *
	 * @param[in] photoAry	2차원 사진 배열
	 * @param[in] height	사진 배열의 행 개수
	 * @param[in] width		사진 배열의 열 개수
 	 * @return				왼쪽으로 90도 회전된 2차원 사진 배열
	 */
	public static char[][] rotatePhoto(char photoAry[][], int height, int width) {
		
		char[][] retAry=new char[width][height];  
		
		int i,k;
		
		for ( i=0; i<height; i++) {
	    	for ( k=0; k<width; k++) {
				retAry[width-k-1][i] = photoAry[i][k];
			}
		}
		
	    return retAry; 
	}

	/**
	 * 2차원 사진 배열에 테두리를 추가한다.
	 *
	 * @param[in] photoAry	2차원 사진 배열
	 * @param[in] height	사진 배열의 행 개수
	 * @param[in] width		사진 배열의 열 개수
	 * @return				테두리가 추가된 2차원 사진 배열
	 */
	public static char[][] drawEdge(char photoAry[][], int height, int width) {
		char[][] retAry=new char[height+2][width+2]; 
		
		int i,k;
		
		for ( i=0; i<height+2; i++) {
	    	for ( k=0; k<width+2; k++) {
				retAry[i][k] = '*';
			}
		}
		
		for ( i=1; i<height+1; i++) {
	    	for ( k=1; k<width+1; k++) {
				retAry[i][k] = photoAry[i-1][k-1];
			}
		}
	    
	    return retAry; 
	}
	
	public static char[][] rotateRight(char photoAry[][], int height, int width) {
		char[][] retAry=new char[width][height]; 

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				retAry[j][height-1-i] = photoAry[i][j];
			}
		}
		return retAry;
	}
}
