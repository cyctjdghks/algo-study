package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BOJ_11779 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int from, to, cost;
		int N = Integer.parseInt(br.readLine()); // 도시의 개수 N (1 <= N <= 1,000) 
		int M = Integer.parseInt(br.readLine()); // 버스의 개수 M (1 <= M <= 100,000)
		int costArr[][] = new int [N+1][N+1]; // i 번째 도시에서 j 번째 도시까지 갈 수 있는 버스 비용 중 최소값 (0 <= C < 100,000)
		for(int i=0; i<=N; i++) {
			Arrays.fill(costArr[i], Integer.MAX_VALUE);
		}
		int minCost[] = new int[N+1];
		boolean v[] = new boolean[N+1];
		int past[] = new int[N+1]; // "시작점에서 i 번째 도시로 가는 최단 경로"에서 i 번째 도시 이전 순서에 위치하는 도시 번호 저장하는 배열 
		Arrays.fill(minCost, Integer.MAX_VALUE);
		String[] strArr;
		for(int i=0; i<M; i++) {
			strArr = br.readLine().split(" ");
			from = Integer.parseInt(strArr[0]);
			to = Integer.parseInt(strArr[1]);
			cost = Integer.parseInt(strArr[2]);
			// 출발-도착지가 같은 여러 버스가 있다면 제일 적은 버스의 비용만 저장
			costArr[from][to] = Math.min(cost, costArr[from][to]);
		}
		// 구하고자 하는 구간의 출발 도시번호, 도착 도시번호
		strArr = br.readLine().split(" ");
		from = Integer.parseInt(strArr[0]);
		to = Integer.parseInt(strArr[1]);
		
		minCost[from] = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(from);
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			while(queueSize-->0) {
				int now = queue.poll();
				if(v[now]) continue; // 이미 방문한 도시는 skip
				for(int i=1; i<=N; i++) {
					if(costArr[now][i] == Integer.MAX_VALUE) continue; // 갈 수 없는 도시는 skip 
					if(minCost[i] < minCost[now] + costArr[now][i]) continue; // 최소 비용일 수 없는 경우면 skip
					minCost[i] = minCost[now] + costArr[now][i]; // 최소 비용 갱신
					past[i] = now; // i번 째 이전 순서 도시 갱신
				}
				int next = Integer.MAX_VALUE;
				int nextPos = -1;
				v[now] = true; // 현재 방문한 도시 방문 처리
				// 남은 미 방문한 도시 중 출발지로 부터 비용이 가장 적은 도시 탐색
				for(int i=1; i<=N; i++){
					if(v[i]) continue;
					if(minCost[i] < next) {
						nextPos = i;
						next = minCost[i];
					}
				}
				if(nextPos == -1) continue;
				queue.offer(nextPos);
			}
		}
		Stack<Integer> stack = new Stack<Integer>();
		int search = to;
		stack.push(search);
		// 도착지로 부터 출발지 까지 역순으로 탐색하며 stack에 쌓음
		while(search != from) {
			stack.push(past[search]);
			search = past[search];
		}
		System.out.println(minCost[to]);
		System.out.println(stack.size());
		// 쌓은 순서대로 pop 하며 출력 ( 역순의 역순 )
		while(!stack.isEmpty()) {
			System.out.printf("%d ", stack.pop());
		}
	}
}
