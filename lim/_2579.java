import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2579 {
	// 계단 오르기
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			dp[i] = arr[i];
		}
		if(n == 1) {
			System.out.println(arr[0]);
			return;
		}
		dp[1] += arr[0];
		if(n == 2) {
			System.out.println(dp[1]);
			return;
		}
		dp[2] += Math.max(arr[0], arr[1]);
		for(int i = 3; i < n; i++) {
			dp[i] += Math.max(dp[i-3] + arr[i-1], dp[i-2]);
		}
		System.out.println(dp[n-1]);		
	}

}
