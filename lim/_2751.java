package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
// 수 정렬하기2
public class _2751 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> arr = new ArrayList<>();
		// Arrays.sort는 dual-pivot 퀵정렬 수행 -> 보통의 경우 O(n*logn)이나, O(n^2)의 반례가 존재
		for(int i=0; i<n; i++) {
			arr.add(Integer.parseInt(br.readLine()));
		}
		Collections.sort(arr);
		// Collections.sort는 merge sort의 개선된 버전 -> 최악의 경우에도 O(n*logn) 보장
		
		for(int e : arr) {
			sb.append(e).append('\n');
		}
		System.out.println(sb);
	}
}
