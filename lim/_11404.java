import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11404 {
// 플로이드
	static int n, m;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i==j) continue;
				map[i][j] = 10000000;
			}
		}
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[a-1][b-1] = Math.min(map[a-1][b-1], c);
		}
		fw();
		for(int i = 0; i < n; i++	) {
			for(int j = 0; j < n; j++) {
				if(map[i][j] == 10000000) System.out.print("0" + " ");
				else System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	private static void fw() {
		for(int k = 0; k < n; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
	}
}
