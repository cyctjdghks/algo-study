import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj1167 {
// 트리의 지름
	static class Node{
		int to;
		int w;
		public Node(int to, int w) {
			this.to = to;
			this.w = w;
		}
	}
	static int n;
	static int res; 
	static ArrayList<Node>[] tree;
	static boolean vst[];
	static int start;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		tree = new ArrayList[n+1];
		vst = new boolean[n+1];
		for(int i = 0; i <= n; i++) {
			tree[i] = new ArrayList<>();
		}
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			while(true) {
				int to = Integer.parseInt(st.nextToken());
				if(to == -1) break;
				int w = Integer.parseInt(st.nextToken());
				tree[v].add(new Node(to, w));
			}
		}
		// 입력부
		dfs(1, 0);
		// 시작점 찾기
		vst = new boolean[n+1];
		res = 0;
		// 방문과 지름 초기화 후 찾아낸 시작점으로부터 dfs
		dfs(start, 0);
		System.out.println(res);
	}

	public static void dfs(int vertex, int dist) {
		vst[vertex] = true;
		int len = tree[vertex].size();
		for(int i = 0; i < len; i++) {
			Node tmp = tree[vertex].get(i);
			if(!vst[tmp.to]) {
				dfs(tmp.to, dist + tmp.w);
			}
		}
		// 말단 노드 도착
		if(res < dist) {
			res = dist; 
			start = vertex;
		}
	}
}
