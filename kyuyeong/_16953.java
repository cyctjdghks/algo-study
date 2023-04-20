package algorithm.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_16953 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l[] = br.readLine().split(" ");
		int A = Integer.parseInt(l[0]);
		int B = Integer.parseInt(l[1]);
		Queue<Long> queue = new LinkedList<>();
		queue.offer((long) A);
		int time = 1;
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			while(queueSize-->0) {
				long now = queue.poll();
				if (now == B) {
					System.out.println(time);
					return;
				} 
				// 1) 2를 곱한다.
				long multiple = now * 2;
				if(multiple <= B) {
					queue.offer(multiple);
				}
				// 2) 1을 수의 가장 오른쪽에 추가한다. 
				long addOne = now * 10 + 1;
				if(addOne <= B) {
					queue.offer(addOne);
				}
			}
			time++;
		}
		System.out.println(-1);
		return;
	}
}
