package solved.ac.lv2;

import java.util.Scanner;

public class FindingPrimes {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int i = 0;
		int[] inputs = new int[N];
		while (i < N) {
			inputs[i] = sc.nextInt();
			i++;
		}
		sc.close();
		int primeCnt = 0;

		int cnt = i = 0;
		while (i < N) {
			int j = 2;
			while (j < inputs[i]) {
				if (inputs[i] % j == 0)
					cnt++;
				j++;
			}
			if (cnt == 0 && inputs[i] != 1) {
				primeCnt++;
			}
			i++;
			cnt = 0;
		}
		System.out.println(primeCnt);
	}

}