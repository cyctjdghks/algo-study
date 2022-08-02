import java.util.Scanner;

/*
 * BOJ 2798 - 블랙잭
 * n장 중 3장을 골라 합이 m을 넘지 않으면서 최대한 가깝게
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					if (sum <= m) {
						max = Math.max(max, sum);
					}
				}
			}
		}
		
		System.out.println(max);
	}

}
