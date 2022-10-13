import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
// 가장 긴 증가하는 부분 수열
	public static void main(String[] args) throws Exception{
//		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] cnt = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			cnt[i] = 1;
		}
		for(int i = 0; i < n; i++) {
			int cur = arr[i];
			int c = 0;
			for(int j = i-1; 0 <= j; j--) {
				if(arr[j] < cur) c = Math.max(cnt[j], c);
			}
			cnt[i] = c+1;
		}
		int max = 0;
		for(int i = 0; i < n; i++) {
			max = Math.max(max, cnt[i]);
		}
		System.out.println(max);
	}

}
