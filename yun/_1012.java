import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * 1012 유기농 배추  
 * => dfs
 */

public class _1012 {

	static int[][] map;

	static void dfs(int x, int y, int n, int m) {
		// 종료 조건: 맵 벗어나거나, 배추 없음  
		if ( x < 0 || x >= n || y < 0 || y >= m || map[x][y] == 0 ) {
			return;
		}
		// 배추 심어졌으면 없애자 (방문 표시)  
		map[x][y] = 0;
		
		// 인접 배추 또 처리  
		dfs(x - 1, y, n, m);
		dfs(x + 1, y, n, m);
		dfs(x, y - 1, n, m);
		dfs(x, y + 1, n, m);
	}

	public static void main(String[] args) throws FileNotFoundException {
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt(); // 테케 개수

		for (int t = 0; t < T; t++) {
			int n = sc.nextInt(); // 가로 길이
			int m = sc.nextInt(); // 세로 길이
			int k = sc.nextInt(); // 배추 개수
			
			map = new int[n][m]; // 밭 정보

			// 배추 입력받기
			for (int i = 0; i < k; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				map[a][b] = 1;
			}

			// 밭 탐색
			int answer = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					// 배추 있다면
					if (map[i][j] == 1) {
						// 배추 없애자 (방문 표시) 
						map[i][j] = 0;
						
						// 인접 배추들은 지렁이가 필요 없다
						dfs(i - 1, j, n, m);
						dfs(i + 1, j, n, m);
						dfs(i, j - 1, n, m);
						dfs(i, j + 1, n, m);
						
						// 한 배추 모듬당 지렁이    
						answer++;
					}
				}
			}
			
			// 결과 출력  
			System.out.println(answer);
		}

	}

}
