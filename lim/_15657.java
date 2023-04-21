import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _15657 {

	static int n, m;
	static int[] nums;
	static int[] order;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		nums = new int[n];
		order = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
		rec(0, 0);
	}
	private static void rec(int start, int step) {
		if(m < step) return;
		if(step == m) {
			for(int i = 0; i < m; i++) {
				System.out.print(order[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = start; i < n; i++) {
			order[step] = nums[i];
			rec(i, step+1);
		}
	}

}
