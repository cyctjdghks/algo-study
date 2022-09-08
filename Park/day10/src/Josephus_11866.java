import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Josephus_11866 {

	public static void main(String[] args) {
		// 요세푸스문제
		// N 과 K
		// 큐 사용

		int N, K;
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();

		for (int i = 1; i <= N; i++) {
			q.add(i);
		}

		sb.append("<");

		while (q.size() > 1) {
			for (int i = 0; i < K - 1; i++) { // K 번째 앞에 까지의 사람들을 뺀 뒤에 다시 넣기
				int val = q.poll();
				q.offer(val);
			}

			sb.append(q.poll()).append(", "); // K 번째 사람을 빼서 출력(죽임)
			// 반복
		}
		
		sb.append(q.poll()).append(">");
		System.out.println(sb);
	}

}
