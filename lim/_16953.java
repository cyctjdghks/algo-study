import java.io.FileInputStream;
import java.util.Scanner;

public class _16953 {
	static long a, b;
	static int res = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		a = sc.nextLong();
		b = sc.nextLong();
		rec(a, 0);
		if(res == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(res+1);
		}
	}

	private static void rec(long input, int step) {
		if(b < input || input <= 0) return;
		if(input == b) {
			res = Math.min(res, step);
			return;
		}
		rec(input*2, step+1);
		rec((input*10)+1, step+1);
	}

}
