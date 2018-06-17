//-----------------------------------------------
// 이 파일은 수정하면 안되며, 제공된 PictureCorrection.java 파일을
// 수정해서 프로그램을 완성해야 합니다.
//-----------------------------------------------

package rotate;

public class PictureCorrectionRun {
	static final int MAX_SIZE = 128; // 최대 사진 크기.

	static char inputPhotoAry[][]; // 입력 배열.
	static char outputPhotoAry[][]; // 출력 배열.
	static int rowNum = 0; // 배열의 크기.
	static int colNum = 0;

	public static void main(String[] args) {

		loadData(); // 데이터 읽어오기.

		// 원본 출력.
		System.out.println(" ----- (0) 원본 사진. -----");
		printData(inputPhotoAry, rowNum, colNum);

		// ///////////
		// 좌우 반전 .
		// //////////
		outputPhotoAry = PictureCorrection.reversalPhoto(inputPhotoAry, rowNum,
				colNum);
		System.out.println(" ----- (1) 좌우 반전된 사진. -----");
		printData(outputPhotoAry, rowNum, colNum);
		inputPhotoAry = outputPhotoAry;// 출력배열 --> 입력 배열.

		// /////////
		// 2배 확대.
		// /////////

		outputPhotoAry = PictureCorrection.zoomScale(inputPhotoAry, rowNum,
				colNum);
		System.out.println(" ----- (2) 2배 확대된 사진 -----");
		rowNum *= 2; // 행 2배
		colNum *= 2; // 열 2배
		printData(outputPhotoAry, rowNum, colNum);
		inputPhotoAry = outputPhotoAry;// 출력배열 --> 입력 배열.

		// ///////////////
		// 왼쪽 90도 회전.
		// ///////////////
		outputPhotoAry = PictureCorrection.rotatePhoto(inputPhotoAry, rowNum,
				colNum);
		System.out.println(" ----- (3) 90도 회전된 사진. -----");
		int tmp; // 행,열을 교체.
		tmp = colNum;
		colNum = rowNum;
		rowNum = tmp;
		printData(outputPhotoAry, rowNum, colNum);
		inputPhotoAry = outputPhotoAry;// 출력배열 --> 입력 배열.

		// /////////////////////
		// 오른쪽으로 90도 회전하기
		// /////////////////////
		outputPhotoAry = PictureCorrection.rotateRight(inputPhotoAry, rowNum,
				colNum);
		System.out.println(" ----- (5) 오른쪽으로 90도 회전 -----");
		tmp = colNum;
		colNum = rowNum;
		rowNum = tmp;

		printData(outputPhotoAry, rowNum, colNum); // 행,열을 교체.
		inputPhotoAry = outputPhotoAry;// 출력배열 --> 입력 배열.
		
		// /////////////////////
		// 테두리가 추가된 회전.
		// /////////////////////
		outputPhotoAry = PictureCorrection.drawEdge(inputPhotoAry, rowNum,
				colNum);
		System.out.println(" ----- (4) 테두리가 추가된 사진. -----");
		printData(outputPhotoAry, rowNum + 2, colNum + 2); // 행,열을 교체.
		inputPhotoAry = outputPhotoAry;
		rowNum = rowNum + 2;
		colNum = colNum + 2;

	}

	// 데이터 읽어오기.
	public static void loadData() {

		// ////////////////////
		// 제공 데이터 세트 1
		// 4x2 사진 데이터.
		// /////////////////////
		/*
		 * rowNum = 4; // 4행. colNum = 2; // 2열. char[][] data= { {'C', 'D' },
		 * {'K', 'P' }, {'A', 'R' }, {'P', 'Q' } } ; inputPhotoAry=data;
		 */

		// ////////////////////
		// 제공 데이터 세트 2 (이 부분의 주석을 풀어서, 작성한 코드의 올바른 작동을 확인해 봐도 됩니다.)
		// 5x3 사진 데이터.
		// /////////////////////
		rowNum = 5; // 5행.
		colNum = 3; // 3열.
		char[][] data = { { 'A', 'B', 'C' }, { 'D', 'E', 'F' },
				{ 'G', 'H', 'I' }, { 'J', 'K', 'L' }, { 'M', 'N', 'O' } };
		inputPhotoAry = data;
		// 세트2의 최종 출력
		// * * * * * * * * * * * *
		// * A A D D G G J J M M *
		// * A A D D G G J J M M *
		// * B B E E H H K K N N *
		// * B B E E H H K K N N *
		// * C C F F I I L L O O *
		// * C C F F I I L L O O *
		// * * * * * * * * * * * *

	}

	public static void printData(char[][] photo, int x, int y) {
		int i, k;
		for (i = 0; i < x; i++) {
			for (k = 0; k < y; k++) {
				System.out.print(photo[i][k] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}