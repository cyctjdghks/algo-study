import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _12851 {
	static class Point {
		int num;
		int step;
		public Point(int num, int step) {
			super();
			this.num = num;
			this.step = step;
		}
	}
// 숨바꼭질 2
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n, k;
		int min = Integer.MAX_VALUE;
		int cnt = 0;
		boolean[] vst = new boolean[100001];
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(n, 0));
		vst[n] = true;
		while(!q.isEmpty()) {
			Point cur = q.poll();
			vst[cur.num] = true;
			if(min < cur.step) continue;
			if(cur.num == k) {
				if(cur.step < min) {
					min = cur.step;
					cnt = 1;
				} else if(cur.step == min) {
					cnt++;
				}
				continue;
			}
			if(cur.num+1 <= 100000 && !vst[cur.num+1]) q.add(new Point(cur.num+1, cur.step+1));
			if(0 <= cur.num-1 && !vst[cur.num-1]) q.add(new Point(cur.num-1, cur.step+1));
			if(cur.num*2 <= 100000 && !vst[cur.num*2]) q.add(new Point(cur.num*2, cur.step+1));
		}
		System.out.println(min);
		System.out.println(cnt);
	}

}
