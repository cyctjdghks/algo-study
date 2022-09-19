import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1932 {
// 정수 삼각형
	static int[][] map;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j <= i; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1; i < n; i++) {
			for(int j = 0; j <= i; j++) {
				int left = 0;
				int right = 0;
				if(0 < j) {
					left = map[i-1][j-1];
				}
				right = map[i-1][j];
				map[i][j] += Math.max(left, right);
			}
		}
		int max = 0;
		for(int i = 0; i < n; i++) {
			max = Math.max(max, map[n-1][i]);
		}
		System.out.println(max);
	}

}
