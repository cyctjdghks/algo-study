import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13172 {
	// 식음아
	static int p = 1000000007;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		long s = 0;
		long n = 1;
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int tn = Integer.parseInt(st.nextToken());
			int ts = Integer.parseInt(st.nextToken());
			s = (s * tn) + (n * ts);
			n *= tn;
			// 분수 더하기
			s %= p;
			n %= p;
		}
		if(s % n != 0) {
			System.out.println((s * rec(n, p-2)) % p);
		} else {
			System.out.println(s/n);
		}
	}

	private static long rec(long n, int x) {
		if(x == 1) return n;
		long result = rec(n, x/2);
		if(x % 2 == 1) {
			return (result * result) % p * n % p;
		} else {
			return result * result % p;
		}
	}

}
