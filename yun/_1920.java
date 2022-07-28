import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 1
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// binary search 위해 정렬
		Arrays.sort(arr);

		// 입력 2
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		// (sol1) 내장함수
//		for (int i = 0; i < m; i++) {
//			if (Arrays.binarySearch(arr, Integer.parseInt(st.nextToken())) >= 0) {
//				System.out.println(1);
//			} else {
//				System.out.println(0);
//			}
//		}

		// (sol2) 구현
		int[] arr2 = new int[m];
		for (int i = 0; i < m; i++) {
			arr2[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i < m; i++) {
			System.out.println(binarySearch(arr, arr2[i]));
		}

	}

	public static int binarySearch(int[] arr, int num) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;

		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] == num)
				return 1;
			else if (arr[mid] > num)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return 0;
	}

}
