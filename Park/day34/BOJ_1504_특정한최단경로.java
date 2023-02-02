import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1504_특정한최단경로 {

	// 1번 정점에서 N번 정점으로 최단 거리로 이동
	// 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다.

	// 첫째 줄에 정점의 개수 N과 간선의 개수 E가 주어진다.
	static int N, E;
	// 둘째 줄부터 E개의 줄에 걸쳐서 세 개의 정수 a, b, c
	// a번 정점에서 b번 정점까지 양방향 길이 존재하며, 그 거리가 c
	static int a, b, c;
	// 반드시 거쳐야 하는 두 개의 서로 다른 정점 번호 v1과 v2
	static int v1, v2;
	static ArrayList<Data>[] list;
	static int[] d;
	static boolean[] v;
	static final int INF = 200000000;
	// 첫째 줄에 두 개의 정점을 지나는 최단 경로의 길이를 출력한다. 그러한 경로가 없을 때에는 -1을 출력한다.
	static int res;

	public static void main(String[] args) {
		// 초기화
		res = -1;

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		E = sc.nextInt();

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Data>();
		}

		for (int i = 0; i < E; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			list[a].add(new Data(b, c));
			list[b].add(new Data(a, c));
		}
		v1 = sc.nextInt();
		v2 = sc.nextInt();

		// 1 -> v1 -> v2 -> N으로 가는 경우
		int res1 = 0;
		res1 += dijkstra(1, v1);
		res1 += dijkstra(v1, v2);
		res1 += dijkstra(v2, N);

		// 1 -> v2 -> v1 -> N으로 가는 경우
		int res2 = 0;
		res2 += dijkstra(1, v2);
		res2 += dijkstra(v2, v1);
		res2 += dijkstra(v1, N);

		res = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);

		System.out.println(res);

	}

	// 다익스트라 알고리즘
	public static int dijkstra(int start, int end) {
		d = new int[N + 1];
		Arrays.fill(d, INF);
		v = new boolean[N + 1];

		PriorityQueue<Data> q = new PriorityQueue<>();
		q.offer(new Data(start, 0));
		d[start] = 0;

		while (!q.isEmpty()) {
			Data data = q.poll();
			int node = data.node;

			if (!v[node]) {
				v[node] = true;

				for (int i = 0; i < list[node].size(); i++) {
					if (!v[list[node].get(i).node] && d[list[node].get(i).node] > d[node] + list[node].get(i).dis) {
						d[list[node].get(i).node] = d[node] + list[node].get(i).dis;
						q.offer(new Data(list[node].get(i).node, d[list[node].get(i).node]));
					}
				}

			}
		}

		return d[end];
	}

	static class Data implements Comparable<Data> {
		int node;
		int dis;

		public Data(int node, int dis) {
			this.node = node;
			this.dis = dis;
		}
		
		@Override
	    public int compareTo(Data o) {
	        return dis - o.dis;
	    }

	}

}
