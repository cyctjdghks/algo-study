import java.util.Scanner;

public class IntegerTriangle_1932 {

	static int[][] arr;
	static Integer[][] dp;
	static int N;
	
	public static void main(String[] args) {
		// 삼각형 크기 n (1 ≤ n ≤ 500)
		// 둘째 줄부터 n+1번째 줄까지 정수 삼각형
		// 맨 위층 7부터 시작해서 아래에 있는 수 중 하나를 선택하여 아래층으로 내려올 때
		// 이제까지 선택된 수의 합이 최대가 되는 경로를 구하는 프로그램
		// https://st-lab.tistory.com/131
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		arr = new int[N][N];
		dp = new Integer[N][N];
 
        
		// 배열 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		// 가장 마지막 행의 값들을 DP의 마지막 행에도 똑같이 복사
				for (int i = 0; i < N; i++) {
					dp[N - 1][i] = arr[N - 1][i];
				}
		 
				System.out.println(find(0, 0));
	}
	
	static int find(int depth, int idx) {
		// 마지막 행일 경우 현재 위치의 dp값 반환
		if(depth == N - 1) return dp[depth][idx];
 
		// 탐색하지 않았던 값일 경우 다음 행의 양쪽 값 비교
		if (dp[depth][idx] == null) {
			dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1)) + arr[depth][idx];
		}
		return dp[depth][idx];
 
	}

}
