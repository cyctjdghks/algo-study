import java.util.Scanner;

public class Boj9663 {
// N-Queen
	static int n;
	static int[][] map;
	static int res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		rec(0);
		System.out.println(res);
	}
	private static void rec(int row) {
		if(row == n) {
			res++;
			return;
		}
		for(int i = 0; i < n; i++) {
			map[row][i] = 1;
			if(good(row, i)) {
				rec(row+1);
			}
			map[row][i] = 0;
		}
	}
	private static boolean good(int row, int col) {
		for(int i = 1; i <= row; i++) {
			if(map[row-i][col] == 1) return false;
			if(0 <= col-i) {
				if(map[row-i][col-i] == 1) return false;
			}
			if(col+i < n) {
				if(map[row-i][col+i] == 1) return false;
			}
		}
		return true;
	}
}
