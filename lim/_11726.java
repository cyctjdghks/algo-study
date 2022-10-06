import java.io.FileInputStream;
import java.util.Scanner;

public class Boj11726 {
// 2xn 타일링
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = 0, b = 1, res = 0;
		for(int i = 0; i < n; i++) {
			res = (a+b)%10007;
			a = b;
			b = res;
		}
		System.out.println(res);
	}
}
