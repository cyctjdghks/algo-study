import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DoublePriorityQueue_7662_2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int k = Integer.parseInt(br.readLine());
			// key - 숫자, value - 개수
			Map<Integer, Integer> map = new HashMap<>();
			PriorityQueue<Integer> minQue = new PriorityQueue<>();
			PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());

			for (int i = 0; i < k; i++) {
				String[] input = br.readLine().split(" ");
				char ch = input[0].charAt(0);
				int n = Integer.parseInt(input[1]);

				if (ch == 'I') {
					// 찾는 값이 존재하면 키의 값 반환, 없다면 0
					map.put(n, map.getOrDefault(n, 0) + 1);

					minQue.add(n);
					maxQue.add(n);
				} else if (ch == 'D') {
					if (map.size() == 0)
						continue;
					// 1이라면 최대값 삭제
					// -1 이라면 최소값 삭제
					PriorityQueue<Integer> que = n == 1 ? maxQue : minQue;
					removeMap(que, map);
				}
			}

			if (map.size() == 0)
				System.out.println("EMPTY");
			else {
				int n = removeMap(maxQue, map);
				System.out.println(n + " " + (map.size() > 0 ? removeMap(minQue, map) : n));
			}

		}

	}

	static int removeMap(PriorityQueue<Integer> que, Map<Integer, Integer> map) {
		int num;
		while (true) {
			num = que.poll();
			int cnt = map.getOrDefault(num, 0);

			if (cnt == 0)
				continue;

			if (cnt == 1)
				// 값이 1개라면 삭제
				map.remove(num);
			else
				// 값이 2개 이상 이라면 갯수 -1
				map.put(num, cnt - 1);

			break;
		}

		return num;
	}

}