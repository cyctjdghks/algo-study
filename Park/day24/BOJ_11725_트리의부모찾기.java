import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_11725_트리의부모찾기 {

	static int N;
	static ArrayList<Integer>[] list;
	static int[] arr;
	static boolean[] v;
	
	public static void main(String[] args) {
		// 노드의 갯수 N (2 ≤ N ≤ 100,000)
		
		StringBuilder sb = new StringBuilder();
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		list = new ArrayList[N+1];
		arr = new int[N+1];
		v = new boolean[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < N-1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[x].add(y);
			list[y].add(x);
		}
		
		bfs();
		
		for(int i = 2; i <= N; i++) {
			sb.append(arr[i] + "\n");
		}
		
		System.out.println(sb);
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		v[1] = true;
		
		while(!q.isEmpty()) {
			int idx = q.poll();
			
			int size = list[idx].size();
			
			for(int i = 0; i < size; i++) {
				if(!v[list[idx].get(i)]) {
					arr[list[idx].get(i)] = idx;
					q.offer(list[idx].get(i));
					v[list[idx].get(i)] = true;
				}
			}
		}
		
		
	}

}
