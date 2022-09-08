import java.util.Scanner;

public class RGBDistance_1149 {

	static int N;
	static int[][] house;
	static int min = 9999_9999;

	public static void main(String[] args) {
		// N 개의 집
		// 1 ~ N 번까지
		// 빨 초 파 로 칠해야한다.
		// 1번 집은 2번 집의 색과 달라야한다.
		// N번 집은 N-1번 집의 색과 달라야한다.
		// i번 집은 i-1, i+1번 집과 다랄야한다.
		// => 인접해 있으면 달라야 함
		// 집의 수 N
		// 빨 초 파 비용
		// 모든 집을 칠하는 비용의 최소값

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		house = new int[N][3];

		for (int i = 0; i < N; i++) {
			house[i][0] = sc.nextInt(); // 빨
			house[i][1] = sc.nextInt(); // 초
			house[i][2] = sc.nextInt(); // 파
		}

//		// 배열 확인
//		for (int i = 0; i < N; i++) {
//			System.out.println(house[i][0] + " " + house[i][1] + " " + house[i][2]);
//		}

		// 각 행에서 1개 선택
		// i번째 행은 i-1, i+1과 달라야함
		// 빨 초 파 에서 순서대로 출발
		// 현재의 열 을 제외한 다음 행의 나머지 2개의 열 값을 비교 후 더 작은 값으로 탐색
		// 현재의 작은 값이랑 큰 값의 차이와 다음 행의 작은 값이랑 큰 값의 차이에 따라 예외 발생 - tc 5번
		for (int i = 0; i < 3; i++) {
			search(0, i, 0);
		}

		System.out.println(min);

	}

	public static void search(int r, int c, int num) {
		num += house[r][c];

		if (r == N - 1) {
			min = Math.min(min, num);
			return;
		}

		switch (c) {
		case 0:
			search(r + 1, 2, num);
			search(r + 1, 1, num);
//			if(house[r+1][1] > house[r+1][2]) {
//				search(r+1, 2);
//			} else {
//				search(r+1, 1);
//			}
			break;
		case 1:
			search(r + 1, 0, num);
			search(r + 1, 2, num);
//			if(house[r+1][0] > house[r+1][2]) {
//				search(r+1, 2);
//			} else {
//				search(r+1, 0);
//			}
			break;
		case 2:
			search(r + 1, 0, num);
			search(r + 1, 1, num);
//			if(house[r+1][0] > house[r+1][1]) {
//				search(r+1, 1);
//			} else {
//				search(r+1, 0);
//			}
			break;
		default:
			break;
		}
	}

}
