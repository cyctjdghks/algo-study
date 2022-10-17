import java.util.Scanner;

public class BOJ_2579_계단오르기 {

	static int N;
	static int[] map;
	static int[] dp;
	static int res;
	
	public static void main(String[] args) {
		// n 번째 위치에서
		// n+1 로 가거나 n+2로 간다
		// 둘다 가거나 n+3 으로 가는건 불가능
		// => n 번의 값을 구하기 위해서는
		// n + (n-1) 의 합과 n + (n-2) 의 합을 비교해야한다.
		// 이때 n-1 의 값을 가져올때 n-2 > n-1 > n 의 순서가 되면 안됨
		// 따라서 n-3 에서 n-1로 왔다가 n으로 와야됨
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N+1];
		res = 0;
		for(int i = 1; i <= N; i++) { 
			map[i] = sc.nextInt();
		}
		
		dp = new int[N+1];
		dp[1] = map[1];
		
		
		
		for(int i = 2; i <= N; i++) {
			if(i == 2) dp[2] = map[1]+map[2];
			if(i == 3) dp[3] = Math.max(map[1], map[2]) + map[3];
			if(i > 3) dp[i] = Math.max(dp[i-3] + map[i-1], dp[i-2]) + map[i];
		}
		
		res = dp[N];
		
		System.out.println(res);
	}

}
