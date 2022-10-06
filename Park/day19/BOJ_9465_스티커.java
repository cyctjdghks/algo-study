import java.util.Scanner;

// BOJ 9465. 스티커
public class BOJ_9465_스티커 {

	public static void main(String[] args) {
		// n 열 (1 ≤ n ≤ 100,000)
		// 0,0 과 1,0 은 자기자신의 최대
		// 0,1 은 1,0의 dp값과 0,1의 값의 합이 최대
		// 1,1 은 0,0의 dp값과 1,1의 값의 합이 최대
		// 그 이후로는 최대값을 구하는 방법 2가지
		// 1. 대각선으로 쭉 이어져있는 경우
		// 2. 찢어지는 스티커를 공유하지 않는 모양의 경우

		int T;
		int N;
		int[][] map;
		int[][] dp;
		int res;

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[2][N];
			dp = new int[2][N];

			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			dp[0][0] = map[0][0];
			dp[1][0] = map[1][0];

			if (N > 1) {
				dp[0][1] = dp[1][0] + map[0][1];
				dp[1][1] = dp[0][0] + map[1][1];

				for (int i = 2; i < N; i++) {
					dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + map[0][i];
					dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + map[1][i];
				}
			}

			res = Math.max(dp[0][N - 1], dp[1][N - 1]);
			System.out.println(res);
		}
	}

}
