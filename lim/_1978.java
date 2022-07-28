package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 1978 소수 찾기
public class _1978 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int num = 0, sum = 0;
		for(int i=0; i<n; i++) {
			num = arr[i];
			for(int j=2; j<num+1; j++) {
				if(num == j) {
					sum += 1;
				}
				if(num % j == 0) {
					break;
				}
			}
		}
		System.out.println(sum);
	}
}
