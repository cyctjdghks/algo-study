package solved.ac.lv2;

import java.util.Scanner;

public class FindingNumbers {

	public static void main(String[] args) {
		// 입력 및 변수 선언
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		boolean isExisting = false;
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		int[] B = new int[M];
		for (int i = 0; i < M; i++) {
			B[i] = sc.nextInt();
		}
		sc.close();

		// 전체 탐색: B배열 하나마다 A배열의 모든 수와 비교해서 isExisting값 바꾸기
		// question: isExisting 값을 넣지 않고 isExisting = true
		// 대신 직접 sysout(1) 출력하는 방법이 있을까요?
		//
		// 문제점: 1을 출력한 후 isExisting 없이는 0의 출력을 막을 방법이 마땅치 않습니다.
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (B[i] == A[j]) {
					isExisting = true;
				}
			}

			// goto: question:
			if (isExisting) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
			isExisting = false;
		}
	}

}
