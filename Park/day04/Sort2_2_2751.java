package com.ssafy.sort2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sort2_2_2751 {

	public static void main(String[] args) {
		// Timsort는 시간 복잡도가 O(n) ~ O(nlogn)
		// Timsort란 합병정렬과 삽입정렬을 섞은 알고리즘
		// Collections.sort() 메소드 사용
		
		Scanner sc = new Scanner(System.in);

		int N = 0;
		List<Integer> arr = new ArrayList<>();
		
		N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
            arr.add(sc.nextInt());
        }
		Collections.sort(arr);
		
		for (int i = 0; i < N; i++) {
            System.out.println(arr.get(i));
        }

	}

}
