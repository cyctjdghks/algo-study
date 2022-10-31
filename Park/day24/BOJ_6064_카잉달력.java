import java.util.Scanner;

public class BOJ_6064_카잉달력 {
	
	static int n, m;
	static int x, y;

	public static void main(String[] args) {
		
		int T;
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			boolean check = false;
			m = sc.nextInt();
			n = sc.nextInt();
			x = sc.nextInt() - 1;
			y = sc.nextInt() - 1;

			for (int i = x; i < (n * m); i += m) {
				if (i % n == y) {
					System.out.println(i + 1);
					check = true;
					break;
				}
			}

			if (!check) {
				System.out.println(-1);

			}
		}
	}
}
