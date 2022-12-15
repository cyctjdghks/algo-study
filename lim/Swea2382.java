import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Swea2382 {
// SWEA: 미생물 격리
// 상하좌우: 1,2,3,4
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	static class Microbe {
		int num;
		int dir;
		public Microbe(int num, int dir) {
			this.num = num;
			this.dir = dir;
		}
	}
	static int n, m, k;
	static Microbe [][] map;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 넓이
			m = Integer.parseInt(st.nextToken()); // 격리시간 
			k = Integer.parseInt(st.nextToken()); // 군집 수
			map = new Microbe[n][n];
			for(int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				int k = Integer.parseInt(st.nextToken());
				map[x][y] = new Microbe(n, k);
			}
			for(int i = 0; i < m; i++) {
				move();
			}
			int res = count();
			System.out.println("#" + t + " " + res);
		}
	}
	private static int count() {
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == null) continue;
				cnt += map[i][j].num;
			}
		}
		return cnt;
	}
	private static void move() {
		ArrayList<Microbe>[][] nMap = new ArrayList[n][n];
		for(int i = 0; i < n; i++ ) {
			for(int j = 0; j < n; j++) {
				nMap[i][j] = new ArrayList<>();
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == null) continue;
				Microbe cur = map[i][j];
				int nx = i+dx[cur.dir-1];
				int ny = j+dy[cur.dir-1];
				if(nx == 0 || ny == 0 || nx == n-1 || ny == n-1) { // 경계점 처리
					if(cur.dir == 1 || cur.dir == 2) { // 방향 전환
						cur.dir = Math.abs(cur.dir-3);
					} else {
						cur.dir = Math.abs(cur.dir-7);
					}
					cur.num = cur.num/2; // 타노스 핑거스냅
					if(cur.num == 0) continue; // 가루가 되었다
				}
				nMap[nx][ny].add(cur);
			}
		}
		map = new Microbe[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(nMap[i][j].isEmpty()) continue;
				if(nMap[i][j].size() == 1) {
					map[i][j] = nMap[i][j].get(0);
				}
				int max = 0;
				int dir = 0;
				int sum = 0;
				for(int k = 0; k < nMap[i][j].size(); k++) {
					sum += nMap[i][j].get(k).num;
					if(max < nMap[i][j].get(k).num) {
						max = nMap[i][j].get(k).num;
						dir = nMap[i][j].get(k).dir;
					}
				}
				map[i][j] = new Microbe(sum, dir);
			}
		}
	}

}
