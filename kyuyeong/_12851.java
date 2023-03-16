package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_12851 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strArr[] = br.readLine().split(" ");
		int N = Integer.parseInt(strArr[0]); // 수빈의 위치 (0 <= X <= 100,000)
		int K = Integer.parseInt(strArr[1]); // 동생의 위치 (0 <= X <= 100,000)
		int v[] = new int[100001]; // 각 위치에 도달할 수 있는 최소 시간 기록.
		Arrays.fill(v, Integer.MAX_VALUE); // 도달하는데 드는 최소 시간 배열 무한대로 초기화.
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(N);
		v[N] = 0;
		int time = 0;
		int count = 0;
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			while(queueSize-->0) {
				int now = queue.poll();
                // 동생 위치에 도착할 경우 탐색하지 않고 count 증가
				if(now == K) {
					count++;
					continue;
				}
                // X-1, X+1, X*2의 경우에 대해
                // 1) 각각 배열 범위 내인지 체크하고
                // 2) 해당 위치에 도달할 수 있는 최소의 경우의 수와 같거나 빠른 경우 큐에 추가(방문)
				if(now - 1 >= 0 && v[now-1] >= time) {
					queue.offer(now-1);
					v[now-1] = time;
				} 
				if(now + 1 <= 100000 && v[now+1] >= time) {
					queue.offer(now+1);
					v[now+1] = time;
				}
				if(now*2 <= 100000 && v[now*2] >= time) {
					queue.offer(now*2);
					v[now*2] = time;
				}
			}
            // 동생 위치에 도달했으면 탈출
			if(count!=0) break;
			time++;
		}
		System.out.println(time);
		System.out.println(count);
	}
}
