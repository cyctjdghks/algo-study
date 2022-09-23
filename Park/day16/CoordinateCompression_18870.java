import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CoordinateCompression_18870 {

	public static void main(String[] args) {
		// N ( 1 ≤ N ≤ 1,000,000 )
		// Xi ( -10^9 ≤ Xi ≤ 10^9 )
		// 숫자가 작은 순서대로 0, 1, 2, 3, ... 으로 압축
		
		int N;
		int[] X;
		int[] res;
		HashMap<Integer, Integer> hash = new HashMap<>();
		int value = 0;
		StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		X = new int[N];
		res = new int[N];
		for(int i = 0; i < N; i++) {
			X[i] = sc.nextInt();
		}
		res = X.clone();
		
		Arrays.sort(X);
		for(int i = 0; i < N; i ++) {
			if(!hash.containsKey(X[i]))
				hash.put(X[i], value++);
		}
		
		for(int i = 0; i < N ; i++) {
   	 		sb.append(hash.get(res[i])).append(" ");
   	 	}
		
		System.out.println(sb);
	}

}
