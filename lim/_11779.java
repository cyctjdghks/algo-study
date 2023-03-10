import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class Node {
	int to;
	int w;
	public Node(int to, int w) {
		this.to = to;
		this.w = w;
	}
}

public class Boj11779 {
// 최소 비용 구하기 2
	static final int INF = Integer.MAX_VALUE;
	static int n, m, s, d;
	static ArrayList<Node>[] graph;
	static int[] before;
	static int[] dst;
	static boolean[] vst;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		graph = new ArrayList[n+1];
		before = new int[n+1];
		dst = new int[n+1];
		vst = new boolean[n+1];

		for(int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
			dst[i] = INF;
		}
		StringTokenizer st;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			graph[from].add(new Node(to, w));
		}
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		
		
		PriorityQueue<Node> pq = new PriorityQueue<>((Node n1, Node n2) -> n1.w - n2.w);
		dst[s] = 0;
		pq.offer(new Node(s, 0));
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			if(dst[cur.to] < cur.w) continue;
			for(Node next : graph[cur.to]) {
				if(cur.w + next.w < dst[next.to]) {
					dst[next.to] = cur.w + next.w;
					pq.offer(new Node(next.to, dst[next.to]));
					before[next.to] = cur.to;
				}
			}
		}
//		while(!pq.isEmpty()) {
//			Node cur = pq.poll();
//			if(vst[cur.to]) continue;
//			vst[cur.to] = true;
//			for(Node next : graph[cur.to]) {
//				if(!vst[next.to] && dst[cur.to] + next.w < dst[next.to]) {
//					dst[next.to] = dst[cur.to] + next.w;
//					pq.offer(new Node(next.to, dst[next.to]));
//					before[next.to] = cur.to;
//				}
//			}
//		}
		Stack<Integer> stk = new Stack<>();
		StringBuilder road = new StringBuilder();
		int cur = d;
		while(before[cur] != 0) {
			stk.push(cur);
			cur = before[cur];
		}
		stk.push(cur);
		int cnt = stk.size();
		while(!stk.isEmpty()) road.append(stk.pop() + " ");

		System.out.println(dst[d]);
		System.out.println(cnt);
		System.out.println(road);
	}
}
