import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2096 {
	static int n;
	static int max[][];
	static int min[][];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		max = new int[n][3];
		min = new int[n][3];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				max[i][j] = min[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 1; i < n; i++) {
			max[i][0] += Math.max(max[i-1][0], max[i-1][1]);
			max[i][1] += Math.max(max[i-1][0], Math.max(max[i-1][1], max[i-1][2]));
			max[i][2] += Math.max(max[i-1][1], max[i-1][2]);

			min[i][0] += Math.min(min[i-1][0], min[i-1][1]);
			min[i][1] += Math.min(min[i-1][0], Math.min(min[i-1][1], min[i-1][2]));
			min[i][2] += Math.min(min[i-1][1], min[i-1][2]);
		}
		int maxx = Math.max(max[n-1][0], Math.max(max[n-1][1], max[n-1][2]));
		int minn = Math.min(min[n-1][0], Math.min(min[n-1][1], min[n-1][2]));
		System.out.println(maxx + " " + minn);

	}

}
