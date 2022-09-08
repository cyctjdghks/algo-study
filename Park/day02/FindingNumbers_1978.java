package com.ssafy.findingnumbers;

import java.util.Scanner;

public class FindingNumbers_1978 {

	public static void main(String[] args) {
		// 첫 줄에 자연수 N이 주어진다.
		// 다음 줄에 N개의 정수 A 행렬
		// 다음 줄에는 M이 주어지고
		// 다음 줄에는 M개의 수가 주어진다.
		// 이 수들이 A 행렬 안에 존재하는지 알아내면 된다.
		
		Scanner sc = new Scanner(System.in);
		int N = 0;
		int[] A;
		int M = 0;
		int[] num;
		int result = 0;
		
		N = sc.nextInt();
		A = new int[N];
		for(int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}
		
		M = sc.nextInt();
		num = new int[M];
		for(int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
		}
		
		// num 행렬을 0부터 순서대로 꺼내서 해당 정수가 A 행렬에 있는지 확인
		// 있다면 1반환, 없다면 0 반환
		for(int i = 0; i < num.length; i++) {
			for(int j = 0; j < A.length; j ++) {
				if(num[i] == A[j]) {
					result = 1;
					break;
				} else {
					result = 0;
				}
			}
			System.out.println(result);
		}

	}

}
