import java.util.ArrayList;
import java.util.Scanner;

public class BOJ_11404_플로이드 {

	static int N, M;
	static int a, b, c;
	static int[][] dist;
	static int INF = 9999_9999;

	public static void main(String[] args) {
		// 도시 A에서 B로 가는데 필요한 비용의 최솟값
		// 도시의 개수 n
		// 버스의 개수 m
		// 버스의 시작 도시 a, 도착 도시 b, 한 번 타는데 필요한 비용 c 
		// 비용은 100,000보다 작거나 같은 자연수
		// i에서 j로 갈 수 없는 경우에는 그 자리에 0을 출력

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		dist = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					dist[i][j] = 0;
				else
					dist[i][j] = INF;
			}
		}

		for (int i = 0; i < M; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			dist[a][b] = Math.min(dist[a][b], c);
		}

		floyd();

		print();

	}

	private static void print() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (dist[i][j] == INF) {
					System.out.print(0 + " ");
				} else {
					System.out.print(dist[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	private static void floyd() {
		for (int k = 1; k <= N; k++) { // 거쳐가는 중간 지점 노드
			for (int i = 1; i <= N; i++) { // 시작 노드
				for (int j = 1; j <= N; j++) { // 도착 노드
					dist[i][j] = Math.min(dist[i][k] + dist[k][j], dist[i][j]); // 최단경로 초기화
				}
			}
		}
	}
}
