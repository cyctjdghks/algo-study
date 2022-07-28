import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * [2164 카드2 - 큐]
 * 1(가장 위) ~ N(가장 아래) 까지 카드에서 한 장 남을 때까지 아래 동작 반복.
 * 가장 위 카드 버림 -> 가장 위 카드를 가장 아래로 옮김.
 * 남은 카드는?
 */

/*
 *  삭제
 	poll() : 대기열이 비었다면 null 반환
	remove() : 대기열이 비었다면 NoSuchElement 에러 반환

 	크기
 	size()
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			q.add(i);
		}

		while (q.size() != 1) {
			q.poll();
			q.add(q.poll());
		}
		System.out.println(q.poll());

	}

}
