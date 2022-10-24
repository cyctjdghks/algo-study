import java.util.Scanner;

public class BOJ_5525_IOIOI_2 {

	static int N, M;
	static char[] S;
	static int res;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		S = new char[M];
		res = 0;
		String str = sc.next();
		for (int i = 0; i < M; i++) {
			S[i] = str.charAt(i);
		}
//		System.out.println(Arrays.toString(S));

		int cnt = 0;
		for (int i = 1; i < M - 1; i++) {
			if (S[i - 1] == 'I' && S[i] == 'O' && S[i + 1] == 'I') {
				cnt++;

				if (cnt == N) { // N 은 O 의 갯수랑 같음
					cnt--;
					res++;
				}
				i++;
			} else {
				cnt = 0;
			}
		}

		System.out.println(res);
	}

}
