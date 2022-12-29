import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11403_경로찾기 {

	static int N;
	static int[][] map;
	static int[][] res;
	static boolean[] v;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 그래프의 정점 수 입력
		N = sc.nextInt();
		// 그래프 선언
		map = new int[N][N];
		// 결과 그래프 선언
		res = new int[N][N];
		
		// 그래프 값 입력
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
//		print();
		
		// 각 지점마다 경로 찾기 - BFS
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				v = new boolean[N];
				bfs(i, j);
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void bfs(int x, int y) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		v[x] = true;
		
		loop:
		while(!q.isEmpty()) {
			int num = q.poll();
			
			for(int i = 0; i < N; i++) {
				if(map[num][i] == 1) {
					// 만약 우리가 원하는 위치면 1 설정 후 while 문 나가기 - return으로 bfs 종료해도 됨. 
					if(i == y) {
						res[x][y] = 1;
						break loop;
					}
					
					if(!v[i]) {
						q.offer(i);
						v[i] = true;
					}
				}
			}
		}
	}

	private static void print() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
