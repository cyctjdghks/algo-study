import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj11724 {
// 연결 요소의 개수
	static int n, m;
	static ArrayList<Integer>[] list;
	static boolean[] vst;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList[n+1];
		vst=  new boolean[n+1];
		for(int i = 0; i <= n; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
			if(!vst[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	
	static public void dfs(int num) {
		vst[num] = true;
		for(int i : list[num]) {
			if(!vst[i]) {
				dfs(i);
			}
		}
	}

}
