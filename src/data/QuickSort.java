package data;

public class QuickSort {
	public static void main(String[] args) {
		int[] nums = { 3, 2, 5, 6, 7, 1 };
		new QuickSort().quickSort(nums, 0, nums.length - 1);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

	public void quickSort(int[] nums, int begin, int end) {
		if (begin < end) {
			int stand = divide(nums, begin, end);
			quickSort(nums, begin, stand - 1);
			quickSort(nums, stand + 1, end);
		}
	}

	public int divide(int[] nums, int begin, int end) {
		int middle = nums[(begin + end) / 2];
		int left = begin;
		int right = end;

		while (left < right) {
			while ((nums[left] < middle) && (left < right)) {
				left++;
			}

			while ((nums[right] > middle) && (left < right)) {
				right--;
			}

			if (left < right) {
				int temp = nums[left];
				nums[left] = nums[right];
				nums[right] = temp;
			}

		}
		return left;
	}
}
