import java.util.Scanner;

public class RightTriangle_4153 {

	public static void main(String[] args) {
		// 여러개의 테스트케이스
		// 0 0 0 이 입력되면 종료
		// 피타고라스 정리 활용
		// a^2 + b^2 = c^2

		int a;
		int b;
		int c;

		Scanner sc = new Scanner(System.in);

		while (true) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();

			if (a == 0 && b == 0 && c == 0) {
				break;
			}
			if (Math.pow(c, 2) == Math.pow(a, 2) + Math.pow(b, 2) || Math.pow(a, 2) == Math.pow(b, 2) + Math.pow(c, 2)
					|| Math.pow(b, 2) == Math.pow(a, 2) + Math.pow(c, 2)) {
				System.out.println("right");
			} else {
				System.out.println("wrong");
			}

		}
	}

}
