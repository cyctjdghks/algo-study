import java.util.Scanner;

/*
 * 1018. 체스판 다시 칠하기
 * -> 브루트포스
 */

public class Main {

	static int[][] map;
	static int MIN = 64; // 다시 칠해야하는 개수의 최솟값

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		map = new int[n][m];

		// map 입력 받기
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == 'W') {
					map[i][j] = 0;
				} else {
					map[i][j] = 1;
				}
			}
		}
		
		// 왼쪽 위 칸 기준으로 8*8로 자른다.
		// 각 칸에 대해 탐색
		for (int i = 0; i < n - 7; i++) {
			for (int j = 0; j < m - 7; j++) {
				find(i, j);
			}
		}

		System.out.println(MIN);
	}

	public static void find(int x, int y) {
		int count = 0; // 다시 칠해야하는 칸 수

		int color = map[x][y]; // 첫 번째 칸 색

		// 잘린 8*8 체스판을 (i, j)를 기준으로 탐색
		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				// 색깔이 번갈아가며 나타남.
				if (map[i][j] != color) {
					count++;
				}
				color = (color == 1) ? 0 : 1;
				
			}
			color = (color == 1) ? 0 : 1;
		}

		// 첫 번째 칸 색의 반대색은 64 - count 개수다.
		count = Math.min(count, 64 - count);

		// 최솟값 체크
		MIN = Math.min(MIN, count);
	}

}
