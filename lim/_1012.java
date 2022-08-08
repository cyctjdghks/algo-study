import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1012 {
	static int count = 0;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws Exception{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		int tc = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= tc; t++) {
			int m, n, k;
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			int[][] map = new int[n][m];
			for(int kk = 0; kk < k; kk++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				map[y][x]= 1;
			}
			// 입력
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					if(map[j][i] == 1) {
						dfs(i, j, map, n, m);
						count++;
					}
				}
			}

			System.out.println(count);
			count = 0;
		}
	}
	
	static void dfs(int x, int y, int[][] map, int n, int m) {
		int nx, ny;
		map[y][x] = 0;
		for(int d = 0; d < 4; d++) {
			nx = x + dx[d];
			ny = y + dy[d];
			if(0 <= nx && nx < m && 0 <= ny && ny < n) {
				if(map[ny][nx] == 1) {
					dfs(nx, ny, map, n, m);
				}
			}
		}
		return;
	}

}
