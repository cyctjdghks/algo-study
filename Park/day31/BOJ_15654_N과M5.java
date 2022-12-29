import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15654_N과M5 {

	static int[] arr;
	static int[] output;
	static boolean[] v;
	
	public static void main(String[] args) {
		int N, M;
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		v = new boolean[N];
		output = new int[M];
		for(int i = 0 ; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 오름차순으로 정렬
		Arrays.sort(arr);
		
		// 조합으로 출력
		perm(N, M, 0);
	}

	// 조합
	private static void perm(int n, int m, int depth) {
		if(m == depth) {
			for(int i = 0; i < m; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!v[i]) {
				v[i] = true;
				output[depth] = arr[i];
				perm(n, m, depth+1);
				v[i] = false;
			}
		}
	}

}
