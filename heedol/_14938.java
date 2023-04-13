package baekjoon.Q_14938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _14938 {
    static class Edge implements Comparable<Edge> {
        int node, cost;

        Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] items = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Edge>[] list = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            list[a].add(new Edge(b, l));
            list[b].add(new Edge(a, l));
        }

        int maxItemCount = 0;

        for (int i = 1; i < n + 1; i++) {
            int[] dist = dijkstra(n, list, i);

            int itemCount = 0;
            for (int j = 1; j < n + 1; j++) {
                if (dist[j] <= m) {
                    itemCount += items[j];
                }
            }
            maxItemCount = Math.max(maxItemCount, itemCount);
        }

        System.out.println(maxItemCount);
    }

    private static int[] dijkstra(int n, ArrayList<Edge>[] list, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        boolean[] visited = new boolean[n + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (visited[current.node]) {
                continue;
            }

            visited[current.node] = true;

            for (Edge next : list[current.node]) {
                int nDist = current.cost + next.cost;

                if (nDist < dist[next.node]) {
                    dist[next.node] = nDist;
                    pq.offer(new Edge(next.node, nDist));
                }
            }
        }
        return dist;
    }
}
