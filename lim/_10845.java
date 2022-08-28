import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj10845 {
// 큐
	public static void main(String[] args) throws Exception{
		Queue<Integer> q = new ArrayDeque<>();
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch (st.nextToken()) {
			case "push":
				q.add(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(q.isEmpty()) System.out.println(-1);
				else {
					System.out.println(q.poll());
				}
				break;
			case "size":
				System.out.println(q.size());
				break;
			case "empty":
				if(q.isEmpty()) System.out.println(1);
				else System.out.println(0);
				break;
			case "front":
				if(q.isEmpty()) System.out.println(-1);
				else {
					System.out.println(q.peek());
				}
				break;
			case "back":
				if(q.isEmpty()) System.out.println(-1);
				else {
					int t = 0;
					for(int x : q) t = x;
					System.out.println(t);
				}
				break;
			}

		}
	}

}
