package bakjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tree_1068 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = 0;
		List<Integer> xx = new ArrayList<Integer>();
		int delete = -1;
		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				n = Integer.valueOf(scanner.nextLine());
			} else if (i == 1) {
				String[] nums = scanner.nextLine().split(" ");
				for (int j = 0; j < nums.length; j++) {
					xx.add(Integer.valueOf(nums[j]));
				}
			} else {
				delete = Integer.valueOf(scanner.nextLine());
			}
		}

		System.out.println(new Tree_1068().run(n, xx, delete));
	}

	public int run(int n, List<Integer> xx, int delete) {
		for (int i = 0; i < n; i++) {
			if (i == 0 || xx.get(i) == -1) {
				tree = new Tree(i);
				treeList.add(tree);
			} else {
				Tree targetTree = new Tree(i);
				int parentNum = xx.get(i);
				Tree parent = treeList.get(parentNum);
				parent.childList.add(targetTree);

				treeList.add(targetTree);
			}
		}
		
		deleteNode(tree, delete);
		
		countNode(tree);
 
		return nodeCnt;
	}

	public void deleteNode(Tree target, int deleteNum) {
		if (target.childList.size() != 0) {
			for (int i = 0; i < target.childList.size(); i++) {
				if (target.childList.get(i).data == deleteNum) {
					target.childList.remove(i);
					target.isLast = true;
					return;
				} else {
					deleteNode(target.childList.get(i), deleteNum);
					
				}
			}
		}else {
			target.isLast = true;
		}
	}
	
	int nodeCnt = 0;
	
	public void countNode(Tree target) {
		if (target.childList.size() != 0) {
			for (int i = 0; i < target.childList.size(); i++) {
				countNode(target.childList.get(i));
			}
		}else {
			nodeCnt ++;
		}
	}

	

	private List<Tree> treeList = new ArrayList<Tree>();
	private Tree tree;

}

class Tree {
	int data;
	List<Tree> childList = new ArrayList<Tree>();
	boolean isLast = false;

	public Tree(int data) {
		this.data = data;
	}
}
