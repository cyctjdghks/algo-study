import java.util.Scanner;

/*
 * 백준 2609 - 최대공약수와 최소공배수 
 * 두 자연수 입력 받아 최대공약수와 최소공배수 출력하기 
 * 
 * =>
 * [유클리드 호제법]
 * r = a % b 일 때, 
 * GCD(a, b) = GCD(b, r)
 * r이 0이면 그 때의 b가 최대공약수 이다.
 */

public class Main {
	
	public static int gcd(int a, int b) {
		while(b != 0) {
			int r = a % b;
			a = b;
			b = r;
		}
		return a;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int gcd = gcd(a, b);
		System.out.println(gcd);
		System.out.println(a * b / gcd);

	}

}
