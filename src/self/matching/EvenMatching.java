package self.matching;

import java.util.ArrayList;
import java.util.Scanner;

/* 이분매칭문제. 선택가능한 최대 세트수
 * 카페에는 N개의 커피 메뉴가 존재하고, 샌드위치는 M개가 존재한다고 가정하자. 각각의 커피마다 할인이 가능한 샌드위치가 존재한다. 예를들어 커피3과 샌드위치 1이나 2를 구매하게 된다면 세트 할인이 적용 된다. 

  해당 문제를 풀기 위해서 우선 필요한 입력값은 커피의 개수 N과 샌드위치의 개수 N이다. 그 아래에 i줄에서는 커피 i의 할을 메뉴 개수와 할인 샌드위치의 번호가 나온다.

Ex)
5 5
2 1 2
1 4
2 1 3
3 3 4 5
1 5


5 5
2 6 7
1 8
2 7 9
2 9 10
1 10


  출력값은 당연히 해당 이분 그래프의 최대 이분 매칭 수 이다.
 */
public class EvenMatching {

	public static ArrayList<Integer> mapping[];
	public static int answer;
	public static int[] Nmatching;
	public static int[] Mmatching;
	public static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		// Input
		int N = sc.nextInt();
		int M = sc.nextInt();

		mapping = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			int size = sc.nextInt();
			mapping[i] = new ArrayList<Integer>();

			for (int j = 0; j < size; j++) {
				int tmp = sc.nextInt();
				mapping[i].add(tmp);

			}
		}

		// algo
		answer = 0;
		Nmatching = new int[N + 1];
		Mmatching = new int[M + 1];
		//Mmatching = new int[100];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (matching(i))
				answer++;
		}

		// output
		System.out.println(answer);

	}

	public static boolean matching(int i) {

		visited[i] = true;

		for (int k = 0; k < mapping[i].size(); k++) {
			int j = mapping[i].get(k);
			if (Mmatching[j] == 0 || !visited[Mmatching[j]] && matching(Mmatching[j])) {
				Nmatching[i] = j;
				Mmatching[j] = i;
				return true;
			}

		}

		return false;
	}

}
