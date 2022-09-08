package com.ssafy.sort2;

import java.util.Arrays;
import java.util.Scanner;

/*
 
5
5
4
3
2
1

 */
public class Sort2_2751 {
	// N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = 0;
		int[] num;

		N = sc.nextInt();
		num = new int[N];
		int length = num.length;

		for (int i = 0; i < length; i++) {
			num[i] = sc.nextInt();
		}

		// 시간 초과
		Arrays.sort(num);
		// Arrays.sort()는 primitive arrays에 대해 Dual-Pivot Quicksort 을 수행한다.
		// 평균 시간복잡도가 O(nlogn)이지만 최악의 경우 시간복잡도는 O(n^2)
		// 퀵 정렬 알고리즘의 번형 버전 - 2개의 피봇으로 퀵 정렬
		// 선택정렬(O(n^2)), 삽입정렬(O(n^2)), 버블정렬(O(n^2))
		// 합병정렬(O(n log2(n))), 퀵정렬(O(n log2(n)) ~ O(n^2))
		// => 합병정렬 알고리즘 사용

		mergeSort(num, 0, length - 1);

		for (int i = 0; i < length; i++) {
			System.out.println(num[i]);
		}
	}

	public static void mergeSort(int[] arr, int start, int end) {
		// 원소가 2개 이상이라면
		if(start < end) {
			// 중앙 값을 구하고
			int mid = (start + end) / 2;
			// 중앙을 기준으로 2개의 그룹으로 분할
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			// 정렬 후 병합
			merge(arr, start, mid, end);
		}
	}

	public static void merge(int[] arr, int start, int mid, int end) {
		// 배열 복사
		// clone()은 단순히 객체에 저장된 값을 그대로 복사
		int[] tmp = new int[arr.length];
		tmp = arr.clone();
		
		/*
		 * part1: 왼쪽 그룹의 시작 인덱스
		 * part2: 오른쪽 그룹의 시작 인덱스
		 * index: 정렬된 값을 병합된 배열의 어떤 위치에 넣어야하는 지
		 */
		int part1 = start;
		int part2 = mid + 1;
		int index = start;
		
		// 두 그룹중 한쪽의 원소가 끝날때까지 반복 (정렬 & 합병)
		while(part1 <= mid && part2 <= end) {
			if(tmp[part1] <= tmp[part2]) {
				arr[index++] = tmp[part1++];
			} else {
				arr[index++] = tmp[part2++];
			}
		}
		
		// 왼쪽 그룹의 원소가 남는 경우 처리
		// (오른쪽 그룹의 원소가 남는 경우는 따로 처리하지 않아도 된다)
		for(int i=0; i<=mid-part1; i++) {
			arr[index+i] = tmp[part1+i];
		}
	}
}
