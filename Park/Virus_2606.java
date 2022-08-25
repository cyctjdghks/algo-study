import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Virus_2606 {

	static int N;
	static ArrayList<Integer>[] map;
	static boolean[] v;
	static int count;
	
	public static void main(String[] args) {
		// 컴퓨터 수(정점 수) N
		// 1번 부터 번호가 매겨짐
		// 컴퓨터 쌍의 수(간선 수) L
		// 양방향 연결
		// bfs 사용
		// 연결 지점이 주어졌으니 배열이 아닌 리스트 사용
		// 1번 컴퓨터가 웜 바이러스에 걸렸을 때
		// => 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
		// => 1번이 포함되어있는 그래프? 의 갯수
		
		int L;
		int a, b;
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new ArrayList[N + 1];
		v = new boolean[N+1];
		count = 0;
		for(int i = 0; i <= N; i++) {
			map[i] = new ArrayList<Integer>();
		}
		L = sc.nextInt();
		for(int i = 0; i < L; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			map[a].add(b);
			map[b].add(a);
		}
		
//		// 리스트 확인
//		for (int i = 0; i <= N; i++) {
//			for (int j = 0; j < map[i].size(); j++) {
//				System.out.print(map[i].get(j) + " ");
//			}
//			System.out.println();
//		}
		
		bfs(1);
		
		System.out.println(count);
	}
	
	public static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(x);
		v[x] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
//			for(int i = 0; i < map[cur].size(); i++) {
//				if(v[map[cur].get(i)] == false) { 
//					q.offer(map[cur].get(i));
//					v[map[cur].get(i)] = true;
//					count++;
//				}
//			}
			
			for(Integer idx : map[cur]) {
				if(!v[idx]) { 
					q.offer(idx);
					v[idx] = true;
					count++;
				}
			}
		}
	}

}
