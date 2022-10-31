import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6064 {
// 카잉 달력
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for(int t = 0; t < tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			boolean can = false;
			for(int i = x; i <= n * m; i += m) {
				int mod = i % n == 0 ? n : i % n;
				if(mod == y) {
					can = true;
					System.out.println(i);
					break;
				}
			}
			if(!can) System.out.println(-1);
		}
	}

}
