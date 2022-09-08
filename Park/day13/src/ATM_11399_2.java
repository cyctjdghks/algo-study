import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ATM_11399_2 {
	// 우선순위 큐 사용

	public static void main(String[] args) {
		// 사람 수 N (1 ≤ N ≤ 1,000)
		// 각 사람이 돈을 인출하는데 걸리는 시간 Pi
		// 걸리는 시간 = P 배열의 누적합
		// 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값
		// 합 : 앞의 시간의 합 + 현재의 시간
		// 1번 => 배열을 오름차순으로 정렬 후 합 구하기
		// 2번 => 우선순위 큐로 입력을 받아 누적합 구하기
		
		int N;
		int x;
		PriorityQueue<Integer> P = new PriorityQueue<>();
		int sum = 0;
		int num = 0;
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		for(int i = 0; i < N; i++)  {
			x = sc.nextInt();
			P.offer(x);
		}
		
		for(int i = 0; i < N; i++) {
			x = P.poll();
			sum += num + x;
			num += x;
		}
		
		System.out.println(sum);
	}

}
