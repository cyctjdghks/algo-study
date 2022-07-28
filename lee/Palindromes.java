package solved.ac.lv2;

import java.util.Scanner;

public class Palindromes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {// input의 개수를 모르므로 input으로 0이 들어올 때까지 무한반복
			gotoDowngraded: while (true) {// break의 label을 활용한 goto 문 -> 반복문 안에 있을 때만 사용 가능(작성한 코드를 하나의 블록 안에 넣어도 될 때만
											// 사용
				// 가능)

				// 입력
				String pal = sc.next();
				int palNum = Integer.parseInt(pal);
				if (palNum == 0) {// 0이면 종료
					sc.close();
					return;
				}

				// 변수 선언
				int[] palArr;
				int temp = palNum;
				int temp1;
				int digits = 0;

				while (temp > 0) {// 입력의 자릿수
					if (temp / 10 > 0) {
						digits++;
					}
					temp /= 10;
				}
				digits++;

				// 변수 선언
				palArr = new int[digits];
				temp1 = digits;
				temp = palNum;
				int digitSlicer = (int) Math.pow(10, digits - 1);

				// 입력 변수를 각 자릿수별로 분리
				palArr[0] = palNum / digitSlicer;
				for (int i = 1; i < digits; i++) {
					temp = palNum / digitSlicer * digitSlicer;
					// int 연산의 버림 기능 사용
					// 예) palNum = 121
					// temp = 121 / 100 * 100;
					// ->temp = 1 * 100;
					// ->temp = 100;

					temp1 = palNum / (digitSlicer / 10) * (digitSlicer / 10);
					// 위와 비슷함
					// 예) palNum = 121
					// temp1 = 121 / 10 * 10;
					// temp1 = 12 * 10;
					// temp1 = 120;

					palArr[i] = (temp1 - temp) * 10 / digitSlicer;
					// palArr[1] = (120 - 100) / 10;
					// palArr[1] = 2;
					digitSlicer /= 10;
				}

				int digitsEvenOdd = digits % 2;
				for (int i = 0; i < digits - digitsEvenOdd; i++) {
					if (palArr[i] != palArr[digits - i - 1]) { // 앞자리 뒷자리 숫자 비교
						System.out.println("no");
						break gotoDowngraded;
					}
				}
				System.out.println("yes");
			}
		}

	}

}
