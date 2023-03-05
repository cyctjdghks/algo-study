import java.util.*;
import java.io.*;

public class Softeer_5차기출_성적처리 {
	static int N; // N 명의 참가자, 3개의 대회
	static int[] map;
	static int[][] res;

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		PriorityQueue<Data> q = null;
		map = new int[N];
		res = new int[4][N];
		for (int i = 0; i < 4; i++) {
			q = new PriorityQueue<Data>();
			if (i < 3) {
				for (int j = 0; j < N; j++) {
					int s = sc.nextInt();
					q.add(new Data(s, j));

					map[j] += s;
				}
			} else if (i == 3) {
				for (int j = 0; j < N; j++) {
					q.add(new Data(map[j], j));
				}
			}

			int len = q.size();
			int rank = 0;
			int temp = -1;
			for (int l = 0; l < len; l++) {
				Data data = q.poll();

				if (data.score != temp) {
					res[i][data.index] = l + 1;
					rank = l + 1;
				} else {
					res[i][data.index] = rank;
				}

				temp = data.score;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(res[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());

	}

	public static class Data implements Comparable {
		int score;
		int index;

		public Data(int score, int index) {
			this.score = score;
			this.index = index;
		}

		@Override
		public int compareTo(Object o) {
			Data d = (Data) o;
			if (this.score < d.score)// 길이 비교
				return 1;
			else if (this.score > d.score)
				return -1;
			return 0;

		}
	}
}