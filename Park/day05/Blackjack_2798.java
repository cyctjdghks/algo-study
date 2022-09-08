import java.util.Scanner;

public class Blackjack_2798 {

	public static void main(String[] args) {
		// 첫줄에는 카드의 개수 N과 최대값 M
		// 카드에 쓰여져 잇는 수
		// 카드에 쓰여져 있는 수 중 3가지를 활용하여 가장 M과 가까운 값
		// 브루트포스 알고리즘 활용
		// 브루트포스 알고리즘 이란 완전탐색 알고리즘. 즉, 가능한 모든 경우의 수를 모두 탐색하면서 요구조건에 충족되는 결과만을 가져온다.
		
		Scanner sc = new Scanner(System.in);
		
		int N;
		int M;
		int[] cards;
		int sum;
		int max;
		
		N = sc.nextInt();
		M = sc.nextInt();
		cards = new int[N];
		for(int i = 0; i < N; i++) {
			cards[i] = sc.nextInt();
		}
		
		max = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				for(int k = j+1; k < N; k++) {
					sum = cards[i] + cards[j] + cards[k];
					if(sum <= M && sum > max) {
						max = sum;
					}
				}
			}
		}
		System.out.println(max);
	}

}
