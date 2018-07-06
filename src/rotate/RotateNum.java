package rotate;

public class RotateNum {
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					System.out.println("(" + i + "," + j + "," + k + ")");
				}
			}
		}
	}

	public int[][] rotateNum(int[][] arr, int num) {
		int[][] retAry = new int[arr.length][arr.length];
		for (int i = 0; i < num; i++) {
			retAry = rotate(retAry);
		}
		return retAry;
	}
	
	public int[][] rotate(int[][] arr){
		int[][] retAry = new int[arr.length][arr.length];

		int i, k;

		for (i = 0; i < arr.length; i++) {
			for (k = 0; k < arr.length; k++) {
				retAry[arr.length - k - 1][i] = arr[i][k];
			}
		}

		return retAry;
	}
}
