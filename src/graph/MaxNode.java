package graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MaxNode {
	public static int solution(int n, int[][] edge) {
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer>[] list = new ArrayList[n + 1];
		int answer = 0;
		int[] visit = new int[n + 1];
		int max = 0;
		
		for(int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < edge.length; i++) {
			list[edge[i][0]].add(edge[i][1]);
			list[edge[i][1]].add(edge[i][0]);
		}
		
		q.add(1);
		visit[1] = 1;
		while(!q.isEmpty()) {
			int x = q.poll();
			for(int i = 0; i < list[x].size(); i++) {
				if(visit[list[x].get(i)] == 0) {
					q.add(list[x].get(i));
					visit[list[x].get(i)] = visit[x] + 1;
					max = Math.max(visit[list[x].get(i)], max);
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			if(visit[i] == max) answer++;
		}
		
		return answer;
	}
	public static void main(String[] args) throws IOException{
		int n = 6;
		int[][] v = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(n, v));
	}
}
    

