package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 큐 
 */

public class _10845 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Queue<Integer> q = new LinkedList<>();

		int n = Integer.parseInt(br.readLine());
		
		int last = 0;
		for (int i = 0; i < n; i++) {
			
			String[] s = br.readLine().split(" ");
			
			switch (s[0]) {
			case "push":
				last = Integer.parseInt(s[1]);
				q.offer(last);
				break;
			case "pop":
				sb.append(q.isEmpty() ? -1 : q.poll()).append("\n");
				break;
			case "size":
				sb.append(q.size()).append("\n");
				break;
			case "empty":
				sb.append(q.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front":
				sb.append(q.isEmpty() ? -1 : q.peek()).append("\n");
				break;
			case "back":
				sb.append(q.isEmpty() ? -1 : last).append("\n");
				break;
			}
		}
		
		System.out.println(sb);

	}

}
