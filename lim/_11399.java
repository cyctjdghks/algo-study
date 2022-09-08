import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj11399 {
// ATM
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int res = 0;
		int[] wait = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			wait[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(wait);
		res = wait[0];
		for(int i = 1; i < n; i++) {
			wait[i] += wait[i-1];
			res += wait[i];
		}
		System.out.println(res);
	}
}
