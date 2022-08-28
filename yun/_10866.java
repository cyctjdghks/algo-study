package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Deque 덱 (Double-Ended Queue)
 * 
 * offerFirst(), offerLast()
 * pollFirst(), pollLast()
 * peekFirst(), peekLast()
 * size()
 */

public class _10866 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		Deque<Integer> deque = new ArrayDeque<>();
		
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			
			String[] s = br.readLine().split(" ");
			
			switch (s[0]) {
			case "push_front":
				deque.offerFirst(Integer.parseInt(s[1]));
				break;
			case "push_back":
				deque.offerLast(Integer.parseInt(s[1]));
				break;
			case "pop_front":
				sb.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
				break;
			case "pop_back":
				sb.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				sb.append(deque.isEmpty() ? 1 : 0).append("\n");
				break;
			case "front":
				sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
				break;
			case "back":
				sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
				break;
			}
		}
		
		System.out.println(sb);
		
	}

}
