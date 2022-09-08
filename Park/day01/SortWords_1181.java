import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SortWords_1181 {

	public static void main(String[] args) {
		// 입력
		Scanner sc = new Scanner(System.in);
		
		// 필요 인자들 초기화
		String[] words; // 입력 받은 단어들을 저장할 배열
		int N = 0; // 입력 받을 횟수
		String data = ""; // 입력 받을 단어를 저장할 String
		String[] compare; // 길이가 같을 경우 비교용
		String temp = ""; // 크기 다를 떄 변환용 String
		int num = 0; // compare 배열 넣을떄 넣는 숫자
		
		// 입력 받은 데이터들 초기화
		// 조건1 - 크기 순 정렬
		// 조건2 - 사전 순 정렬
		N = sc.nextInt();
		sc.nextLine();
		words = new String[N];
		for(int i = 0; i < N; i++) {
			data = sc.nextLine();
			words[i] = data;
		}
		
//		// 확인용
//		System.out.println(Arrays.toString(words));
//		Arrays.sort(words); // 알파벳순 정렬
//		System.out.println(Arrays.toString(words));
		
		for(int i = 0; i < words.length - 1; i++) { // 선택 알고리즘 기법 사용 - 길이순 정렬
			for(int j = i+1; j < words.length; j++) {
				if(words[i].length() > words[j].length()) {
					temp = words[j];
					words[j] = words[i];
					words[i] = temp;
				}
			}
		}
		for(int i = 0; i < words.length - 1; i++) { // 길이가 같은 배열끼리의 사전 순 재정렬
			for(int j = i+1; j < words.length; j++) {
				if(j == words.length - 1 || words[i].length() != words[j+1].length()) {
					if((j-i) <= 1) {
						break;
					}
					compare = new String[j-i+1];
					num = i;
					for(int x = 0; x < j-i+1; x ++) {
						compare[x] = words[num];
						num++;
					}
//					System.out.println(Arrays.toString(compare)); // 저장된 같은 길이의 행렬 확인
					Arrays.sort(compare); // 알파벳순 정렬
//					System.out.println("정렬");
//					System.out.println(Arrays.toString(compare)); // 정렬된 행렬 확인
					num = i;
					for(int x = 0; x < j-i+1; x ++) {
						words[num] = compare[x];
						num++;
					}
					i = j + 1; // 같은 길이까지는 이미 다 정렬했으니 다음 길이로 이동
					break; // 정렬은 다됐으니 j 탐색은 탈출
				}
			}
		}
		
		// 출력 - 중복단어의 경우 한번씩만 출력
		for(int i = 0; i < words.length; i++) {
			if(i >= 1) {
				if(!words[i].equals(words[i-1])) {
					System.out.println(words[i]);
				}
			} else {
				System.out.println(words[i]);
			}
		}
	}
}
