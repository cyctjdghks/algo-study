import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _18870 {
//좌표 압축
	static class Pos implements Comparable<Pos>{
		int order;
		int val;
		public Pos(int order, int val) {
			this.order = order;
			this.val = val;
		}
		@Override
		public int compareTo(Pos o) {
			return val - o.val;
		}
	}
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Pos> list = new ArrayList<>();
		int[] orders = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			list.add(new Pos(i, Integer.parseInt(st.nextToken())));
		}
		Collections.sort(list);
		int cnt = -1;
		int pre = Integer.MAX_VALUE;
		for(Pos p : list) {
			if(pre != p.val) {
				cnt++;
			}
			pre = p.val;
			orders[p.order] = cnt;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			sb.append(orders[i] + " ");
		}
		System.out.println(sb);
	}
}
