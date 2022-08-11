import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * BOJ 1463 - 1로 만들기 
 * 
 * 아래 세 가지 연산을 통해 1로 만든다. 연산 횟수의 최솟값은?  
 * 1) x가 3으로 나눠 떨어지면, 3으로 나눈다.
 * 2) x가 2로 나눠 떨어지면, 2로 나눈다.
 * 3) 1을 뺀다.
 */

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] dp = new int[n + 1];
		for (int i = 2; i <= n; i++) {

			dp[i] = dp[i - 1] + 1;
			if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);

		}

		System.out.println(dp[n]);

	}

}
