import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1629 {
// 곱셈
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		long c = Integer.parseInt(st.nextToken());
		System.out.println(rec(a, b, c));
	}
	
	public static long rec(long a, long b, long c) {
		if(b == 1) {
			return a % c;
		}
		if(b % 2 == 0) { // 짝수
			long res = rec(a, b/2, c) % c;
			return (res * res) % c;
		} else { // 홀수
			long res = rec(a, b/2, c) % c;
			return (((res * res) % c) * a) % c;
		}
	}
}

