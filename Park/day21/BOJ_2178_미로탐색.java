import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2178_미로탐색 {

	static int N, M;
	static int[][] map;
	static boolean[][] v;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	// 상 하 좌 우
	static int res;
	
	public static void main(String[] args) {
		// 1, 1 => N, M
		// > 0, 0 => N-1, M-1
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		v = new boolean[N][M];
		for(int i = 0; i < N; i++) {
			String str = sc.next();
			for(int j = 0; j < M; j++) {
				map[i][j] = Character.getNumericValue(str.charAt(j));
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < M; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		
		
		bfs();
		
		System.out.println(res);
	}
	private static void bfs() {
		Queue<Data> q = new LinkedList<Data>();
		
		q.offer(new Data(0, 0, 0));
		v[0][0] = true;
		
		while(!q.isEmpty()) {
			Data data = q.poll();
			
			if(data.x == N-1 && data.y == M-1) {
				res = data.move + 1;
			}
			
			for(int d = 0; d < 4; d++) {
				int nx = data.x + dx[d];
				int ny = data.y + dy[d];
				
				if(isInBound(nx, ny) && !v[nx][ny] && map[nx][ny] == 1) {
					q.offer(new Data(nx, ny, data.move + 1));
					v[nx][ny] = true;
				}
			}
		}
	}
	
	public static boolean isInBound(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < M;
	}
	
	static class Data {
		int x, y;
		int move;
		public Data(int x, int y, int move) {
			super();
			this.x = x;
			this.y = y;
			this.move = move;
		}
	}

}
