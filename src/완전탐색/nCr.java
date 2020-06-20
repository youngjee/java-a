package 완전탐색;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import tree.MakeNumber;

public class nCr {
	public static void main(String[] ar) {
		nCr ex = new nCr();
		int[] arr = { 1, 3, 5, 7, 9 };
		int n = arr.length;
		int r = 3;
		int[] combArr = new int[n];

		ex.doCombination(combArr, n, r, 0, 0, arr);
		System.out.println(ex.getCombList());
	}
	
	List<Integer> combList = new ArrayList<Integer>();
	
	public void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr) {
		if (r == 0) {
			int[] numArr = new int[index];
			for (int i = 0; i < index; i++)
				numArr[i] = arr[combArr[i]];
			combList.add(makeNum(numArr));
		} else if (target == n)
			return;
		else {
			combArr[index] = target;
			doCombination(combArr, n, r - 1, index + 1, target + 1, arr); // (i)
			doCombination(combArr, n, r, index, target + 1, arr); // (ii)
		}
	}
	
	public int makeNum(int[] nums) {
    	int num = nums[0];
    	for (int i = 1; i < nums.length; i++) {
			num = num*10 + nums[i];
		}
    	return num;    	
    }
	
	public List<Integer> getCombList() {
		return this.combList;
	}
}
