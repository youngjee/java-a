package 완전탐색;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class nPr {

	public static void main(String[] args) {
        int n = 3;
        int[] arr = {1, 2, 3};
        int[] output = new int[n];
        boolean[] visited = new boolean[n];

        nPr fp = new nPr();
        System.out.println("사전순 순열");
        fp.perm(arr, output, visited, 0, n, 2);
        System.out.println();
        System.out.println("순열");
        fp.permutation(arr, 0, n, 2);
    }

    // 사전순으로 순열 구하기
    // 사용 예시: perm(arr, output, visited, 0, n, 3);
    void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            print(output, r);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
    
    HashSet<Integer> numSet = new HashSet<Integer>();

    // 순열 구하기
    // 사용 예시: permutation(arr, 0, n, 4);
    void permutation(int[] arr, int depth, int n, int r) {
        if (depth == r) {
            print(arr, r);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
    
    void addNumSet(int[] nums) {
    	int num = nums[0];
    	for (int i = 1; i < nums.length; i++) {
			num = num + nums[i]*10;
		}
    	numSet.add(num);
    	
    }
    
    
    // 배열 출력
    void print(int[] arr, int r) {  
        for (int i = 0; i < r; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
}
