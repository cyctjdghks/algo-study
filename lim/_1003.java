package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 피보나치 함수
public class _1003 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m;
		for(int i=0; i<n; i++) {
			m = Integer.parseInt(br.readLine());
			int[][] arr = new int[2][m+2];
			arr[0][0] = 1;
			arr[1][1] = 1;
			for(int j=2; j<m+1; j++) {
				arr[0][j] = arr[0][j-1] + arr[0][j-2];
				arr[1][j] = arr[1][j-1] + arr[1][j-2];
			}
			System.out.printf("%d %d%n", arr[0][m], arr[1][m]);
		}
	}
}
