import java.util.Arrays;
import java.util.Scanner;

public class BOJ_15650_N과M2 {
	
	static int[] output;
	static boolean[] v;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		output = new int[M];
		v = new boolean[N];
		
		comb(N, M, 0, 0);
	}

	private static void comb(int N, int M, int depth, int start) {
		if(M == depth) {
//			System.out.println(Arrays.toString(output));
			for(int i = 0; i < output.length; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
				output[depth] = i+1;
				comb(N, M, depth+1, i+1);
				v[i] = false;
			}
		}
	}

}
