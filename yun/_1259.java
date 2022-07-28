import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int n = 0;
		int step = 0;
		boolean isPalindrom = true;

		// 0이 입력으로 주어질 때까지 반복 
		while (!str.equals("0")) {
			isPalindrom = true;

			n = str.length();
			step = (int) n / 2;	// 중간 index

			// 각각 앞, 뒤에서부터 문자 비교 
			for (int i = 0; i < step; i++) {
				if (str.charAt(i) != str.charAt(n - i - 1)) {
					isPalindrom = false;
					break;
				}
			}

			// 결과 출력 
			if (isPalindrom) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}

			str = sc.nextLine();
		}
	}

}
