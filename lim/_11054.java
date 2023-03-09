import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _11054 {

	static int n;
	static int[] list;
	static int[] orr;
	static int[] nar;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new int[n];
		orr = new int[n];
		nar = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) list[i] = Integer.parseInt(st.nextToken());
		orr[0] = nar[0] = 1;
		for(int i = 1; i < n; i++) {
			int max = 1;
			for(int j = 0; j < i; j++) {
				if(list[j] < list[i] && max <= orr[j]) {
					max = orr[j]+1;
				}
			}
			orr[i] = max;
		}
		for(int i = 1; i < n; i++) {
			int max = orr[i];
			for(int j = 0; j < i; j++) {
				if(list[j] > list[i] && max <= nar[j]) {
					max = nar[j]+1;
				}
			}
			nar[i] = max;
		}
		int realMax = 1;
		for(int i = 0; i < n; i++) {
			realMax = Math.max(realMax, nar[i]);
		}
		System.out.println(realMax);
//		1 5 2 1 4 3 4 5 2 1
//		1 2 2 1 3 3 4 5 2 1 orr
//		1 2 3 4 3 4 3 5 6 7 nar
	}

}
