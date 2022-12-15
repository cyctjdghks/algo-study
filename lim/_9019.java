import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _9019 {
// DSLR
	static class Data{
		int num;
		String cmd;
		public Data(int num, String cmd) {
			this.num = num;
			this.cmd = cmd;
		}
	}

	static int a, b;
	static boolean[] vst;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			Queue<Data> q = new LinkedList<>();
			vst = new boolean[10000];
			StringBuilder res = new StringBuilder();
			
			q.add(new Data(a, ""));
			while(!q.isEmpty()) {
				Data cur = q.poll();
				if(cur.num == b) { // 답 발견
					System.out.println(cur.cmd);
					break;
				}
				int d = d(cur.num);
				int s = s(cur.num);
				int l = l(cur.num);
				int r = r(cur.num);
				
				if(!vst[d]) {
					q.add(new Data(d, cur.cmd+"D"));
					vst[d] = true;
					res.append("D");
				}
				if(!vst[s]) {
					q.add(new Data(s, cur.cmd+"S"));
					vst[s] = true;
					res.append("S");
				}
				if(!vst[l]) {
					q.add(new Data(l, cur.cmd+"L"));
					vst[l] = true;
					res.append("L");
				}
				if(!vst[r]) {
					q.add(new Data(r, cur.cmd+"R"));
					vst[r] = true;
					res.append("R");
				}
			}
		}
	}

	private static int d(int n) {
		if(n * 2 > 9999) return (n * 2) % 10000;
		return n * 2;
	}

	private static int s(int n) {
		if(n == 0) return 9999;
		return n - 1;
	}

	private static int l(int n) {
		return n / 1000 + (n % 1000) * 10;
	}

	private static int r(int n) {
		return n % 10 * 1000 + n / 10;
	}
}
