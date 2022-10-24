import java.util.Scanner;

public class BOJ_11444_피보나치수6 {

	public static void main(String[] args) {
		// n은 1,000,000,000,000,000,000보다 작거나 같은 자연수
		// Fn = Fn-1 + Fn-2 (n ≥ 2)
		
		long N;
		long[] arr;
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextLong();
		
		if(N == 1) {
			System.out.println(1);
			System.exit(0);
		}
		
//		System.out.println(N);
		
		arr = new long[(int) N+1];
		arr[0] = 0;
		arr[1] = 1;
		for(int i = 2; i <= N; i++) {
			arr[i] = (arr[i-1] + arr[i-2]) % 1000000007;
		}
		long res = arr[(int) N] % 1000000007;
		
		System.out.println(res);
	}

}
