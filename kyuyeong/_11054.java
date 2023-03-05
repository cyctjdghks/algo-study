package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11054 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int high[][] = new int[2][N]; // [0] -> 각 자리 원소 포함시 최대 수열길이, [1] -> 순열의 N 번째 자리의 값 
		int highLength = 0;
		int highPos = 0;
		int low[][] = new int[2][N]; // [0] -> 각 자리 원소 포함시 최대 수열길이, [1] -> 순열의 N 번째 자리의 값 
		int lowLength = 0;
		int lowPos = 0;
		String strArr[] = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
			if(i == 0) {
				high[0][i] = highLength;
				high[1][highLength++] = arr[i];
				continue;
			}
			// 최장 증가 부분 수열
			if(high[1][highLength-1] < arr[i]) {
				high[0][i] = highLength;
				high[1][highLength++] = arr[i];
				highPos = i;
			} else {
				high[0][i] = highLength;
				for(int j=0; j<highLength; j++) {
					if(high[1][j] >= arr[i]) {
						high[1][j] = arr[i];
						high[0][i] = j;
						break;
					}
				}
			}
		}
		for(int i=N-1; i>=0; i--) {
			if(i == N-1) {
				low[0][i] = lowLength;
				low[1][lowLength++] = arr[i];
				continue;
			}
			// 최장 감소 부분 수열
			if(low[1][lowLength-1] < arr[i]) {
				low[0][i] = lowLength;
				low[1][lowLength++] = arr[i];
				lowPos = i;
			} else {
				for(int j=0; j<lowLength; j++) {
					if(low[1][j] >= arr[i]) {
						low[1][j] = arr[i];
						low[0][i] = j;
						break;
					}
				}
			}
		}
		int highLow = 0;
		for(int i=0; i<N; i++) {
			highLow = Math.max(highLow, high[0][i] + low[0][i] + 1);
		}
		int MAX = Math.max(Math.max(highLength, lowLength), highLow);
		System.out.println(MAX);
	}
}
