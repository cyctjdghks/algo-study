import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class Pair{
		int prevPos;
		int sumL;
		Pair(int prevPos, int sumL){
			this.prevPos = prevPos;
			this.sumL = sumL;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strArr[] = br.readLine().split(" ");
		int N = Integer.parseInt(strArr[0]);
		int M = Integer.parseInt(strArr[1]);
		int R = Integer.parseInt(strArr[2]);
		int area[] = new int[N+1];
		int cost[][] = new int[N+1][N+1];
		int shortestPath[] = new int[N+1];
		strArr = br.readLine().split(" ");
		for(int i=1; i<=N; i++) {
			area[i] = Integer.parseInt(strArr[i-1]);
		}
		for(int i=0; i<R; i++) {
			strArr = br.readLine().split(" ");
			int from = Integer.parseInt(strArr[0]);
			int to = Integer.parseInt(strArr[1]);
			int length = Integer.parseInt(strArr[2]);
			cost[from][to] = cost[to][from] = length;
		}
		Queue<Pair> queue = new LinkedList<Pair>();
		int MAX_ITEM = 0;
		// 각 지점으로 낙하
		for(int i=1; i<=N; i++) {
			shortestPath = new int[N+1];
			// 첫 낙하지점으로 부터 각 지점까지의 최단거리는 무한대로 초기화
			Arrays.fill(shortestPath, Integer.MAX_VALUE);
			shortestPath[i] = 0;
			int ROUND_TOTAL_ITEM = 0;
			queue.offer(new Pair(i, 0));
			while(!queue.isEmpty()) {
				int queueSize = queue.size();
				while(queueSize-->0) {
					Pair now = queue.poll();
					for(int j=1; j<=N; j++) {
						if(cost[j][now.prevPos] == 0) continue;
						int tmpL = cost[j][now.prevPos] + now.sumL;
						if(tmpL > M) continue;
						if(tmpL > shortestPath[j]) continue;
						// 여태까지의 j까지의 최단거리 > 현재 위치까지 거리+현재위치->j까지의 거리
						// 인것 이므로 최단거리 갱신
						shortestPath[j] = tmpL;
						queue.offer(new Pair(j, tmpL));
					}
				}
			}
			for(int j=1; j<=N; j++) {
				if(shortestPath[j] <= M) {
					ROUND_TOTAL_ITEM += area[j];
				}
			}
			MAX_ITEM = Math.max(MAX_ITEM, ROUND_TOTAL_ITEM);
		}
		System.out.println(MAX_ITEM);
	}
}
