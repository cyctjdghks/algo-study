import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int N, M, numbers[];
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		numbers = new int[M];
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		combination(0, 1);
		bw.flush();
		bw.close();
	}
	public static void combination(int cnt, int start) throws IOException {
		if(cnt == M) {
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<M; i++) {
				sb.append(numbers[i]);
				sb.append(" ");
			}
			sb.append("\n");
			bw.append(sb.toString());
			return;
		}
		for(int i=start; i<=N; i++) {
			numbers[cnt] = i;
			combination(cnt+1, i);
		}
	}
}