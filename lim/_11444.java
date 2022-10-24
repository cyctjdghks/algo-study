import java.io.FileInputStream;
import java.util.Scanner;

public class _11444 {
// 피보나치 수 6
	static long n;
	static final long m = 1000000007l;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		n = sc.nextLong();
		// 입력
		System.out.println(fb(n)[0][1]);
	}

	/*
	 * |-            -|         |-   -| n
	 * |f(n+1) f(n)   |     =   | 1 1 |
	 * |f(n)   f(n-1) |         | 1 0 |
	 * |-            -|         |-   -|
	 */
	private static long[][] matMul(long[][] a, long[][] b) {
		long[][] arr = new long[2][2];
		arr[0][0] = (a[0][0] * b[0][0] % m + a[0][1] * b[1][0] % m) % m;
		arr[1][0] = (a[0][0] * b[0][1] % m + a[0][1] * b[1][1] % m) % m;
		arr[0][1] = (a[1][0] * b[0][0] % m + a[1][1] * b[1][0] % m) % m;
		arr[1][1] = (a[1][0] * b[0][1] % m + a[1][1] * b[1][1] % m) % m;
		return arr;
	}
	
	private static long[][] fb(long n) {
		if(n == 1 ) {
			return new long[][] {{1,1},{1,0}};
		}
		long[][] tmp = fb(n/2);
		if(n % 2 == 1) {
			return matMul(matMul(tmp, tmp), fb(1));
		} else {
			return matMul(tmp, tmp);
		}
	}
	
}
