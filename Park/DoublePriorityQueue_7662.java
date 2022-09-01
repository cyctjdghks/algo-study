import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DoublePriorityQueue_7662 {

	public static void main(String[] args) throws IOException {
		// 테스트 케이스 T
		// 입력 데이터 수 k
		// D 또는 I + 정수 n
		// I 는 큐에 삽입
		// D 1 은 큐에 최대값 삭제
		// D -1 은 큐에 최소값 삭제
		// 만약 Q가 비어있다면 ‘EMPTY’를 출력

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		// 테스트 케이스 T 만큼 반복
		for (int tc = 1; tc <= T; tc++) {
			int k = Integer.parseInt(br.readLine());
			// 작은 값 부터
			PriorityQueue<Integer> minQue = new PriorityQueue<>();
			// 큰 값 부터
			PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());

			// k 번 만큼 입력 받기
			for (int i = 0; i < k; i++) {
				String[] input = br.readLine().split(" ");
				char ch = input[0].charAt(0);
				int n = Integer.parseInt(input[1]);

				if (ch == 'I') {
					// 찾는 값이 존재하면 키의 값 반환, 없다면 0
//					map.put(n, map.getOrDefault(n, 0) + 1);

					minQue.add(n);
					maxQue.add(n);
				} else if (ch == 'D') {
					if(n == 1) {
						minQue.remove((maxQue.poll()));
					} else if(n == -1) {
						maxQue.remove((minQue.poll()));
					}
				}
			}

			// 비어있으면 EMPTY 출력
			if (minQue.size() == 0)
				System.out.println("EMPTY");
			else {
				System.out.println(maxQue.poll() + " " + minQue.poll());
			}

		}

	}
}