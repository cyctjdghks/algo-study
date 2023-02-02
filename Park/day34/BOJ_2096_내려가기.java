import java.util.Scanner;

public class BOJ_2096_내려가기 {
	
	static int N;
	static int[][] map;
	static int[][] dp_max;
	static int[][] dp_min;
	static int res_max, res_min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		map = new int[N][3];
		dp_max = new int[N][3];
		dp_min = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();
			map[i][2] = sc.nextInt();
		}
		
		dp_max[0][0] = map[0][0];
		dp_max[0][1] = map[0][1];
		dp_max[0][2] = map[0][2];
		
		dp_min[0][0] = map[0][0];
		dp_min[0][1] = map[0][1];
		dp_min[0][2] = map[0][2];
		
		// 반대로 보면 자기 위치로 내려올 수 있는 곳은 바로 위와 바로 위의 수와 붙어 있는 수
		// j == 0 > 0, 1
		// j == 1 > 0, 1, 2
		// j == 2 > 1, 2
		for(int i = 1; i < N; i++) {
			dp_max[i][0] = map[i][0] + Math.max(dp_max[i-1][0], dp_max[i-1][1]);
			dp_max[i][1] = map[i][1] + Math.max(dp_max[i-1][0], Math.max(dp_max[i-1][1], dp_max[i-1][2]));
			dp_max[i][2] = map[i][2] + Math.max(dp_max[i-1][1], dp_max[i-1][2]);
		}
		
		for(int i = 1; i < N; i++) {
			dp_min[i][0] = map[i][0] + Math.min(dp_min[i-1][0], dp_min[i-1][1]);
			dp_min[i][1] = map[i][1] + Math.min(dp_min[i-1][0], Math.min(dp_min[i-1][1], dp_min[i-1][2]));
			dp_min[i][2] = map[i][2] + Math.min(dp_min[i-1][1], dp_min[i-1][2]);
		}
		
		res_max = Math.max(dp_max[N-1][0], Math.max(dp_max[N-1][1], dp_max[N-1][2]));
		res_min = Math.min(dp_min[N-1][0], Math.min(dp_min[N-1][1], dp_min[N-1][2]));
		System.out.println(res_max + " " + res_min);
		
	}

}
