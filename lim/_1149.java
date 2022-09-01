import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1149 {
// RGB 거리
	static int n;
	static int[][] homes;
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		homes = new int[n][3];
		StringTokenizer st;
		// 입력
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			homes[i][0] = Integer.parseInt(st.nextToken());
			homes[i][1] = Integer.parseInt(st.nextToken());
			homes[i][2] = Integer.parseInt(st.nextToken());
		}
		// DP
		for(int i = 1; i < n; i++) {
			homes[i][0] += Math.min(homes[i-1][1], homes[i-1][2]);
			homes[i][1] += Math.min(homes[i-1][0], homes[i-1][2]);
			homes[i][2] += Math.min(homes[i-1][0], homes[i-1][1]);
		}
		System.out.println(Math.min(homes[n-1][0], Math.min(homes[n-1][1], homes[n-1][2])));
	}
}
