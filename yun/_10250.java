import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * BOJ 10250 - ACM 호텔 
 */
public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();

			int x, y;
			if (n % h == 0) {
				x = h;
				y = n / h;
			} else {
				x = n % h;
				y = n / h + 1;
			}

			System.out.printf("%d%02d%n", x, y);
		}

	}

}
