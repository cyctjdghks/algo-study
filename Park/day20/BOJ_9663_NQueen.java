import java.util.Scanner;

public class BOJ_9663_NQueen {

	static int N;
	static int[] map;
	static int res;
	
	public static void main(String[] args) {
		// N (1 ≤ N < 15)
		// 퀸 N개를 서로 공격할 수 없게 놓는 문제
		// 퀸은 가로 세로 대각선 이동 가능 ( 8방위 )

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N];
		res = 0;
		
		search(0);
		System.out.println(res);
		
	}

	private static void search(int depth) {
		if(depth == N) {
			res++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			map[depth] = i;
			if(check(depth)) {
				search(depth+1);
			}
		}
	}

	private static boolean check(int col) {
		for(int i = 0; i < col; i++) {
			if(map[col] == map[i]) {
				return false;
			} else if(Math.abs(col - i) == Math.abs(map[col] - map[i])) {
				return false;
			}
		}
		return true;
	}
}
