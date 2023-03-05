import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10830 {

	static int n;
	static long b;
	static int[][] map;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		b = Long.parseLong(st.nextToken());
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()) % 1000;
			}
		}
		
		int[][] result = rec(map, b);
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static int[][] rec(int[][] mat, long e) {
		if(e == 1L) return mat;
		int[][] result = rec(mat, e/2);
		result = mult(result, result);
		if(e % 2 == 1L) result = mult(result, mat);
		return result;
	}

	private static int[][] mult(int[][] a, int[][] b) {
		int[][] result = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					result[i][j] += a[i][k] * b[k][j];
				}
				result[i][j] %= 1000;
			}
		}
		return result;
	}
}
