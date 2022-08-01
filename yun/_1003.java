
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * 백준 1003 - 피보나치 함수  
 * 
 * [다이나믹 프로그래밍]
 * 
 */

public class _1003 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[][] dp = new int[41][2]; // {0개수, 1개수}
		int[] nums;

		// input
		int t = Integer.parseInt(br.readLine());
		nums = new int[t];
		for (int i = 0; i < t; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}

		// dp 배열 초기화
		dp[0][0] = 1;
		dp[0][1] = 0;
		dp[1][0] = 0;
		dp[1][1] = 1;

		// dp 배열 계산
		for (int i = 2; i < 41; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
			dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
		}

		// 결과 출력
		for (int num : nums) {
			String s = dp[num][0] + " " + dp[num][1];
			bw.write(s + "\n");
			bw.flush();
		}
		
		br.close();
		bw.close();

	}

}
