import java.util.ArrayList;
import java.util.Scanner;


public class DiameterTree_1167 {

	static ArrayList<Node>[] list;
	static boolean[] visited;
	static int max = 0;

	public static void main(String args[]) {
		// 트리 정점의 개수 V
		// 연결된 간선의 정보 2개씩
		// 정점번호, 거리
		// 마지막에는 -1 => -1이 입력되면 다음 정점으로
		// V 의 범위는  (2 ≤ V ≤ 100,000)
		// => 단순 dfs 사용 시 시간초과

		int V;

		Scanner sc = new Scanner(System.in);

		V = sc.nextInt();
		list = new ArrayList[V + 1];
		for (int i = 1; i < V + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < V; i++) {
			int s = sc.nextInt();
			while (true) {
				int e = sc.nextInt();
				if (e == -1)
					break;
				int cost = sc.nextInt();
				list[s].add(new Node(e, cost));
			}
		}
		
//		// 리스트 확인
//		for (int i = 1; i <= V; i++) {
//			System.out.print(i + " : ");
//			for (int j = 0; j < list[i].size(); j++) {
//				System.out.print(list[i].get(j).e + "(" + list[i].get(j).cost + ")" + " ");
//			}
//			System.out.println();
//		}

		for (int i = 1; i <= V; i++) {
			visited = new boolean[V + 1];
			dfs(i, 0);
		}

		System.out.println(max);
	}

	public static void dfs(int x, int len) {
        if(len > max) {
            max = len;
        }
        visited[x] = true;
        
        for(int i = 0; i < list[x].size(); i++) {
            Node n = list[x].get(i);
            if(visited[n.e] == false) {
                dfs(n.e, n.cost + len);
                visited[n.e] = true;
            }
        }
        
    }

	public static class Node {
		int e;
		int cost;

		public Node(int e, int cost) {
			this.e = e;
			this.cost = cost;
		}
	}
}