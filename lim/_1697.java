import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Boj1697 {
// 숨바꼭질
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] visited = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		while(0 < q.size()) {
			int temp = q.poll();
			if(temp == k) {
				System.out.println(visited[k]);
				return;
			}
			if(temp+1 < 100001 && visited[temp+1] == 0) {
				visited[temp+1] = visited[temp]+1;
				q.add(temp+1);
			}
			if(0 <= temp-1 && visited[temp-1] == 0) {
				visited[temp-1] = visited[temp]+1;
				q.add(temp-1);
			}
			if(temp*2 < 100001 && visited[temp*2] == 0) {
				visited[temp*2] = visited[temp]+1;
				q.add(temp*2);
			}
		}
	}
}
