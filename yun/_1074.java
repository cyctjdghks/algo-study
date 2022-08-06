
import java.util.Scanner;

/*
 * BOJ 1074 - Z
 * 재귀
 */

public class _1074 {

	static int n, r, c;
	static int cnt = 0;
	static int[] dx = { 0, 0, 1, 1 };
	static int[] dy = { 0, 1, 0, 1 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();

		recursive(0, 0, (int) Math.pow(2, n)); // 행, 열, 길이
	}

	static void recursive(int x, int y, int len) {
		// 탐색할 사각형 내에 (r, c) 가 없으면 리턴
		if (!(x <= r && r < x + len && y <= c && c < y + len)) {
			cnt += len * len;
			return;
		}
		// 탐색하는 사각형이 2 * 2 라면 찾았다
		if (len == 2) {
			// 2 * 2 내에서 어느 위치인지 찾자
			for (int i = 0; i < 4; i++) {
				if ((x + dx[i]) == r && (y + dy[i]) == c) {
					System.out.println(cnt + i);
					return;
				}
			}

		}

		// 네 개의 사각형으로 쪼개서 탐색
		recursive(x, y, len / 2);
		recursive(x, y + len / 2, len / 2);
		recursive(x + len / 2, y, len / 2);
		recursive(x + len / 2, y + len / 2, len / 2);

	}

}
