import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1780 {
// 종이의 개수
	static int n;
	static int[][] map;
	static int[] papers;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		papers = new int[3];
		map = new int[n][n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		rec(0, 0, n);
		System.out.println(papers[2]);
		System.out.println(papers[0]);
		System.out.println(papers[1]);
	}
	private static void rec(int x, int y, int size) {
		if(isSame(x, y, size)) {
			if(map[x][y] == -1) papers[2]++;
			else papers[map[x][y]]++;
			return;
		} else {
			int newSize = size/3;
			for(int i = 0; i < 9; i++) {
				int nx = x + (i % 3)*newSize;
				int ny = y + (i / 3)*newSize;
				rec(nx, ny, newSize);
			}
		}
	}
	private static boolean isSame(int x, int y, int size) {
		for(int i = x; i < x+size; i++) {
			for(int j = y; j < y+size; j++) {
				if(map[i][j] != map[x][y]) return false;
			}
		}
		return true;
	}
}
