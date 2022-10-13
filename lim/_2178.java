import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj2178 {
// 미로 탐색
	static class P {
		int x; 
		int y;
		int depth;
		public P(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
	static int n, m;
	static boolean[][] map;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			for(int j = 0; j < m; j++) {
				if(s.charAt(j) == '0') map[i][j] = true;
			}
		}
		bfs();
	}
	private static void bfs() {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
 		Queue<P> q = new ArrayDeque<>();
		q.add(new P(0, 0, 1));
		map[0][0] = true;
		while(!q.isEmpty()) {
			P cur = q.poll();
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx < 0 || n <= nx || ny < 0 || m <= ny || map[nx][ny]) continue;
				if(nx == n-1 && ny == m-1) {
					System.out.println(cur.depth+1);
					return;
				}
				map[nx][ny] = true;
				q.add(new P(nx, ny, cur.depth+1));
			}
		}
	}
}
