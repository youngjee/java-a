package data.arr.rotateCar;

import java.util.Arrays;

public class CarRotationRun {
	public static void main(String[] args) {
		int[][] road = new int[10][10];
		
		CarRotation cr = new CarRotation();
		System.out.println(Arrays.toString(cr.getCarPosition(0, 0, 4, 0, true, 2, 5)));
	}
}
