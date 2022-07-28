package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//1920 수 찾기
public class _1920 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 입력부
		
		Arrays.sort(arr); // 오름차순 정렬
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			find(Integer.parseInt(st.nextToken()), arr); // find함수 돌리기
		}
	}
	
	static void find(int n, int arr[]) { // 이분탐색 수행
		int first = 0, last = arr.length-1;
		int middle = 0;

		while(first<=last) { 
			middle = (last+first)/2; // 탐색 범위 절반씩 감소
			if(arr[middle] < n) { // 찾아야할 값이 현재 탐색 범위의 중간지점보다 크면
				first = middle+1; // 중간지점이 탐색 범위의 새로운 왼쪽 끝이 된다.
			} else if(arr[middle] > n) { // 찾아야할 값이 현재 탐색 범위의 중간지점보다 작으면 
				last = middle-1; // 중간지점이 탐색 범위의 새로운 오른쪽 끝이 된다.
			} else {
				System.out.println(1); // 중간지점과 찾아야할 값이 일치하는 경우
				return;
			}
		}
		System.out.println(0); //반복문을 모두 수행했으나 찾지 못한 경우
	}
}
