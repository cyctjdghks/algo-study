import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _11779 {

    static final int INF = 987654321;

    static class Node implements Comparable<Node> {
        int to, cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node e) {
            return this.cost - e.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Node>[] list = new List[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, v));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        int[] previousNode = new int[n + 1]; // 최단 경로일 때의 현재 점 직전 점 번호 저장 배열

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (visited[current.to]) {
                continue;
            }
            visited[current.to] = true;

            for (Node next : list[current.to]) {
                if (visited[next.to]) {
                    continue;
                }
                int nCost = current.cost + next.cost;

                if (nCost < dist[next.to]) {
                    dist[next.to] = nCost;
                    pq.offer(new Node(next.to, nCost));
                    previousNode[next.to] = current.to; // 현재점 직점 점 번호 저장
                }
            }
        }

        // 목적지부터 역추적하여 최단 경로인 경우의 방문 경로 찾기
        List<Integer> reverseRoute = new ArrayList<>();
        reverseRoute.add(target);
        int temp = target;
        while (temp != start) {
            reverseRoute.add(previousNode[temp]);
            temp = previousNode[temp];
        }

        StringBuilder sb = new StringBuilder();

        sb.append(dist[target]).append("\n");
        sb.append(reverseRoute.size()).append("\n");

        for (int i = reverseRoute.size() - 1; i >= 0; i--) {
            sb.append(reverseRoute.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}
