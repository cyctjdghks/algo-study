import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		String[] arr = new String[n];

		// 입력 받기
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLine();
		}

		// 정렬하기
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
                // 단어 길이가 같을 경우 
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);           // compareTo : 문자열 길이의 차를 리턴
				}
				return s1.length() - s2.length();
			}
		});
//		Arrays.sort(arr, (s1, s2) -> s1.length() - s2.length());

		// 중복 제거하며 출력
        System.out.println(arr[0]);
		for (int i = 1; i < n; i++) {
			if (!arr[i].equals(arr[i - 1])) {
				System.out.println(arr[i]);
			}
		}

	}

}
