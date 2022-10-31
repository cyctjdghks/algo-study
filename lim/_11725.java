import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _11725 {
// 트리의 부모 찾기
	static int n;
	static ArrayList<Integer>[] list;
	static int[] parents;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		parents = new int[n+1];
		for(int i = 0; i < n+1; i++) {
			parents[i] = -1;
			list[i] = new ArrayList<>();
		}
		parents[1] = 1;
		for(int i = 0; i < n-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		dfs(1);
		for(int i = 2; i < n+1; i++) {
			System.out.println(parents[i]);
		}
	}
	
	public static void dfs(int p) {
		int length = list[p].size();
		for(int i = 0; i < length; i++) {
			if(parents[list[p].get(i)] < 0) {
				parents[list[p].get(i)] = p;
				dfs(list[p].get(i));
			}
		}
	}
}
