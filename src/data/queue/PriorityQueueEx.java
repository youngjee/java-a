package data.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueEx {
	public static void main(String[] args) {
		int stock = 4;
		int[] dates = {4, 10, 15};
		int[] supplies = {20, 5, 10};
		int k = 30;
		
		PriorityQueueEx pqe = new PriorityQueueEx();
		System.out.println(pqe.solution(stock, dates, supplies, k));
	}
	public int solution(int stock, int[] dates, int[] supplies, int k) {
		Queue<Integer> priorityQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());
		
		int left =stock;
		int index = 0;
		int result = 0;
		for(int i=0; i<k; i++) {
			if(index<dates.length && dates[index]==i) {
				priorityQueue.add(supplies[index]);
				index++;
			}
			
			if(left==0) {
				left += priorityQueue.poll();
				result++;
			}
			
			left --;
		}
		return result;
	}
}
