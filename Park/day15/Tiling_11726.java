import java.util.Scanner;

public class Tiling_11726 {

	public static void main(String[] args) {
		// 2*n 크기의 직사각형 (1 ≤ n ≤ 1,000)
		// 2*1, 1*2 타일로 채우는 방법의 수
		// 10,007로 나눈 나머지
		// n = 1 => 1
		// n = 2 => 2
		// n = 3 => 3 = 1 + 2
		// n = 4 => 5 = 3 + 2
		// n = 5 => 8 = 5 + 3
		// n = 6 => 13 = 8 + 5

		int n;
		int res = 0;
		int[] dp;

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		dp = new int[1000 + 1];
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i < n+1; i++) {
			dp[i] = (dp[i-1] + dp[i-2]) % 10007;
		}
		res = dp[n];
		res = res % 10007;
		System.out.println(res);
	}

}
