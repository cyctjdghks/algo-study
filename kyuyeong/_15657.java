package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_15657 {
	static int N, M, list[], result[];
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line[] = br.readLine().split(" ");
		N = Integer.parseInt(line[0]);
		M = Integer.parseInt(line[1]);
		list = new int[N];
		result = new int[M];
		sb = new StringBuilder();
		line = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			list[i] = Integer.parseInt(line[i]);
		}
		Arrays.sort(list);
		combination(0, 0);
		System.out.println(sb.toString());
	}
	public static void combination(int cnt, int pos) {
		if(cnt == M) {
			for(int i=0; i<result.length; i++) {
				sb.append(result[i]);
				sb.append(" ");
			}
			sb.append("\n");
			return;
		}
		for(int i=pos; i<N; i++) {
			result[cnt] = list[i];
			combination(cnt+1, i);
		}
	}
}
