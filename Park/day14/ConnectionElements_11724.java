import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConnectionElements_11724 {

	static ArrayList<Integer>[] list;
	static boolean[] v;
	
	public static void main(String[] args) {
		// 정점의 개수 N
		// 간선의 개수 M
		// 방향 없는 그래프 => 양방향 그래프
		// 연결 요소의 개수 => 그래프 갯수
		
		int N, M;
		int x, y;
		int count;
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		list = new ArrayList[N+1];
		v = new boolean[N+1];
		count = 0;
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0;i < M; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			list[x].add(y);
			list[y].add(x);
		}
		
//		// 리스트 확인
//		for(int i = 1;i <= N; i++) {
//			for(int j = 0; j < list[i].size(); j++) {
//				System.out.print(list[i].get(j) + " ");
//			}
//			System.out.println();
//		}
		
		for (int i = 1; i <= N; i++) {
			if(v[i]) {
				continue;
			}
//			dfs(i);
			bfs(i);
			count++;
		}
		
		System.out.println(count);
	}
	
	static void dfs(int x) {
		v[x] = true;
		
		for(int i = 0; i < list[x].size(); i++) {
			if(!v[list[x].get(i)]) {
				dfs(list[x].get(i));
			}
		}
	}
	
	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(x);
		v[x] = true;
		
		int cnt;
		while(!q.isEmpty()) {
			cnt = q.poll();
			
			for(int i = 0; i < list[cnt].size(); i++) {
				if(!v[list[cnt].get(i)]) {
					q.offer(list[cnt].get(i));
					v[list[cnt].get(i)] = true;
				}
			}
		}
	}
}
