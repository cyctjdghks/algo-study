import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _12851 {
    static final int MAX_SIZE = 200000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] costs = new int[MAX_SIZE + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        int time = 0; // 진행시간
        int count = 0; // 가장 빠른 시간으로 수빈이가 동생 찾는 방법의 수
        while (!queue.isEmpty()) {
            time++; // 시간 증가
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int x = queue.poll();

                if (x == k) { // 동생을 찾았다면
                    count++; // 방법의 수 카운트
                    continue; // 다음 탐색
                }

                // x-1 위치까지 가는데 걸린 시간이 최신에 업데이트한 비용값보다 같거나 작다면
                if (x - 1 >= 0 && time <= costs[x - 1]) {
                    costs[x - 1] = time; // 비용 테이블 업데이트
                    queue.offer(x - 1); // 탐색 대상에 추가
                }

                // x+1 위치까지 가는데 걸린 시간이 최신에 업데이트한 비용값보다 같거나 작다면
                if (x + 1 <= MAX_SIZE && time <= costs[x + 1]) {
                    costs[x + 1] = time; // 비용 테이블 업데이트
                    queue.offer(x + 1); // 탐색 대상에 추가
                }

                // 2*x 위치까지 가는데 걸린 시간이 최신에 업데이트한 비용값보다 같거나 작다면
                if (2 * x <= MAX_SIZE && time <= costs[2 * x]) {
                    costs[2 * x] = time; // 비용 테이블 업데이트
                    queue.offer(2 * x); // 탐색 대상에 추가
                }
            }

            // 동생을 찾는 방법의 수가 구해졌다면 멈추기
            if (count > 0) {
                break;
            }
        }

        // 비용테이블이 업데이트 되어있지 않은 경우엔 처음부터 동생의 위치에 있었을 경우이므로 0
        System.out.println(costs[k] != Integer.MAX_VALUE ? costs[k] : 0);
        System.out.println(count);
    }
}
