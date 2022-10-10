import java.io.FileInputStream;
import java.math.BigInteger;
import java.util.Scanner;

public class _2407 {
// 조합
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		BigInteger[][] map = new BigInteger[n+1][n+1];
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j <= i; j++) {
				if(i == j || j == 0) map[i][j] = new BigInteger("1");
				else map[i][j] = map[i-1][j-1].add(map[i-1][j]);
			}
		}
		System.out.println(map[n][m]);
	}

}
