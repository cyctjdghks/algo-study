import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class CodeBattle02 {
// 코드 배틀 No.2 헌터
	static class P {
		int x, y, depth;

		public P(int x, int y, int depth) {
			this.x = x;
			this.y = y;
			this.depth = depth;
		}
	}
	static int n;
	static int monster = 0;
	static int[][] map;
	static int[] kill;
	static int minTime = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			monster = 0;
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					monster = Math.max(monster, map[i][j]);
				}
			}
			minTime = Integer.MAX_VALUE;
			kill = new int[monster+1];
			//초기화 및 입력부

			bfs(0, 0, 0, kill);
			System.out.println("#" + t + " " + minTime);
		}
	}

	public static void bfs(int x, int y, int time, int[] kill) {
		boolean[][] vst = new boolean[n][n];
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		Queue<P> q = new ArrayDeque<>();
		q.add(new P(x, y, 0));
		vst[x][y] = true;
		while(!q.isEmpty()) {
			P cur = q.poll();
			// 미방문한 몬스터 찾아가기
			if(0 < map[cur.x][cur.y] && kill[map[cur.x][cur.y]] == 0) {
				// 몬스터 죽이기
				kill[map[cur.x][cur.y]] = 1;
				// 몬스터 죽인 상태로 다시 BFS (헌터가 이동 )
				bfs(cur.x, cur.y, time+cur.depth, kill);
				// 이번 몬스터를 살려두는 다른 경우의 수를 찾는다.
				kill[map[cur.x][cur.y]] = 0;
			}
			// 미방문한 고객 찾아가기
			if(map[cur.x][cur.y] < 0 && kill[Math.abs(map[cur.x][cur.y])] == 1) {
				// 사냥완료한 몬스터 고객 찾아가기
				kill[Math.abs(map[cur.x][cur.y])] = 2;
				// 고객 방문하고 다시 BFS( 헌터가 이동 )
				bfs(cur.x, cur.y, time+cur.depth, kill);
				// 이번 고객을 스킵하는 다른 경우의 수를 찾는다.
				kill[Math.abs(map[cur.x][cur.y])] = 1;
			}
			// 너비 우선 탐색
			for(int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if(nx < 0 | n <= nx | ny < 0 | n <= ny) continue;
				if(!vst[nx][ny]) {
					q.add(new P(nx, ny, cur.depth+1));
					vst[nx][ny] = true;
				}
			}	
		}
		// 모든 몬스터를 사냥하고 고객까지 방문했는지 검사
		for(int i = 1; i <= monster; i++) {
			if(kill[i] != 2) return; // 덜한게 있으니 리턴
		}
		// 모두 사냥했으면 최소 사냥시간 업데이트 
		minTime = Math.min(minTime, time);
	}
}
