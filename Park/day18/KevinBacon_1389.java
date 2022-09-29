import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KevinBacon_1389 {

	static int N, M;
	static ArrayList<Integer>[] list;
	static boolean[] v;

	public static void main(String[] args) {
		// 유저의 수 N
		// 친구 관계의 수 M
		// 케빈 베이컨의 수란??
		// 임의의 두 사람이 이어질 수 있는 단계 의 합

		int x, y;
		int min = 9999_9999;
		int res = 0;

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		int sum;

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			list[x].add(y);
			list[y].add(x);
		}

//		// 리스트 확인
//		for (int i = 1; i <= N; i++) {
//			for (int j = 0; j < list[i].size(); j++) {
//				System.out.print(list[i].get(j) + " ");
//			}
//			System.out.println();
//		}

		// 1-2 와 2-1 의 케빈 베이컨의 수의 값은 같다
		// dfs가 효율적일까? bfs가 효율적일까?
		for (int i = 1; i <= N; i++) {
			sum = 0;
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;

				v = new boolean[N + 1];
				sum += bfs(i, j);
			}
			if (sum < min) {
				min = sum;
				res = i;
			}
		}
		System.out.println(res);

	}

	public static int bfs(int start, int end) {
		int cnt = 0;

		Queue<Integer> q = new LinkedList<>();

		q.offer(start);
		v[start] = true;

		loop: while (!q.isEmpty()) {
			int size = q.size();
			cnt++;
			for (int s = 0; s < size; s++) {
				int cur = q.poll();
				
				for (int i = 0; i < list[cur].size(); i++) {
					if (list[cur].get(i) == end) {
						break loop;
					}
					if (v[list[cur].get(i)])
						continue;

					v[list[cur].get(i)] = true;
					q.offer(list[cur].get(i));
				}
			}

		}

		return cnt;
	}

}
