import java.util.*;

public class BOJ_11779_최소비용구하기2 {

    static ArrayList<Node>[] list;
    static int n, m, start, end;
    static int[] dist;
    static int[] route; // 직전 노드 저장
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        m = scan.nextInt();

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int s = scan.nextInt();
            int e = scan.nextInt();
            int c = scan.nextInt();
            list[s].add(new Node(e, c));
        }

        start = scan.nextInt();
        end = scan.nextInt();

        dist = new int[n + 1];
        route = new int[n + 1];
        Arrays.fill(dist, 1000000001);
        visited = new boolean[n + 1];
        dijkstra();

        System.out.println(dist[end]);

        ArrayList<Integer> routes = new ArrayList<>();
        int current = end;
        while (current != 0) {
            routes.add(current);
            current = route[current];
        }
        System.out.println(routes.size());
        for (int i = routes.size() - 1; i >= 0; i--) {
            System.out.print(routes.get(i) + " ");
        }
    }

    public static void dijkstra() {
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        dist[start] = 0;
        route[start] = 0;

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (!visited[current.e]) visited[current.e] = true;
            else continue;

            for (int i = 0; i < list[current.e].size(); i++) {
                Node next = list[current.e].get(i);
                if (dist[next.e] > dist[current.e] + next.cost) {
                    dist[next.e] = dist[current.e] + next.cost;
                    q.offer(new Node(next.e, dist[next.e]));
                    route[next.e] = current.e;
                }
            }
        }
    }

    public static class Node implements Comparable<Node> {
        int e;
        int cost;

        public Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }
}


//import java.util.*;
//
//public class BOJ_11779_최소비용구하기2 {
//    // 첫째 줄에 출발 도시에서 도착 도시까지 가는데 드는 최소 비용을 출력한다.
//    //둘째 줄에는 그러한 최소 비용을 갖는 경로에 포함되어있는 도시의 개수를 출력한다. 출발 도시와 도착 도시도 포함한다.
//    //셋째 줄에는 최소 비용을 갖는 경로를 방문하는 도시 순서대로 출력한다.
//    static int N, M;
//    static ArrayList<City>[] list;
//    static int start_city, end_city;
//    static Move[] dijk;
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        N = sc.nextInt();
//        M = sc.nextInt();
//        list = new ArrayList[N + 1];
//        dijk = new Move[N + 1];
//        for (int i = 1; i <= N; i++) {
//            list[i] = new ArrayList<City>();
//            dijk[i] = new Move(Integer.MAX_VALUE, 0, "");
//        }
//        for (int i = 0; i < M; i++) {
//            int st = sc.nextInt();
//            int nx = sc.nextInt();
//            int wt = sc.nextInt();
//            list[st].add(new City(nx, wt));
//        }
//        start_city = sc.nextInt();
//        end_city = sc.nextInt();
//
//        bfs();
//
//        StringBuilder sb = new StringBuilder();
//        sb.append(dijk[end_city].cost + "\n");
//        sb.append(dijk[end_city].city_count + "\n");
//        sb.append(dijk[end_city].city_route + "\n");
//
//        System.out.println(sb);
//    }
//
//    private static void bfs() {
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        queue.offer(start_city);
//        dijk[start_city] = new Move(0, 1, "" + start_city);
//
//        while (!queue.isEmpty()) {
//            int move = queue.poll();
//
//            int size = list[move].size();
//            for (int i = 0; i < size; i++) {
//                if(dijk[move].cost + list[move].get(i).weight < dijk[list[move].get(i).next].cost) {
//                    queue.offer(list[move].get(i).next);
//
//                    dijk[list[move].get(i).next].cost = dijk[move].cost + list[move].get(i).weight;
//                    dijk[list[move].get(i).next].city_count = dijk[move].city_count + 1;
//                    dijk[list[move].get(i).next].city_route = dijk[move].city_route + " " + list[move].get(i).next;
//                }
//            }
//        }
//    }
//
//    public static class City {
//        int next;
//        int weight;
//
//        public City(int next, int weight) {
//            this.next = next;
//            this.weight = weight;
//        }
//    }
//
//    public static class Move implements Comparable<Move> {
//        int cost;
//        int city_count;
//        String city_route;
//
//        public Move(int cost, int city_count, String city_route) {
//            this.cost = cost;
//            this.city_count = city_count;
//            this.city_route = city_route;
//        }
//
//        @Override
//        public int compareTo(Move o) { // 비용 오름차순 정렬
//            return this.cost - o.cost;
//        }
//    }
//}
