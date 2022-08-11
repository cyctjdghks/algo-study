import java.util.Scanner;

public class ACMHotel_10250 {

	public static void main(String[] args) {
		// 호텔 정문으로부터 거리가 가장 짧도록 방을 배정
		// 테스트 케이스 T
		// H, W, N
		// H 는 호텔 층수 = y
		// W 는 층 수 = x
		// N 은 몇 번째 손님

		int T;
		int H, W, N;
		int layer, room;
		int xxyy;

		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			layer = 0;
			room = 0;
			xxyy = 0;

			H = sc.nextInt();
			W = sc.nextInt();
			N = sc.nextInt();

			// xx01호 부터 쭉 채워진 후
			// xx02호 쭉 채워짐
			if( N % H == 0 ) {
				layer = H * 100;
			}
			else {
				layer = (N % H) * 100;
			}
			
			if( N % H == 0 ) {
				room = N / H;
			}
			else {
				room = (N / H) + 1;
			}

			xxyy = layer + room;
			
			System.out.println(xxyy);
		}
	}

}
