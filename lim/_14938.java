import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m, r;
	static int[] items;
	static int[][] graph;
	static int[][] dist;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		items = new int[n];
		dist = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				dist[i][j] = 987654321;
			}
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			items[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			dist[a-1][b-1] = w;
			dist[b-1][a-1] = w;
		}
		
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(i == j) continue;
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		int result = 0;
		for(int i = 0; i < n; i++) {
			int sum = items[i];
			for(int j = 0; j < n; j++) {
				if(dist[i][j] <= m) sum += items[j];
			}
			result = Math.max(sum, result);
		}
		System.out.println(result);
	}

}
