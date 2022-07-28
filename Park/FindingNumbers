
import java.util.Arrays;
import java.util.Scanner;

public class FindingNumbers {

	static int N = 0;
	static int[] A;
	static int M = 0;
	static int[] num;

	public static void main(String[] args) {
		// 첫 줄에 자연수 N이 주어진다.
		// 다음 줄에 N개의 정수 A 행렬
		// 다음 줄에는 M이 주어지고
		// 다음 줄에는 M개의 수가 주어진다.
		// 이 수들이 A 행렬 안에 존재하는지 알아내면 된다.

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		A = new int[N];
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}

		M = sc.nextInt();
		num = new int[M];
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
		}

		// 이중 for 문을 사용하니 시간 초과가 발생함
		// 이분 탐색 활용
		// 이분 탐색 전 A 행렬을 정렬
		Arrays.sort(A);

		// num 배열의 값 한개씩 A배열에 있는지 배교
		for (int i = 0; i < num.length; i++) {
			System.out.println(BinarySearch(num[i]));
		}
	}

	public static int BinarySearch(int num) {
		int start = 0; // 탐색 시작 index
		int end = A.length - 1; // 탐색 끝 index
		int mid;

		while (start <= end) {
			mid = (start + end) / 2;

			if (num < A[mid]) {
				end = mid - 1;
			} else if (num > A[mid]) {
				start = mid + 1;
			} else {
				return 1;
			}
		}
		return 0;
	}
}
