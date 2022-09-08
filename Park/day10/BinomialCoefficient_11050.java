import java.util.Scanner;

public class BinomialCoefficient_11050 {

	public static void main(String[] args) {
		// 이항 계수 공식 (n k)
		// => n! / (k!(n-k)!)
		// 팩토리얼 재귀 사용 시 스택오버플로우 발생

		int n, k;
		int result;

		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		k = sc.nextInt();

		result = fac(n) / (fac(k) * fac(n - k));

		System.out.println(result);
	}

	public static int fac(int n) {
		int i = 1;
		for (int j = 1; j <= n; j++) {
			i *= j;
		}
		return i;
	}

}
