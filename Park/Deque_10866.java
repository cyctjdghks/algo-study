import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Deque_10866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
		int N = Integer.parseInt(br.readLine());
		int back = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String type = st.nextToken();
			switch (type) {
			case "push_front":
				back = Integer.parseInt(st.nextToken());
				dq.addFirst(back);
				break;
			case "push_back":
				back = Integer.parseInt(st.nextToken());
				dq.addLast(back);
				break;
			case "pop_front":
				if (dq.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(dq.pollFirst()).append('\n');
				}
				break;
			case "pop_back":
				if (dq.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(dq.pollLast()).append('\n');
				}
				break;
			case "size":
				sb.append(dq.size()).append('\n');
				break;
			case "empty":
				if (dq.isEmpty()) {
					sb.append(1).append('\n');
				} else {
					sb.append(0).append('\n');
				}
				break;
			case "front":
				if (dq.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(dq.peekFirst()).append('\n');
				}
				break;
			case "back":
				if (dq.isEmpty()) {
					sb.append(-1).append('\n');
				} else {
					sb.append(dq.peekLast()).append('\n');
				}
				break;
			}
		}
		System.out.println(sb);
	}
}