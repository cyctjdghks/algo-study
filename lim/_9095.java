import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj9095 {
// 1, 2, 3 더하기
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 0; t < tc; t++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[12];
			arr[1] = 1;
			arr[2] = 2;
			arr[3] = 4;
			for(int i = 4; i <= n; i++) {
				arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
			}
			System.out.println(arr[n]);
		}
	}

}
