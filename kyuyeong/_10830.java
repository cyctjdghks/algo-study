package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10830 {
	static int N, origin[][];
	public static void main(String[] args) throws IOException {
		long B;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		// 행렬의 크기 N, B제곱의 B
		N = Integer.parseInt(strArr[0]);
		B = Long.parseLong(strArr[1]);
		origin = new int[N][N];
		for(int i=0; i<N; i++) {
			strArr = br.readLine().split(" ");
			for(int j=0; j<N ;j++) {
				origin[i][j] = Integer.parseInt(strArr[j]);
			}
		}
		int ans[][] = pow(B);
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.printf("%d ", ans[i][j] % 1000);				
			}
			System.out.println();
		}
	}
	// 제곱 지수를 1/2으로 쪼개서 구하는 함수
	public static int[][] pow(long count){
		if(count == 1) {
			return origin;
		}
		int tmp[][] = pow(count/2);
		// 지수가 홀수면 A^(N/2) * A^(N/2) * A 
		if(count % 2 == 1) {
			return multi(multi(tmp, tmp), origin);
		} else {
			// 지수가 짝수면 A^(N/2) * A^(N/2)
			return multi(tmp, tmp);
		}
	}
	// 행렬 간 곱셈 해주는 함수
	public static int[][] multi(int left[][], int right[][]){
		int tmpArr[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				tmpArr[i][j] = 0;
				for(int k=0; k<N; k++) {
					tmpArr[i][j] += left[i][k] * right[k][j];
				}
				tmpArr[i][j] %= 1000;
			}
		}
		return tmpArr;
	}
}
