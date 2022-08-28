import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
// ACM 호텔
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for(int t = 0; t < tc; t++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int n = sc.nextInt();
			int floor, ho;
			if(n % h == 0) {
				floor = h;
			} else {
				floor = n % h;
			}
			if(n / h != (n-1)/h) {
				ho = (n-1)/h;
			} else {
				ho = n/h;
			}
			ho++;
			System.out.print(floor);
			if(ho < 10) System.out.print(0);
			System.out.println(ho);
		}
	}

}
