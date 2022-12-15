import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea4013 {
	// 특이한 자석
	static int n, res;
	static boolean[][] magnets;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			res = 0;
			magnets = new boolean[4][8];
			for(int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 8; j++) {
					magnets[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
				}
			}
			// 입력
			for(int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int m = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				rotate(m-1, dir);
			}
			score();
			System.out.println("#" + t + " " + res);
		}
	}

	private static void score() {
		for(int i = 0; i < 4; i++) {
			if(magnets[i][0] == true) {
				res += Math.pow(2, i);
			}
		}
	}

	private static void rotate(int m, int dir) {
		boolean[] willR = new boolean[4];
		willR[m] = true;

		int i = m+1;
		while(i < 4) {
			if(magnets[i-1][2] != magnets[i][6]) {
				willR[i] = true;
			} else break;
			i++;
		}
		i = m-1;
		while(0 <= i) {
			if(magnets[i][2] != magnets[i+1][6]) {
				willR[i] = true;
			} else break;
			i--;
		}

		for(int z = 0; z < 4; z++) {
			if(willR[z]) {
				int curDir = 0;
				if(m % 2 == z % 2) {
					curDir = dir;
				} else {
					curDir = -dir;
				}
				if(curDir == 1) {
					boolean last = magnets[z][7];
					for(int x = 6; 0 <= x; x--) {
						magnets[z][x+1] = magnets[z][x];
					}
					magnets[z][0] = last;
				} else {
					boolean first = magnets[z][0];
					for(int x = 0; x < 7; x++) {
						magnets[z][x] = magnets[z][x+1];
					}
					magnets[z][7] = first;
				}
			}
		}
	}
}
