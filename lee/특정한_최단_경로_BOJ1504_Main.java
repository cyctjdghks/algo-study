package solved.category_Dijkstra.gold4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 특정한_최단_경로_BOJ1504_Main {

	static boolean visit[];
	static int field[][];
	static int N, E;

	static public void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int ans = 0;
		int v1, v2;
		int a, b, c;
		int i;

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		field = new int[N + 1][N + 1];
		visit = new boolean[N + 1];

		for (i = 1; i <= N; i++) {
			Arrays.fill(field[i], 99999999);
		}
		for (i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			field[a][b] = c;
			field[b][a] = c;
		}

		st = new StringTokenizer(br.readLine(), " ");
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		dikstraWithoutVisitCheck(1);
		Arrays.fill(visit, false);
		dikstraWithoutVisitCheck(N);
		Arrays.fill(visit, false);
		dikstraWithoutVisitCheck(v1);
		if (v1 != 1 || v2 != N) {
			if (v1 == 1) {
				ans = field[N][v2];
			} else if (v2 == N) {
				ans = field[1][v1];
			} else {
				if (field[1][v1] + field[N][v2] > field[1][v2] + field[N][v1]) {
					ans = field[1][v2] + field[N][v1];
				} else {
					ans = field[1][v1] + field[N][v2];
				}
			}
		}
		ans += field[v1][v2];

		if (ans >= 99999999) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}

	static void dikstraWithoutVisitCheck(int x) {
		int i, j, k;
		for (i = 1; i <= N; i++) {
			k = dijkstra(x);
			if (k == x) {
				break;
			}
			for (j = 1; j <= N; j++) {
				if (j != x && field[x][k] + field[k][j] < field[x][j]) {
					field[x][j] = field[x][k] + field[k][j];
				}
			}
		}
	}

	static int dijkstra(int x) {
		int tmp = Integer.MAX_VALUE;
		int idx = x;

		for (int i = 1; i <= N; i++) {
			if (field[x][i] != 99999999 && x != i && field[x][i] < tmp && !visit[i]) {
				tmp = field[x][i];
				idx = i;
			}
		}
		visit[idx] = true;
		return idx;
	}

}