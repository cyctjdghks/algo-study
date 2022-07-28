import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 입력 받기
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];

		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);

		// 배열 입력 받기 & 최댓값 찾기
		int MAX = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			MAX = Math.max(MAX, arr[i]);
		}

		// 2~ MAX까지 소수를 찾는다.
		boolean[] nums = new boolean[MAX + 1];
		nums[1] = true;	// 1은 소수 아니다.
		for (int i = 2; i <= MAX; i++) {
			// 소수 라면?
			if (nums[i] == false) {
				// 소수의 배수는 소수가 아님.
				for (int j = 2 * i; j <= MAX; j += i) {
					nums[j] = true;
				}
			}
		}

		// 소수를 나타낸 배열에 입력 수 넣어보며 개수 센다.
		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (nums[arr[i]] == false) {
				answer++;
			}
		}
		System.out.println(answer);
	}

}
