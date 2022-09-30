import java.io.FileInputStream;
import java.util.Scanner;

public class _1107 {
// 리모컨
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int	m = sc.nextInt();
		boolean[] button = new boolean[10];
		for(int i = 0; i < 10; i++) {
			button[i] = true;
		}
		for(int i = 0; i < m; i++) {
			button[sc.nextInt()] = false;
		}
		// 입력
		int min = Math.abs(100- n);
		lp: for(int i = 0; i < 1000000; i++) {
			String s = String.valueOf(i);
			for(int j = 0 ; j < s.length(); j++) {
				if(button[s.charAt(j)-'0'] == false) continue lp;
			}
			int cnt = 0;
			cnt = s.length() + Math.abs(i-n);
			min = Math.min(cnt, min);
		}
		System.out.println(min);
	}
}
