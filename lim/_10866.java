import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj10866 {
// 덱
	public static void main(String[] args) throws Exception{
		Deque<Integer> dq = new LinkedList<>();
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push_front":
				dq.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back":
				dq.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front":
				if(dq.isEmpty()) System.out.println(-1);
				else {
					System.out.println(dq.pollFirst());
				}
				break;
			case "pop_back":
				if(dq.isEmpty()) System.out.println(-1);
				else {
					System.out.println(dq.pollLast());
				}
				break;
			case "size":
				System.out.println(dq.size());
				break;
			case "empty":
				if(dq.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;
			case "front":
				if(dq.isEmpty()) System.out.println(-1);
				else {
					System.out.println(dq.peekFirst());
				}
				break;
			case "back":
				if(dq.isEmpty()) System.out.println(-1);
				else {
					System.out.println(dq.peekLast());
				}
				break;
			}

		}
	}

}
