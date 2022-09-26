import java.util.Scanner;

public class TreeTour_2263 {

	static int n;
	static int[] in;
	static int[] post;
	static int[] index;
	
	public static void main(String[] args) {
		// n개의 정점 (1 ≤ n ≤ 100,000)
		// 이진 트리의 인오더(중위 순회)와 포스트오더(후위 순회)
		// 프리오더(전위 순회)를 출력
		// 중위 순회 - left, root, right
		// 후위 순회 - left, right, root
		// 후위 순위 가장 마지막 값 => root
		// root 값을 통해 중위 순회 값을 분할정복 할 수 있음
		
		// 전위 순회 - root, left, right
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		in = new int[n+1];
		post = new int[n+1];
		index = new int[n+1];
		for(int i = 1; i <= n; i++) {
			in[i] = sc.nextInt();
		}
		for(int i = 1; i <= n; i++) {
			post[i] = sc.nextInt();
		}
		for(int i = 1; i <= n; i++) {
			index[in[i]] = i;
		}
		
//		// 배열 확인
//		for(int i = 1; i <= n; i++) {
//			System.out.print(in[i] + " ");
//		}
//		System.out.println();
//		for(int i = 1; i <= n; i++) {
//			System.out.print(post[i] + " ");
//		}
		
		preOrder(0, n, 0, n);
	}

	 public static void preOrder(int in_begin, int in_end, int post_begin, int post_end) {
	        if(in_begin > in_end || post_begin > post_end || post_end == 0)
	            return;
	        
	        int root = post[post_end];
	        System.out.print(root+" ");
	        
	        int left = index[root] - in_begin;
	                
	        //Left
	        preOrder(in_begin, index[root] - 1, post_begin, post_begin + left -1);
	        //right
	        preOrder(index[root] + 1, in_end, post_begin + left, post_end - 1);
	    }
}
