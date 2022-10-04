import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1389 {
// 케빈 베이컨 6머시기
	static int[][] map;
	static int n, m;
	static int minBacon = Integer.MAX_VALUE;
	static int person;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a][b] = 1;
			map[b][a] = 1;
		}
		for(int i = 0; i < n; i++) {
			int res = bfs(i);
			if(res < minBacon) {
				minBacon = res;
				person = i;
			}
		}
		System.out.println(person+1);
	}
	static int bfs(int s) {
		int sum = 0;
		int[] vst = new int[n];
		for(int i = 0; i < n; i++) {
			vst[i] = -1;
		}
		vst[s] = 0;
		Queue<Integer> q = new ArrayDeque<>();
		q.add(s);
		while(q.size() != 0) {
			int tmp = q.poll();
			for(int i = 0; i < n; i++ ) {
				if(map[tmp][i] == 1 && vst[i] == -1) {
					q.add(i);
					vst[i] = vst[tmp]+1;
				}
			}
		}
		for(int i = 0; i < n; i++) {
			sum += vst[i];
		}
		return sum;
	}
}
