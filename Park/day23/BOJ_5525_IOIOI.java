import java.util.Arrays;
import java.util.Scanner;

public class BOJ_5525_IOIOI {

	static int N, M;
	static char[] S;
	static char[] P;
	static int res;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		S = new char[M];
		P = new char[2*N + 1];
		res = 0;
		int p = P.length;
		String str = sc.next();
		for(int i = 0; i < M; i++) {
			S[i] = str.charAt(i);
		}
		for(int i = 0; i < p; i++) {
			if(i % 2 == 0) P[i] = 'I';
			else P[i] = 'O';
		}
		System.out.println(Arrays.toString(S));
		System.out.println(Arrays.toString(P));
		
		loop:
		for(int i = 0; i <= M-p; i++) {
			for(int j = 0; j < p; j++) {
				if(S[i+j] != P[j]) {
					continue loop;
				}
			}
			res++;
		}
		
		System.out.println(res);
	}

}
