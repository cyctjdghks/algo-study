import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1865 {
// 웜홀
	static class Node {
		int to;
		int time;
		public Node(int to, int time) {
			this.to = to;
			this.time = time;
		}
	}
	static int n, m, w;
	static int INF = 100_000_000;
	static int[] dst;
	static ArrayList<Node>[] list;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int tt = 0; tt < tc; tt++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			list = new ArrayList[n+1];
			dst = new int[n+1];
			for(int i = 0; i < n+1; i++) {
				list[i] = new ArrayList<>();
				dst[i] = INF;
			}
			for(int i = 0; i < m+w; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int t = Integer.parseInt(st.nextToken());
				if(m <= i) {
					list[s].add(new Node(e, -t));
				} else {
					list[s].add(new Node(e, t));
					list[e].add(new Node(s, t));
				}
			}
			// 입력
			if(bmf()) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	
	public static boolean bmf()	{
		dst[1] = 0;
		for(int i = 1; i < n; i++) {
			for(int j = 1; j < list.length; j++) {
				for(Node node : list[j]) {
					if(dst[node.to] > dst[j] + node.time) {
						dst[node.to]  = dst[j] + node.time;
					}
				}
			}
		}
		for(int j = 1; j < list.length; j++) {
			for(Node node : list[j]) {
				if(dst[node.to] > dst[j] + node.time) {
					return true;
				}
			}
		}
		return false;
	}
}
